package org.olezha;

import org.junit.Test;

import static org.junit.Assert.*;

public class FavoriteSequenceTests {

    @Test
    public void case0a() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, FavoriteSequence.lessSequence(new int[][]{
                {1, 3},
                {2, 3, 4}}));
    }

    @Test
    public void case0b() {
        assertArrayEquals(new int[]{7, 1, 2, 3, 4}, FavoriteSequence.lessSequence(new int[][]{
                {2, 3, 4},
                {1, 3},
                {7, 1}}));
    }

    @Test
    public void case0c() {
        assertArrayEquals(new int[]{7, 1, 2, 3, 4}, FavoriteSequence.lessSequence(new int[][]{
                {2, 3, 4},
                {1, 3},
                {7, 1},
                {7, 4}}));
    }

    @Test
    public void case0d() {
        assertArrayEquals(new int[]{5, 7, 1, 2, 3, 4, 9, 8}, FavoriteSequence.lessSequence(new int[][]{
                {2, 3, 4},
                {1, 3},
                {7, 1},
                {5, 9, 8}}));
    }

    @Test
    public void case1() {
        assertArrayEquals(new int[]{67, 46, 11, 68, 7, 18, 99, 48, 69, 57, 19, 45, 95}, FavoriteSequence.lessSequence(new int[][]{
                {68, 7, 18},
                {67, 46, 11, 99, 48, 69, 57, 19, 45, 95}}));
    }

    @Test
    public void case2() {
        assertArrayEquals(new int[]{29, 3, 88, 35, 9, 39, 8, 27, 12, 65}, FavoriteSequence.lessSequence(new int[][]{
                {35, 9},
                {29, 3, 88, 35, 39, 8, 27, 12, 65}}));
    }
}
