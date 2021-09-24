package solutions.No_0001_To_No_0100.No_0046_permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 给出一个数组, 里面有不重复的数字, 求数字所有的排列组合
 * 解题思路:
 * 比如1,2,3, 回溯法, 有点抽象, 总体来说是在每个分支处理之后回滚节点状态, 再处理其他分支
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrackingHandle(nums, 0, result);
        return result;
    }

    /**
     * 回溯法处理
     * @param nums
     * @param i
     * @param result
     */
    private void backTrackingHandle(int[] nums, int i, List<List<Integer>> result) {
        /*如果i到了尽头, 说明此时分支已经到了尽头, 加入结果集*/
        if(i == nums.length - 1){
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            result.add(list);
            return;
        }
        /*处理单分支后回滚*/
        for(int j = i; j < nums.length; j++){
            /*第i位元素与后面任一元素交换, 为一个分支, 处理完回滚*/
            swap(nums, i, j);
            backTrackingHandle(nums, i + 1, result);
            swap(nums, i, j);
        }
    }

    /**
     * 交换数组中的两个元素
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
