package my.cryptoanalizer.encryption;

public class WordsEncryptor {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public String doEncryption(String inputText, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (char character : inputText.toCharArray()) {
            int index = new String(ALPHABET).indexOf(character);
            if (index != -1) {
                encryptedText.append(ALPHABET[(index + key) % ALPHABET.length]);
            } else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }

    public String doDecryption(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();
        for (char character : encryptedText.toCharArray()) {
            int index = new String(ALPHABET).indexOf(character);
            if (index != -1) {
                int decryptedIndex = (index - key) % ALPHABET.length;
                if (decryptedIndex < 0) {
                    decryptedIndex += ALPHABET.length;
                }
                decryptedText.append(ALPHABET[decryptedIndex]);
            } else {
                decryptedText.append(character);
            }
        }
        return decryptedText.toString();
    }

}
