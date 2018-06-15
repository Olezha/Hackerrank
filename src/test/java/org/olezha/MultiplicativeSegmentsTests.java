package org.olezha;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MultiplicativeSegmentsTests {

    @Test
    public void case1() {
        List<String> results = MultiplicativeSegments.findShortestIntervals(6, 5,
                Arrays.asList(2L, 9L, 4L, 3L, 16L));
        String[] expected = new String[]{
                "Minimum interval length: 2",
                "Found intervals:",
                "[1, 2]",
                "[2, 3]",
                "[3, 4]",
                "[4, 5]"
        };
        assertArrayEquals(expected, results.toArray());
    }

    @Test
    public void case2() {
        List<String> results = MultiplicativeSegments.findShortestIntervals(30, 10,
                Arrays.asList(15L, 3L, 6L, 4L, 10L, 25L, 21L, 18L, 11L, 5L));
        String[] expected = new String[]{
                "Minimum interval length: 3",
                "Found intervals:",
                "[1, 3]",
                "[3, 5]",
                "[5, 7]",
                "[6, 8]",
                "[8, 10]"
        };
        assertArrayEquals(expected, results.toArray());
    }

    @Test
    public void case3() {
        List<String> results = MultiplicativeSegments.findShortestIntervals(6, 5,
                Arrays.asList(7L, 11L, 13L, 17L, 19L));
        String[] expected = new String[]{
                "NONE"
        };
        assertArrayEquals(expected, results.toArray());
    }

    @Ignore // TODO: need to understand logic
    @Test
    public void case4() {
        List<String> results = MultiplicativeSegments.findShortestIntervals(490, 15,
                Arrays.asList( 914L, 101L, 243L, 811L, 716L, 791L, 726L, 175L, 670L, 721L, 783L, 969L, 940L, 160L, 293L));
        String[] expected = new String[]{
                "Minimum interval length: 3",
                "Found intervals:",
                "[6, 8]",
                "[8, 10]"
        };
        assertArrayEquals(expected, results.toArray());
    }
}
