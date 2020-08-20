package encryptdecrypt;

import encryptdecrypt.algorithms.DecryptShift;
import encryptdecrypt.algorithms.DecryptUnicode;
import encryptdecrypt.algorithms.EncryptShift;
import encryptdecrypt.algorithms.EncryptUnicode;
import encryptdecrypt.fileIO.MessageReader;
import encryptdecrypt.fileIO.MessageWriter;

public class ControlPanel {
    private String[] args;
    private String algorithm = "shift";
    private String operationName = "enc";
    private int key = 0;
    private String message = "";
    private String outputFile = "";

    public ControlPanel(String[] args) {
        this.args = args;
    }

    public void launch() {
        assignArgs();
        if (algorithm.equals("unicode")) {
            algorithmUnicode();
        }
        else if (algorithm.equals("shift")) {
            algorithmShift();
        }
    }

    private void assignArgs() {
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-alg")) {
                algorithm = args[i + 1];
            }

            if (args[i].contains("-mode")) {
                operationName = args[i + 1];
            }
            if (args[i].contains("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }

            if (args[i].contains("-data")) {
                message = args[i + 1];
            } else if (args[i].contains("-in")) {
                MessageReader messageReader = new MessageReader(args[i + 1]);
                message = messageReader.readAndGetMessage();
            }

            if (args[i].contains("-out")) {
                outputFile = args[i + 1];
            }
        }
    }

    private void algorithmUnicode() {
        if (operationName.equals("enc")) {
            String encryptedMessage = EncryptUnicode.encryptAndGetMessage(key, message);
            if (!outputFile.equals("")) {
                MessageWriter writer = new MessageWriter(outputFile, encryptedMessage);
                writer.write();
            } else {
                System.out.println(encryptedMessage);
            }
        } else if (operationName.equals("dec")) {
            String decryptedMessage = DecryptUnicode.decryptAndGetMessage(key, message);
            if (!outputFile.equals("")) {
                MessageWriter writer = new MessageWriter(outputFile, decryptedMessage);
                writer.write();
            } else {
                System.out.println(decryptedMessage);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void algorithmShift() {
        if (operationName.equals("enc")) {
            String encryptedMessage = EncryptShift.encryptMessage(key, message);
            if (!outputFile.equals("")) {
                MessageWriter writer = new MessageWriter(outputFile, encryptedMessage);
                writer.write();
            } else {
                System.out.println(encryptedMessage);
            }
        } else if (operationName.equals("dec")) {
            String decryptedMessage = DecryptShift.decryptMessage(key, message);
            if (!outputFile.equals("")) {
                MessageWriter writer = new MessageWriter(outputFile, decryptedMessage);
                writer.write();
            } else {
                System.out.println(decryptedMessage);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
