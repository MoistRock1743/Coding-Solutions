/* Given two strings consisting of digits 0 and 1 only, find the XOR of
 * the two strings.
 */
package HackerRankJava.Week1;
import java.io.*;

class XORSTResult {
    public static String stringsXOR(String s, String t) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                result += "0";
            } else {
                result += "1";
            }
        }
        return result;
    }
}

public class XORStringsTwoSolutions {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    String s = bufferedReader.readLine();

    String t = bufferedReader.readLine();

    String result = XORSTResult.stringsXOR(s, t);

    System.out.println(result);

    bufferedReader.close();
  }  
}

/*****************************Solution Explained***********************************
 *  In this solution, Hackerrank actually had this as a debugging challenge only for
 * Python3. So I implemented the solution into Java for the sake of documentation.
 * It is pretty simple, iterate through the lengths of the strings (since their
 * lengths will always be equivalent). Then, if the characters equal each other, put
 * a 0, else put a 1.
 *  The solution has a time complexity of O(n).
 *  The solution has a space complexity of O(n).
 */
