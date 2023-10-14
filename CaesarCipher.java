import java.util.*;

public class CaesarCipher {
    // Encrypt the plaintext using Caesar Cipher with a given shift key
    public static String encrypt(String plaintext, int shiftKey) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int shifted = (ch - base + shiftKey) % 26;
                char encryptedChar = (char) (base + shifted);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

    // Decrypt the ciphertext using Caesar Cipher with a given shift key
    public static String decrypt(String ciphertext, int shiftKey) {
        return encrypt(ciphertext, 26 - shiftKey); // Decryption is just shifting in the opposite direction
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the message:");
        String plaintext=sc.nextLine();
        System.out.println("Enter the key: ");
        int shiftKey=sc.nextInt();
        //int shiftKey = 3;

        // Encryption
        String encryptedText = encrypt(plaintext, shiftKey);
        System.out.println("Encrypted: " + encryptedText);

        // Decryption
        String decryptedText = decrypt(encryptedText, shiftKey);
        System.out.println("Decrypted: " + decryptedText);
    }
}
