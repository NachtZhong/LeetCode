package solutions.No_0201_To_No_0300.No_0258_add_digits;

/**
 * https://leetcode.com/problems/add-digits/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * Example:
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 1. 如果n<10,那就是n本身
 * 2. 如果n>10,那么如果n能被9整除,结果为9,否则为n除以9的余数
 * 运用到一个结论:能被9整除的数字它的各位数字之和必然能被9整除
 * 原理:任何一个数除以9的余数，等于它的各位数字和除以9的余数。
 * 例如100a + 10b + c = (99a + 9b) + (a + b + c)，右边第一部分能被9整除，第二部分是各位数字之和
 */
public class Solution {
    public int addDigits(int num) {
        return num < 10 ? num : num % 9 == 0 ? 9 : num % 9 ;
    }
}
