package solutions.No_1001_To_No_1100.No_1051_height_checker;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/height-checker/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * Example 1:
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 * Note:
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 排序对比即可
 */
public class Solution {
    public int heightChecker(int[] heights) {
        int[] rightArray = new int[heights.length];
        System.arraycopy(heights,0,rightArray,0,heights.length);
        Arrays.sort(rightArray);
        int result = 0 ;
        for(int i = 0 ; i < heights.length ; i++){
            if(heights[i]!=rightArray[i]){
                result++;
            }
        }
        return result;
    }
}
