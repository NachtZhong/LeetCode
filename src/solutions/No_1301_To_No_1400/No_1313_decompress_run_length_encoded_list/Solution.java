package solutions.No_1301_To_No_1400.No_1313_decompress_run_length_encoded_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/decompress-run-length-encoded-list/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 *
 * Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are a elements with value b in the decompressed list.
 *
 * Return the decompressed list.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
 * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
 * At the end the concatenation [2] + [4,4,4,4] is [2,4,4,4].
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历即可
 */
public class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0 ; i < nums.length - 1 ; i += 2){
            int nextNum = nums[i + 1];
            int count = nums[i];
            for(int j = 0 ; j < count ; j++){
                resultList.add(nextNum);
            }
        }
        int[] resultArray = new int[resultList.size()];
        for(int i = 0 ; i < resultList.size() ; i++){
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().decompressRLElist(new int[]{1,2,3,4})));
    }
}
