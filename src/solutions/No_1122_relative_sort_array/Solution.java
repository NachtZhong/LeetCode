package solutions.No_1122_relative_sort_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/relative-sort-array/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * Constraints:
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 先用一个map把arr1中所有的数和它们的个数统计出来, 再遍历arr2, 根据map中的个数填入arr1中, 再遍历剩下的数字, 排序填入arr1中即可
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int a : arr1){
            countMap.put(a,countMap.containsKey(a)?countMap.get(a)+1:1);
        }
        int currentIndex = 0 ;
        for(int a : arr2){
            int count = countMap.get(a);
            for(int i = 0 ; i < count ; i++){
                arr1[currentIndex++] = a;
            }
            countMap.remove(a);
        }
        int[] arr3 = new int[countMap.size()];
        int i = 0 ;
        for(int a : countMap.keySet()){
            arr3[i++] = a;
        }
        Arrays.sort(arr3);
        for(int a : arr3){
            int count = countMap.get(a);
            for(int j = 0 ; j < count ; j++){
                arr1[currentIndex++] = a;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6})));
    }
}
