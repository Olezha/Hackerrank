package org.olezha;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PriyankaAndToys {

    public static void main(String[] args) {
        System.out.println(howMuchDoToysCost(new int[]{1, 2, 3, 17, 10}));
    }

    /*
     * Any one toy is worth 1 money.
     * But when you buy any toy you get others weighing in [w, w + 4] for free.
     * Find a minimum of money for which you can buy all the toys.
     */
    private static int howMuchDoToysCost(int[] w) {
        List<Integer> toys = Arrays.stream(w).boxed().sorted().collect(Collectors.toList());
        int spentMoney = 0;
        while (toys.size() > 0) {
            spentMoney++;
            int toy = toys.remove(0);
            for (int i = 0; i < toys.size();) {
                int nextToy = toys.get(i);
                if (nextToy >= toy && nextToy <= toy + 4) toys.remove(i);
                else i++;
            }
        }
        return spentMoney;
    }
}
