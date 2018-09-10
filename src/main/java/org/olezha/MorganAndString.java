package org.olezha;

/*
 * https://www.hackerrank.com/challenges/morgan-and-a-string
 */
class MorganAndString {

    static String morganAndString(String a, String b) {
        char[] aLetters = a.toCharArray();
        char[] bLetters = b.toCharArray();
        StringBuilder lexicographicallyMinStrFromTwoCollections =
                new StringBuilder(aLetters.length + bLetters.length);
        int aLettersPointer = 0;
        int bLettersPointer = 0;
        lettersOneByOne:
        while (aLetters.length > aLettersPointer || bLetters.length > bLettersPointer)
            if (aLetters.length == aLettersPointer) {
                lexicographicallyMinStrFromTwoCollections.append(b.substring(bLettersPointer));
                bLettersPointer = bLetters.length;
            }
            else if (bLetters.length == bLettersPointer) {
                lexicographicallyMinStrFromTwoCollections.append(a.substring(aLettersPointer));
                aLettersPointer = aLetters.length;
            }

            else if (aLetters[aLettersPointer] < bLetters[bLettersPointer])
                lexicographicallyMinStrFromTwoCollections.append(aLetters[aLettersPointer++]);
            else if (aLetters[aLettersPointer] > bLetters[bLettersPointer])
                lexicographicallyMinStrFromTwoCollections.append(bLetters[bLettersPointer++]);

            else {
                // aLetters[aLettersPointer] == bLetters[bLettersPointer]
                int innerALettersPointer = aLettersPointer + 1;
                int innerBLettersPointer = bLettersPointer + 1;
                while (aLetters.length > innerALettersPointer || bLetters.length > innerBLettersPointer) {
                    if (aLetters[innerALettersPointer] == bLetters[innerBLettersPointer]) {
                        innerALettersPointer++;
                        innerBLettersPointer++;
                        continue;
                    }

                    if (aLetters[innerALettersPointer] < bLetters[innerBLettersPointer]) {
                        char letter = aLetters[aLettersPointer++];
                        lexicographicallyMinStrFromTwoCollections.append(letter);
                        while (innerALettersPointer > aLettersPointer
                                && letter >= aLetters[aLettersPointer])
                            lexicographicallyMinStrFromTwoCollections.append(aLetters[aLettersPointer++]);
                    }
                    else {
                        char letter = bLetters[bLettersPointer++];
                        lexicographicallyMinStrFromTwoCollections.append(letter);
                        while (innerBLettersPointer > bLettersPointer
                                && letter >= bLetters[bLettersPointer])
                            lexicographicallyMinStrFromTwoCollections.append(bLetters[bLettersPointer++]);
                    }

                    continue lettersOneByOne;
                }

                lexicographicallyMinStrFromTwoCollections.append(aLetters[aLettersPointer++]);
            }
        return lexicographicallyMinStrFromTwoCollections.toString();
    }
}
