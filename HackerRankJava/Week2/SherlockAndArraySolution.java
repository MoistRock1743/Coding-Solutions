/* Watson gives Sherlock an array of integers. His challenge is to find an element of the array
 * such that the sum of all elements to the left is equal to the sum of all the elements to the
 * right.
 * 
 * Example: 
 * arr = [5, 6, 8, 11]
 * 8 is between two subarrays that sum to 11.
 * arr = [1]
 * The answer is [1] since left and right sum to 0. 
 * You will be given arrays of integers and must determine whether there is an element that
 * meets the criterion. If there is, return YES. Otherwise, return NO. 
 * 
 * balancedSums has the following parameter:
 * ~ int arr[n]: an array of integers
 */
package HackerRankJava.Week2;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class SAAResult {
    /*
     * 'balancedSums' accepts INTEGER_ARRAY arr as parameter.
     * The function is expected to return a STRING. 
     */

    public static String balancedSums(List<Integer> arr) {
        int n = arr.size();
        if (n == 1) {
            return "YES";
        } else if (n == 2 && arr.get(1) == 0) {
            return "YES";
        } else if (n == 2) {
            return "NO";
        }

        int leftSum = 0;
        int rightSum = arr.get(1);
        for (int i = 2; i < n; i++) {
            rightSum += arr.get(i);
        }

        if (leftSum == rightSum) {
            return "YES";
        }

        for (int j = 1; j < n - 1; j++) {
            rightSum -= arr.get(j);
            leftSum += arr.get(j-1);
            if (leftSum == rightSum) {
                return "YES";
            }
        }

        return "NO";
    }
}

public class SherlockAndArraySolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                List<Integer> arr = Stream.of(bufferedReader.readLine()
                                            .replaceAll("\\s+$", "").split(" "))
                                            .map(Integer::parseInt)
                                            .collect(toList());
                
                String result = SAAResult.balancedSums(arr);

                System.out.println(result);
            } catch (IOException ex){
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I decided to implement the dynamic programming approach. This
 * is done by calculating the sums of the left and right of a given index in separate
 * integer variables and modifying them accordingly when iterating through the array. 
 * The only special cases are if the size of the array is 1, where it is always YES,
 * or the size of the array is 2, where we have to check if the second element of the
 * array is 0 and return accordingly. This is because the first element of the array
 * can never be 0 as defined by the problem statement on the website.
 *  The solution has a time complexity of O(n). 
 *  The solution has a space complexity of O(1). 
 */