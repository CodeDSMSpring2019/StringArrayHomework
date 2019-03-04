package edu.dmacc.codedsm.examples;

import java.util.Random;

public class StringArrayValidator {
    public static String[] validStrings = new String[5];

    public static void main(String[] args) {
        int savedStringsCount = 0;

        while (savedStringsCount < 5) {
            String input = createRandomAlphaNumericString(5);

            if (containsNumbers(input)) {
                System.out.println("input contained an invalid character = " + input);
            } else if (startsWithAVowel(input)) {
                validStrings[savedStringsCount] = input;

                savedStringsCount++;
            }
        }

        for (int i = 0; i < validStrings.length; i++) {
            System.out.println("validStrings = " + validStrings[i]);
        }

    }

    public static boolean containsNumbers(String input) {
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                return true;
            }
        }

        return false;
    }

    public static boolean startsWithAVowel(String input) {
        char[] chars = input.toCharArray();
        char[] firstCharacter = { chars[0] };

        String validChars = "AEIOU";


        return validChars.contains(new String(firstCharacter));

    }

    /* stole this from stack overflow hahaha */
    public static String createRandomAlphaNumericString(int randomStringLength) {

        int leftLimit = 97; // letter 'a'

        int rightLimit = 122; // letter 'z'

        Random random = new Random();

        StringBuilder buffer = new StringBuilder(randomStringLength);

        for (int i = 0; i < randomStringLength; i++) {

            if (random.nextInt(10) >= 9) {

                buffer.append(random.nextInt(9));

            } else {

                int randomLimitedInt = leftLimit + (int)

                        (random.nextFloat() * (rightLimit - leftLimit + 1));

                char characterForString = (char) randomLimitedInt;

                if (random.nextBoolean()) {

                    characterForString = Character.toUpperCase(characterForString);

                }

                buffer.append(characterForString);

            }

        }

        return buffer.toString();

    }
}
