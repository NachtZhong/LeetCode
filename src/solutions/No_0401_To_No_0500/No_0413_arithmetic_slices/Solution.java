package solutions.No_0401_To_No_0500.No_0413_arithmetic_slices;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/arithmetic-slices/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 求数组里面等差数列的数量(要三个或以上元素才能组成等差数列)
 * 解题思路:
 * 找到规律, 比如之前已经有等差数列1,2,3, 那么多一个4的时候, 等差数列应该比在3的位置的时候多出dp[i-1]+1个数列, 如果是之前没有等差数列, 到了i这个位置形成了一个等差数列, 那么这个位置应该比前一个位置多1 不构成等差数列时dp[i] = 0
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1,2,3,4,5}));
    }
    public int numberOfArithmeticSlices(int[] nums) {
        /*处理边界条件*/
        if(nums.length < 3){
            return 0;
        }
        /*dp数组用于存储当前位置i比前一个位置i-1多出的等差数列数量*/
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;
        int sum = 0;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;

    }
}
