package com.company.generics.generics_2_errors;

public class GenericMain {
    public static void main(String[] args) {
    // 1
//        AnimalHouse<Animal> house_1 = new AnimalHouse<Cat>(); 
        
        // fails to compile
        // AnimalHouse<Cat> and AnimalHouse<Animal> are not compatible types, even though Cat is a subtype of Animal.

    // 2
//        AnimalHouse<Dog> house_2 = new AnimalHouse<Animal>();
        
        // fails to compile
        // Same as 1: AnimalHouse<Cat> and AnimalHouse<Animal> are not compatible types, even though Cat is a subtype of Animal.
        
    // 3
//        AnimalHouse<?> house_3 = new AnimalHouse<Cat>();
//        house_3.setAnimal(new Cat());
        
        // fails to compile
        // While the first line is acceptable — it is OK to define an instance of unknown type — the compiler doesn't know 
        // the type of animal stored in house so the setAnimal method cannot be used.

    // 4
        AnimalHouse house_4 = new AnimalHouse();
        house_4.setAnimal(new Dog());
        // compiles with a warning
        // The compiler doesn't know what type house contains. It will accept the code, but warn that there might be 
        // a problem when setting the animal to an instance of Dog.
        
        //Using a generic type as a raw type might be a way to work around a particular compiler error, but you 
        // lose the type checking that generics provides, so it is not recommended.

        // 5
        Animal cat = new Cat();

        AnimalHouse<? extends Animal> animalHouse = new AnimalHouse<>();
//        animalHouse.setAnimal(cat); // compile error to because of required type
        
        // 6 
        Cat cat1 = new Cat();
        AnimalHouse<Cat> animalHouse1 = new AnimalHouse<>(); // Write-only object 
        animalHouse1.setAnimal(cat1);
//        animalHouse1.getAnimal(); // will be ignored
        
        

    }
}

class AnimalHouse<E> {
    private E animal;

    public void setAnimal(E x) {
        animal = x;
    }

    public E getAnimal() {
        return animal;
    }
}

class Animal {
}

class Cat extends Animal {
}

class Dog extends Animal {
}