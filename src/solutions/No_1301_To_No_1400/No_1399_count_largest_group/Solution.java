package solutions.No_1301_To_No_1400.No_1399_count_largest_group;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/count-largest-group/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.
 *
 * Return how many groups have the largest size.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 13
 * Output: 4
 * Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
 * Example 2:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are 2 groups [1], [2] of size 1.
 * Example 3:
 *
 * Input: n = 15
 * Output: 6
 * Example 4:
 *
 * Input: n = 24
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^4
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用map做临时存储, key为数字之和的值,例如11->key为2, 12->key为3 value为数字之和为key的数字的值
 */
public class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, AtomicInteger> map = new HashMap<>();
        for(int i = 1 ; i <= n ; i++){
            int count = 0;
            for(char c : String.valueOf(i).toCharArray()){
                count += c - '0';
            }
            map.computeIfAbsent(count, key -> new AtomicInteger()).incrementAndGet();
        }
        Map<Integer, List<AtomicInteger>> groupMap = map.values()
                .stream()
                .collect(Collectors.groupingBy(AtomicInteger :: get));
        int max = 0 ;
        for(int i : groupMap.keySet()){
            max = Math.max(max, i);
        }
        return groupMap.get(max).size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countLargestGroup(13));
    }
}
