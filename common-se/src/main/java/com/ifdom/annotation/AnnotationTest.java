package com.ifdom.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @注解
 * 注解的本质是一个特殊注释，有2种扫描方式。1.在编译期直接被扫描2。一种是运行期反射
 * @『元注解』
 * @Target：注解的作用目标
 * @Retention：注解的生命周期
 * @Documented：注解是否应当被包含在JavaDoc文档中
 * @Inherited：是否允许子类继承该注解
 *
 */

/**
 * @Target(value = {ElementType.FIELD})
 * @ElementType.TYPE：允许被修饰的注解作用在类、接口和枚举上
 * @ElementType.FIELD：允许作用在属性字段上
 * @ElementType.METHOD：允许作用在方法上
 * @ElementType.PARAMETER：允许作用在方法参数上
 * @ElementType.CONSTRUCTOR：允许作用在构造器上
 * @ElementType.LOCAL_VARIABLE：允许作用在本地局部变量上
 * @ElementType.ANNOTATION_TYPE：允许作用在注解上
 * @ElementType.PACKAGE：允许作用在包上
 *
 */
@SuppressWarnings("all")
public class AnnotationTest {
    @FirstAnnotation("my first annotation")
    public static void main(String[] args) throws NoSuchMethodException {
        // spring注解实现的原理就是将注解上的属性方法一一映射给target
        // 测试自定义的注解
        Class<AnnotationTest> aClass = AnnotationTest.class;
        Method method = aClass.getMethod("main", String[].class);
        FirstAnnotation firstAnnotation = method.getAnnotation(FirstAnnotation.class);
        System.out.println(firstAnnotation.toString());
    }
}


