/* An array is a type of data structure that stores elements of the same type in a
 * contiguous block of memory. In an array, A, of size N, each memory location has
 * some unique index, i (where 0 <= i < N), that can be referenced as A[i] or A_i.
 * Reverse an array of integers.
 */
package HackerRankJava.DataStructures;
import java.util.*;

public class Arrays1Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = ArrIResult.reverseArray(arr);
        
        ArrIResult.printArray(result);

        in.close();
    }
}

class ArrIResult {
    /*
     * 'reverseArray' accepts INTEGER_ARRAY arr as parameter.
     * The function is expected to return an INTEGER_ARRAY.
     */

    public static int[] reverseArray(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I've decided to completely rewrite the main method to reflect
 * more common practices I've been exposed to, as the buffered readers were starting
 * to peeve me haha. But I chose to have two pointers at either end of the array so
 * that way iterates through the array N/2 times, however the time complexity of the
 * solution still remains O(n).
 */