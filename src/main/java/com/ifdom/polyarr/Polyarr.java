package com.ifdom.polyarr;

public class Polyarr {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        people[0] = new Person("ifredom", 18);

        people[1] = new Student("tom", 18, 60);
        people[2] = new Student("jack", 19, 61);
        people[3] = new Teacher("hans", 18, 1000);
        people[4] = new Teacher("jinxing", 19, 2000);

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].say());
            if( people[i] instanceof Student){
                ((Student) people[i]).study();
            }
            if( people[i] instanceof Teacher){
                ((Teacher) people[i]).teach();
            }
        }

    }
}
