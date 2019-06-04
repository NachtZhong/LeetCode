package solutions.No_0231_power_of_two;

/**
 * https://leetcode.com/problems/power-of-two/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an integer, write a function to determine if it is a power of two.
 * Example 1:
 * Input: 1
 * Output: true
 * Explanation: 2^0 = 1
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 2^4 = 16
 * Example 3:
 * Input: 218
 * Output: false
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 一直除2直到不能整除, 如果结果为1则是2的n次方, 如果不为1则不是2的n次方
 * 注意判断n=0和n=1的特殊情况
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        while(n%2==0){
            n = n/2 ;
        }
        return n == 1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(-4));
    }
}
