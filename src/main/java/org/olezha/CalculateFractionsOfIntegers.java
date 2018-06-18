package org.olezha;

import java.util.HashMap;
import java.util.Map;

public class CalculateFractionsOfIntegers {

    public static void main(String[] args) {
        plusMinus(new int[]{1, -1, 14, 1, 1, 1, -1});
    }

    static void plusMinus(int[] arr) {
        Map<String, Integer> frequency = new HashMap<>();
        for (int n : arr) {
            if (n > 0)
                frequency.put("positive", frequency.getOrDefault("positive", 0) + 1);
            else if (n < 0)
                frequency.put("negative", frequency.getOrDefault("negative", 0) + 1);
            else
                frequency.put("zeros", frequency.getOrDefault("zeros", 0) + 1);
        }
        System.out.printf("%f%n", ((float) frequency.getOrDefault("positive", 0)) / arr.length);
        System.out.printf("%f%n", ((float) frequency.getOrDefault("negative", 0)) / arr.length);
        System.out.printf("%f%n", ((float) frequency.getOrDefault("zeros", 0)) / arr.length);
    }
}
