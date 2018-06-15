package org.olezha;

import java.util.*;

/**
 * You have an integer K and a list of  integers.
 * Your goal is to find all possible shortest intervals in the list,
 * such that the product of the integers in each interval, is a multiple of K.
 *
 * Sample Input:
 * 6 5
 * 2 9 4 3 16
 * Sample Output:
 * Minimum interval length: 2
 * Found intervals:
 * [1, 2]
 * [2, 3]
 * [3, 4]
 * [4, 5]
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

            findInInterval: for (ListIterator<Long> iterator = nList.listIterator(); iterator.hasNext(); ) {
                position++;
                long firstINTEGER = iterator.next();
                iterator.previous();
                for (long i = 1; i < interval; i++) {
                    if (iterator.hasNext())
                        iterator.next();
                    else break findInInterval;
                    if (!iterator.hasNext())
                        break findInInterval;
                }
                long secondINTEGER = iterator.next();
                for (long i = 1; i < interval; i++)
                    iterator.previous();

                if (firstINTEGER * secondINTEGER % k == 0)
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
            Collections.sort(possibleIntervals);
            response.addAll(possibleIntervals);
        }
        return response;
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
