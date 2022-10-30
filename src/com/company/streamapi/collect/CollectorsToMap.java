package com.company.streamapi.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsToMap {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Mulan",
                "Mjay",
                "Jasmine",
                "Aurora",
                "Eve",
                "Mjay");
        
        /*
            !!! ВАРТО ПАМ'ЯТАТИ
            
            Коли ви перетворюєте List на Map, ви повинні звернути увагу на різні характеристики цих двох класів колекції, 
            List допускає повторювані елементи, але Map не дозволяє дублікат ключі. 
            
            Що станеться, якщо ви спробуєте перетворити список із повторюваними елементами на Map в Java 8? = 
            метод викличе IllegalStateException
            
         */

        /*  
            коли значенням Map є сам об’єкт, ми передаємо об'єкт за допомогою методу Function.identify()
            тобто можна передати лямбду цього об'єкта 
            у цьому випадку було б     name -> name == Function.identity() == s -> s == key -> key ... someObject -> someObject 
         */

        Map<String, Integer> map = names.stream()
                .collect(Collectors.toMap(
                        Function.identity(),   // 1. actual String as KEY   | коли значенням Map є сам об’єкт,
                        String::length,        // 2. String length as their VALUE
                        (key1, ke2) -> key1   // 3. duplicate KEY resolver  | (oldValue, newValue) -> oldValue
                ));

        System.out.println("map = " + map);
//        map = {Aurora=6, Mjay=4, Mulan=5, Eve=3, Jasmine=7}
        
        
//        якщо потрібно відсортувати по ключу можна використати TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>(map);
        
        System.out.println("treeMap = " + treeMap);
//        treeMap = {Aurora=6, Eve=3, Jasmine=7, Mjay=4, Mulan=5}
        
        System.out.println("----------------------------------------------------------------------------------------\n");

//        щоб зразу мати відсортовану мапу, можна передати TreeMap
        
        Map<String, Integer> map1 = names.stream()
                .collect(Collectors.toMap(
                        Function.identity(),   // 1. actual String as KEY   | коли значенням Map є сам об’єкт,
                        String::length,        // 2. String length as their VALUE
                        (key1, ke2) -> key1,   // 3. duplicate KEY resolver  | (oldValue, newValue) -> oldValue
                        TreeMap::new           // 4. implementation-class = TreeMap
                ));

        System.out.println("map1 = " + map1);
//        map1 = {Aurora=6, Eve=3, Jasmine=7, Mjay=4, Mulan=5}  // буде відсортоване, бо використовуємо TreeMap

        System.out.println("----------------------------------------------------------------------------------------\n");

//        IllegalStateException тому що не визначено що робити з дублікатами
        
//        Map<String, Integer> map2 = names.stream()
//                .collect(Collectors.toMap(
//                        Function.identity(),   // 1. actual String as KEY
//                        String::length        // 2. String length as their VALUE
//                ));

//        System.out.println("map2 = " + map2); // тому що не визначено що робити з дублікатами

//        Exception in thread "main" java.lang.IllegalStateException: Duplicate key 4
        
//------------------------------------------------------------------------------------------------------
//      цей самий приклад IllegalStateException: Duplicate key Mjay
        
//        Map<String, String> map3 = names.stream()
//                .collect(Collectors.toMap(Function.identity(), name -> name));
//
//        System.out.println("map3 = " + map3);
//        Exception in thread "main" java.lang.IllegalStateException: Duplicate key Mjay

        System.out.println("----------------------------------------------------------------------------------------\n");

//     можна зразу відкинути дублікати

        Map<String, Integer> map4 = names.stream()
                .distinct()                    // 1.відкидаємо дублікати
                .collect(Collectors.toMap(
                        Function.identity(),   // 2. сам об'єкт
                        String::length         // 3. довжина рядка цього значення
                ));

        System.out.println("map4 = " + map4); // працює, бо зразу відкинули дублікатами
//        map4 = {Aurora=6, Mjay=4, Mulan=5, Eve=3, Jasmine=7}

        System.out.println("----------------------------------------------------------------------------------------\n");

//        Цей приклад показує трюк для збереження порядку елементів у списку під час перетворення на карту за допомогою LinkedHashMap.

        LinkedHashMap<String, Integer> map5 = names.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::length,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        
        System.out.println("map5 = " + map5);
//        map5 = {Mulan=5, Mjay=4, Jasmine=7, Aurora=6, Eve=3}  // у тому ж порядку, що і були записані

        System.out.println("----------------------------------------------------------------------------------------\n");
        
        System.out.println("-------  для групування значень які частково або повність дублюються по ключу ----------");
        System.out.println("----------------------------------------------------------------------------------------\n");

        List<String> fruits = Arrays.asList(
                "apricot",
                "apple",
                "banana",
                "orange",
                "apple");

        Map<Character, String> collect = fruits.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit.charAt(0),
                        Function.identity(),      // == fruit -> fruit
                        (fruit1, fruit2) -> fruit1 + "|" + fruit2));

        System.out.println("collect = " + collect);
//        collect = {a=apple|apricot|apple, b=banana, o=orange}

    }
}
