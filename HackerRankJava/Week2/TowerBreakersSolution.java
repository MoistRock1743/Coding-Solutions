/* Two players are playing a game of Tower Breakers!
 * Player 1 always moves first, and both players always
 * play optimally. The rules of the game are as follows:
 *  - Initially there are n towers.
 *  - Each tower is of height m.
 *  - The players move in alternating turns
 *  - In each turn, a player can choose a tower of height
 *    x and reduce its height to y, where 1 <= y < x and 
 *    y evenly divides x.
 *  - If the current player is unable to make a move, they
 *    lose the game. 
 * Given the values of n and m, determine which player will
 * win. If the first player wins, return 1. Otherwise,
 * return 2.
 * 
 * Example:
 * n = 2
 * m = 6
 * There are 2 towers, each 6 units tall. Player 1 has a
 * choice of two moves:
 *      - remove 3 pieces from a tower to leave 3 as 6%3=0
 *      - remove 5 pieces to leave 1
 * Let Player 1 remove 3. Now the towers are 3 and 6 units
 * tall. Player 2 matches the move. Now the towers are both
 * 3 units tall. Now Player 1 has only one move. Player 1
 * removes 2 pieces leaving 1. Towers are 1 and 2 units tall.
 * Player 2 matches again. Towers are both 1 unit tall. Player
 * 1 has no move and loses Return 2. 
 * 
 * towerBreakers has the following parameters:
 * ~ int n: the number of towers
 * ~ int m: the height of each tower
 */
package HackerRankJava.Week2;
import java.io.*;
import java.util.stream.*;

class TBResult {
    /*
     * 'towerBreakers' accepts following parameters:
     *      1. INTEGER n
     *      2. INTEGER m
     * The function is expected to return an INTEGER. 
     */

    public static int towerBreakers(int n, int m) {
        if (n % 2 == 0 || m == 1) {
            return 2;
        } else {
            return 1;
        }
    }
}

public class TowerBreakersSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine()
                    .replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = TBResult.towerBreakers(n, m);

                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, it is pretty tricky by the wording of the problem statement,
 * but it boils down to a simple if-else statement. Taking the example given, it is
 * clear to see that with an even tower count, Player 1 is destined to lose, no matter
 * how many moves it tries to delay the end. Meanwhile a game of towers with 1 block will end in 
 * a Player 2 win as well since there are no moves to begin with. The only way for 
 * Player 1 to win is if there are an odd number of towers that have greater than 1
 * blocks.
 *  The solution has a time complexity of O(1).
 *  The solution has a space complexity of O(1).
 */