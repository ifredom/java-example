# 目录包

包名乱了，鼠标右键选择maven重新加载项目

## 继承

- super 关键字
- 终点为Object类

---

就近原则

- 直接调用 methodName()
- this.methodName()
- super.methodName()

## [多态](https://www.bilibili.com/video/BV1fh411y7R8?p=315)

- 编译类型看等号左边，运行类型看等号右边
- 向上转型
- 向下转型 只能强转父类引用，不能转换父类对象 `Cat cat = (Cat) animal;`
- 1.属性值不存在重写，使用等号左边的编译类型 ⭐⭐⭐⭐⭐
- 2.方法存在重写，使用运行类型 ⭐⭐⭐⭐⭐
- instanceof 判断对象运行类型⭐⭐⭐⭐⭐
- == 比较的是对象地址

```java
package com.ifdom.polymorphic;

/**
 * 多态
 */
public class Polymorphic {

    public static void main(String[] args) {

        Person ifredom = new Person("ifredom");

        Dog tom = new Dog("Tom");

        Cat jimmy = new Cat("Jimmy");

        // 向上转型
        Animal jimmy2 = new Cat("Jimmy2");
        jimmy2.eat();
        jimmy2.run();
        jimmy2.sleep();

        // 向下转型
        // 使用向下转型的限制：创建时 jimmy2则使用的是Cat
        Cat jimmy3 = (Cat) jimmy2;
        jimmy3.catchMouse();

        Food bood = new Food("bood");

        Food fish = new Food("fish");

        ifredom.feed(tom, bood);
        ifredom.feed(jimmy, fish);
    }

}
```

## 多态动态绑定机制 dynamicbingding

## 方法

- 使用条件判断时，找出不正确的条件，避免if-else

静态方法访问作用域

```java

package com.ifdom.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
        XX xx = new XX();
        xx.custom();
    }
}

class XX {
    public static int count = 0;

    public static void test() {
        System.out.println(XX.count);
    }

    public static void add() {
        XX.count++;
    }

    public void custom() {
        count++;
        System.out.println(count);
        add();
        System.out.println(XX.count);
    }
}
```

## debug

- F7 单步跳入
- F8 单步跳出
- F9 断点跳出

### 快捷键

- ctrl + alt + f 格式化代码，保持跟Vscode一致
- alt+ insert 快速创建构造函数
- alt + 回车 快速创建变量名称
- ctrl + d 复制当前行
- shift + enter 向下新建一行
- ctrl + alt + enter 向上新建一行
- ctrl + alt + T try...catch 快速生成
- 先按下home 或者end , shift + home / shift +end 选中当前行
- 迭代器快捷键 itit   ,方式二 ： 大写的 I +回车 生成增强for循环