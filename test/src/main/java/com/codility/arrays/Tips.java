package com.codility.arrays;

public class Tips {
    public static void main(String[] args) {
        //odd or even
        oddOrEven();
        fastMultiplicationOrDivision();
        swap2Numbers();
        mostSignificantDigit();
        numberOfDigits();
        isPowerOfTwo(8);
        bitwise();
    }

    public static void oddOrEven(){
        int a = 2;
        System.out.println((a & 1) == 0 ?  "EVEN" : "ODD" );
        /**
         * Example:
         * num = 5
         * Binary: “101 & 1” will be 001, so true
         * num = 4
         * Binary: “100 & 1” will be 000, so false.
         */
    }

    public static void fastMultiplicationOrDivision(){
        int n = 10;
        //multiply by 2
        System.out.println( n << 1);

        //divide by 2
        System.out.println( n>> 1);
    }


    public static void  swap2Numbers(){
        int a = 10;
        int b = 20;
        System.out.println( " a = "+ a + " | b = " +b);
        a ^= b;
        b ^= a;
        a ^= b;

        System.out.println( " a = "+ a + " | b = " +b);
    }


    public static void mostSignificantDigit(){
        double N = 2123456789d;
        double K = Math.log10(N);
        K = K - Math.floor(K);
        int X = (int)Math.pow(10,K);
        System.out.println(X);

    }

    public static void numberOfDigits(){
        double N = 10000000.0;
        int D = (int)Math.floor(Math.log10(N))+ 1;
        System.out.println(D);

        System.out.println(Math.log10(N));
        System.out.println(Math.floor(Math.log10(N)));
        // get two double numbers
        double x = 60984.1;
        double y = 1000;

        // get the base 10 logarithm for x
        System.out.println("Math.log10(" + x + ")=" + Math.log10(x));

        // get the base 10 logarithm for y
        System.out.println("Math.log10(" + y + ")=" + Math.log10(y));
    }

    /* Method to check if x is power of 2*/
    public static boolean isPowerOfTwo (int x)
    {
     /* First x in the below expression is
     for the case when x is 0 */
        boolean result = x!=0 && ((x&(x-1)) == 0);
        System.out.println(result);
        return result;
    }

    public static void bitwise(){
        //Initial values
        int a = 5;
        int b = 7;

        // bitwise and
        // 0101 & 0111=0101 = 5
        System.out.println("a&b = " + (a & b));

        // bitwise or
        // 0101 | 0111=0111 = 7
        System.out.println("a|b = " + (a | b));

        // bitwise xor
        // 0101 ^ 0111=0010 = 2
        System.out.println("a^b = " + (a ^ b));

        // bitwise and
        // ~0101=1010
        // will give 2's complement of 1010 = -6
        System.out.println("~a = " + ~a);

        // can also be combined with
        // assignment operator to provide shorthand
        // assignment
        // a=a&b
        a &= b;
        System.out.println("a= " + a);
    }
}
