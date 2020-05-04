package solutions.No_0301_To_No_0400.No_0326_power_of_three;

/**
 * https://leetcode.com/problems/power-of-three/
 *
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Example 1:
 * <p>
 * Input: 27
 * Output: true
 * Example 2:
 * <p>
 * Input: 0
 * Output: false
 * Example 3:
 * <p>
 * Input: 9
 * Output: true
 * Example 4:
 * <p>
 * Input: 45
 * Output: false
 * Follow up:
 * Could you do it without using any loop / recursion?
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 如果为3的n次方, 一定能被int类型里面3的次方的最大值1162261467整除,这道题用loge函数会出现精度丢失问题, 注意区分(可用log10)
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n <= 0 ? false : 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(243));
    }
}
