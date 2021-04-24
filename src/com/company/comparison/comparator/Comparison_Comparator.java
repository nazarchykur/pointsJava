package com.company.comparison.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Comparison_Comparator {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("A", 9),
                new User("Z", 2),
                new User("B", 3),
                new User("C", 5));

        System.out.println("before sorting users = " + users);


        System.out.println("--------------------------------------------");
        // sorting with lambda by age
        users.sort((user1, user2) -> user1.getAge() - user2.getAge());
        System.out.println("after sorting users with lambda by age  = " + users);

        // sorting with lambda by name
        users.sort((user1, user2) -> user1.getName() .compareTo(user2.getName()));
        System.out.println("after sorting users with lambda by name = " + users);


        System.out.println("--------------------------------------------");
        // sorting with static method + method reference by age
        users.sort(Comparator.comparingInt(User::getAge));
        System.out.println("after sorting users with method reference by age = " + users);

        // sorting with static method + method reference by name
        users.sort(Comparator.comparing(User::getName));
        System.out.println("after sorting users with method reference by name = " + users);

        System.out.println("--------------------------------------------");
        // with stream
        List<User> collect = users.stream()
                .sorted(Comparator
                        .comparing(User::getName)
                        .thenComparing(User::getAge))
                .collect(Collectors.toList());
        System.out.println("after sorting users with stream by name = " + collect);

        List<User> collect1 = users.stream()
                .sorted(Comparator
                        .comparing(User::getName)
                        .reversed())
                .collect(Collectors.toList());
        System.out.println("after sorting users with stream by name reversed= " + collect1);

        System.out.println("--------------------------------------------");

        Collections.sort(users, Comparator.comparing(User::getName));
        System.out.println("fter sorting users with  Collections.sort = " + users);

        System.out.println("--------------------------------------------");


    }
}

class User {
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

}

