package solutions.No_0283_move_zeroes;

/**
 * https://leetcode.com/problems/move-zeroes/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 把非0的数set到数组前面,记录下索引, 然后把索引后的全部set为0
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]!=0){
                nums[index++] = nums[i];
            }
        }
        for(int i = index ; i < nums.length ; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {

    }
}
