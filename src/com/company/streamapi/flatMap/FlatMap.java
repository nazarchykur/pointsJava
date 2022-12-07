package com.company.streamapi.flatMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<Customer> customers = getAll();

        /*
                    using  .map()
                    
                    input   Stream<T>
                    output  Stream<R>
         */
        List<String> allNames = customers.stream()
                .map(Customer::getFirstName)
                .collect(Collectors.toList());

        // тут використовуємо one-to-one mapping
        // один об'єкт Customer має поле firstName у якому тільки одне значення
        System.out.println("allNames = " + allNames);  // allNames = [John, John, Leo, Lia]

        List<List<String>> phoneNumbers = customers.stream()
                .map(Customer::getPhoneNumbers)
                .collect(Collectors.toList());

        // тут використовуємо one-to-many mapping
        // один об'єкт Customer має поле phoneNumbers яке містить деякий список значень, тому отримаємо масив масивів
        System.out.println("phoneNumbers = " + phoneNumbers); // phoneNumbers = [[111, 222], [333], [444, 555, 666], [777, 888]]

        
         /*
                    using  .flatMap()
                    
                    input   Stream<Stream<T>>
                    output  Stream<R>
         */

        List<String> phoneNumbers2 = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        
        // так як тут використовуємо one-to-many mapping
        // тобто один об'єкт Customer має поле phoneNumbers яке містить деякий список значень
        // то щоб отримати список цих номерів в однорівневому масиві ми використовуємо  flatMap , 
        // тому ми перетворюємо список номерів на .stream()    = customer.getPhoneNumbers().stream()
        // бо він якраз і приймає input   Stream<Stream<T>> 
        
        System.out.println("phoneNumbers2 = " + phoneNumbers2); // phoneNumbers2 = [111, 222, 333, 444, 555, 666, 777, 888]

       
        List<String> collect = customers.stream()
                .flatMap(customer -> Stream.of(customer.getFirstName(), customer.getLastName()))
                .collect(Collectors.toList());

        // отримати всі імена і прізвища по порядку як список String 
        // для цього створюємо  Stream.of(customer.getFirstName(), customer.getLastName())
        System.out.println("collect = " + collect); // collect = [John, Aa, John, Ab, Leo, Cd, Lia, Eh]
        

        List<Character> collect1 = customers.stream()
                .map(Customer::getLastName)
                .flatMapToInt(String::chars)              // using lambda    name -> name.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        // вивести всі літери з прізвищ: 
            // 1) беремо тільки прізвище  = тобто на цьому кроці ми маємо Stream<String>
            // 2) так як flatMap приймає input   Stream<Stream<T>>, то ми і створюємо з кожного імені масив чарів  name -> name.chars()
            // 3) але так як на попередньому кроці ми працюмо з int   flatMapToInt, то тут приводимо кожне число назад у символ  mapToObj
        System.out.println("collect1 = " + collect1); // collect4 = [A, a, A, b, C, d, E, h]



        Map<Character, String> collect2 = customers.stream()
                .map(Customer::getFirstName)
                .collect(Collectors.toMap(name -> name.charAt(0), Function.identity(), (name1, name2) -> name1));
        System.out.println("collect2 = " + collect2); // collect2 = {J=John, L=Leo}

        Map<Character, List<String>> collect3 = customers.stream()
                .map(Customer::getFirstName)
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println("collect3 = " + collect3); // collect3 = {J=[John, John], L=[Leo, Lia]}

        Map<Character, Set<String>> collect4 = customers.stream()
                .map(Customer::getFirstName)
                .collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.toSet()));

        System.out.println("collect4 = " + collect4); // collect4 = {J=[John], L=[Lia, Leo]}
    }

    public static List<Customer> getAll() {
        return Arrays.asList(
                new Customer(101, "John", "Aa", Arrays.asList("111", "222")),
                new Customer(102, "John", "Ab", Arrays.asList("333")),
                new Customer(103, "Leo", "Cd", Arrays.asList("444", "555", "666")),
                new Customer(104, "Lia", "Eh", Arrays.asList("777", "888"))
                );
    }
    
    static class Customer {
        private int id;
        private String firstName;
        private String lastName;
        private List<String> phoneNumbers;

        public Customer(int id, String firstName, String lastName, List<String> phoneNumbers) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumbers = phoneNumbers;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }
    }
}
