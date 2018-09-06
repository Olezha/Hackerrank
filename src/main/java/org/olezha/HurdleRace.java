package org.olezha;

import java.util.Arrays;

public class HurdleRace {

    public static void main(String[] args) {
        System.out.println(hurdleRace(1, new int[]{1, 6, 3, 5, 2}));
        System.out.println(hurdleRace(7, new int[]{1, 6, 3, 5, 2}));
    }

    private static int hurdleRace(int k, int[] height) {
        int maxHeight = Arrays.stream(height).max().orElse(0);
        return maxHeight > k ? maxHeight - k : 0;
    }
}
