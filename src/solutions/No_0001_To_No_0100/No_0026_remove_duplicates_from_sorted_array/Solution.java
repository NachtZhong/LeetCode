package solutions.No_0001_To_No_0100.No_0026_remove_duplicates_from_sorted_array;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * Internally you can think of this:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历数组,碰到不同的数就按顺序放到数组前面
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0 ;
        for(int num:nums){
            //如果num是第一个数或者num和最后一个放到数组前面的数不同则加到数组前面
            if(i == 0 || num != nums[i-1]){
                nums[i++] = num ;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        new Solution().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
