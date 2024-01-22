/*
 * 
 */
package HackerRankJava.Week3;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class BResult {
    /*
     * 
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        
    }
}

public class BombermanSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine()
                                       .replaceAll("\\s+$", "").split(" ");
        
        int r = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        
        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = BResult.bomberMan(n, grid);

        System.out.println(result);

        bufferedReader.close();
    }
}