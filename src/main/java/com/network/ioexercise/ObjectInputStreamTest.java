package com.network.ioexercise;


import org.junit.Test;

import java.io.*;

/**
 * ObjectInputStream
 * 用户保存数据内容 和 数据类型，要求能将数据序列化和反序列化
 * 要让一个类可序列化，必须实现接口 Serializable 或者 Externalizable
 * 序列化的类添加一个属性，提高兼容性：private static final long serialVersionUID = 1L;
 *
 * transient 修饰符修饰的成员无法被序列化
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) throws Exception {
        String filePath = "D:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(1024);
        oos.writeBoolean(false);
        oos.writeChar('J');
        oos.writeUTF("G");

        oos.writeObject(new Dog("旺财", 10));

        oos.close();
    }

    // 返序列化
    // 要求保存的顺序与读取反学历恶化时的顺序相同
    @Test
    public void reverseSerializable() throws Exception {
        String filePath = "D:\\data.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readUTF());

        Object o = ois.readObject();

        System.out.println(o.getClass());
        System.out.println(o);
        ois.close();
    }
}


class Dog implements Serializable {
    private String name;
    private  int age;
    private static final long serialVersionUID = 1L;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}