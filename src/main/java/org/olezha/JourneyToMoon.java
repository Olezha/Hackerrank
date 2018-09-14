package org.olezha;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//www.hackerrank.com/challenges/journey-to-the-moon
public class JourneyToMoon {

    public static void main(String[] args) {
        System.out.println(journeyToMoon(5, new int[][]{{0, 1}, {2, 3}, {0, 4}}) == 6);
        System.out.println(journeyToMoon(4, new int[][]{{0, 2}}) == 5);
    }

    private static int journeyToMoon(int n, int[][] astronaut) {
        Set<Integer> namedAstronautSet = new HashSet<>();

        for (int[] pair : astronaut) {
            namedAstronautSet.add(pair[0]);
            namedAstronautSet.add(pair[1]);
        }

        List<Integer> namedAstronautList = new ArrayList<>(namedAstronautSet);

        Set<Pair> pairs = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Pair pair = new Pair();
                if (namedAstronautList.size() > i)
                    pair.first = namedAstronautList.get(i);
                if (namedAstronautList.size() > j)
                    pair.second = namedAstronautList.get(j);
                pairs.add(pair);
            }
        }

        for (int[] pair : astronaut) {
            Pair countryPair = new Pair();
            countryPair.first = pair[0];
            countryPair.second = pair[1];
            pairs.remove(countryPair);

            for (int[] otherPair : astronaut) {
                if (otherPair[0] == pair[0] && otherPair[1] == pair[1])
                    continue;

                for (int i = 0, j = 0; i < 2;) {
                    if (pair[i] == otherPair[j]) {
                        Pair sameCountryPair = new Pair();
                        sameCountryPair.first = pair[i == 0 ? 1 : 0];
                        sameCountryPair.second = otherPair[j == 0 ? 1 : 0];
                        pairs.remove(sameCountryPair);
                    }

                    i += j;
                    j = j == 0 ? 1 : 0;
                }
            }
        }

        return pairs.size();
    }
}

class Pair {

    Integer first, second;

    @Override
    public int hashCode() {
        return (first != null ? first : 0) + (second != null ? second : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pair pair = (Pair) obj;

        return first != null && second != null && pair.first != null && pair.second != null
                && ((first.equals(pair.first) && second.equals(pair.second))
                || (second.equals(pair.first) && first.equals(pair.second)));

    }
}
