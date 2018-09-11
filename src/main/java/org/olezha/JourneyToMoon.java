package org.olezha;

import java.util.HashSet;
import java.util.Set;

/*
 * https://www.hackerrank.com/challenges/journey-to-the-moon
 */
public class JourneyToMoon {

    public static void main(String[] args) {
        System.out.println(journeyToMoon(-1, new int[][]{{0, 1}, {2, 3}, {0, 4}}));
    }

    private static int journeyToMoon(int n, int[][] astronaut) {
        Set<Pair> pairs = new HashSet<>();
        for (int i = 0; i < astronaut.length - 1; i++) {
            Pair pair1 = new Pair();
            pair1.first = astronaut[i][0];
            pair1.second = astronaut[i + 1][0];
            pairs.add(pair1);

            Pair pair2 = new Pair();
            pair2.first = astronaut[i][0];
            pair2.second = astronaut[i + 1][1];
            pairs.add(pair2);

            Pair pair3 = new Pair();
            pair3.first = astronaut[i][1];
            pair3.second = astronaut[i + 1][1];
            pairs.add(pair3);

            Pair pair4 = new Pair();
            pair4.first = astronaut[i][1];
            pair4.second = astronaut[i + 1][1];
            pairs.add(pair4);
        }
        return pairs.size();
    }
}

class Pair {

    int first, second;

    @Override
    public int hashCode() {
        return first + second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pair pair = (Pair) obj;

        return first == pair.first && second == pair.second;
    }
}
