package com.codility.timecomplexity;

import java.util.*;
import java.util.stream.Collectors;

/*Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

        Given A = [1, 2, 3], the function should return 4.

        Given A = [−1, −3], the function should return 1.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].*/
public class NextPositiveMissingElement {
    public static void main(String[] args) {
        NextPositiveMissingElement element = new NextPositiveMissingElement();
        int A[] = {1,2,3};
        System.out.println(element.solution(A));
        int B[] = {-1,-3};
        System.out.println(element.solution(B));
        int C[] = {-1};
        System.out.println(element.solution(C));
        int D[] = {2};
        System.out.println(element.solution(D));

    }
    public int solution(int[] A) {
        int aa = A.length ;
        List<Integer> list = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());
        Iterator it = list.iterator();
        int current =(Integer) it.next();
        int found = 1;
        while(it.hasNext()){
            int next = (Integer) it.next();
            if (next-current == 2) {
                found = current+1;
                break;
            } else {
                found = next + 1;
                current = next;
            }
        }
        if(found<0){
            return 1;
        }
        return found;
    }

    public int solution1(int[] A) {
        List<Integer> list = null;
        if(A[0]>0) {
            list = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());
        }else {
            list = Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
            return (list.get(0)+2);
        }
        Iterator it = list.iterator();
        int current =(Integer) it.next();
        int found = 0;
        if(it.hasNext()) {
            do {
                int next = (Integer) it.next();
                if (next - current == 2) {
                    found = current+1;
                    break;
                } else {
                    found = next+1;
                    current = next;
                }

            } while (it.hasNext());
        }
        return found;
    }
}
