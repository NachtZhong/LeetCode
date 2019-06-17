package solutions.No_0167_two_sum_2;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 由于是已经排好序的数组, 从两边向中间检索
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] resultArray = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                break;
            }
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        resultArray[0] = left + 1;
        resultArray[1] = right + 1;
        return resultArray;
    }
}
