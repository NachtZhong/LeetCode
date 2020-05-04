package solutions.No_1101_To_No_1200.No_1200_minimum_absolute_difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-absolute-difference/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * Example 2:
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * Example 3:
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 先排序, 然后遍历依次找出最小差值
 * 再遍历一次, 将相差为最小差值的数加入list中
 */
public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(arr);
        int minimumAbsValue = Integer.MAX_VALUE ;
        for(int i = 0 ; i < arr.length - 1 ; i++){
            if(arr[i+1] - arr[i] < minimumAbsValue){
                minimumAbsValue = arr[i+1] - arr[i];
            }
        }
        for(int i = 0 ; i < arr.length - 1 ; i++){
            if(arr[i+1] - arr[i] == minimumAbsValue){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                resultList.add(list);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,8,-10,23,19,-4,-14,27};
        System.out.println(new Solution().minimumAbsDifference(arr));
    }
}
