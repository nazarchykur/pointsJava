package com.company.comparison.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class Comparison_Comparator {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Z", 2),
                new User("A", 1),
                new User("A", 9),
                new User("B", 3),
                new User("A", 7),
                new User("Z", 3),
                new User("C", 5));

        System.out.println("before sorting users = " + users);
        // before sorting users = [User{name='Z', age=2}, User{name='A', age=1}, User{name='A', age=9}, User{name='B', age=3}, User{name='A', age=7}, User{name='Z', age=3}, User{name='C', age=5}]

        System.out.println("--------------------------------------------");
        // sorting with lambda by age
        users.sort((user1, user2) -> user1.getAge() - user2.getAge());
        System.out.println("after sorting users with lambda by age  = " + users);
//        after sorting users with lambda by age  = [User{name='A', age=1}, User{name='Z', age=2}, User{name='B', age=3}, User{name='Z', age=3}, User{name='C', age=5}, User{name='A', age=7}, User{name='A', age=9}]

        // sorting with lambda by name
        users.sort((user1, user2) -> user1.getName().compareTo(user2.getName()));
        System.out.println("after sorting users with lambda by name = " + users);
//        after sorting users with lambda by name = [User{name='A', age=1}, User{name='A', age=7}, User{name='A', age=9}, User{name='B', age=3}, User{name='C', age=5}, User{name='Z', age=2}, User{name='Z', age=3}]


        System.out.println("--------------------------------------------");
        // sorting with static method + method reference by age
        users.sort(comparingInt(User::getAge));
        System.out.println("after sorting users with method reference by age = " + users);
//        after sorting users with method reference by age = [User{name='A', age=1}, User{name='Z', age=2}, User{name='B', age=3}, User{name='Z', age=3}, User{name='C', age=5}, User{name='A', age=7}, User{name='A', age=9}]

        // sorting with static method + method reference by name
        users.sort(Comparator.comparing(User::getName));
        System.out.println("after sorting users with method reference by name = " + users);
//        after sorting users with method reference by name = [User{name='A', age=1}, User{name='A', age=7}, User{name='A', age=9}, User{name='B', age=3}, User{name='C', age=5}, User{name='Z', age=2}, User{name='Z', age=3}]

        System.out.println("--------------------------------------------");
        // with stream
        List<User> collect = users.stream()
                .sorted(Comparator
                        .comparing(User::getName)
                        .thenComparing(User::getAge))
                .collect(Collectors.toList());
        System.out.println("after sorting users with stream by name and then by age = " + collect);
//        after sorting users with stream by name and then by age = [User{name='A', age=1}, User{name='A', age=7}, User{name='A', age=9}, User{name='B', age=3}, User{name='C', age=5}, User{name='Z', age=2}, User{name='Z', age=3}]

        List<User> collect1 = users.stream()
                .sorted(Comparator
                        .comparing(User::getName)
                        .reversed())
                .collect(Collectors.toList());
        System.out.println("after sorting users with stream by name reversed= " + collect1);
//        after sorting users with stream by name reversed= [User{name='Z', age=2}, User{name='Z', age=3}, User{name='C', age=5}, User{name='B', age=3}, User{name='A', age=1}, User{name='A', age=7}, User{name='A', age=9}]

        System.out.println("--------------------------------------------");

        Collections.sort(users, Comparator.comparing(User::getName));
        System.out.println("after sorting users with  Collections.sort = " + users);
