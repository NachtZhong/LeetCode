package solutions.No_0001_To_No_0100.No_0047_permutations_ii;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * Example 1:
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Constraints:
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 给一个数字集合, 求所有可能的数字排列(相同数字不同顺序也是不同的排列)
 * 解题思路:
 * 用之前一样的思路, 从第i数字开始, 第i个数字和第i ~ nums.length-1个数字交换, 然后统计剩下的数字所有可能的排列, 统计只不过这道题可能会有相同的数字, 这种情况不做交换即可
 * 比如1,2,3, 先统计在1的时候2,3所有可能的排列, 然后统计1和2交换后, 也就是变成2,1,3后1,3所有可能的排列, ...
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1,1,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, 0, nums);
        return result;
    }

    /**
     * 深度遍历, 获取从第i个位置开始的排列
     * @param result
     * @param i
     * @param nums
     */
    private void dfs(List<List<Integer>> result, int i, int[] nums) {

        /*如果已经处理到了数组最后一位, 将当前排列添加到结果集中*/
        if(i == nums.length - 1){
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            result.add(list);
        }

        /*用一个集合存储已经占了当前坑位的元素, 避免出现当前index交换后的数字和之前处理过的数字重复的情况*/
        Set<Integer> set = new HashSet<>();
        /*将当前位置元素后面的每一个元素都与当前元素交换, 进行下一步深度遍历(注意这里要从j取值要从i而不是i+1开始!!!!!!!!不然会漏掉不交换位置时的排列情况)*/
        for(int j = i ; j < nums.length ; j++){
            if(!set.contains(nums[j])) {
                set.add(nums[j]);
                swap(nums, i, j);
                dfs(result, i + 1, nums);
                swap(nums, i, j);
            }
        }
        set.clear();

    }

    /**
     * 交换数组中两个位置元素的值
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
