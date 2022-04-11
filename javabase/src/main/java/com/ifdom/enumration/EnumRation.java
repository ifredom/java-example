package com.ifdom.enumration;

public class EnumRation {

    public static void main(String[] args) throws Exception {
        Season season = Season.spring;
        Season2 season2 = Season2.summer;
        Season3 season3 = Season3.spring;


        Season2 summer2 = season2.valueOf("summer");
        System.out.println(summer2 == season2);


        season3.getDesc();
        System.out.println(season3.getDesc());

        for (Season3 item : Season3.values()) {
            System.out.println(item);
        }

        int n =200;
        Integer integer = n;
    }
}


/**
 * 默认继承 Enum 类
 * <p>
 * ! 有顺序要求
 */

enum Season3 {
    spring("春天", 1),
    winter("夏天", 2),
    autumn("秋天", 3),
    summer("冬天", 4),
    what; // 调用无参数构造器


    private String name;
    private int desc;

    private Season3() {

    }

    private Season3(String name, int desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public int getDesc() {
        return desc;
    }
}


enum Season2 {
    spring,
    winter,
    autumn,
    summer;

    private String summers = "summer";
}

/**
 * 枚举本质
 * <p>
 * 自定义方式创建枚举类
 */
class Season {
    private String name;
    private String desc;

    public static final Season spring = new Season("春天", "凌冽");
    public static final Season winter = new Season("夏天", "凌冽");
    public static final Season autumn = new Season("秋天", "凌冽");
    public static final Season summer = new Season("冬天", "凌冽");

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

/**
 * 自定义异常
 */
class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}