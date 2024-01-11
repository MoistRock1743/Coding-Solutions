/* Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 * 
 * Example:
 * - s = '12:01:00PM'
 *   Return '12:01:00'
 * - s = '12:01:00AM'
 *   Return '00:01:00'
 * 
 * timeConversion has the following parameter(s):
 * ~ string s: a time in 12 hour format
 */
package HackerRankJava;
import java.io.*;

class TCResult {
    /*
     * 'timeConversion' function accepts STRING s as parameter.
     * The function is expected to return a STRING.
     */

    public static String timeConversion(String s) {
        String[] dateComp = s.split("(:)|(?<=\\d)(?=\\D)");

        if (!dateComp[0].equals("12")) {

            if (dateComp[3].equals("AM")) {
                return dateComp[0] + ":" + dateComp[1] + ":" + dateComp[2];
            } else {
                int temp = Integer.parseInt(dateComp[0]) + 12;
                return temp + ":" + dateComp[1] + ":" + dateComp[2];
            }

        } else if (dateComp[3].equals("AM")) {
            return "00:" + dateComp[1] + ":" + dateComp[2];
        } else {
            return dateComp[0] + ":" + dateComp[1] + ":" + dateComp[2];
        }
    }
}

public class TimeConversionSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        String s = bufferedReader.readLine();

        String result = TCResult.timeConversion(s);
        
        System.out.println(result);

        bufferedReader.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I have the heavy utilization of if-else statements. After 
 * splitting the arrays into the substrings "12" "00" "00" and "AM", I then put them
 * through these if statements. These statements are meant to catch several elements 
 * that indicate what needs to be returned.
 *  These checks include: is the time 12:something? If so, is it in the morning or
 * afternoon? If it is not 12 then is it the morning?
 *  The solution has a time complexity of O(1).
 *  The solution has a space complexity of O(1).
 *  Although I believe this solution does sacrifice readability.
 */
