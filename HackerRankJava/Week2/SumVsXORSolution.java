/* Given an integer n, find each x such that:
 *  ~ 0 <= x <= n
 *  ~ n + x = n XOR x
 * 
 * Example:
 * n = 4
 * There are four values that meet the criteria:
 *  ~ 4 + 0 = 4 XOR 0 = 4
 *  ~ 4 + 1 = 4 XOR 1 = 5
 *  ~ 4 + 2 = 4 XOR 2 = 6
 *  ~ 4 + 3 = 4 XOR 3 = 7
 * Return 4
 * 
 * sumXor has the following parameter:
 * ~ int n: an integer
 */
package HackerRankJava.Week2;
import java.io.*;

class SVXResult {
    /*
     * 'sumXOR' accepts LONG_INTEGER n as parameter. 
     * The function is expected to return a LONG_INTEGER. 
     */

    public static long sumXor(long n) {
        long count = 0;
        if (n == 0 || n == 1) {
            return 1;
        }

        String bitS = Long.toBinaryString(n);
        for (int i = 0; i < bitS.length(); i++) {
            if (bitS.charAt(i) == '0') {
                count++;
            }
        }

        return SVXResult.pow(2, count);
    }

    public static long pow(long base, long exp) {
        return (long) Math.pow(base, exp);
    }
}

public class SumVsXORSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = SVXResult.sumXor(n);

        System.out.println(result);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, the understanding of bits is crucial. Essentially, the problem
 * statement boils down to matching a 1 or 0 with a 0. How does this work? Well,
 * let's use the example of 10. Bitwise, 10 comes out to 1010. It ends up having four
 * possibilities, (0, 1, 4, and 5). Which come out to the following comparisons:
 * 1010 -> (10) | 1010 -> (10) | 1010 -> (10) | 1010 -> (10)
 * 0000 -> +(0) | 0001 -> +(1) | 0100 -> +(4) | 0101 -> +(5)
 * ---------------------------------------------------------
 * 1010 =   10  | 1011 =   11  | 1110 =   14  | 1111 =   15
 * This view allows us to see that you need to pair a 0 or 1 to the 0's of the number. 
 * Since there are two possible values to pair with a 0 and there are two 0's in 
 * 10 in binary, then there are 2**2=4 possibilities. So, we simply need to find how
 * many zeros are in the binary of the number, then put 2 to the power of that number
 * and return the result.
 *  The solution has a time complexity of O(logn).
 *  The solution has a space complexity of O(logn). 
 */