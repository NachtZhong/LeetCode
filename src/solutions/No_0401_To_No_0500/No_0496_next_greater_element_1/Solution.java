package solutions.No_0401_To_No_0500.No_0496_next_greater_element_1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 先遍历nums2, 将每个数和下一个大于它的数的值放到map里面, 如果没有则放-1
 * 然后对于每个num1里面的数, 查询map, 获取对应的值
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for(int i = 0 ; i < nums2.length; i++){
            for(int j = i + 1 ; j < nums2.length ; j++){
                if(nums2[j] > nums2[i]){
                    numMap.put(nums2[i],nums2[j]);
                    break;
                }
            }
            if(!numMap.containsKey(nums2[i])){
                numMap.put(nums2[i], -1);
            }
        }
        for(int i = 0 ; i < nums1.length ; i ++){
            nums1[i] = numMap.get(nums1[i]);
        }
        return nums1;
    }
}
