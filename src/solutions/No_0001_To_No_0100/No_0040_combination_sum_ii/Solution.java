package solutions.No_0001_To_No_0100.No_0040_combination_sum_ii;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * <p>
 * 解题思路:
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /*把糖果从小到大排序*/
        Arrays.sort(candidates);
        /*筛选出小于等于target的值*/
        List<Integer> candyList = Arrays.stream(candidates).filter(i -> i <= target).boxed().collect(Collectors.toList());
        /*结果集*/
        List<List<Integer>> result = new ArrayList<>();
        /*dfs遍历, 找到符合条件的组合*/
        List<Integer> path = new ArrayList<>();
        dfs(result, candyList, 0, path, target, 0);
        return result;
    }

    /**
     * 从candyList的第i个元素开始, 挑最多level-path.size()个数字, 使得path中的数字之和sum等于target, 符合条件的添加到result中
     * @param result
     * @param candyList
     * @param i
     * @param path
     * @param target
     * @param sum
     */
    private void dfs(List<List<Integer>> result, List<Integer> candyList, int i, List<Integer> path, int target, int sum) {
        /*如果sum和target相同, 说明当前path里面的数字符合要求, 添加到结果集, 同时返回, 因为sum大于target, 继续遍历下去sum必定大于target, 不符合要求*/
        if(sum >= target){
            if(sum == target){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        /*到了边界, 不用继续处理了, 返回*/
        if (i == candyList.size()) {
            return;
        }
        for(int j = i; j < candyList.size(); j++) {
            /*如果sum小于target, 继续遍历*/
            path.add(candyList.get(j));
            sum += candyList.get(j);
            dfs(result, candyList, j + 1, path, target, sum);
            /*回溯*/
            path.remove(path.size() - 1);
            sum -= candyList.get(j);
            while (j + 1 < candyList.size() && candyList.get(j) == candyList.get(j + 1)){
                j++;
            }
        }
    }
}
