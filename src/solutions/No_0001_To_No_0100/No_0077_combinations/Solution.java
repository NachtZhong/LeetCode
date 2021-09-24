package solutions.No_0001_To_No_0100.No_0077_combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * https://leetcode.com/problems/combinations/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Example:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 在n个数中选k个数, 求所有的排列组合
 * 解题思路:
 * 回溯法, 比如1,2,3选两个数, 第一个选1, 组合2/3, 第二个选2, 就只能从2后面的开始选了, 不能再选1, 关键是思路要清晰
 */
public class Solution {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        /*从第一个位置开始, 从1-n范围中, 选k个数*/
        dfs(resultList, new ArrayList<Integer>(), 1, n, k);
        return resultList;
    }

    /**
     * 从n的第i个位置开始, 选k个数
     * @param resultList
     * @param integers
     * @param i
     * @param n
     * @param k
     */
    private void dfs(List<List<Integer>> resultList, ArrayList<Integer> integers, int i, int n, int k) {
        if(integers.size() == k){
            List<Integer> list = new ArrayList<>();
            list.addAll(integers);
            resultList.add(list);
            return;
        }
        /*剩下的数满足个数要求时才继续处理, 剪枝*/
        if(n - i + 1 + integers.size() < k){
            return;
        }
        for(int j = i ; j <= n ; j++){
            integers.add(j);
            /*选了一个数之后, 下一个数只能从j + 1开始选*/
            dfs(resultList, integers, j + 1, n, k);
            /*回退一位, 让上一个分支可以基于原来的结果继续处理下一位*/
            integers.remove(integers.size() - 1);

        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4,2));
    }
}
