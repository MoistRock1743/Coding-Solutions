/* A pangram is a string that contains every letter of the alphabet. Given
 * a sentence, determine whether it is a pangram in the English alphabet.
 * Ignore case. Return either 'pangram' or 'not pangram' as appropriate.
 * 
 * Example:
 * s = 'The quick brown fox jumps over the lazy dog.'
 * The string contains all letters in the English alphabet,
 * so return 'pangram'.
 * 
 * pangrams has the following parameter:
 * ~ string s: a string to test
 */
package HackerRankJava;
import java.io.*;
import java.util.*;

class PResult {
    /*
     * 'pangrams' accepts STRING s as parameter.
     * The function is expected to return a STRING.
     */

    public static String pangrams(String s) {
        Map<Character, Integer> soup = new HashMap<>();

        for (Character c : s.toLowerCase().toCharArray()) {
            if (!soup.containsKey(c) && !c.equals(' ')) {
                soup.put(c, 1);
            } else {
                continue;
            }
        }

        if (soup.size() == 26) {
            return "pangram";
        } else {
            return "not pangram";
        }
    }
}

public class PangramsSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = PResult.pangrams(s);

        System.out.println(result);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I used a HashMap (named soup, because you know, alphabet soup
 * haha) that would store the characters used through the string. The reason I used
 * a HashMap instead of a List is due to the fact that the containsKey() method of 
 * the HashMap class is a method that executes in O(1) linear time. In comparison to
 * having to compare all the elements to each other in a list taking O(nlogn) time,
 * this is much faster. The .put() method of HashMap is consequently O(1) time as 
 * well, which is a step up from the .add() method of the Set class that executes
 * in O(logn) time. 
 *  Now, this HashMap solution also beats the GeeksForGeeks solution that uses a 
 * boolean vector which has the same time complexity but still technically completes
 * in O(2n) time versus just one for-loop in this solution. I had checked the web
 * for other solutions after solving this and felt the need to clarify how I found
 * this to be the best solution to our problem here.
 *  The solution has a time complexity of O(n).
 *  The solution has a space complexity of O(1).
 */
