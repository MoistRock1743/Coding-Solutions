/* Given a square matrix, calculate the absolute difference between the sums
 * of its diagonals.
 * 
 * Example:
 * 1 2 3
 * 4 5 6
 * 9 8 9
 * The left-to-right diagonal = 1+5+9 = 15.
 * The right-to-left diagonal = 3+5+9 = 17.
 * Their absolute difference is |15 - 17| = 2.
 * 
 * diagonalDifference takes the following parameter:
 * ~ int arr[n][m]: an array of integers
 */
package HackerRankJava;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class DDResult {
    /*
     * 'diagonalDifference' function accepts 2D_INTEGER_ARRAY arr as parameter.
     * The function is expected to return an INTEGER.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum_one = 0;
        int sum_two = 0;
        int result = 0;
        int math_size = arr.size() - 1;

        for (int i = 0; i < arr.size(); i++) {
            sum_one += arr.get(i).get(i);
            sum_two += arr.get(i).get(math_size - i);
        }

        result = Math.abs(sum_one - sum_two);

        return result;
    }
}

public class DiagonalDifferenceSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0,n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine()
                        .replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = DDResult.diagonalDifference(arr);

        System.out.println(result);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I use one for-loop and store the two diagonal sums in two
 * integer variables. The way this is done without using two loops is only going
 * through n interations, where n is the number of columns (or rows) of the square
 * matrix. I get the arr[i][i] and the opposite of that in the square matrix by
 * doing arr[i][n-1-i] which will obtain the opposite column of that row. For example,
 * arr[1][1] in a 5x5 matrix will have the opposite of arr[1][5-1-1] = arr[1][3]. This
 * solution is scalable only to the MAX_INTEGER for the sum of each diagonal.
 *  This solution has a time complexity of O(n).
 */