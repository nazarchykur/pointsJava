package com.company.comparison.comparable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Comparison_Comparable {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("A", 9),
                new User("Z", 2),
                new User("B", 3),
                new User("C", 5));

        System.out.println("before sorting users = " + users);
        // natural sort with comparable
        users.sort(User::compareTo);
        System.out.println("after sorting users = " + users);

        List<User> collect = users.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}

class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(User user) {
        return this.getName().compareTo(user.getName());
    }
}