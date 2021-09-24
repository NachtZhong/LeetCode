package solutions.No_0601_To_No_0700.No_0633_sum_of_square_numbers;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 * Example 1:
 *
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 *
 * Input: c = 3
 * Output: false
 * Example 3:
 *
 * Input: c = 4
 * Output: true
 * Example 4:
 *
 * Input: c = 2
 * Output: true
 * Example 5:
 *
 * Input: c = 1
 * Output: true
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 给一个数, 返回这个数能否是两个数的平方之和
 * 解题思路:
 * 双指针法, 计算两个指针指向的数的平方之和, 然后和n比较, 如果大于则右指针左移, 反之左指针右移
 * 右指针的选取:
 * 取n开方后的整数就好了
 * 求开方数两种方法解析:
 * https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(1000000));
    }

    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = sqrtByBinary(c);
        while(left <= right){
            /*用int很容易溢出, 用long*/
            long current = (long) left * left + (long) right * right;
            if(current == c){
                return true;
            }else if(current > 0 && current < c){
                /*考虑到current溢出小于0的情况*/
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    private int sqrtByNewton(int c){
        if(c == 0){
            return 0;
        }
        double x = c;
        while(true){
            double nextX = (x * x + c)/(2 * x);
            if(Math.abs(x - nextX) < 1e-7){
                break;
            }
            x = nextX;
        }
        return (int) x;
    }

    private int sqrtByBinary(int c){
        if(c == 0){
            return c;
        }
        int l = 0, r = c, result = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if((long) mid * mid == c){
                return mid;
            }else if((long) mid * mid > c){
                r = mid - 1;
            }else{
                result = mid;
                l = mid + 1;
            }
        }
        return result;
    }
}
