package com.company.streamapi.groupingby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingBy_2 {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 1, 1, 3);

        Map<Integer, Long> map1 = integers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("map1 = " + map1);
//        map1 = {1=3, 2=1, 3=2}
        
        System.out.println("----------------------------------------------------------------------------------------\n");

        List<String> strings = Arrays.asList("a", "b", "c", "a", "c", "a");
        Map<String, Long> map2 = strings.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("map2 = " + map2);
//        map2 = {a=3, b=1, c=2}
        
        System.out.println("----------------------------------------------------------------------------------------\n");

    }
}
