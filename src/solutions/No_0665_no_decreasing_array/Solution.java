package solutions.No_0665_no_decreasing_array;

/**
 * https://leetcode.com/problems/non-decreasing-array/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 *
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 *
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历数组, 出现数据不是增的情况时, 假设当前下标为n 首先判断n-1是否为第一个数字, 如果是, 修改n-1下标元素为最小(不会影响到后面的数字)
 * 如果不是第一个数字, 判断n-2是否大于当前数字, 如果不大于的话, 将n-1下标元素改为等于当前数字(不会影响后面的数字)
 * 如果n-2下标元素大于n下标元素, 将n下标元素改为等于n-1下标元素
 * 改完之后, 继续遍历剩下的数字, 如果规律递增, 返回true , 否则返回false
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int operCount = 0 ;
        for(int n = 1 ; n < nums.length ; n++){
            if(nums[n] < nums[n-1]){
                if(n == 1 || nums[n-2] <= nums[n]){
                    nums[n-1] = nums[n];
                    operCount ++ ;
                }else{
                    nums[n] = nums[n-1];
                    operCount++;
                }
            }
            if (operCount > 1 ){
                break ;
            }
        }
        return operCount <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkPossibility(new int[]{4,2,3}));
    }
}
