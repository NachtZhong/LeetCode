package solutions.No_0260_single_number_3;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number-iii/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * Example:
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 由于题目说明重复的数只会重复2次, 用集合做一下去重偷懒
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int num:nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        int[] result = new int[set.size()];
        int i = 0 ;
        for(int num : set){
            result[i++] = num;
        }
        return result ;
    }
}
