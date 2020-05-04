package solutions.No_1301_To_No_1400.No_1394_find_lucky_integer_in_an_array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
 *
 * Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,2,3,4]
 * Output: 2
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 * Example 2:
 *
 * Input: arr = [1,2,2,3,3,3]
 * Output: 3
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
 * Example 3:
 *
 * Input: arr = [2,2,2,3,3]
 * Output: -1
 * Explanation: There are no lucky numbers in the array.
 * Example 4:
 *
 * Input: arr = [5]
 * Output: -1
 * Example 5:
 *
 * Input: arr = [7,7,7,7,7,7,7]
 * Output: 7
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用map记录每个数字出现的个数, 然后获取满足个数和数字相等条件的数字中最大的一个即可
 */
public class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for(int num : arr){
            numCountMap.putIfAbsent(num, 0);
            numCountMap.put(num,numCountMap.get(num)+1);
        }
        return numCountMap.keySet().stream().filter(key -> numCountMap.get(key).equals(key)).min((x, y) -> -x.compareTo(y)).orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLucky(new int[]{1,2,2,3,3,3}));
    }
}
