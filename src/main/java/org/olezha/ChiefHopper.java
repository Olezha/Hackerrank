package org.olezha;

public class ChiefHopper {

    public static void main(String[] args) {
        System.out.println(chiefHopper(new int[]{3, 4, 3, 2, 4}) + " "
                + chiefHopperOptimized(new int[]{3, 4, 3, 2, 4}) + " "
                + chiefHopperOptimized2(new int[]{3, 4, 3, 2, 4}));
        System.out.println(chiefHopper(new int[]{4, 4, 4}) + " "
                + chiefHopperOptimized(new int[]{4, 4, 4}) + " "
                + chiefHopperOptimized2(new int[]{4, 4, 4}));
        System.out.println(chiefHopper(new int[]{1, 6, 4}) + " "
                + chiefHopperOptimized(new int[]{1, 6, 4}) + " "
                + chiefHopperOptimized2(new int[]{1, 6, 4}));
        System.out.println(chiefHopper(new int[]{2, 3, 4, 5, 6, 9, 11}) + " "
                + chiefHopperOptimized(new int[]{2, 3, 4, 5, 6, 9, 11}) + " "
                + chiefHopperOptimized2(new int[]{2, 3, 4, 5, 6, 9, 11}));
    }

    /**
     * https://www.hackerrank.com/challenges/chief-hopper
     */
    private static int chiefHopper(int[] arr) {
        int startingEnergy = 0, energy = 0;
        for (int i = 0; i < arr.length; ) {
            if (arr[i] > energy)
                energy -= arr[i] - energy;
            else
                energy += energy - arr[i];

            if (energy < 0) {
                energy = ++startingEnergy;
                i = 0;
                continue;
            }

            i++;
        }
        return startingEnergy;
    }

    private static int chiefHopperOptimized(int[] arr) {
        int energy = 0;
        for (int i = arr.length - 1; i >= 0; i--)
            energy = (energy + arr[i] + 1) / 2;
        return energy;
    }

    private static int chiefHopperOptimized2(int[] arr) {
        int energy = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int x = energy + arr[i];
            energy = x / 2 + x % 2;
        }
        return energy;
    }
}
