package solutions.No_1501_To_No_1600.No_1512_number_of_good_pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array of integers nums.
 *
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 *
 * Return the number of good pairs.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 0
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 自己体会
 */
public class Solution {
    public int numIdenticalPairs(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Integer::intValue)).values().stream().mapToInt(integers -> (integers.size() - 1) * integers.size() / 2).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numIdenticalPairs(new int[]{1,2,3}));
    }
}
