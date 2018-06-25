package org.olezha;

import java.util.Arrays;

public class MagicSquare {

    private static int[][] squareLuoShu = {
            {4, 9, 2},
            {3, 5, 7},
            {8, 1, 6}
    };

    static int formingMagicSquare(int[][] square) {
        int[] difference = {0, 0, 0, 0, 0, 0, 0, 0};
        for (int n = 0; n < 4; n++) {
            int[][] reflectedSquare = reflect(squareLuoShu);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    difference[n] += Math.abs(square[i][j] - squareLuoShu[i][j]);
                    difference[n + 4] += Math.abs(square[i][j] - reflectedSquare[i][j]);
                }
            }
            squareLuoShu = rotate(squareLuoShu);
        }
        return Arrays.stream(difference).min().getAsInt();
    }

    private static int[][] rotate(int[][] square) {
        int[][] rotatedSquare = new int[square.length][square.length];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                rotatedSquare[square.length - 1 - j][i] = square[i][j];
            }
        }
        return rotatedSquare;
    }

    private static int[][] reflect(int[][] square) {
        int[][] reflectedSquare = new int[3][3];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length / 2 + square.length % 2; j++) {
                reflectedSquare[i][j] = square[i][square.length - 1 - j];
                reflectedSquare[i][square.length - 1 - j] = square[i][j];
            }
        }
        return reflectedSquare;
    }

    public static void main(String[] args) {
        System.out.println(formingMagicSquare(new int[][]{
                {4, 9, 2},
                {3, 5, 7},
                {8, 1, 5}
        }));

        System.out.println(formingMagicSquare(new int[][]{
                {4, 8, 2},
                {4, 5, 7},
                {6, 1, 6}
        }));
    }
}
