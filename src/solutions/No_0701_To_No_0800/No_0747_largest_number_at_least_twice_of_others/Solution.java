package solutions.No_0701_To_No_0800.No_0747_largest_number_at_least_twice_of_others;

/**
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * In a given integer array nums, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 *
 * If it is, return the index of the largest element, otherwise return -1.
 *
 * Example 1:
 *
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 *
 *
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 *
 *
 * Note:
 *
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 记录第一大和第二大的数, 以及第一大的数的索引, 如果第一大的数大于等于第二大的数的两倍, 返回第一大的数的索引, 否则返回-1
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        int maxNum = 0;
        int secondMaxNum = -1;
        int maxNumIndex = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(maxNum <= nums[i]){
                secondMaxNum = maxNum;
                maxNum = nums[i];
                maxNumIndex = i;
            }else{
                secondMaxNum = Math.max(secondMaxNum, nums[i]);
            }
        }
        if(maxNum >= 2 * secondMaxNum){
            return maxNumIndex;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().dominantIndex(new int[]{1, 2,3,4}));
    }
}
