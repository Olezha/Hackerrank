package org.olezha;

public class PickingNumbers {

    public static void main(String[] args) {
        System.out.println(pickingNumbers(new int[]{1, 1, 2, 2, 4, 4, 5, 5, 5}));
    }

    private static int pickingNumbers(int[] a) {
        int maxLength = 0;
        for (int a1 : a) {
            int countGroupFromAiToAiPlus1 = 0;
            int countGroupFromAiMinus1ToAi = 0;
            for (int a2 : a) {
                if (a1 == a2) {
                    countGroupFromAiToAiPlus1++;
                    countGroupFromAiMinus1ToAi++;
                } else if (a1 + 1 == a2)
                    countGroupFromAiToAiPlus1++;
                else if (a1 - 1 == a2)
                    countGroupFromAiMinus1ToAi++;
            }

            if (countGroupFromAiToAiPlus1 > maxLength)
                maxLength = countGroupFromAiToAiPlus1;
            if (countGroupFromAiMinus1ToAi > maxLength)
                maxLength = countGroupFromAiMinus1ToAi;
        }
        return maxLength;
    }
}
