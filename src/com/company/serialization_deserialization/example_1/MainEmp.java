package com.company.serialization_deserialization.example_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
    > Serialization is a mechanism of converting the state of an object into a byte stream. 
    > Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. 
    > This mechanism is used to persist the object.
    
    
    
    The byte stream created is platform independent. So, the object serialized on one platform can be deserialized 
    on a different platform.
    
    To make a Java object serializable we implement the java.io.Serializable interface.
    
        The ObjectOutputStream class contains writeObject() method for serializing an Object:
                  public final void writeObject(Object obj) throws IOException
    
    
        The ObjectInputStream class contains readObject() method for deserializing an object:
                  public final Object readObject() throws IOException, ClassNotFoundException


    
    Advantages of Serialization
        1. To save/persist state of an object.
        2. To travel an object across a network.



    Only the objects of those classes can be serialized which are implementing java.io.Serializable interface.
    
    Serializable is a marker interface (has no data member and method). It is used to “mark” java classes so that 
    objects of these classes may get certain capabilities. Other examples of marker interfaces are: Cloneable and Remote.
    


    Points to remember
        1. If a parent class has implemented a Serializable interface then the child class doesn’t need to implement 
            it but vice-versa is not true.
        2. Only non-static data members are saved via the Serialization process.
        3. Static data members and transient data members are not saved via Serialization process. 
            So, if you don’t want to save value of a non-static data member then make it transient.
        4. Constructor of an object is never called when an object is deserialized.
        5. Associated objects must be implementing a Serializable interface.    
                    Example :
                            class A implements Serializable{
                                // B also implements Serializable interface.
                                B ob=new B();  
                            }



 */

/*
    
    SerialVersionUID

    The Serialization runtime associates a version number with each Serializable class called a SerialVersionUID, 
    which is used during Deserialization to verify that sender and receiver of a serialized object have loaded 
    classes for that object which are compatible with respect to serialization. If the receiver has loaded a class 
    for the object that has different UID than that of corresponding sender’s class, the Deserialization will result 
    in an InvalidClassException. A Serializable class can declare its own UID explicitly by declaring a field name.
    
    It must be static, final and of type long.
            i.e- ANY-ACCESS-MODIFIER static final long serialVersionUID=42L;
    
    If a serializable class doesn’t explicitly declare a serialVersionUID, then the serialization runtime will 
    calculate a default one for that class based on various aspects of class, as described in Java Object Serialization 
    Specification. However it is strongly recommended that all serializable classes explicitly declare serialVersionUID 
    value, since its computation is highly sensitive to class details that may vary depending on compiler 
    implementations, any change in class or using different id may affect the serialized data.
    
    It is also recommended to use private modifier for UID since it is not useful as inherited member.

    
    
    
   
   
   
   
   Object has been serialized
    Data before Deserialization.
    name = ab
    age = 20
    a = 2
    b = 1000
    notSerializableField = some field
    Object has been deserialized
    Data after Deserialization.
    name = ab
    age = 20
    a = 0
    b = 2000
    notSerializableField = null
    
    In case of transient variables:
        A variable defined with transient keyword is not serialized during serialization process.
        This variable will be initialized with default value during deserialization. 
        (e.g: for objects it is null, for int it is 0).
    
    In case of static Variables:
        A variable defined with static keyword is not serialized during serialization process.
        This variable will be loaded with current value defined in the class during deserialization.

 */

