package solutions.No_0101_To_No_0200.No_0198_house_robber;

/**
 * https://leetcode.com/problems/house-robber/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 抢劫, 数组每一个元素代表第i个房子有的钱, 要求不能抢相邻的房子, 求最多能抢的钱
 * 解题思路:
 * 动态规划思想, 主要是要找出规律
 * 比如到了第i个房子, 有两个选择
 * 1. 抢劫第i个房子, 此时金额为nums[i] + dp[i-2]
 * 2. 抢劫第i-1个房子, 第i个房子不抢, 此时金额为dp[i-1]
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2,1,1,2}));
    }
    public int rob(int[] nums) {
        /**
         * 处理边界条件
         */
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i< nums.length; i++){
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
}
