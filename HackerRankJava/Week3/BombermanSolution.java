/* Bomberman lives in a rectangular gird. Each cell in the grid either contains a bomb or nothing at all.
 * Each bomb can be palnted in any cell of the grid but once planted, it will detonate after exactly 3 seconds.
 * Once a bomb detonates, it's destroyed -- along with anything in its neighboring four cells. This means
 * that if a bomb detonates in cell i, j, any valid celss (i +- 1, j) and (i, j +- 1) are cleared. If there
 * is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating, so there's no chain
 * reaction. Bomberman is immune to bombs, so he can move freely throughout the grid. Here's what he does:
 *      1. Initially, Bomberman arbitrarily plants bombs in some of the cells, the initial state.
 *      2. After one second, Bomberman does nothing.
 *      3. After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole
 *         grid with bombs. No bombs detonate at this point.
 *      4. After one more second, any bombs planted exactly three seeconds ago will detonate. Here, Bomberman
 *         stands back and observes.
 *      5. Bomberman then repeats steps 3 and 4 indefinitely.
 * Note that during every second Bomberman plants bombs, the bomvs are planted simultaneously (i.e., at the
 * exact same moment), and any bombs planted at the same time will detonate at the same time. Given the initial
 * configuration of the grid with the locations of Bomberman's first batch of planted bombs, determine the sate of
 * the grid after N seconds.
 * Example Initial Grid:
 *  . . .
 *  . O .
 *  . . .
 * It looks that same after the first second. After the second second, Bomberman has placed all his charges:
 *  O O O
 *  O O O
 *  O O O
 * At the third second, the bomb in the middle blows up, emptying all surrounding cells:
 *  O . O
 *  . . .
 *  O . O
 * 
 * bomberMan has the following parameters:
 * ~ int n: the number of seconds to simulate
 * ~ string grid[r]: n array of strings that represent the grid in its final state
 */
package HackerRankJava.Week3;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class BResult {
    /*
     * 'bomberMan' accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
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