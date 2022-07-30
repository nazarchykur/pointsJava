package com.company.generics.generics_1;

public class GenericClassWithExtends<T extends Number> {

    private T field;

    public GenericClassWithExtends(T field) {
        this.field = field;
    }

    public double square() {
        return field.intValue() * field.intValue();
    }
}

/*
Number
  Integer
  Double
  Float
  ...
  
  
                T extends Number
                
  означає, що ми можемо прийняти якийсь тип Т = будь-який підтип Number
  
  якщо спробувати прокинути наприклад String, то буде помилка компіляції
 */