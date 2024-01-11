/* There is a large pile of socks that must be paired by color. Given an array of
 * integers representing the color of each sock, determine how many pairs of socks
 * with matching colors there are.
 * 
 * Example:
 * n = 7
 * ar = [1. 2, 1, 2, 1, 3, 2]
 * There is one pair of color 1 and one of color 2. There are three odd socks left,
 * one of each color. The number of pairs is 2.
 * 
 * sockMerchant has the following parameters:
 * ~ int n: the number of socks in the pile
 * ~ int ar[n]: the colors of each sock
 */
package HackerRankJava.Week2;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class SBMResult {
    /*
     * 'sockMerchant' accepts following parameters:
     *      1. INTEGER n
     *      2. INTEGER_ARRAY ar
     * The function is expected to return an INTEGER.
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        int count = 0;
        int temp = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < ar.size(); i++) {
            if (map.containsKey(ar.get(i))) {
                temp = map.get(ar.get(i));
                temp += 1;
                map.put(ar.get(i), temp);

                if (map.get(ar.get(i)) % 2 == 0) {
                    count++;
                } else {
                    continue;
                }
            } else {
                map.put(ar.get(i), 1);
            }
        }

        return count;
    }
}

public class SalesByMatchSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine()
                            .replaceAll("\\s+$", "").split(" "))
                            .map(Integer::parseInt)
                            .collect(toList());
        
        int result = SBMResult.sockMerchant(n, ar);

        System.out.println(result);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I utilize a HashMap to store the types of colors (represented
 * through integers) with the values of their counts. As I iterate through the array
 * and after I have updated the value of the color, I check whether or not it is
 * divisible by two to indicate another pair. While checking in the initial for-loop
 * it prevents having to iterate through the HashMap again to see which values are
 * divisible by 2.
 *  The solution has a time complexity of O(n).
 *  The solution has a space complexity of O(n).
 */