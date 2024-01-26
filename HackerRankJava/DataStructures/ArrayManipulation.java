/* Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value
 * to each array element between two given indicies, inclusive. Once all operations have been performed
 * return the maximum value in the array.
 * 
 * Example:
 * n = 10
 * queries = [[1, 5, 3], [4, 8, 7], [6, 9, 1]]
 * Queries are interpreted as follows:
 * a b k
 * 1 5 3
 * 4 8 7
 * 6 9 1
 * Add the values of k between the indices a and b inclusive:
 * index ->  1 2 3  4  5 6 7 8 9 10
 *          [0,0,0, 0, 0,0,0,0,0, 0]
 *          [3,3,3, 3, 3,0,0,0,0, 0]
 *          [3,3,3,10,10,7,7,7,0, 0]
 *          [3,3,3,10,10,8,8,8,1, 0]
 * The largest value is 10 after all operations are performed.
 */
package HackerRankJava.DataStructures;
import java.util.*;

public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] firstMultipleInput = sc.nextLine().split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int[][] queries = new int[m][3];
        for (int i = 0; i < m; i++) {
            queries[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        long result = AMResult.arrayManipulation(n, queries);
        System.out.println(result);

        sc.close();
    }
}

class AMResult {
    /*
     * 'arrayManipulation' accepts following parameters:
     *   1. INTEGER n
     *   2. 2D_INTEGER_ARRAY queries
     * The function is expected to return a LONG_INTEGER.
     */

    public static long arrayManipulation(int n, int[][] queries) {
        long maxValue = Integer.MIN_VALUE;
        int[] arr = new int[n];
        int[] arrDif = new int[n+1];
        arrDif[0] = arr[0];
        arrDif[n] = 0;

        for (int i = 0; i < queries.length; i++) {
            arrDif[queries[i][0] - 1] += queries[i][2];
            arrDif[queries[i][1]] -= queries[i][2];

            arr[0] = arrDif[0];
            for (int j = 1; j < n; j++) {
                arr[j] = arrDif[j] + arr[j-1];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        System.out.println();
        return maxValue;
    }
}

/*This question has nothing to do with array manipulation! 
The only manipulation is done to the problem solver!

The idea is to remember where the range starts and where it ends - 
to do this we maintain a map of at what index (a) an increment is applied (+k), and at what index (b+1) 
it stops to apply (-k). Sort this map on the key (index of the array), 
iterate it(so we apply the increments in order), apply the increments,
 get the max value at any point and return it at the end.
 * def arrayManipulation(n, queries):
    maxValue = 0
    currentValue = 0
    prefixMap = {}
    for a,b,k in queries:
        prefixMap[a] = prefixMap.get(a, 0) + k
        prefixMap[b+1] = prefixMap.get(b+1, 0) - k
    prefixList = sorted(prefixMap.items())
    #print(prefixList)
    for prefix, increment in prefixList:
        currentValue += increment
        maxValue = max(maxValue, currentValue)
    
    return maxValue
 */