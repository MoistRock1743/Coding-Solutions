/* We define super digit of an integer x using the following rules:
 * Given an integer, we need to find the super digit of the integer. 
 *  - If x has only 1 digit, then its super digit is x. 
 *  - Otherwise, the super digit of x is equal to the super digit of the sum of
 *    the digits of x. 
 * 
 * Example:
 * n = '9874'
 * k = 4
 * The number p is created by concatenating the string n k times so the initial
 * p = 9875987598759875
 * superDigit(p) = superDigit(9875987598759875) = 116
 * superDigit(p) = superDigit(116)
 * superDigit(p) = superDigit(8)
 * All of the digits of p sum to 116. The digits of 116 sum to 8. 8 is only one digit
 * so it is the super digit. 
 * 
 * superDigit has the following parameters:
 * ~ string n: a string representation of an integer
 * ~ int k: the times to concatenate n to make p
 */
package HackerRankJava.Week2;
import java.io.*;

class RDSResult {
    /*
     * 'superDigit' accepts foloowing parameters:
     *      1. STRING n
     *      2. INTEGER k
     * The function is expected to return an INTEGER. 
     */

    public static int superDigit(String n, int k) {
        long result = 0;
        for (Character c : n.toCharArray()) {
            result += Character.getNumericValue(c);
        }

        result = result * k;
        if ((result / 10) == 0) {
            return (int)result;
        } else {
            result = superDigit(Long.toString(result), 1);
        }

        return (int)result;
    }
}

public class RecursiveDigitSumSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = RDSResult.superDigit(n, k);

        System.out.println(result);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, the strategy of recursion must be applied to get this solution. 
 * The reasoning behind this necessity for recursion lies in the constraints presented
 * by the website for this problem. The number given in the input n can be up to 
 * 10^100000. This cannot be held in any one variable, not even a long variable. Therefore,
 * I implemented this recursive technique. The function initializes a new result as 0,
 * that is crucial here. Then the function iterates through each character of the
 * string, summing the values of each character into this result variable. Then it
 * multiplies by k. This because concatenating the strings k times effectively multiplies
 * the number k times, as evident in the problem statement of p = n k. Then, the function
 * checks for if the result / 10 == 0 (meaning there is only one digit), and if not
 * the function calls itself again, storing the return into that result variable. (Keep
 * in mind I did have to cast it into an int variable just in case some results were
 * too large to keep inside an integer value.)
 *  The solution has a time complexity of O(n). (I'm not quite sure about this.)
 *  The solution has a space complexity of O(logk).
 */