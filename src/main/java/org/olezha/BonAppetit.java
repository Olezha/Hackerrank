package org.olezha;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class BonAppetit {

    public static void main(String[] args) {
        int annaDeclinesToEatItem, charged;
        int[] bill;
        try (Scanner scan = new Scanner(System.in).useLocale(Locale.US)) {
            annaDeclinesToEatItem = Integer.parseInt(scan.nextLine().split(" ")[1]);
            bill = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
            charged = scan.nextInt();
        }

        int actual = 0;
        for (int i = 0; i < bill.length; i++) {
            if (i != annaDeclinesToEatItem)
                actual += bill[i];
        }
        actual /= 2;

        if (charged == actual)
            System.out.println("Bon Appetit");
        else
            System.out.println(charged - actual);
    }
}
