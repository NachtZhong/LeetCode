package solutions.No_1301_To_No_1400.No_1365_how_many_numbers_are_smaller_than_the_current_number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * How Many Numbers Are Smaller Than the Current Number
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 * Example 2:
 *
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 * Example 3:
 *
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 将数组排序, 根据某个数字在排序后的list中的第一个下标即可获取小于某个数字的数字个数
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        return Arrays.stream(nums).boxed().map(num -> Arrays.stream(nums).sorted().boxed().collect(Collectors.toList()).indexOf(num)).mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().smallerNumbersThanCurrent(new int[]{6,5,4,8})));
    }
}
