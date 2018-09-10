package org.olezha;

public class MorganAndString {

    public static void main(String[] args) {
        String answer = morganAndString("JACK", "DANIEL");
        System.out.println("DAJACKNIEL = " + answer + " " + "DAJACKNIEL".equals(answer));
        answer = morganAndString("SAME", "SAME");
        System.out.println("SAMESAME = " + answer + " " + "SAMESAME".equals(answer));
        answer = morganAndString("ASEM", "ASEM");
        System.out.println("AASEMSEM = " + answer + " " + "AASEMSEM".equals(answer));
        answer = morganAndString("YZYYZYZYY", "ZYYZYZYY");
        System.out.println("YZYYZYYZYZYYZYZYY = " + answer + " " + "YZYYZYYZYZYYZYZYY".equals(answer));
        answer = morganAndString("ZZYYZZZA", "ZZYYZZZB");
        System.out.println("ZZYYZZYYZZZAZZZB = " + answer + " " + "ZZYYZZYYZZZAZZZB".equals(answer));
        answer = morganAndString("AECCCBAF", "BECCCBAD");
        System.out.println("ABECCCBADECCCBAF = " + answer + " " + "ABECCCBADECCCBAF".equals(answer));
    }

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
                        while (aLetters.length > aLettersPointer
                                && letter >= aLetters[aLettersPointer] && letter != 'Z')
                            lexicographicallyMinStrFromTwoCollections.append(aLetters[aLettersPointer++]);
                    }
                    else {
                        char letter = bLetters[bLettersPointer++];
                        lexicographicallyMinStrFromTwoCollections.append(letter);
                        while (bLetters.length > bLettersPointer
                                && letter >= bLetters[bLettersPointer] && letter != 'Z')
                            lexicographicallyMinStrFromTwoCollections.append(bLetters[bLettersPointer++]);
                    }

                    continue lettersOneByOne;
                }

                lexicographicallyMinStrFromTwoCollections.append(aLetters[aLettersPointer++]);
            }
        return lexicographicallyMinStrFromTwoCollections.toString();
    }
}
