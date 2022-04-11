package com.ifdom.collection;

import org.junit.Test;

import java.util.*;

public class GenericHomework {
    public static void main(String[] args) {

    }

    @Test
    public void testDAO() {
        DAO<User> userDAO = new DAO<>();

        User tom = new User(100, 100, "tom");
        userDAO.save("tomId", tom);

        User jack = new User(200, 200, "jack");
        userDAO.save("jackId", jack);

        User funny = new User(300, 300, "funny");
        userDAO.save("funnyId", funny);

        System.out.println(userDAO.list());


        System.out.println(userDAO.get("jackId"));

        User jenny = new User(500, 500, "jenny");
        userDAO.update("jackId", jenny);

        System.out.println(userDAO.get("jackId"));
        System.out.println(userDAO.list());
        userDAO.delete("jackId");
        System.out.println(userDAO.list());
    }


}

class DAO<T> {
    Map<String, T> subs = new HashMap<>();

    public void save(String id, T entity) {
        subs.put(id, entity);
    }

    public T get(String id) {
        return subs.get(id);
    }

    public void update(String id, T entity) throws RuntimeException {
        if (!subs.containsKey(id)) {
            throw new RuntimeException("not found the id");
        }
        subs.put(id, entity);
    }

    public List<T> list() {
        Set<String> entries = subs.keySet();
        List<T> list = new ArrayList<>();
        for (String key : entries) {
            list.add(subs.get(key));
        }
        return list;
    }

    public void delete(String id) {
        subs.remove(id);
    }


}


class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}