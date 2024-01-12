/* Julius Caesar protected his confidential information by encrypting it using a cipher.
 * Caesar's cipher shifts each letter by a number of letters.  If the shift takes you past
 * the end of the alphabet, just rotate back to the front of the alphabet. In the case of a 
 * rotation by 3, w, x, y and z would map to z, a, b and c.
 * 
 * Example:
 * s = There's-a-starman-waiting-in-the-sky
 * k = 3
 * The alphabet is rotated by , matching the mapping above. The encrypted string is
 * "Wkhuh's-d-vwdupdq-zdlwlqj-lq-wkh-vnb". The cipher only encrypts letters; symbols, such
 * as -, remain unencrypted.
 * 
 * caesarCipher has the following parameters:
 * ~ string s: cleartext
 * ~ int k: the alphabet rotation factor
 */
package HackerRankJava.Week2;
import java.io.*;

class CCResult {
    /*
     * 'caesarCipher' accepts following parameters:
     *      1. STRING s
     *      2. INTEGER k
     * The function is expected to return a STRING.
     */

    public static String caesarCipher(String s, int k) {
        String result = new String();

        for (int i = 0; i < s.length(); i++) {
            int temp = (int)s.charAt(i);

            if (temp < 65 || temp > 122) {
                result += (char)temp;
                continue;
            } else if (temp > 90 && temp < 97) {
                result += (char)temp;
                continue;
            }

            if (Character.isUpperCase(s.charAt(i))) {
                result += (char)((temp + k - 65) % 26 + 65);
            } else {
                result += (char)((temp + k - 97) % 26 + 97);
            }
        }

        return result;
    }
}

public class CaesarCipherSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = CCResult.caesarCipher(s, k);

        System.out.println(result);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, it solves one of the most famous problems to in computer science
 * regarding encryption. The special case about this specific HackerRank problem is
 * the inclusion of other symbols besides the alphabet in the cipher input. This 
 * does not hinder the solution with any time complexity as all we have to check is
 * whether or not it is one of these special symbols and then add it onto the result
 * string. HackerRank specifically put in testing inputs including symbols like 
 * !, @, $, and '.
 *  The real thinking of the solution comes from how we deal with the alphabetic 
 * characters. For this, the best solution is to look at the ASCII table for the
 * integer values for each alphabetic character. In this table, it is known that
 * A-Z and a-z range in the values [65, 90] and [97, 122] respectively. As we iterate
 * through each character of the string, we shift the characters to the right k 
 * times which is represented by temp + k. However, z or Z would then return a 
 * non-alphabetic symbol, therefore we must find where in the beginning of the
 * alphabet we must shift it to. This can be done by reducing the problem to a 
 * simple matter of keeping an array of 26 elements, hence the subtraction of 65.
 * If we were to shift 4 from z in this [0, 25] array, it would be at index 29.
 * How do we get it to [3] so it is not out of bounds? Well, 29 % 26 returns the
 * remainder, which is 3. Therefore, we get the new placement of this letter that
 * can easily be applied to characters that do not have to shift back to the front.
 * After putting the index back into the ASCII ranges, we get our desired output.
 *  The solution has a time complexity of O(n).
 *  The solution has a space complexity of O(n).
 */