package encryptdecrypt.fileIO;

import java.io.FileWriter;
import java.io.IOException;

public class MessageWriter {
    private String encryptedMessage;
    private String filePath;

    public MessageWriter(String filePath, String encryptedMessage) {
        this.filePath = filePath;
        this.encryptedMessage = encryptedMessage;
    }

    public void write() {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(encryptedMessage);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
