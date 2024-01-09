/* There are two n-element arrays of integers, A and B. Permute them
 * into some A' and B' such that the relation A'[i] + B'{i} >= k holds
 * for all i where 0 <= i < n.
 * There will be q queries consisting of A, B, and k. For each query,
 * return YES if some permutation A', B' satisfying the relation exists.
 * Otherwise, return NO.
 * 
 * Example:
 * A = [0, 1]
 * B = [0, 2]
 * k = 1
 * A valid A', B' is A' = [1, 0] and B' = [0, 2]: 1+0 >= 1, 0+2 >= 1.
 * Return YES.
 * 
 * twoArrays has the following parameters:
 * ~ int k: an integer
 * ~ int A[n]: an array of integers
 * ~ int B[n]: an array of integers
 */
package HackerRankJava;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class PTAResult {
    /*
     * 'twoArrays' accepts following parameters:
     *      1. INTEGER k
     *      2. INTEGER_ARRAY A
     *      3. INTEGER_ARRAY B
     * The function is expected to return a STRING.
     */

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        Collections.reverse(B);
        Queue<Integer> tester = new LinkedList<>();

        for (int i = 0; i < A.size(); i++) {
            tester.add(A.get(i));
        }

        for (Integer e : B) {
            if ((tester.peek() + e) >= k) {
                tester.remove();
            } else {
                continue;
            }
        }

        if (tester.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}

public class PermutingTwoArraysSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine()
                    .replaceAll("\\s+$", "").split(" ");
                
                int k = Integer.parseInt(firstMultipleInput[0]);

                List<Integer> A = Stream.of(bufferedReader.readLine()
                    .replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> B = Stream.of(bufferedReader.readLine()
                    .replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = PTAResult.twoArrays(k, A, B);

                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I fi
 */