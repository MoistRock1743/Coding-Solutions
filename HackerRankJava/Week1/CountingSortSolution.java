/* -Comparison Sorting-
 * Quicksort usually has a running time of n x log(n), but is there an
 * algorithm that can sort even faster? In general, this is not possible.
 * Most sorting algorithms are comparison sorts, i.e. they sort a list just
 * by comparing the elements to one another. A comparison sort algorithm
 * cannot beat n x log(n) (worst-case) running time, since n x log(n) represents
 * the minimum number of comparisons needed to know where to place each
 * element. Check out this link for more details:
 * http://www.cs.cmu.edu/~avrim/451f11/lectures/lect0913.pdf
 * 
 * -Alternative Sorting-
 * Another sorting method, the counting sort, does not require comparison.
 * Instead, you create an integer array whose index range covers the entire
 * range of values in your array to sort. Each time a value occurs in the 
 * original array, you increment the counter at that index. At the end, run
 * through your counting array, printing the value of each non-zero valued
 * index that number of times.
 * 
 * Example:
 * arr = [1, 1, 3, 2, 1]
 * All of these values are in the range [0 ... 3], so create an array of
 * zeros, result = [0, 0, 0, 0]. The results of each iteration follow:
 * i    arr[i]  result
 * 0    1       [0, 1, 0, 0]
 * 1    1       [0, 2, 0, 0]
 * 2    3       [0, 2, 0, 1]
 * 3    2       [0, 2, 1, 1]
 * 4    1       [0, 3, 1, 1]
 * The frequency array is [0, 3, 1, 1]. These values can be used to create
 * the sorted array as well: sorted = [1, 1, 1, 2, 3].
 * 
 * countingSort has the following paramter(s):
 * ~ arr[n]: an array of integers
 */
package HackerRankJava;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class CSSolution {
    /*
     * 'countingSort' accepts INTEGER_ARRAY arr as parameter.
     * The function is expected to return an INTEGER_ARRAY of size 100.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> frequencyArr = new ArrayList<Integer>(Collections.nCopies(100, 0));
        int temp = 0;
        for (Integer element : arr) {
            temp = frequencyArr.get(element);
            temp += 1;
            frequencyArr.set(element, temp);
        }
        return frequencyArr;
    }
}

public class CountingSortSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        List<Integer> arr = Stream.of(bufferedReader.readLine()
            .replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        
        List<Integer> result = CSSolution.countingSort(arr);

        System.out.println(result);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I used a self-explanatory for-loop that iterates through each
 * element of the array parameter and increments the index of the created frequency
 * array that corresponds to the element in the array parameter. The overall solution
 * just returns the frequency array, but you can easily print the sorted array by
 * going through this frequency array. However, the website was only asking for the
 * frequency array, so that is all that was printed and returned.
 *  The solution has a time complexity of O(n).
 *  The solution has a space complexity of O(1).
 */
