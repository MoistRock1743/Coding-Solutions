/* Given a 6x6 2D Array, arr. An hourglass in A is a subset of values with indices falling in this
 * pattern in arr's graphical representation:
 * a b c
 *   d 
 * e f g
 * There are 16 hourglasses in arr. An hourglass sum is the sum of an hourglass' values. Calculate
 * the hourglass sum for every hourglass in arr, then print the maximum hourglass sum. The array will
 * always be 6 x 6.
 * 
 * hourglassSum has the following parameter:
 * ~ int arr[6][6]: an array of integers
 */
package HackerRankJava.DataStructures;
import java.util.*;

public class TDArraysSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        
        int result = ArrayIIResult.hourglassSum(arr);

        System.out.println(result);
        
        in.close();
    }
}

class ArrayIIResult {
    /*
     * 'hourglassSum' acceps 2D_INTEGER_ARRAY arr as parameter;
     * The function is expected to return an INTEGER.
     */

    public static int hourglassSum(int[][] arr) {
        int sum = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                int temp = arr[i][j] + (arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1])
                            + (arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1]);
                
                if (sum < temp) {
                    sum = temp;
                }
            }
        }

        return sum;
    }

}

/*****************************Solution Explained***********************************
 *  In this solution, it asks to go ahead and compute all of the hourglass sums, so
 * that is what I did. It was a simple question meant to fully grasp ways to navigate
 * multidimensional arrays, as well as also an linear way of finding the sum. As for
 * the actual solution, it can be seen that the only centers of the hourglass are all
 * of the integers except for the outer padding layer (using Deep Learning lingo there).
 * Therefore, you just need to iterate through all of those integers, find the three
 * integers of each row+-1 and col, col+-1.
 */