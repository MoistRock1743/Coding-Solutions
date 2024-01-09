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

class Result {
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
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/*****************************Solution Explained***********************************
 *  In this solution, I have the heavy utilization of if-else statements. After 
 * splitting the arrays into the substrings "12" "00" "00" and "AM", I then put them
 * through these if statements. These statements are meant to catch several elements 
 * that indicate what needs to be returned.
 *  These checks include: is the time 12:something? If so, is it in the morning or
 * afternoon? If it is not 12 then is it the morning?
 *  This solution has a time complexity of O(1).
 *  Although I believe this solution does sacrifice readability.
 */