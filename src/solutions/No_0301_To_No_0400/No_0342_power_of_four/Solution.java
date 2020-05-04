package solutions.No_0301_To_No_0400.No_0342_power_of_four;

/**
 * https://leetcode.com/problems/power-of-four/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用log函数做
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        return (Math.log(num)/Math.log(4))%1 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(5));
        System.out.println(Math.log(16)/Math.log(4));
    }
}
