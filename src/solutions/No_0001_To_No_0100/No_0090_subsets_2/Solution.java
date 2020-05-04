package solutions.No_0001_To_No_0100.No_0090_subsets_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 和78题思路一样, 只不过要先排序(为了让元素相同的子集里面的元素保持一样的顺序,可以做去重操作), 同时在添加子集到结果集的时候要判断一下是否已经存在该子集,有的话就不加到结果集中
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(new ArrayList<>());
        Arrays.sort(nums);
        for(int num:nums){
            List<List<Integer>> tmpList = new ArrayList<>();
            tmpList.addAll(resultList);
            for(List<Integer> list : tmpList){
                List<Integer> newList = new ArrayList<>();
                newList.addAll(list);
                newList.add(num);
                if(!resultList.contains(newList)) {
                    resultList.add(newList);
                }
            }
        }
        return resultList;
    }
}