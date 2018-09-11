package org.olezha;

/*
 * https://www.hackerrank.com/challenges/utopian-tree
 */
public class UtopianTree {

    public static void main(String[] args) {
        System.out.println(utopianTree(0));
        System.out.println(utopianTree(1));
        System.out.println(utopianTree(4));
    }

    private static int utopianTree(int n) {
        int h = 1;
        for (int i = 0; i < n;)
            if (++i % 2 == 1) h *= 2;
            else h += 1;
        return h;
    }
}
