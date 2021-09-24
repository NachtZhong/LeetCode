package solutions.No_0001_To_No_0100.No_0034_find_element_in_sorted_array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 一个有序数组, 找出某个元素在里面的开始index和结束index
 * 解题思路:
 * 由于是有序, 使用二分查找, 在查找的过程中调整逻辑分别查找左边界和右边界
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{2,2}, 3)));
    }

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        int leftBound = findLeftBound(nums, target);
        int rightBound = findRightBound(nums, target);
        return new int[]{leftBound >= nums.length || nums[leftBound] != target ? -1 : leftBound, nums[rightBound] == target ? rightBound : -1};
    }

    private int findLeftBound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            /*只有小于才移动左边界, 等于时移动右边界, 使最终定位偏左, 获得元素范围的左边界*/
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    private int findRightBound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            /*小于等于都移动左边界, 使最终定位偏右, 获得元素范围的右边界, 这样最终左边界会多加一个1, 返回的时候需要-1再返回*/
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return Math.max(0, left - 1);
    }
}
