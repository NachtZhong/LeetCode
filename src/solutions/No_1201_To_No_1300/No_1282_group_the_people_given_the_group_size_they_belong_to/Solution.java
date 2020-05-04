package solutions.No_1201_To_No_1300.No_1282_group_the_people_given_the_group_size_they_belong_to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group. Given the array groupSizes of length n telling the group size each person belongs to, return the groups there are and the people's IDs each group includes.
 *
 * You can return any solution in any order and the same applies for IDs. Also, it is guaranteed that there exists at least one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: groupSizes = [3,3,3,3,3,1,3]
 * Output: [[5],[0,1,2],[3,4,6]]
 * Explanation:
 * Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
 * Example 2:
 *
 * Input: groupSizes = [2,1,3,3,3,2]
 * Output: [[1],[0,5],[2,3,4]]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用一个hashmap作为临时存储, 将相同分组的数字放在同一组, 如果该组满了, 加到返回结果list
 */
public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, List<Integer>> tempMap = new HashMap<>();
        for(int i = 0 ; i < groupSizes.length ; i++){
            int groupSize = groupSizes[i];
            if(!tempMap.containsKey(groupSize)){
                tempMap.put(groupSize, new ArrayList<>());
            }
            tempMap.get(groupSize).add(i);
            if(tempMap.get(groupSize).size() == groupSize){
                resultList.add(tempMap.get(groupSize));
                tempMap.remove(groupSize);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().groupThePeople(new int[]{2,1,3,3,3,2}));
    }
}
