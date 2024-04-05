package my.cryptoanalizer;

import my.cryptoanalizer.encryption.WordsEncryptor;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class ConsoleRunner {
    public static void main(String[] args){
        TextIO textIO = TextIoFactory.getTextIO();
        WordsEncryptor wordsEncryptor = new WordsEncryptor();

        while (true) {
            String menu = "1. Шифровка текста\n" +
                    "2. Расшифровка текста с помощью ключа\n" +
                    "3. Расшифровка текста с помощью brute force\n" +
                    "4. Выход\n" +
                    "Пожалуйста, сделайте выбор.\n";
            int choice = textIO.newIntInputReader().read(menu);

            switch (choice) {
                case 1:
                    String textToEncrypt = textIO.newStringInputReader().read("Введите текст для шифрования:");
                    int key = textIO.newIntInputReader().read("Введите ключ:");
                    String encryptedText = wordsEncryptor.doEncryption(textToEncrypt, key);
                    textIO.getTextTerminal().println("Зашифрованный текст: " + encryptedText);
                    break;
                case 2:
                    String textToDecrypt = textIO.newStringInputReader().read("Введите текст для расшифровки:");
                    int decryptionKey = textIO.newIntInputReader().read("Введите ключ для расшифровки:");
                    String decryptedText = wordsEncryptor.doDecryption(textToDecrypt, decryptionKey);
                    textIO.getTextTerminal().println("Расшифрованный текст: " + decryptedText);
                    break;
                case 3:
                    // Реализация brute force
                    break;
                case 4:
                    System.exit(0);
                default:
                    textIO.getTextTerminal().println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
