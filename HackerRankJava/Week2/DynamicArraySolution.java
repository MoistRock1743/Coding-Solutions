/* > Declare a 2-dimensional array, arr, of n empty arrays. All arrays are zero indexed.
 * > Declare an integer, lastAnswer, and initialize it to 0.
 * > There are 2 types of queries, given as an array of strings for you to parse:
 *  1. Query: 1 x y
 *      1. Let idx = ((x (XOR) lastAnswer) % n)
 *      2. Append the integer y to arr[idx]
 *  2. Query: 2 x y
 *      1. Let idx = ((x (XOR) lastAnswer) % n)
 *      2. Assign the value arr[idx][y % size(arr[idx])] to lastAnswer
 *      3. Store the new value of lastAnswer to an answers array
 * 
 * Example:
 * 2 5
 * 1 0 5
 * 1 1 7
 * 1 0 3
 * 2 1 0
 * 2 1 1
 * Output is 7 \n 3
 * 
 * dynamicArray has the following parameters:
 * ~ int n: the number of empty arrays to initialize in arr
 * ~ string[q] queries: query strings that contain 3 space-separated integers
 */
package HackerRankJava.Week2;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class DAResult {
    /*
     * 'dynamicArray' accepts following parameters:
     *      1. INTEGER n
     *      2. 2D_INTEGER_ARRAY queries
     * The function is expected to return an INTEGER_ARRAY.
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<Integer>());
        }

        List<Integer> result = new ArrayList<>();
        int lastAnswer = 0;

        for (int i = 0; i < queries.size(); i++) {
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            int idx = (x ^ lastAnswer) % n;

            if (queries.get(i).get(0) == 1) {
                
                arr.get(idx).add(y);

            } else {

                lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                result.add(lastAnswer);
            }
        }

        return result;
    }
}

public class DynamicArraySolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine()
                                    .replaceAll("\\s+$", "").split(" ");
        
        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(Stream.of(bufferedReader.readLine()
                    .replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = DAResult.dynamicArray(n, queries);

        System.out.println(result);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, we have to utilize two different arrays. One to store the 
 * empty arrays of the desired question. It is essentially just translating the steps
 * provided by the prompt to code.
 *  The solution has a time complexity of O(q), the number of queries.
 *  The solution has a space complexity of O(n+q).
 */