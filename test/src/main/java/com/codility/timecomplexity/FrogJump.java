package com.codility.timecomplexity;

public class FrogJump {
    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        System.out.println(frogJump.solution(10,85,30));
        System.out.println(frogJump.solution(0,90,10));
        System.out.println(frogJump.solution(0,91,10));
    }
    public int solution(int X, int Y, int D){
        return (Y-X) / D + ((Y-X) % D == 0 ? 0 : 1);
    }
}
