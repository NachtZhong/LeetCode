package solutions.No_0001_To_No_0100.No_0069_sqrt;

/**
 * https://leetcode.com/problems/sqrtx/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 对某个数开方, 取整
 * 解题思路:
 * 1. 二分法
 * 2. 牛顿法
 */
public class Solution {
    public int mySqrt(int x) {
        return sqrtByNewton(x);
    }

    public int sqrtByBinary(int x){
        long left = 0;
        long right = x;
        int result = 0;
        while(left <= right){
            long mid = left + (right - left)/2;
            long tmp = mid * mid;
            if(tmp == x){
                return (int) mid;
            }else if (tmp < x){
                result = (int) mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }

    public int sqrtByNewton(int x){
        long x0 = x;
        while(x0 * x0 > x){
            x0 = (x0 * x0 + x)/(2 * x0);
        }
        return (int) x0;
    }
}
