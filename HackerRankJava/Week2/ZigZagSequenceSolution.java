/* Given an array of n distinct integers, transform the array into a zig zag
 * sequence by permuting the array elements. A sequence will be called zig
 * zag sequence if the first k elements in the sequence are in increasing order
 * and the last k elements are in decreasing order, where k = (n+1)/2. You need
 * to find the lexicographically smallest zig zag sequence of the given array.
 * 
 * Example:
 * a= [2, 3, 5, 1, 4]
 * Now if we permute the array as [1, 4, 5, 3, 2], the result is a zig zag
 * sequence. Debug the given function 'findZigZagSequence' to return the appropriate
 * zig zag sequence for the given input array.
 */
package HackerRankJava.Week2;
import java.util.*;

public class ZigZagSequenceSolution {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner kb = new Scanner(System.in);
        int test_cases = kb.nextInt();

        for(int cs = 1; cs <= test_cases; cs++){
            int n = kb.nextInt();
             int a[] = new int[n];

            for(int i = 0; i < n; i++){
                a[i] = kb.nextInt();
            }

            findZigZagSequence(a, n);
        }

        kb.close();
   }
   
    public static void findZigZagSequence(int[] a, int n){
        Arrays.sort(a);

        int mid = ((n - 1)/2); //This was originally (n+1)/2
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;
    
        int st = mid + 1;
        int ed = n - 2; //This was originally n - 1.
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1; //This was originally ed + 1.
        }

        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }

        System.out.println();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I debugged three lines of code. I will explain the bugged
 * solution they provided and explain why these lines hindered the result of the 
 * function.
 *  Once the parameter array has been sorted, the original solution calculated the
 * middle index by taking n, the size of the array that will always be odd, and 
 * dividing it by 2. This will lead to an index that is not the middle of the array.
 * For example, say we have an array of size n=5, then this line would calculate the
 * middle of the array as a[(5+1)/2] = a[3]. This fails to acknowledge that arrays
 * start with index 0, so we must fix the equation to (n-1)/2. This would result in
 * a[(5-1)/2] = a[2], which is the middle index of the array.
 *  The next issue follows after switching the largest integer of the array with the
 * middle. The solution uses a while-loop that starts in the middle+1 index and the
 * second to last index of the array. However, the original code had it starting at
 * the last index of the array that was formally the middle, which effectively erased
 * the work of the previous few lines of code.
 *  Finally, the last error was the increments of which the iteration through this 
 * portion of the array were conducted with the "right pointer" that started near the
 * end of the array. The incrementation had it going forward through the array rather
 * than backwards. This led to IndexOutOfBoundsException.
 *  In summation, this solution sorts the array, takes the middle and last integer, flips
 * them, then iterates between them switching the elements to descend.
 *  The solution has a time complexity of O(nlogn).
 *  The solution has a space complexity of O(1).
 */