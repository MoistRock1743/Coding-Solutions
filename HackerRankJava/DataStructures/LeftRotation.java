/* A left rotation operation on an array of size n shifts each of the array's elements 1 unit
 * to the left. Given an integer, d, rotate the array that many steps left and return the result.
 * 
 * Example:
 * d = 2
 * arr = [1, 2, 3, 4, 5]
 * After 2 rotations, arr' = [3, 4, 5, 1, 2]
 */
package HackerRankJava.DataStructures;
import java.util.*;

public class LeftRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int d = Integer.parseInt(in.nextLine());

        int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        LRResult.printArray(LRResult.rotateLeft(d, arr));

        in.close();
    }
}

class LRResult {
    /*
     * 'rotateLeft' accepts the following parameters:
     *   1. INTEGER d
     *   2. INTEGER_ARRAY arr
     * The function is expected to return an INTEGER_ARRAY.
     */

    public static int[] rotateLeft(int d, int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[d];
            d++;
            if (d == arr.length) {
                d = 0;
            }
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, the constraints detail d to be within 1, N. Therefore, d will
 * always be a valid index within the original array. Upon inspection, it is evident
 * that the number of rotations is the index of the original array that corresponds
 * with the first entry of the newly rotated array. Therefore, it can be copied by
 * starting at that index, looping back to the first index and going until the new
 * resulting array is filled.
 *  The solution has a time complexity of O(n).
 */