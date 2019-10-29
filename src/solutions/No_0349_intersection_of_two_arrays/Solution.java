package solutions.No_0349_intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 放到两个set做去重, 然后取交集即可
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersectionSet = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            set2.add(num);
        }
        for(int num : set1){
            if(set2.contains(num)){
                intersectionSet.add(num);
            }
        }
        int[] result = new int[intersectionSet.size()];
        int i = 0 ;
        for(int num : intersectionSet){
            result[i++] = num;
        }
        return result;
    }
}
