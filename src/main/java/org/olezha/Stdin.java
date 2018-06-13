package org.olezha;

import java.util.Locale;
import java.util.Scanner;

/**
 * In this challenge, you must read an integer, a double, and a String from stdin,
 * then print the values according to the instructions in the Output Format section below.
 *
 * Note: If you use the nextLine() method immediately following the nextInt() method,
 * recall that nextInt() reads integer tokens;
 * because of this, the last newline character for that line of integer input
 * is still queued in the input buffer and the next nextLine()
 * will be reading the remainder of the integer line (which is empty).
 */
class Stdin {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        int i = scan.nextInt();

        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
