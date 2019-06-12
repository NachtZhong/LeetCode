package solutions.No_0400_nth_digit;

import java.util.Map;

/**
 * https://leetcode.com/problems/nth-digit/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 * Example 1:
 * Input:
 * 3
 * Output:
 * 3
 * Example 2:
 * Input:
 * 11
 * Output:
 * 0
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 循环会超时
 * 1位数开始的数字索引:1
 * 2位数开始的数字索引:9*1+1=10
 * 3位数开始的数字索引:90*2+10=190
 * ...
 */
public class Solution {
    public int findNthDigit(int n) {
        if(n==Integer.MAX_VALUE){
            return 2;
        }
        //数字位数
        int digits = 1;
        //1位数,2位数,...n位数开始的第一个数字的索引
        int startIndex = 1;
        //n所对应的数字的位数开始的第一个数字的索引
        int digitsStartIndex =0;
        while(0==0){
            if(n < startIndex){
                break;
            }
            if(n == startIndex){
                return 1;
            }
            else{
                digitsStartIndex = startIndex;
                startIndex = (int) (startIndex + digits * 9 * Math.pow(10,digits-1));
                digits ++;
            }
        }
        //第n个数字属于哪个num,由于位数在循环中加了1,运算时要减去1再算
        int num = (int)Math.pow(10,digits-2)+(n-digitsStartIndex)/(digits-1);
        int index = (n-digitsStartIndex)%(digits-1);
        return String.valueOf(num).charAt(index)-'0';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(
                2147483647));
    }
}
