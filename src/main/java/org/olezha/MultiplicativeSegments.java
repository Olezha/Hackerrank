package org.olezha;

import java.math.BigInteger;
import java.util.*;

/**
 * You have an integer K and a list of N integers.
 * Your goal is to find all possible shortest intervals in the list,
 * such that the product of the integers in each interval, is a multiple of K.
 *   N[i] * N[j] % K == 0
 *
 * Constraints:
 *   1 <= N <= 2 * 1e5
 *   1 <= K <= 1e17
 *
 * Sample Input:
 *   6 5
 *   2 9 4 3 16
 * Sample Output:
 *   Minimum interval length: 2
 *   Found intervals:
 *   [1, 2]
 *   [2, 3]
 *   [3, 4]
 *   [4, 5]
 *
 * https://www.hackerrank.com/contests/codeagon2015/challenges/mulseg
 */
public class MultiplicativeSegments {

    private static final String NO_POSSIBLE_INTERVAL_MESSAGE = "NONE";
    private static final String INTERVAL_IS_FOUND_PREFIX = "Minimum interval length: ";
    private static final String FOUND_INTERVALS_MESSAGE = "Found intervals:";

    static List<String> findShortestIntervals(long k, long n, List<Long> nList) {
        long interval = 1;
        List<String> possibleIntervals = new LinkedList<>();
        for (; interval < n - 1; interval++) {
            long position = 0;

            ListIterator<Long> firstIterator = nList.listIterator();
            ListIterator<Long> secondIterator = nList.listIterator();
            for (long i = 1; i < interval; i++)
                secondIterator.next();
            for (; secondIterator.hasNext();) {
                position++;
                Long first = firstIterator.next();
                Long second = secondIterator.next();

                if (isMultiple(first, second, k))
                    possibleIntervals.add("[" + position + ", " + (position + interval - 1) + "]");
            }

            if (!possibleIntervals.isEmpty())
                break;
        }

        List<String> response = new LinkedList<>();
        if (possibleIntervals.isEmpty())
            response.add(NO_POSSIBLE_INTERVAL_MESSAGE);
        else {
            response.add(INTERVAL_IS_FOUND_PREFIX + interval);
            response.add(FOUND_INTERVALS_MESSAGE);
            response.addAll(possibleIntervals);
        }
        return response;
    }

    /**
     * @return n1 * n2 % k == 0
     */
    private static boolean isMultiple(long n1, long n2, long k) {
        // TODO: too slow check
        return BigInteger.valueOf(n1)
                .multiply(BigInteger.valueOf(n2))
                .remainder(BigInteger.valueOf(k))
                .equals(BigInteger.ZERO);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long k = scan.nextLong();
        long n = scan.nextLong();
        List<Long> nList = new LinkedList<>();
        while (scan.hasNextLong())
            nList.add(scan.nextLong());
        scan.close();

        for (String s : findShortestIntervals(k, n, nList))
            System.out.println(s);
    }
}
