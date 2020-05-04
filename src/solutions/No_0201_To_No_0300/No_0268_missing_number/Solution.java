package solutions.No_0201_To_No_0300.No_0268_missing_number;

/**
 * https://leetcode.com/problems/missing-number/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 0-n理论上的和为(0+n)*(n+1)/2
 * 减去实际数组的和就是缺失的数字
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0 ;
        for(int num : nums){
            sum += num;
        }
        return nums.length*(nums.length+1)/2-sum;
    }
}
