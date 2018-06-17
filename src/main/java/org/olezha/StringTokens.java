package org.olezha;

import java.util.Arrays;

public class StringTokens {

    public static void main(String[] args) {
        String[] s1Tokens = tokens("He is a very very good boy, isn't he?");
        System.out.println(s1Tokens.length + " " + Arrays.toString(s1Tokens));

        String[] s2Tokens = tokens(" He is a very very good boy, isn't he ");
        System.out.println(s2Tokens.length + " " + Arrays.toString(s2Tokens));

        String[] s3Tokens = tokens("");
        System.out.println(s3Tokens.length + " " + Arrays.toString(s3Tokens));

        String[] s4Tokens = tokens("!");
        System.out.println(s4Tokens.length + " " + Arrays.toString(s4Tokens));
    }

    /**
     * string matching the regular expression [A-Za-z !,?._'@]+
     */
    private static String[] tokens(String s) {
        s = s
                .replaceFirst("^\\W+", "")
                .replaceAll("[!,?._'@]+", " ")
                .replaceAll(" +", " ");
        if (s.isEmpty())
            return new String[0];
        return s.split(" ");
    }
}
