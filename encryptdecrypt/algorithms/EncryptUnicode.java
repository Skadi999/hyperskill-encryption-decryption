package encryptdecrypt.algorithms;


public class EncryptUnicode {

    private static StringBuilder encryptedMessage = new StringBuilder();

    private static void encryptMessage(int key, String message) {
        for (int i = 0; i < message.length(); i++) {
            int charIntValue = message.charAt(i);
            encryptedMessage.append((char)(charIntValue + key));
        }
    }

    public static String encryptAndGetMessage(int key, String message) {
        encryptMessage(key, message);
        return encryptedMessage.toString();
    }
}
