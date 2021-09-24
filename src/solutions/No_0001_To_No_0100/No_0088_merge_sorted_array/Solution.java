package solutions.No_0001_To_No_0100.No_0088_merge_sorted_array;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
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
 * 三个指针, 两个处理两个数组的数据, 一个处理插入位置, 插入时从nums1右边开始从大到小插入, 因为后面有足够的空间
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int pos = nums1.length - 1;
        while(m >= 0 && n >= 0){
            /*选大的数插入到nums1后面*/
            if(nums1[m] > nums2[n]){
                nums1[pos--] = nums1[m--];
            }else{
                nums1[pos--] = nums2[n--];
            }
        }
        /*如果m=0时, 第二个数组还有数据, 说明第一个数组处理完了, 由于第二个数组已经有序, 插入到剩下的位置就行*/
        /*如果n=0时第一个数组还有数据没处理就不用管了, 因为他们本来就在nums1里面合适的位置*/
        while (n >= 0){
            nums1[pos--] = nums2[n--];
        }
    }
}
