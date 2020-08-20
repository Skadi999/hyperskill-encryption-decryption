package encryptdecrypt.algorithms;

public class DecryptUnicode {
    private static StringBuilder decryptedMessage = new StringBuilder();

    private static void decryptMessage(int key, String message) {
        for (int i = 0; i < message.length(); i++) {
            int charIntValue = message.charAt(i);
            decryptedMessage.append((char) (charIntValue - key));
        }
    }

    public static String decryptAndGetMessage(int key, String message) {
        decryptMessage(key, message);
        return decryptedMessage.toString();
    }
}
