/* Given an array of integers, where all elements but one occur twice, find the
 * unique element.
 * 
 * Example: 
 * a = [1, 2, 3, 4, 3, 2, 1]
 * The unique element is 4.
 * 
 * lonelyInteger has the following parameter(s):
 * ~ int a[n]: an array of integers
 */
package HackerRankJava;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class LIResult {
    /*
     * 'lonelyInteger' function accepts INTEGER_ARRAY a as parameter.
     * The function is expected to return an INTEGER.
     */

    public static int lonelyInteger(List<Integer> a) {
        int ans = 0;
        for (int ele : a) {
            ans = ans ^ ele;
        }
        return ans;
    }
}

public class LonelyIntegerSolution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> a = Stream.of(bufferedReader.readLine()
                                .replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList());

        int result = LIResult.lonelyInteger(a);

        System.out.println(result);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I used the bitwise XOR operator. I had initially thought of 
 * using a Stack on a sorted version of the array given, however I recalled this
 * problem from my Data Structures and Algorithms class in university. I remembered
 * it had utilized the XOR operator by iterating through the array. Considering the
 * solution is comparing bits, all the duplicates will cancel out by the end of the
 * loop due to the exclusion of all like bits, resulting in the leftover bits that
 * will form our resulting integer.
 *  The only reason I reinstated this solution was due to the fact that it saves
 * memory and space by only using one variable and not sectioning off multiple
 * portions of memory for a Stack.
 *  The solution has a time complexity of O(n).
 *  The solution has a space complexity of O(1).
 */
