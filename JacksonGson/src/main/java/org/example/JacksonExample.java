package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonExample {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Серіалізація об'єкта в JSON
        try {
            String json = objectMapper.writeValueAsString(new Person("John", 30));
            System.out.println("Serialization: " + json);  // Serialization: {"name":"John","age":30}
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Десеріалізація JSON в об'єкт
        String json = """
            {
                "name":"John",
                "age":30
            }
        """;
        try {
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println("Deserialization: " + person); // Deserialization: Person{name='John', age=30}
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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