package com.codility.vonage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        int X[] = {1,8,7,3,4,1,8};
        int Y[] = {6,4,1,8,5,1,7};
        Test2 test2 = new Test2();
        System.out.println(test2.solution(X,Y));
    }
    public int solution(int[] X, int[] Y) {
        final List<Integer> list = Arrays.stream(X).boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        final List<Integer> diffList = new ArrayList<>();
        final AtomicInteger first = new AtomicInteger(0);
        final AtomicInteger current =  new AtomicInteger();
        list.forEach(element -> {
            if(first.getAndSet(1)==0){
                current.set(element);
            }else {
                diffList.add(current.getAndSet(element)-element);
            }

        });
        diffList.add(1);
        diffList.sort(Collections.reverseOrder());
        return diffList.get(0);
    }
}
