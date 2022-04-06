package com.ifdom.designmode;

/**
 * 装饰器模式
 * https://www.bilibili.com/video/BV1fh411y7R8?p=623
 * https://www.cnblogs.com/TomXu/archive/2012/02/24/2353434.html
 *
 * 顶级类 使用 abstract 与不使用 abstract 差别极大
 */
public class DecoratorMode {

    public static void main(String[] args) {

        PerformerBird wildGoose = new PerformerBird(new WildGoose());

        wildGoose.fly();
        wildGoose.flyThenSwing();
        wildGoose.flyFifth();

        PerformerBird sparrow = new PerformerBird(new Sparrow());
        sparrow.flyFifth();

    }
}


class PerformerBird extends Bird {

    private Bird bird;

    public PerformerBird(Bird bird) {
        this.bird = bird;
    }

    /**
     * 拓展方法，比如执行5次
     */
    void flyFifth() {
        for (int i = 0; i < 5; i++) {
            this.bird.fly();
        }
    }

    /**
     * 拓展方法，比如一次后 再干点别的
     */
    void flyThenSwing() {
        this.bird.fly();
        System.out.println("俯冲游泳");
    }
}


class WildGoose extends Bird {

    public void fly() {
        System.out.println("大雁飞");
    }
}

class Sparrow extends Bird {

    @Override
    public void fly() {
        System.out.println("麻雀飞");
    }
    public void eat() {
        System.out.println("麻雀eat");
    }
}

// 抽象方法必须实现
abstract class Bird {
    public void fly(){
        System.out.println("鸟 飞");
    };

//    abstract void shit();

}