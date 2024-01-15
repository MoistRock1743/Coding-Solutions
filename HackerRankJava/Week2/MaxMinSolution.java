/* You will be given a list of integers, arr, and a single integer k. You must create
 * an array of length k from elements of arr such that its unfairness is minimized. Call
 * that array arr'. Unfairness of an array is calculated as max(arr')-min(arr'), where 
 * max denotes the largest integer in arr' and min denotes the smallest integer in arr'.
 * 
 * Example:
 * arr = [1, 4, 7, 2]
 * k = 2
 * Pick any two elements, say arr' = [4, 7]. unfairness = max(4, 7) - min(4, 7) = 
 * 7 - 4 = 3. Testing for all pairs, the solution [1, 2] provides the minimum unfairness.
 * 
 * maxMin has the following parameters:
 * ~ int k: the number of elements to select
 * ~ int arr[n]: an array of integers
 */
package HackerRankJava.Week2;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class MMResult {
    /*
     * 'maxMin' accepts the following parameters:
     *      1. INTEGER k
     *      2. INTEGER_ARRAY arr
     * The function is expected to return an INTEGER.
     */

    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int unfairness = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size() - (k - 1); i++) {
            int temp = (arr.get(i+k-1) - arr.get(i));
            
            if (unfairness > temp) {
                unfairness = temp;
            }
        }
        
        return unfairness;
    }
}

public class MaxMinSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        
        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0 , n).mapToObj(i -> {
            try {
                return  bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());
        
        int result = MMResult.maxMin(k, arr);

        System.out.println(result);

        bufferedReader.close();
    }
}
