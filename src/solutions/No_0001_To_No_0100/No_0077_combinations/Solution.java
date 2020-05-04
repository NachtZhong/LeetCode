package solutions.No_0001_To_No_0100.No_0077_combinations;

import java.util.ArrayList;
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
 * 解题思路:
 * 和78题思路一样, 只不过不用处理元素个数大于k的子集
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());
        for(int i = 1 ; i <= n ; i++){
            List<List<Integer>> tmpList = new ArrayList<>();
            tmpList.addAll(resultList);
            for(List<Integer> list : tmpList){
                if(list.size()<k){
                    List<Integer> newList = new ArrayList<>();
                    newList.addAll(list);
                    newList.add(i);
                    resultList.add(newList);
                }
            }
        }
        resultList.removeIf(new Predicate<List<Integer>>() {
            @Override
            public boolean test(List<Integer> integers) {
                return integers.size()!=k;
            }
        });
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4,2));
    }
}
