/* There is a collection of input strings and a collection of query strings. For
 * each query string, determine how many times it occurs in the list of input 
 * strings. Return an array of the results.
 * 
 * Example:
 * strings = ['ab', 'ab', 'abc']
 * queries = ['ab', 'abc', 'bc']
 * There are 2 instances of 'ab', 1 of 'abc', and 0 of 'bc'. For each query, add
 * an element to the return array, results = [2, 1, 0].
 * 
 * matchingStrings has the following parameters:
 * ~ string strings[n]: an array of strings to search
 * ~ string queries[q]: an array of query strings
 */
package HackerRankJava;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class SAResult {
    /*
     * 'matchingStrings' function accepts following parameters:
     *      1. STRING_ARRAY strings
     *      2. STRING_ARRAY queries
     * It is expected to return an INTEGER_ARRAY.
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String temp ="";

        for (String query : queries) {
            temp = query;
            map.put(temp, 0);
        }

        for (String str : strings) {
            temp = str;
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            }
        }

        Collection<Integer> values = map.values();
        List<Integer> ans = new ArrayList<>(values);

        return ans;
    }
}

public class SparseArraysSolution {
    public static void main(String[] args) throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj
            (i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj
            (i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .collect(toList());
        
        List<Integer> res = SAResult.matchingStrings(strings, queries);

        System.out.println(res);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I decided to keep track of the counts via a LinkedHashMap. I
 * decided to use a LinkedHashMap instead of a normal HashMap due to the fact I can
 * preserve the input order with the Linked version, as opposed to the normal version
 * which will sort the elements.
 *  Therefore, this solution goes through the list of queries, logs them as keys with
 * the values of 0. Then it iterates through the list of strings to search and if the
 * structure contains the current string as a key, it increments the count. To put it 
 * into the desired output data value, I used a Collection instance to store just the
 * values of the LinkedHashMap and created a new list of integers off the collection.
 *  The solution has a time complexity of O(m+n).
 *  The solution has a space complexity of O(m+n).
 */