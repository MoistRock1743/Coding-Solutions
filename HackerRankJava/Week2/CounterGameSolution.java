/* Louise and Richard have developed a numbers game. They pick a number and check to see
 * if it is a power of 2. If it is, they divide it by 2. If not, they reduce it by the next
 * lower number which is a power of 2. Whoever reduces the number to 1 wins the game. Louise
 * always starts.
 * Given an initial value, determine who wins the game.
 * 
 * Example:
 * n = 132
 * It's Louise's turn first. She determines that 132 is not a power of 2. The next lower 
 * power of 2 is 128, so she subtracts that from 132 and passes 4 to Richard. 4 is a power
 * of 2, so Richard divides it by 2 and passes 2 to Louise. Likewise, 2 is a power so she
 * divides it by 2 and reaches 1. She wins the game. If they initially set counter to 1,
 * Richard wins. 
 * 
 * counterGame has the following parameter:
 * ~ int n: the initial game counter value
 */
package HackerRankJava.Week2;
import java.io.*;
import java.util.stream.*;

class CGResult {
    /*
     * 'counterGame' accepts LONG_INTEGER n as parameter.
     * The function is expected to return a STRING.
     */

    static long findLowerTwo(long n) {

        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n |= n >> 32;

        return n - (n >> 1);
    }

    public static String counterGame(long n) {
        boolean player = true;
        if (n == 1) {
            return "Richard";
        }

        while (n != 1) {
            if ((n & (n-1)) == 0) {
                n = n / 2;
                player = !player;
            } else {
                n = n - CGResult.findLowerTwo(n);
                player = !player;
            }
        }

        if (player) {
            return "Richard";
        } else {
            return "Louise";
        }
    }
}

public class CounterGameSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = CGResult.counterGame(n);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, we utilize a while loop for our game loop and bitwise operators
 * (which are found in another method to save clutter and readability) to solve the
 * gameplay loop. The goal is to get down to 1, so that will be our condition for the
 * while loop. We will use a boolean variable that we can flip easily as an indicator
 * of whose turn it is (T for Louise and F for Richard). Then at the end we check for
 * whose last turn it was, and they lose. Now, the trickiest part was finding the next
 * power of 2 below the given number. However, this can easily be done by taking the 
 * number, shifting it bitwise and expanding x2 bits every time up to 32 bits, comparing
 * using an OR operator to maximize 1's, and then finally returning the resulting 111...111 
 * number that we will subtract by that number shifted over 1.
 *  Example of the bitwise:
 *  Say we have an integer 12. In binary, that is 1100. Now if we do what we described
 * above and compare 1100 OR 0110 we end up with 1110. Then again, 1110 | 0011 = 1111. 
 * Then if we do the next portion: 1111 - 0111 = 1000. We end up with 1000 which is 8. 
 * And subsequently the next power of 2 going down. 
 *  The solution has a time complexity of O(logn).
 *  The solution has a space complexity of O(1).
 */