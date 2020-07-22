package com.codility.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class OddOccurancyInArray {
    public static void main(String[] args) {
        int[] data = {9, 3, 9, 7, 9, 7, 9, 3, 3, 3, 9};
        OddOccurancyInArray occurancy = new OddOccurancyInArray();
        System.out.println(occurancy.solution(data));
    }

    public int solution(int[] A) {
        final Comparator<Map.Entry<Integer, Long>> comp = Map.Entry.<Integer, Long>comparingByValue().reversed();
        final List<Map.Entry<Integer, Long>> list = Arrays.stream(A).boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue() % 2))
                .entrySet().stream().collect(Collectors.toList());
        list.sort(comp);
        return list.get(0).getKey();
    }
}
