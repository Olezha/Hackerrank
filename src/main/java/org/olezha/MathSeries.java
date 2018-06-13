package org.olezha;

import java.util.Scanner;

/**
 * Java Loops II
 */
public class MathSeries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            for (int j = 1; j <= n; j++) {
                int sum = 0;
                for (int k = 0; k < j; k++) {
                    sum += Math.pow(2, k) * b;
                }
                System.out.print(a + sum + " ");
            }
            System.out.println();
        }
        in.close();
    }
}
