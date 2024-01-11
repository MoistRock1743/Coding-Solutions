/* A teacher asks the class to open their books to a
 * page number. A student can either start turning pages
 * from the front of the book or from the back of the
 * book. They always turn pages one at a time. When they
 * opne the book, page 1 is always on the right side.
 * When they flip page 1, they see pages 2 and 3. Each 
 * page except the last page will always be printed on
 * both sides. The last page may only be printed on the
 * front, given the length of the book. If the book is
 * n pages long, and a student wants to turn to page p,
 * what is the minimum number of pages to turn? They can
 * start at the beginning or the end of the book.
 * Given n and p, find and print the minimum number of 
 * pages that must be turned in order to arrive at page p.
 * 
 * Example:
 * n = 5
 * p = 3
 * Open the book to page 1, flip 1 page and you're on the
 * correct page. If they open the book to the last page,
 * page 5, they turn 1 page and are at the correct page.
 * Return 1.
 * 
 * pageCount has the following parameters:
 * ~ int n: the number of pages in the book
 * ~ int p: the page number to turn to
 */
package HackerRankJava.Week2;
import java.io.*;

class DBResult {
    /*
     * 'pageCount' accepts following parameters:
     *      1. INTEGER n
     *      2. INTEGER p
     * The function is expected to return an INTEGER.
     */

    public static int pageCount(int n, int p) {
       if (n % 2 == 0) {
            if (p < (n/2)) {

                if (p % 2 == 0) {
                    return p / 2;
                } else {
                    return (p-1) / 2;
                }

            } else {

                if ((n-p) == 1 && n != 2) { 
                    return 1; 
                } else if ((n-p) % 2 == 0) {
                    return (n-p) / 2;
                } else {
                    return (n-p-1) / 2;
                }

            }
        } else {
            if (p < (n+1)/2) {

                if (p % 2 == 0) {
                    return p / 2;
                } else {
                    return (p-1) / 2;
                }

            } else {

                if ((n-p) % 2 == 0) {
                    return (n-p) / 2;
                } else {
                    return (n-p-1) / 2;
                }
            }
        } 
    }
}

public class DrawingBookSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = DBResult.pageCount(n, p);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I tackled this with several if-else statements to cover the
 * different conditions that arise from this problem. Considering the parameters
 * only included the size of the book and the page being desired and not an array,
 * I tackled this in a discrete mathematical method. This sacrificed readability (at
 * least for my sake) for speed and space. The essentials of this solution checks 
 * for if the book is odd or even, if the page desired is either before the middle
 * or after, and other special conditions (such as a book with size=2).
 *  The solution has a time complexity of O(1).
 *  The solution has a space complexity of O(1).
 */