package org.olezha;

import java.util.Scanner;

public class Staircase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        staircase(n);

        System.out.println(timeConversion("07:05:45PM"));
    }

    static void staircase(int n) {
        String out = "";
        for (int i = 1; i <= n; i++) {
            out += "#";
            System.out.printf("%" + n + "s%n", out);
        }
    }

    static String timeConversion(String s) {
        String time = s.substring(0, 8);
        String flag = s.substring(8);

        int hour = Integer.parseInt(time.substring(0, 2));
        String secondPart = time.substring(2);
        if (hour == 12)
            hour = 0;

        if ("PM".equals(flag)) {
            hour += 12;
            if (hour == 24)
                hour = 0;
        }
        return String.format("%02d", hour) + secondPart;
    }
}
