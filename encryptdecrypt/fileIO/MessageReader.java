package encryptdecrypt.fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MessageReader {
    private String filePath;
    private String message;

    public MessageReader(String filePath) {
        this.filePath = filePath;
        message = "";
    }

    private void read() {
        File file = new File(filePath);
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                message += reader.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    public String readAndGetMessage() {
        read();
        return message;
    }
}
