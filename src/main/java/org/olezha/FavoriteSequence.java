package org.olezha;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FavoriteSequence {

    /**
     * https://www.hackerrank.com/challenges/favourite-sequence
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        int n = scan.nextInt();
        int[][] nM = new int[n][];

        for (int i = 0; i < n; i++) {
            int k = scan.nextInt();
            int[] m = new int[k];
            for (int j = 0; j < k; j++) {
                m[j] = scan.nextInt();
            }
            nM[i] = m;
        }

        System.out.println(
                IntStream.of(lessSequence(nM))
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(" ")));
    }

    static int[] lessSequence(int[][] nCopiesOfBrokenSequenceM) {
        /* TODO
         * - найти все совпадающие цифры
         * - собрать последовательность сразу в лексикографическом порядке,
         *   исходя из найденных интервалов
         */
        return null;
    }
}

@Slf4j
class Main2 {

    public static void main(String[] args) {
        log.info("{}", FavoriteSequence.lessSequence(new int[][]{
                {1, 3},
                {2, 3, 4}}));
    }
}
