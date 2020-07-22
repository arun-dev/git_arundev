package com.codility;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NthMostRareElementList {
    public static void main(String[] args) {
        int[] array = {2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 16};
        //IntStream.range(0, 8).forEach(i -> System.out.println(findRarest(array, i)));
        IntStream.range(0, 1).forEach(i -> System.out.println(rare(array, i)));


       /* Map result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));*/
    }

    public static long findRarest(int[] array, int nth) {
        Map<Integer, Long> map = Arrays.stream(array).boxed().collect(
                Collectors.groupingBy(arrayElement -> arrayElement, Collectors.counting()));
        Comparator<Map.Entry<Integer, Long>> comp = Comparator.comparing(entry -> entry.getValue());
        List<Map.Entry<Integer, Long>> list = new ArrayList<>(map.entrySet());
        list.sort(comp);
        if (nth > list.size() - 1) throw new IllegalArgumentException("no such element");
        return list.get(nth).getKey();
    }

    public static long rare(int array[], int nth) {
        Map<Integer, Long> map = Arrays.stream(array).boxed().collect(
                Collectors.groupingBy(element ->
                 {
                    System.out.println(element);
                    return element;
                }, Collectors.counting()));
        return 0l;
    }

}
