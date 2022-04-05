package com.ifdom.collection;

import java.awt.font.TextHitInfo;
import java.util.*;


/**
 * 1. HashMap$Node ,
 * 2. TreeMap,
 * 3. HashTable
 * <p>
 * 实现了 map.Entry, 其中 keys 使用Set存储， values 使用collection存储
 */
public class MapTest {
    public static void main(String[] args) {

        Hashtable hashtable = new Hashtable();
        hashtable.put("name","cool");

        Map map = new HashMap();
        map.put("no1", "cool");
        map.put("no2", "dom");
        map.put("no2", "every");

        System.out.println(map);

        Set entrySet = map.entrySet();
        System.out.println(entrySet);

        Set keySet = map.keySet();
        System.out.println(keySet);

        Collection values = map.values();
        System.out.println(values);
        System.out.println("=====================");

        for (Object k : map.keySet()) {
            System.out.println(k + " ==== " + map.get(k));
        }
        System.out.println("=====================");

        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("=====================");

        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object entry = iterator2.next();
            // 实现了Map.Entry 所以可以向下转型
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m);
        }

    }
}
