package org.olezha;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    public static void main(String[] args) {
        System.out.printf("%15s%s%n", "Anagrams ", isAnagram("anagram", "margana"));
        System.out.printf("%15s%s%n", "Not Anagrams ", isAnagram("anagramm", "marganaa"));
        System.out.printf("%15s%s%n", "Anagrams ", isAnagram("Hello", "hello"));
    }

    private static boolean isAnagram(String s1, String s2) {
        Map<Character,Integer> s1CharacterFrequency = new HashMap<>();
        for (char ch : s1.toLowerCase().toCharArray())
            s1CharacterFrequency.put(ch, s1CharacterFrequency.getOrDefault(ch, 0) + 1);

        Map<Character,Integer> s2CharacterFrequency = new HashMap<>();
        for (char ch : s2.toLowerCase().toCharArray())
            s2CharacterFrequency.put(ch, s2CharacterFrequency.getOrDefault(ch, 0) + 1);

        return s1CharacterFrequency.equals(s2CharacterFrequency);
    }
}
