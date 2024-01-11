/* Given five positive integers,find the minimum and maximum values that can be
 * calculated by summing exactly four of the five integers. Then print the respective
 * minimum and maximum values as a single of two space-separated long integers.
 * 
 * Example:
 * arr = [1, 3, 5, 7, 9]
 * The minimum sum is 1+3+5+7 = 16 and the maximum sum is 3+5+7+9 = 24.
 * The function prints:
 * 16 24
 * 
 * miniMaxSum has the following parameter(s):
 * ~ arr: an array of 5 integers
 */
package HackerRankJava.Week1;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class MMSResult {
    /*
     * 'miniMaxSum' function accepts INTEGER_ARRAY arr 
     * as parameter. The functions must produce the output within
     * its scope as it is a 'void' function.
     */

    public static void miniMaxSum(List<Integer> arr) {
        int min = arr.get(0), max = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            if (min > arr.get(i)) {
                min = arr.get(i);
            } else if (max < arr.get(i)) {
                max = arr.get(i);
            }
        }

        if (min == max) {
            System.out.println(min*(arr.size()-1) + " " + min*(arr.size()-1));
            return;
        }

        long minSum = 0, maxSum = 0;
        for (Integer element : arr) {

            if (element == max) {
                maxSum += element;
            } else if (element == min) {
                minSum += element;
            } else {
                maxSum += element;
                minSum += element;
            }
        }

        System.out.println(minSum + " " + maxSum);
    }
}

public class MiniMaxSumSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine()
            .replaceAll("\\s+$", " ").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        MMSResult.miniMaxSum(arr);
    }
}

/****************************Solution Explained***********************************
 *  In this solution, I use two integer variables to store the minimum and maximum
 * values of the given array. I then iterate through the array to find these
 * respective values. Then using the updated values, if the minimum and maximum
 * values are the same, the array is consistent of all the same value and will 
 * return the proper values accordingly. After that condition is checked, I iterate
 * through the array again to calculate the minimum and maximum sums of the array.
 *  These sums are calculated by adding the elements together, however if the one
 * of either the minimum or maximum is the current element, it is put into its
 * respective summation variable and excluded from the other.
 *  The solution's time complexity is O(n).
 *  The solution's space complexity is O(1).
 */