/*

    ObjectOutputStream class
        
        The ObjectOutputStream class is used to write primitive data types, and Java objects to an OutputStream. 
        Only objects that support the java.io.Serializable interface can be written to streams.
        
   Constructor:
        +-------------------------------------------------------------------+--------------------------------------------+
        | public ObjectOutputStream(OutputStream out) throws IOException {} | It creates an ObjectOutputStream           |
        |                                                                   | that writes to the specified OutputStream. |
        +-------------------------------------------------------------------+--------------------------------------------+         
            
   Important Methods:    
        +--------------------------------------------------------------------+-----------------------------------------------------------+
        | Method                                                             | Description                                               |
        +--------------------------------------------------------------------+-----------------------------------------------------------+
        | 1) public final void writeObject(Object obj) throws IOException {} | It writes the specified object to the ObjectOutputStream. |
        +--------------------------------------------------------------------+-----------------------------------------------------------+
        | 2) public void flush() throws IOException {}                       | It flushes the current output stream.                     |
        +--------------------------------------------------------------------+-----------------------------------------------------------+
        | 3) public void close() throws IOException {}                       | It closes the current output stream.                      |
        +--------------------------------------------------------------------+-----------------------------------------------------------+   




    ObjectInputStream class
        
        An ObjectInputStream deserializes objects and primitive data written using an ObjectOutputStream.
        
    Constructor:
        +----------------------------------------------------------------+----------------------------------------------------------------------------+
        | public ObjectInputStream(InputStream in) throws IOException {} | It creates an ObjectInputStream that reads from the specified InputStream. |
        +----------------------------------------------------------------+----------------------------------------------------------------------------+


    Important Methods:
        +-------------------------------------------------------------------------------+-------------------------------------------+
        | Method                                                                        | Description                               |
        +-------------------------------------------------------------------------------+-------------------------------------------+
        | public final Object readObject() throws IOException, ClassNotFoundException{} | It reads an object from the input stream. |
        +-------------------------------------------------------------------------------+-------------------------------------------+
        | public void close() throws IOException {}                                     | It closes ObjectInputStream.              |
        +-------------------------------------------------------------------------------+-------------------------------------------+
            
 */

/*
    
    > Java Serialization with Inheritance (IS-A Relationship)
        If a class implements Serializable interface then all its sub classes will also be serializable.
        Parent class properties are inherited to subclasses so if the parent class is Serializable, subclasses would also be. 

    > Java Serialization with Aggregation (HAS-A Relationship)
        If a class has a reference to another class, all the references must be Serializable otherwise the 
        serialization process will not be performed. In such case, NotSerializableException is thrown at runtime
     
    > Java Serialization with the static data member
        If there is any static data member in a class, it will not be serialized because static is the part of class not the object.

    > Java Serialization with array or collection
        Rule: In case of array or collection, all the objects of array or collection must be serializable. 
        If any object is not serializable, serialization will be failed.

    > Java Transient Keyword
        If you don't want to serialize any data member of a class, you can mark it as transient.
        so when you deserialize the object after serialization => It will return default value always.
        
                +--------------------------+----------------------------+
                |         Data Type        | Default Value (for fields) |
                +--------------------------+----------------------------+
                | byte / short / int /     | 0                          |
                +--------------------------+----------------------------+
                | long                     | 0L                         |
                +--------------------------+----------------------------+
                | float                    | 0.0f                       |
                +--------------------------+----------------------------+
                | double                   | 0.0d                       |
                +--------------------------+----------------------------+
                | char                     | '\u0000'                   |
                +--------------------------+----------------------------+
                | String (or any object)   | null                       |
                +--------------------------+----------------------------+
                | boolean                  | false                      |
                +--------------------------+----------------------------+

 */

public class MainEmp {
    public static void main(String[] args) {
        Emp object = new Emp("ab", 20, 2, 1000, "some field");
        String filename = "example2.txt";

        // Serialization

        // Saving of object in a file
        try (FileOutputStream file = new FileOutputStream(filename)) {
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();


            System.out.println("Object has been serialized\n"
                    + "Data before Deserialization.");
            printData(object);

            // value of static variable changed
            object.b = 2000;
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        object = null;

        // Deserialization

        // Reading the object from a file
        try (FileInputStream file = new FileInputStream(filename)) {
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object = (Emp) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printData(object);

            // System.out.println("z = " + object1.z);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
        }
    }

    public static void printData(Emp object1) {

        System.out.println("name = " + object1.name);
        System.out.println("age = " + object1.age);
        System.out.println("a = " + object1.a);
        System.out.println("b = " + object1.b);
        System.out.println("notSerializableField = " + object1.notSerializableField);
    }
}


class Emp implements Serializable {
    private static final long serialversionUID = 129348938L;
    transient int a;
    static int b;
    transient String notSerializableField;
    String name;
    int age;

    // Default constructor
    public Emp(String name, int age, int a, int b, String notSerializableField) {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
        this.notSerializableField = notSerializableField;
    }
}