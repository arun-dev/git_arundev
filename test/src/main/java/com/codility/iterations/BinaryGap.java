package com.codility.iterations;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryGap {
    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(1041));
        System.out.println(binaryGap.solution(104001));
        System.out.println(binaryGap.solution(100));
        System.out.println(binaryGap.solution(10));
        System.out.println(binaryGap.solution(20));
        System.out.println(binaryGap.solution(4));
        System.out.println(binaryGap.solution(6));
    }

    public int solution1(int N){
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);
        System.out.println(binary.replaceAll("0+$",""));
        int count = 0;
        List<Integer> counterList = new ArrayList<Integer>();
        for(char pos : binary.toCharArray()){

           if(pos=='0'){
               count++;
           }else{
               counterList.add(count);
               count = 0;
           }
        }

        return Collections.max(counterList);
    }
    public int solution(int N){
        try {
            return Collections.max(Arrays.asList(Integer.toBinaryString(N)
                    .replaceAll("0+$", "").split("1"))
                    .stream().mapToInt(String::length).boxed()
                    .collect(Collectors.toList()));
        }catch (NoSuchElementException e){
            return 0;
        }
    }

    public int solutionw(int N) {
        String binaryNumber = Integer.toBinaryString(N);

        String[] gaps = binaryNumber.replaceAll("0+$", "").split("1");


        int maxLength = 0;
        for (String gap: gaps) {
            if (gap.length() > 0 && gap.length() > maxLength) {
                maxLength = gap.length();
            }
        }
        return maxLength;
    }
}
