package com.interview.collection.hash;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CollectionInitialization {

    public static void main(String[] args) {
        initArray();
        initList();
    }

    private static void initArray() {
        //array
        int intArray[] = new int[10];
        int intArray2[] = new int[]{1, 2, 3};
        final String names[] = {"b", "c"};

        List<String> stringList = Arrays.asList(names);
        List<String> stringList1 = Arrays.asList("a", "b");

        String[] strArray = {"How", "To", "Do", "In", "Java"};

        String joinedString = String.join(", ", strArray);
        System.out.println(joinedString);
        //   Output: How, To, Do, In, Java

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("How")
                .add("To")
                .add("Do")
                .add("In")
                .add("Java");
        //   Output: [How, To, Do, In, Java]

        List<String> numbers = Arrays.asList("How", "To", "Do", "In", "Java");
        String joinedString1 = numbers
                .stream()
                .collect(Collectors.joining(", ", "[", "]"));
        //   Output: [How, To, Do, In, Java]
    }

    private static void initList() {
        List<String> list1 = Arrays.asList("arun", "divya", "anwitha", "aadhi");
        String data = list1.stream().collect(Collectors.joining());
        System.out.println(data);
    }
}
