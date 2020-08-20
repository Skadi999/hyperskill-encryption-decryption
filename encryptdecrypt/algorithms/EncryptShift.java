package encryptdecrypt.algorithms;

public class EncryptShift {

    public static String encryptMessage(int key, String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (isEnglishLetter(c) && Character.isUpperCase(c)) {
                encryptedMessage.append(encryptUppercaseCharacter(key, c));
            } else if (isEnglishLetter(c) && Character.isLowerCase(c)) {
                encryptedMessage.append(encryptLowercaseCharacter(key, c));
            }
            else {
                encryptedMessage.append(c);
            }
        }
        return encryptedMessage.toString();
    }

    private static char encryptUppercaseCharacter(int key, char charToEncrypt) {
        final int UPPERCASE_Z = 90;
        final int UPPERCASE_A = 65;
        if (charToEncrypt + key > UPPERCASE_Z) {
            int difference = UPPERCASE_Z - charToEncrypt;
            return (char) (UPPERCASE_A + key - difference - 1);
        }
        return (char) (charToEncrypt + key);
    }

    private static char encryptLowercaseCharacter(int key, char charToEncrypt) {
        final int LOWERCASE_Z = 122;
        final int LOWERCASE_A = 97;
        if (charToEncrypt + key > LOWERCASE_Z) {
            int difference = LOWERCASE_Z - charToEncrypt;
            return (char) (LOWERCASE_A + key - difference - 1);
        }
        return (char) (charToEncrypt + key);
    }

    private static boolean isEnglishLetter(char c) {
        return (Character.toString(c).matches("[a-zA-z]"));
    }
}