//        after sorting users with  Collections.sort = [User{name='A', age=1}, User{name='A', age=7}, User{name='A', age=9}, User{name='B', age=3}, User{name='C', age=5}, User{name='Z', age=2}, User{name='Z', age=3}]

        System.out.println("--------------------------------------------");
        System.out.println("---------------- users2 --------------------");
        System.out.println("--------------------------------------------");


        List<User> users2 = Arrays.asList(
                new User("Z", 2),
                new User("B", 3),
                new User("B", 2),
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
//        after using stream with static methods of Comparator comparing by name then by age = 
//        [User{name='A', age=7}, User{name='A', age=9}, User{name='A', age=9}, User{name='B', age=2}, User{name='B', age=3}, User{name='B', age=6}, User{name='C', age=5}, User{name='Y', age=1}, User{name='Z', age=2}]

        System.out.println("--------------------------------------------");
        // using stream with static method of Comparator comparing by age then by name
        List<User> collect3 = users2.stream()
                .sorted(comparing(User::getAge)
                        .thenComparing(User::getName))
                .collect(Collectors.toList());
        System.out.println("after using stream with static methods of Comparator comparing by age then by name = " + collect3);
//        after using stream with static methods of Comparator comparing by age then by name = 
//        [User{name='Y', age=1}, User{name='B', age=2}, User{name='Z', age=2}, User{name='B', age=3}, User{name='C', age=5}, User{name='B', age=6}, User{name='A', age=7}, User{name='A', age=9}, User{name='A', age=9}]

        System.out.println("--------------------------------------------");
        // using stream with static method of Comparator comparing by age then by name with peek to see sorting in the middle
        List<User> collect4 = users2.stream()
                .sorted(comparing(User::getAge))
                .peek(System.out::println)
                .sorted(comparing(User::getName))
                .collect(Collectors.toList());
        System.out.println("after comparing by age then by name with peek to see sorting in the middle = " + collect4);

        System.out.println("--------------------------------------------");
        // using stream with static method of Comparator comparing by name then by age with peek to see sorting in the middle
        List<User> collect5 = users2.stream()
                .sorted(comparing(User::getName))
                .peek(System.out::println)
                .sorted(comparing(User::getAge))
                .collect(Collectors.toList());
        System.out.println("after comparing by name then by age with peek to see sorting in the middle = " + collect5);

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
//        Youngest Footballer: Footballer{name='Ozil', team='Fenerbahce', age=32}

        eldestFootballer.ifPresent(footballer -> System.out.println("Eldest Footballer: " + footballer));
//        Eldest Footballer: Footballer{name='Ronaldo2', team='Manchester United', age=36}

        System.out.println("--------------------------------------------");
        boolean present = youngestFootballer.isPresent();
        System.out.println("isPresent = " + present);

        System.out.println("--------------------------------------------");
        // comparing by age then by name
        Optional<Footballer> youngestFootballer2 = footballers.stream()
                .min(comparingInt(Footballer::getAge)
                        .thenComparing(Footballer::getName));
        youngestFootballer2.ifPresent(footballer -> System.out.println("comparing by age then by name = Youngest Footballer: " + footballer));
//        comparing by age then by name = Youngest Footballer: Footballer{name='Azil', team='Fenerbahce', age=32}


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
                .filter(number -> number % 2 == 1) //Filter the odd numbers   | x%2 == 0  => even numbers | x%2 != 0  => odd numbers
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


        System.out.println("--------------------------------------------");
        System.out.println("----------- odd and even Numbers ------------");
        System.out.println("--------------------------------------------");

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(5);
        numbers2.add(8);
        numbers2.add(3);
        numbers2.add(7);
        numbers2.add(2);
        numbers2.add(6);
        numbers2.add(1);
        numbers2.add(10);
        numbers2.add(9);
        numbers2.add(4);
        numbers2.add(2);

        List<Integer> evenNumbers = numbers2.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("evenNumbers = " + evenNumbers);
//        evenNumbers = [8, 2, 6, 10, 4, 2]

        System.out.println("--------------------------------------------");

        List<Integer> evenNumbersDistinctAndSorted = numbers2.stream()
                .distinct()
                .filter(x -> x % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("evenNumbersDistinctAndSorted = " + evenNumbersDistinctAndSorted);
//        evenNumbersDistinctAndSorted = [2, 4, 6, 8, 10]

        System.out.println("--------------------------------------------");

        Set<Integer> evenNumbersToSet = numbers2.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toSet());

        System.out.println("evenNumbersToSet = " + evenNumbersToSet);
//        evenNumbersToSet = [2, 4, 6, 8, 10]

        System.out.println("--------------------------------------------");

        List<Integer> oddNumbers = numbers2.stream()
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toList());

        System.out.println("oddNumbers = " + oddNumbers);
//        oddNumbers = [5, 3, 7, 1, 9]

        System.out.println("--------------------------------------------");

        List<Integer> oddNumbers2 = numbers2.stream()
                .filter(x -> x % 2 == 1)
                .collect(Collectors.toList());

        System.out.println("oddNumbers2 = " + oddNumbers2);
//        oddNumbers2 = [5, 3, 7, 1, 9]

        System.out.println("--------------------------------------------");

        Map<Boolean, List<Integer>> mapOfEvenAndOddNumbers = numbers2.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0, Collectors.toList()));

        System.out.println("mapOfEvenAndOddNumbers = " + mapOfEvenAndOddNumbers);
//        mapOfEvenAndOddNumbers = {false=[5, 3, 7, 1, 9], true=[8, 2, 6, 10, 4, 2]}

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

class Footballer {
    String name;
    String team;
    int age;

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
