package org.olezha;

public class MorganAndString {

    public static void main(String[] args) {
        System.out.println("DAJACKNIEL = " + morganAndString("JACK", "DANIEL"));
        System.out.println("SAMESAME = " + morganAndString("SAME", "SAME"));
        System.out.println("AASEMSEM = " + morganAndString("ASEM", "ASEM"));
    }

    private static String morganAndString(String a, String b) {
        char[] jacksLetters = a.toCharArray();
        char[] danielsLetters = b.toCharArray();
        StringBuilder lexicographicallyMinimalStringMadeOfThoseTwoCollections = new StringBuilder();
        int jacksLettersPointer = 0;
        int danielsLettersPointer = 0;
        lettersOneByOne: while (jacksLetters.length > jacksLettersPointer || danielsLetters.length > danielsLettersPointer)
            if (jacksLetters.length == jacksLettersPointer) {
                lexicographicallyMinimalStringMadeOfThoseTwoCollections.append(b.substring(danielsLettersPointer));
                danielsLettersPointer = danielsLetters.length;
            }
            else if (danielsLetters.length == danielsLettersPointer) {
                lexicographicallyMinimalStringMadeOfThoseTwoCollections.append(a.substring(jacksLettersPointer));
                jacksLettersPointer = jacksLetters.length;
            }
            else if (jacksLetters[jacksLettersPointer] < danielsLetters[danielsLettersPointer])
                lexicographicallyMinimalStringMadeOfThoseTwoCollections.append(jacksLetters[jacksLettersPointer++]);
            else if (jacksLetters[jacksLettersPointer] > danielsLetters[danielsLettersPointer])
                lexicographicallyMinimalStringMadeOfThoseTwoCollections.append(danielsLetters[danielsLettersPointer++]);
            else {
                // jacksLetters[jacksLettersPointer] == danielsLetters[danielsLettersPointer]
                int innerJacksLettersPointer = jacksLettersPointer + 1;
                int innerDanielsLettersPointer = danielsLettersPointer + 1;
                while (jacksLetters.length > innerJacksLettersPointer || danielsLetters.length > innerDanielsLettersPointer) {
                    if (jacksLetters[innerJacksLettersPointer] == danielsLetters[innerDanielsLettersPointer]) {
                        innerJacksLettersPointer++;
                        innerDanielsLettersPointer++;
                        continue;
                    }

                    if (jacksLetters[innerJacksLettersPointer] < danielsLetters[innerDanielsLettersPointer])
                        lexicographicallyMinimalStringMadeOfThoseTwoCollections.append(jacksLetters[jacksLettersPointer++]);
                    else if (jacksLetters[innerJacksLettersPointer] > danielsLetters[innerDanielsLettersPointer])
                        lexicographicallyMinimalStringMadeOfThoseTwoCollections.append(danielsLetters[danielsLettersPointer++]);

                    continue lettersOneByOne;
                }
                lexicographicallyMinimalStringMadeOfThoseTwoCollections.append(jacksLetters[jacksLettersPointer++]);
            }
        return lexicographicallyMinimalStringMadeOfThoseTwoCollections.toString();
    }
}
