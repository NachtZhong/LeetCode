package solutions.No_1090_largest_values_from_labels;

import java.util.*;

/**
 * https://leetcode.com/problems/largest-values-from-labels/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * We have a set of items: the i-th item has value values[i] and label labels[i].
 * Then, we choose a subset S of these items, such that:
 * |S| <= num_wanted
 * For every label L, the number of items in S with label L is <= use_limit.
 * Return the largest possible sum of the subset S.
 * Example 1:
 * Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * Output: 9
 * Explanation: The subset chosen is the first, third, and fifth item.
 * Example 2:
 * Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * Output: 12
 * Explanation: The subset chosen is the first, second, and third item.
 * Example 3:
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 * Output: 16
 * Explanation: The subset chosen is the first and fourth item.
 * Example 4:
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 * Output: 24
 * Explanation: The subset chosen is the first, second, and fourth item.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 每个label选出use_limit个数来放到一起, 然后取最大的前num_wanted个数相加
 */
public class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer,List<Integer>> labelAndValuesMap = new HashMap<>();
        for(int i = 0 ; i < values.length ; i++){
            if(labelAndValuesMap.containsKey(labels[i])){
                labelAndValuesMap.get(labels[i]).add(values[i]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(values[i]);
                labelAndValuesMap.put(labels[i],list);
            }
        }
        List<Integer> maxValueList = new ArrayList<>();
        for(int i : labelAndValuesMap.keySet()){
            maxValueList.addAll(getMaxNValuesFromAList(labelAndValuesMap.get(i),use_limit));
        }
        Collections.sort(maxValueList);
        int result = 0 ;
        for(int i = maxValueList.size() - 1 ; i >= 0 ; i--){
            if(num_wanted == 0){
                break;
            }
            result+=maxValueList.get(i);
            num_wanted--;
        }
        return result;
    }
    private List<Integer> getMaxNValuesFromAList(List<Integer> list , int n ){
        List<Integer> resultList = new ArrayList<>();
        Collections.sort(list);
        for(int i = list.size() - 1 ; i >= 0 ; i--){
            if(n == 0){
                break;
            }
            resultList.add(list.get(i));
            n--;
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(new Solution().getMaxNValuesFromAList(list,2));
        System.out.println(new Solution().largestValsFromLabels(new int[]{5,4,3,2,1},new int[]{1,1,2,2,3},3,2));
    }
}
