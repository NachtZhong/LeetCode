package solutions.No_1201_To_No_1300.No_1299_replace_elements_with_greatest_element_on_right_side;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * After doing so, return the array.
 * Example 1:
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 对每个数找出后面的最大值即可
 */
public class Solution {
    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length - 1; i++){
            int max = 1 ;
            for(int j = i + 1 ; j < arr.length; j++){
                max = Math.max(max, arr[j]);
            }
            result[i] = max;
        }
        result[arr.length - 1] = -1;
        return result;
    }
}
