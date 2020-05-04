package solutions.No_0001_To_No_0100.No_0088_merge_sorted_array;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 所有数放到一个数组, 然后排序不是美滋滋?
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int currentIndex = 0;
        for(int i = 0 ; i < m ; i++){
            nums[currentIndex++] = nums1[i];
        }
        for(int num : nums2){
            nums[currentIndex++] = num;
        }
        Arrays.sort(nums);
        currentIndex = 0 ;
        for(int num : nums){
            nums1[currentIndex++] = num;
        }
    }
}
