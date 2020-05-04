package solutions.No_1201_To_No_1300.No_1295_find_numbers_with_even_number_of_digits;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array nums of integers, return how many of them contain an even number of digits.
 *
 *
 * Example 1:
 *
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * Example 2:
 *
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历即可
 */
public class Solution {
    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums).mapToObj(i -> i).map(i -> String.valueOf(i)).filter(s -> s.length() % 2 == 0).count();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNumbers(new int[]{555,901,482,1771}));
    }
}
