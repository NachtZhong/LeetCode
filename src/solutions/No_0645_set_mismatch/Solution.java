package solutions.No_0645_set_mismatch;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/set-mismatch/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 利用set暴力判断
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int errorNum = 0;
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            if(!numSet.contains(num)){
                numSet.add(num);
            }else{
                errorNum = num;
            }
        }
        int missNum = 0;
        for(int i = 1 ; i <= nums.length ; i++){
            if(!numSet.contains(i)){
                missNum = i ;
            }
        }
        return new int[]{errorNum,missNum};
    }
}
