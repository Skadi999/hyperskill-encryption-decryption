package encryptdecrypt.algorithms;

public class DecryptShift {
    public static String decryptMessage(int key, String message) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (isEnglishLetter(c) && Character.isUpperCase(c)) {
                decryptedMessage.append(decryptUppercaseCharacter(key, c));
            } else if (isEnglishLetter(c) && Character.isLowerCase(c)) {
                decryptedMessage.append(decryptLowercaseCharacter(key, c));
            }
        }
        return decryptedMessage.toString();
    }

    private static char decryptUppercaseCharacter(int key, char charToDecrypt) {
        final int UPPERCASE_Z = 90;
        final int UPPERCASE_A = 65;
        if (charToDecrypt - key < UPPERCASE_A) {
            int difference = charToDecrypt - UPPERCASE_A;
            return (char) (UPPERCASE_Z - key + difference + 1);
        }
        return (char) (charToDecrypt - key);
    }

    private static char decryptLowercaseCharacter(int key, char charToDecrypt) {
        final int LOWERCASE_Z = 122;
        final int LOWERCASE_A = 97;
        if (charToDecrypt - key < LOWERCASE_A) {
            int difference = charToDecrypt - LOWERCASE_A;
            return (char) (LOWERCASE_Z - key + difference + 1);
        }
        return (char) (charToDecrypt - key);
    }

    private static boolean isEnglishLetter(char c) {
        return (Character.toString(c).matches("[a-zA-z]"));
    }
}
