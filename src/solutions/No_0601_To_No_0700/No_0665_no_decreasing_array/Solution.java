package solutions.No_0601_To_No_0700.No_0665_no_decreasing_array;

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
 * 遍历数组, 出现数据不是增的情况时, 假设当前下标为n 首先判断n-1是否为第一个数字, 如果是, 这个数字是必改的, 因为改第小第一个数字不会影响到后面, 而改大第二个数字就会影响后面, 改修改n-1下标元素为最小(不会影响到后面的数字)
 * 如果不是第一个数字, 分两种情况, 假设A1, A2, A3, A3判断出比A2小了, 此时有两种情况, A1<=A3, 和A1>A3, 可以举个例子: A1,A2,A3 => 2,4,3 和 A1, A2, A3 => 2,4,1
 * 第一种情况改A2才是最优解, 因为这样A3不会变大, 对后面的影响最小, 是最优选择
 * 第二种情况没得选, 只能改A3和A2一样, 才能尽量不影响后面的数字
 * 改完之后, 继续遍历剩下的数字, 如果规律递增, 返回true , 否则返回false
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        /*总修改次数*/
       int modCount = 0;
       for(int i = 1; i < nums.length; i++){
           /*出现了不递增的情况*/
           if(nums[i] < nums[i - 1]){
               if(i == 1 || nums[i - 2] <= nums[i]){
                   /*如果是第二个元素或者i-2的值<=i的值, 改i-1位置的值*/
                   nums[i - 1] = nums[i];
                   modCount++;
               }else{
                   /*如果不是第二个元素且i-2的值>i的值, 只能将i的值改为i-1的值*/
                   nums[i] = nums[i - 1];
                   modCount++;
               }
           }
           /*改了两次就不满足条件了, 返回false*/
           if(modCount > 1){
               return false;
           }
       }
       return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkPossibility(new int[]{4,2,3}));
    }
}
