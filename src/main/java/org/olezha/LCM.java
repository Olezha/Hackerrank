package org.olezha;

/**
 * Least common multiple
 * Наименьшее общее кратное
 */
public class LCM {

    private static long lcm(long a, long b) {
        return a * (b / GCD.gcd(a, b));
    }

    private static long lcm(long[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = lcm(result, input[i]);
        }
        return result;
    }
}
