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

## 多态

- 编译类型看等号左边，运行类型看等号右边
- 向上转型
- 向下转型 只能强转父类引用，不能转换父类对象 `Cat cat = (Cat) animal;`
- 属性值不存在重写，使用等号左边的编译类型 ⭐⭐⭐⭐⭐

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

        ifredom.feed( tom, bood);
        ifredom.feed(jimmy,fish);
    }

}
```

### 快捷键

- alt+ insert 快速创建构造函数
- -alt +回车 快速创建变量名称