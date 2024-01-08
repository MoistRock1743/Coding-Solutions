/* Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
 * Print the decimal value of each fraction on a new line with places after the decimal.
 * Note: This challenge introduces precision problems.
 * The test cases are scaled to six decimal places, though answers with absolute error of up to 10^-4 are acceptable.
 * Example:
 * arr = [1,1,0,-1,-1]
 * There are n=5 elements, two positive, two negative, and one zero.
 * Their ratios are 2/5 = 0.400000, 2/5 = 0.400000, and 1/5 = 0.200000.
 * Results are printed as:
 * 0.400000
 * 0.400000
 * 0.200000
 * 
 * plusMinus has the following paramter(s):
 * ~ int arr[n]: an array of integers
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * The 'plusMinus' function below accepts INTEGER_ARRAY arr
     * as parameter. The function must produce the output within
     * its scope as it is a 'void' function.
     */

    public static void plusMinus(List<Integer> arr) {
        double pos = 0, neg = 0, zed = 0, size = arr.size();

        for (Integer element : arr) {
            if (element > 0) {
                pos += 1;
            } else if (element < 0) {
                neg += 1;
            } else {
                zed += 1;
            }
        }
        pos /= size;
        neg /= size;
        zed /= size;

        System.out.format("%.6f\n%.6f\n%.6f", pos, neg, zed);
    }
}

public class PlusMinusSolution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine()
            .replaceAll("\\s+$","").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        
        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

/* A note regarding the main class:
 *  - The input consists of one line containing the integer size
 *    of the array and another line containing the integers separated by spaces.
 * 
 * ***************************Solution Explained***********************************
 *  In this solution, I utilized a for-loop to iterate through the provided
 * List<Integer>. If-statements were then used to compare the current element 
 * to 0 to test whether it was positive, negative, or zero. Then counters were
 * incremented accordingly. 
 *  These counters along with the variable containing the size of the array were 
 * created as instances of doubles in order to provide the necessary decimal points 
 * to generate the desired solution. After getting these ratios of each type 
 * (positive, negative, zero), then I used the System.out.format method to output 
 * these ratios with the desired 6 decimal places.
 *  The solution has a linear time complexity of O(n).
 */