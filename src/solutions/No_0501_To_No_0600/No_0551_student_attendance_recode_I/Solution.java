package solutions.No_0501_To_No_0600.No_0551_student_attendance_recode_I;

/**
 * https://leetcode.com/problems/student-attendance-record-i/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * You need to return whether the student could be rewarded according to his attendance record.
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历即可
 */
public class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0 ;
        int continuousLateCount = 0;
        for(char c : s.toCharArray()){
            if(c == 'A'){
                continuousLateCount = 0;
                if(++absentCount > 1){
                    return false;
                }
            } else if(c == 'L'){
                if(++continuousLateCount > 2){
                    return false;
                }
            }else {
                continuousLateCount = 0;
            }
        }
        return true;
    }
}
