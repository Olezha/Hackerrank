package org.olezha;

import java.util.Scanner;

public class Staircase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        staircase(n);
    }

    static void staircase(int n) {
        String out = "";
        for (int i = 1; i <= n; i++) {
            out += "#";
            System.out.printf("%" + n + "s%n", out);
        }
    }
}
