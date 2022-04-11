package com.ifdom.designmode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 动态代理
 */
public class DynamicAgent {
    public static void main(String[] args) {

        // 真实角色
        Landlord tom = new Landlord("Tom");

        // 创建代理
        DynamicProxyHandle dynamicProxyHandle = new DynamicProxyHandle();

        // 设置代理对象
        dynamicProxyHandle.setLandlord(tom);

        Rent proxy = (Rent) dynamicProxyHandle.getProxy();

        proxy.rent();

    }
}


class DynamicProxyHandle implements InvocationHandler {

    // 将要被代理的对象
    private Landlord landlord;

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), landlord.getClass().getInterfaces(), this);
    }

    // 处理代理示例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 动态代理的本质是使用反射
        Landlord invoke = (Landlord) method.invoke(landlord, args);
        return invoke;
    }
}

// 房东
class Landlord implements Rent {
    private double price = 3000;
    private String name;

    public Landlord(String name) {
        this.name = name;
    }

    public void rent() {
        System.out.println("房东要出租房子");
    }
}

interface Rent {
    void rent();
}
