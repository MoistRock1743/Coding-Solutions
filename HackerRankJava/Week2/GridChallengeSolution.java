/* Given a square grid of characters in the range ascii[a-z], rearrange
 * elements of each row alphabetically, ascending. Determine if the columns are also
 * in ascending alphabetical order, top to bottom. Return YES if they are or NO if 
 * they are not.
 * 
 * Example:
 * grid = ['abc', 'ade', 'efg']
 * The grid is illustrated below.
 * a b c
 * a d e
 * e f g
 * The rows are already in alphabetical order. The columns a a e, b d f and c e g
 * are also in alphabetical order, so the answer would be YES. Only elements within
 * the same row can be rearranged. They cannot be moved to a different row.
 * 
 * gridChallenge has the following parameter:
 * ~ string[n] grid: an array of strings
 */
package HackerRankJava.Week2;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class GCResult {
    /*
     * 'gridChallenge' accepts STRING_ARRAY grid as parameter.
     * The function is expected to return a STRING.
     */

    public static String gridChallenge(List<String> grid) {
        char[][] arr = new char[grid.size()][grid.get(0).length()];

        for (int i = 0; i < grid.size(); i++) {
            char[] word = grid.get(i).toCharArray();
            Arrays.sort(word);
            arr[i]= word;
        }

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < grid.size() - 1; j++) {
                if (arr[j][i] > arr[j+1][i]) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}

public class GridChallengeSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = GCResult.gridChallenge(grid);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException();
            }
        });

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, the given strings that count as each row are sorted. Then they
 * are put into a multi-dimensional character array as character arrays. The nested
 * for loops then go through the columns and compare each row to see if they are 
 * alphabetical or not.
 *  The solution has a time complexity of O(nlogn).
 *  The solution has a space complexity of O(n).
 */