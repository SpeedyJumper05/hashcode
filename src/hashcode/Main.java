package hashcode;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static String undecryptedString;

    public static void main(String[] args) throws NoSuchAlgorithmException {
        User user = new User();
        HashEncrypt hashEncrypt = new HashEncrypt();
        Bruteforce bruteforce = new Bruteforce();

        String encryptOrDecrypt;
        System.out.println("Encrypt or decrypt? (e/d)");
        user.promptInput();
        encryptOrDecrypt = user.getInput().toLowerCase();

        String unencryptedString;

        switch (encryptOrDecrypt) {
            case "encrypt", "en", "e":
                System.out.println("\nType string to be encrypted:");
                user.promptInput();
                unencryptedString = user.getInput();
                unencryptedString = unencryptedString.toLowerCase();
                boolean printReplaceMessage = false;
                for (int i = 0; i < unencryptedString.length(); i++) {
                    if (!bruteforce.charactersA.contains(Character.toString(unencryptedString.charAt(i)))) {
                        unencryptedString = unencryptedString.replace(Character.toString(unencryptedString.charAt(i)), "");
                        i -= 1;
                        printReplaceMessage = true;
                    }
                }
                if (printReplaceMessage) {
                    System.out.println("\nIllegal characters in string!\nConverting \"" + unencryptedString + "\"...");
                }
                System.out.println("\n" + unencryptedString + " -> " + hashEncrypt.encryptString(unencryptedString));
                break;
            case "decrypt", "de", "d":
                System.out.println("\nPaste hash to be decrypted:");
                user.promptInput();
                undecryptedString = user.getInput();
                bruteforce.initializeDecrypt();
                break;
            default:
                System.out.println("\nInvalid input!\nterminating program...");
                System.exit(0);
        }

    }
}