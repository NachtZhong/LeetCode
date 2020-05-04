package solutions.No_0101_To_No_0200.No_0136_single_number;

/**
 * https://leetcode.com/problems/single-number/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 利用异或的性质来做:a xor b xor b = a , 0 xor a = a
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0 ;
        for(int num : nums){
            result = result ^ num ;
        }
        return result;
    }
}
