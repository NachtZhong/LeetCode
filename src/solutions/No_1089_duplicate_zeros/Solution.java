package solutions.No_1089_duplicate_zeros;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/duplicate-zeros/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place, do not return anything from your function.
 * Example 1:
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 * Note:
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历后移即可
 */
public class Solution {
    public void duplicateZeros(int[] arr) {
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0){
                int tmp = arr[i];
                for(int j = i+1 ; j < arr.length ; j++){
                    int fuck = arr[j];
                    arr[j] = tmp;
                    tmp = fuck;
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        new Solution().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
