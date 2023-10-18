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