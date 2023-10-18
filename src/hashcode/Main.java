/*      This program is free software; you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation; either version 2 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License along
        with this program; if not, write to the Free Software Foundation, Inc.,
        51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/

package hashcode;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static String undecryptedString = null;

    public static void main(String[] args) throws NoSuchAlgorithmException {
        HashEncrypt hashEncrypt = new HashEncrypt();
        Bruteforce bruteforce = new Bruteforce();

        String encryptOrDecrypt;
        System.out.println("Encrypt or decrypt? (e/d)");
        User.promptInput();
        encryptOrDecrypt = User.getInput().toLowerCase();

        String unencryptedString;

        switch (encryptOrDecrypt) {
            case "encrypt", "en", "e" -> {
                System.out.println("\nType string to be encrypted:");
                User.promptInput();
                unencryptedString = User.getInput();
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
            }
            case "decrypt", "de", "d" -> {
                System.out.println("\nPaste hash to be decrypted:");
                User.promptInput();
                undecryptedString = User.getInput();
                bruteforce.initializeDecrypt();
            }
            default -> {
                System.out.println("\nInvalid input!\nterminating program...");
                System.exit(0);
            }
        }

    }
}