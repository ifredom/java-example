package com.ifdom.collection;

import java.util.ArrayList;
import java.util.List;

public class Generic {
    public static void main(String[] args) {
        ArrayList<AA> list2 = new ArrayList<>();
        ArrayList<BB> list3 = new ArrayList<>();
        ArrayList<CC> list4 = new ArrayList<>();

        testGeneric(list2);
        testGeneric(list3);
        testGeneric(list4);
    }

    /**
     * <? extends AA>  泛型。 继承自A的子类， AA表示上限
     *
     * @param aa
     */
    public static void testGeneric(List<? extends AA> aa) {

//        ArrayList<Object> list = new ArrayList<String>();
        ArrayList<String> list1 = new ArrayList<>();

    }


}


class AA {
}

class BB extends AA {
}

class CC extends BB {
}
