package solutions.No_1185_day_of_week;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * https://leetcode.com/problems/day-of-the-week/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a date, return the corresponding day of the week for that date.
 *
 * The input is given as three integers representing the day, month and year respectively.
 *
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 *
 *
 *
 * Example 1:
 *
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 * Example 2:
 *
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 * Example 3:
 *
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 * Constraints:
 *
 * The given dates are valid dates between the years 1971 and 2100.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 工具类乱转
 */
public class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        try {
            String weekDay = new SimpleDateFormat("E").format(new SimpleDateFormat("yyyy-MM-dd").parse(String.format("%s-%s-%s",year,month,day)));
            if("Mon".equals(weekDay)){
                return "Monday";
            }
            if("Tue".equals(weekDay)){
                return "Tuesday";
            }
            if("Wed".equals(weekDay)){
                return "Wednesday";
            }
            if("Thu".equals(weekDay)){
                return "Thursday";
            }
            if("Fri".equals(weekDay)){
                return "Friday";
            }
            if("Sat".equals(weekDay)){
                return "Saturday";
            }
            return "Sunday";
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().dayOfTheWeek(31,8,2019));
    }
}
