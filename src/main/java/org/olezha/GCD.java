package org.olezha;

public class GCD {

    public static void main(String[] args) {
        System.out.println("100 25: " + gcd(100, 25));
        System.out.println("100 45: " + gcd(100, 45));
        System.out.println("17 7: " + gcd(17, 7));
        System.out.println("5 0: " + gcd(5, 0));
//        System.out.println("-5 10: " + gcd(-5, 10));
    }

    public static long gcd(long a, long b) {
        if (a == b)
            return a;
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        if ((~a & 1) != 0) {
            if ((b & 1) != 0)
                return gcd(a >> 1, b);
            else
                return gcd(a >> 1, b >> 1) << 1;
        }

        if ((~b & 1) != 0)
            return gcd(a, b >> 1);

        if (a > b)
            return gcd((a - b) >> 1, b);

        return gcd((b - a) >> 1, a);
    }
}
