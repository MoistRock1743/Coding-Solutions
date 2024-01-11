/* Two children want to share a chocolate bar. Each of the
 * squares has an integer on it. One child decides to share
 * a contiguous segment of the bar selected such that:
 *  - The lenth of the segment matches the other's birth month
 *  - The sum of the integers on the squares is equal to their birthday
 * Determine how many ways she can divide the chocolate.
 * 
 * Example:
 * s = [2, 2, 1, 3, 2]
 * d = 4
 * m = 2
 * We want to find segments summing to Ron's birth day, d = 4
 * with a length equalling his birth month, m = 2. In this case,
 * there are two segments meeting her criteria:
 * [2, 2] and [1, 3]
 * 
 * birthday has the following parameters:
 * ~ int s[n]: the numbers on each of the squares
 * ~ int d: the other's birth day
 * ~ int m: the other's birth month
 */
package HackerRankJava;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class SDOResult {
    /*
     * 'birthday' accepts following parameters:
     *      1. INTEGER_ARRAY s
     *      2. INTEGER d
     *      3. INTEGER m
     * The function is expected to return an INTEGER.
     */

    public static int birthday(List<Integer> s, int d, int m) {
        List<Integer> tester = new ArrayList<>();
        int subSum = 0;
        int count = 0;

        for (int i = 0; i <= s.size() - m; i++) {
            tester = s.subList(i, (i + (m)));
            subSum = 0;
            for (int j = 0; j < tester.size(); j++) {
                subSum += tester.get(j);
            }
            if (subSum == d) {
                count++;
            } else {
                continue;
            }
        }

        return count;
    }
}

public class SubarrayDivisionOneSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> s = Stream.of(bufferedReader.readLine()
            .replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        
        String[] firstMultipleInput = bufferedReader.readLine()
            .replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = SDOResult.birthday(s, d, m);

        System.out.println(result);

        bufferedReader.close();
    }
}

/****************************Solution Explained***********************************
 *  In this solution, I use a nested for-loop with the outer loop iterating through
 * n-m-1 times and the inner loop running through a subarray stored in a temporary
 * arraylist summing its elements. This solution effectively "inchworms" through 
 * the given array, summing the subarray that has a size of m. This does not have
 * a great time complexity, but once I fabricated this solution, I could not find
 * any better options by anyone else.
 *  The solution has a time complexity of O(n*m)?
 *  The solution has a space complexity of O(m).
 */
