/* Given a list of 32 bit unsigned integers. Flip all the bits
 * (1 -> 0 and 0 -> 1) and return the result as an unsigned integer.
 * 
 * Example:
 * n = 9 base-10
 * 9 base-10 = 1001 base-2. We're working with 32 bits so:
 * 000000000000000000000000000010001 base-2 = 9 base-10
 * 111111111111111111111111111101110 base-2 = 4294967286 base-10
 * Return 4294967286.
 * 
 * flipping bits has the following parameter(s):
 * ~ int n: an integer
 */
package HackerRankJava.Week1;
import java.io.*;
import java.util.stream.*;

class FBResult {
    /*
     * 'flippingBits' function accepts LONG_INTEGER n as parameter.
     * The function is expected to return a LONG_INTEGER.
     */

    public static long flippingBits(long n) {
        return n^0xFFFFFFFFL;
    }
}

public class FlippingBitsSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0 , q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = FBResult.flippingBits(n);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, it is a simple case of returning the XOR result of a given
 * integer with an integer of all 1's. This will flip all of the 0's and 1's. The
 * reason the compared integer is not all 0's is due to the fact that XOR returns
 * 1 (true) when there is not a match (because of OR excluding the match) and 
 * 0 (false) when there is a match (because exclude this match). If the integer was
 * all 0's, it would just return the same integer. However, since the integer is
 * composed of all 1's (true), it flips 0 (false) -> 1 (true) and 1 (true) -> 0 (false).
 *  The solution has a time complexity of O(1).
 *  The solution has a space complexity of O(1).
 */
