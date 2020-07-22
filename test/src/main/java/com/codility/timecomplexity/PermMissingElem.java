package com.codility.timecomplexity;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/*
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)],
 which means that exactly one element is missing.

    Your goal is to find that missing element.

    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A, returns the value of the missing element.

    For example, given array A such that:

    A[0] = 2
    A[1] = 3
    A[2] = 1
    A[3] = 5
    the function should return 4, as it is the missing element.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [0..100,000];
    the elements of A are all distinct;
    each element of array A is an integer within the range [1..(N + 1)].*/
public class PermMissingElem {
    public static void main(String[] args) {
        final int[] data = {2,3,5,1,4,7,8,9 };
        final int[] data1 = {2,3,4,1};
        PermMissingElem elem = new PermMissingElem();
        System.out.println(elem.solution(data));
        System.out.println(elem.solution(data1));
    }

    public int solution(int[] A){
        List<Integer> result = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());
        Iterator it = result.iterator();
        int current =(Integer) it.next();
        int found = 0;
        if(it.hasNext()) {
            do {
                int next = (Integer) it.next();
                if (next - current == 2) {
                    found = current+1;
                    break;
                } else {
                    current = next;
                }

            } while (it.hasNext());
        }
        return found;
    }
}
