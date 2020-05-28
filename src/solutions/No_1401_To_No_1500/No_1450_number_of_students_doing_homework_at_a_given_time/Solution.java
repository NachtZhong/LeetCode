package solutions.No_1401_To_No_1500.No_1450_number_of_students_doing_homework_at_a_given_time;

import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two integer arrays startTime and endTime and given an integer queryTime.
 *
 * The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
 *
 * Return the number of students doing their homework at time queryTime. More formally, return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.
 *
 *
 *
 * Example 1:
 *
 * Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
 * Output: 1
 * Explanation: We have 3 students where:
 * The first student started doing homework at time 1 and finished at time 3 and wasn't doing anything at time 4.
 * The second student started doing homework at time 2 and finished at time 2 and also wasn't doing anything at time 4.
 * The third student started doing homework at time 3 and finished at time 7 and was the only student doing homework at time 4.
 * Example 2:
 *
 * Input: startTime = [4], endTime = [4], queryTime = 4
 * Output: 1
 * Explanation: The only student was doing their homework at the queryTime.
 * Example 3:
 *
 * Input: startTime = [4], endTime = [4], queryTime = 5
 * Output: 0
 * Example 4:
 *
 * Input: startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
 * Output: 0
 * Example 5:
 *
 * Input: startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
 * Output: 5
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历即可, 水题
 */
public class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        return (int) Stream.iterate(0, i -> i + 1).limit(startTime.length).filter(i -> queryTime >= startTime[i] && queryTime <= endTime[i]).count();
    }
}
