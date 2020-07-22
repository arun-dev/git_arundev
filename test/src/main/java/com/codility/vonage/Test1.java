package com.codility.vonage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.solution(213));
        System.out.println(test1.solution(355));
    }
    public int solution(int N){
        final List<Integer> digits = new ArrayList<>();
        while (N > 0) {
            digits.add(N%10);
            N/=10;
        }
        digits.sort(Collections.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        digits.stream().forEach(element -> stringBuilder.append(element));
        return Integer.parseInt(stringBuilder.toString());
    }
}
