package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

public class GsonExample {
    public static void main(String[] args) {
        // Create a Gson instance
        Gson gson = new Gson();

        // Define a JSON string
        String json = """
           {
                "name": "John Smith",
                "age": 30
           }
        """;

        // Convert the JSON string to a Java object
        Person2 person = gson.fromJson(json, Person2.class);
        System.out.println("person = " + person);


        Person2 person2 = new Person2();
        person2.setName("John Doe");
        person2.setAge(20);

        String json2 = gson.toJson(person2);

        System.out.println(json2); // prints {"name":"John Doe","age":20}
    }
}

class Person2 {
    private String name;
    private int age;

    public Person2() {
    }

    public Person2(String name, int age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}