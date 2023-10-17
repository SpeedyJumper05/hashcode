package hashcode;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

public class Bruteforce {
    public String charactersA = "abcdefghijklmnopqrstuvwxyz ";
    HashEncrypt hashEncrypt = new HashEncrypt();
    int toAppend = 1;
    String finalHash = "";
    long timerStart;
    long timerEnd;
    long timer;
    private String hash;

    public void initializeDecrypt() throws NoSuchAlgorithmException {
        hash = Main.undecryptedString;
        timerStart = System.nanoTime();
        while (true) {
            for (int i = 0; i < charactersA.length(); i++) {
                decrypt(charactersA, i, toAppend, "");
            }
            toAppend += 1;
        }
    }

    public void decrypt(String characters, int position, int toApp, String finalString) throws NoSuchAlgorithmException {
        finalString = finalString + characters.charAt(position);
        toApp -= 1;

        if (toApp == 0) {
            finalHash = hashEncrypt.encryptString(finalString);
            if (hash.equals(finalHash)) {
                timerEnd = System.nanoTime();
                timer = timerEnd - timerStart;

                System.out.println("\nOriginal message found! (approx. " + TimeUnit.SECONDS.convert(timer, TimeUnit.NANOSECONDS) + " seconds)" + "\n\n" + finalHash + " -> " + finalString);
                System.exit(0);
            } else {
                System.out.println(finalString + " -> " + finalHash);
            }

        } else {
            for (int i = 0; i < characters.length(); i++) {
                decrypt(characters, i, toApp, finalString);
            }
        }
    }
}