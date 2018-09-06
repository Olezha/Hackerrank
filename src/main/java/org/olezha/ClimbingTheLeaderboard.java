package org.olezha;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ClimbingTheLeaderboard {

    public static void main(String[] args) {
        log.info("{}",
                climbingLeaderboard(
                        new int[]{100, 90, 90, 80, 75, 60},
                        new int[]{50, 65, 77, 90, 102}));
    }

    private static Object climbingLeaderboard(int[] scores, int[] alice) {
        List<Integer> uniqueRankLeaderboard = new HashSet<Integer>() {{
            for (int rank : scores) add(rank);
        }}.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        return Arrays.stream(alice).map(aliceRank -> {
            int startInterval = 0, endInterval = uniqueRankLeaderboard.size() - 1;
            while (endInterval - startInterval > 1) {
                int center = (endInterval - startInterval) / 2 + startInterval;
                int centerValue = uniqueRankLeaderboard.get(center);

                if (aliceRank == centerValue) return center + 1;

                if (aliceRank > centerValue) endInterval = center;
                else startInterval = center;
            }

            if (aliceRank >= uniqueRankLeaderboard.get(startInterval)) return startInterval + 1;
            else if (aliceRank >= uniqueRankLeaderboard.get(endInterval)) return endInterval + 1;
            else return endInterval + 2;
        }).toArray();
    }
}
