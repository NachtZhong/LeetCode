package solutions.No_0001_To_No_0100.No_0001_two_sum;

/**
 * https://leetcode.com/problems/two-sum/
 * @author Nacht
 * Created on 2019/5/15
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 两个for循环遍历数组索引即可。
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] t = new int[2];
        for(int a = 0 ; a < nums.length ; a ++){
            for(int b = a + 1 ; b < nums.length ; b++){
                if(nums[a] + nums[b] == target){
                    t[0] = a ;
                    t[1] = b ;
                }
            }
        }
        return t;
    }
}
