package com.company.comparison.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

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
        users.sort(comparingInt(User::getAge));
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
        System.out.println("after sorting users with  Collections.sort = " + users);

        System.out.println("--------------------------------------------");
        System.out.println("---------------- users2 --------------------");
        System.out.println("--------------------------------------------");


        List<User> users2 = Arrays.asList(
                new User("Z", 2),
                new User("B", 3),
                new User("A", 9),
                new User("C", 5),
                new User("A", 9),
                new User("A", 7),
                new User("B", 6),
                new User("Y", 1)
                );
        
        // using stream with static method of Comparator comparing by name then by age
        List<User> collect2 = users2.stream()
                .sorted(comparing(User::getName)
                        .thenComparing(User::getAge))
                .collect(Collectors.toList());
        System.out.println("after using stream with static methods of Comparator comparing by name then by age = " + collect2);

        System.out.println("--------------------------------------------");
        // using stream with static method of Comparator comparing by age then by name
        List<User> collect3 = users2.stream()
                .sorted(comparing(User::getAge)
                        .thenComparing(User::getName))
                .collect(Collectors.toList());
        System.out.println("after using stream with static methods of Comparator comparing by age then by name = " + collect3);

        System.out.println("--------------------------------------------");
        // using stream with static method of Comparator comparing by age then by name with peek to see sorting in the middle
        List<User> collect4 = users2.stream()
                .sorted(comparing(User::getAge))
                .peek(System.out::println)
                .sorted(comparing(User::getName))
                .collect(Collectors.toList());
        System.out.println("after comparing by age then by name with peek to see sorting in the middle = " + collect4);

        System.out.println("--------------------------------------------");
        // using stream with static method of Comparator comparing by age then by name with peek to see sorting in the middle
        List<User> collect5 = users2.stream()
                .sorted(comparing(User::getAge))
                .peek(System.out::println)
                .sorted(comparing(User::getName))
                .collect(Collectors.toList());
        System.out.println("after comparing by age then by name with peek to see sorting in the middle = " + collect5);

        System.out.println("--------------------------------------------");
        System.out.println("--------------- Footballer -----------------");
        System.out.println("--------------------------------------------");
        
        List<Footballer> footballers = Arrays.asList(
                new Footballer("Ronaldo2", "Manchester United", 36),
                new Footballer("Ronaldo", "Manchester United", 36),
                new Footballer("Messi", "Paris Saint German", 33),
                new Footballer("Ozil", "Fenerbahce", 32),
                new Footballer("Azil", "Fenerbahce", 32)
        );

        Optional<Footballer> youngestFootballer = footballers.stream()
                .min(comparingInt(Footballer::getAge));


        Optional<Footballer> eldestFootballer = footballers.stream()
                .max(comparing(Footballer::getAge));

        youngestFootballer.ifPresent(footballer -> System.out.println("Youngest Footballer: " + footballer));
        eldestFootballer.ifPresent(footballer -> System.out.println("Eldest Footballer: " + footballer));

        System.out.println("--------------------------------------------");
        boolean present = youngestFootballer.isPresent();
        System.out.println("isPresent = " + present);

        System.out.println("--------------------------------------------");
        // comparing by age then by name
        Optional<Footballer> youngestFootballer2 = footballers.stream()
                .min(comparingInt(Footballer::getAge)
                        .thenComparing(Footballer::getName));
        youngestFootballer2.ifPresent(footballer -> System.out.println("comparing by age then by name = Youngest Footballer: " + footballer));


        System.out.println("--------------------------------------------");
        System.out.println("----------------- Numbers ------------------");
        System.out.println("--------------------------------------------");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(8);
        numbers.add(3);
        numbers.add(7);
        numbers.add(2);
        numbers.add(6);
        numbers.add(1);
        numbers.add(10);
        numbers.add(9);
        numbers.add(4);
        numbers.add(2);

        numbers.stream()
                .peek(number -> System.out.println("Filter operation for number: " + number)) //Peek is used for debugging purposes.
                .filter(number -> number % 2 == 1) //Filter the odd numbers
                .sorted(Comparator.naturalOrder()) //Natural order of sorting. (Ascending Sort)
                .limit(4) //After 4th element stop the stream. Process first 4 element.
                .peek(number -> System.out.println("Map operation for number: " + number)) //Peek is used for debugging purposes.
                .map(number -> number * 2) //Transform the number to number*2
                .forEach(number -> System.out.println("Result of stream = Ascending Sort : " + number)); //Print the results.
        
        System.out.println("--------------------------------------------");
        
        numbers.stream()
                .peek(number -> System.out.println("Filter operation for number: " + number)) //Peek is used for debugging purposes.
                .filter(number -> number % 2 == 1) //Filter the odd numbers
                .sorted(Comparator.reverseOrder()) //Reverse order of sorting. (Descending Sort)
                .limit(4) //After 4th element stop the stream. Process first 4 element.
                .peek(number -> System.out.println("Map operation for number: " + number)) //Peek is used for debugging purposes.
                .map(number -> number * 2) //Transform the number to number*2
                .forEach(number -> System.out.println("Result of stream = Descending Sort : " + number)); //Print the results.
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

class Footballer {
    String name;
    String team;
    int    age;

    public Footballer(String name, String team, int age) {
        this.name = name;
        this.team = team;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Footballer{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", age=" + age +
                '}';
    }
}
