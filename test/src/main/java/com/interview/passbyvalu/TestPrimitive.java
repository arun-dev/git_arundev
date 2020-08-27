package com.interview.passbyvalu;

public class TestPrimitive {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        TestPrimitive primitive = new TestPrimitive();
        sb.append("First");
        System.out.println(sb.toString());
        primitive.testObject(sb);
        System.out.println(sb.toString());
        int val = 5;
        primitive.testPrimitive(val);
        System.out.println(val);
    }

    private void testObject(StringBuilder sb){
        sb.append("Second");
    }

    private void testPrimitive(int val){
        val = 10;
    }
}



