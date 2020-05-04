package solutions.No_1301_To_No_1400.No_1389_create_target_array_in_the_given_order;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 *
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 *
 * It is guaranteed that the insertion operations will be valid.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * Example 2:
 *
 * Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * Output: [0,1,2,3,4]
 * Explanation:
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 * Example 3:
 *
 * Input: nums = [1], index = [0]
 * Output: [1]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 新建一个数组填数字即可, 没啥技术含量
 */
public class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] result = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            result[i] = -1;
        }
        for(int i = 0 ; i < nums.length ; i++){
            int idx = index[i];
            int num = nums[i];
            if(result[idx] == -1){
                result[idx] = num;
            }else{
                System.arraycopy(result, idx, result, idx + 1, nums.length - idx -1);
                result[idx] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().createTargetArray(new int[]{0,1,2,3,4},new int[]{0,1,2,2,1})));
    }
}
