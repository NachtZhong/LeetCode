package solutions.No_0401_To_No_0500.No_0409_longest_palindrome;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/longest-palindrome/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 将所有字母进行数量统计, 先将所有的双数数量加到结果, 然后看是否还剩下单数, 如果剩下则+1(该字母放中间), 如果没有直接返回
 */
public class Solution {
    public int longestPalindrome(String s) {
        if(s.length() == 0){
            return 0;
        }
        AtomicInteger result = new AtomicInteger();
        AtomicBoolean hasBeenAdd = new AtomicBoolean(false);
        Map<Character, Integer> judgeMap = new HashMap<>();
        for(char c : s.toCharArray()){
            judgeMap.putIfAbsent(c, 0);
            judgeMap.put(c, judgeMap.get(c) + 1);
        }
        judgeMap.forEach((key, value) -> {
            if(value % 2 == 0){
                result.addAndGet(value);
            }else{
                result.addAndGet(value - 1);
                if(!hasBeenAdd.get()){
                    result.addAndGet(1);
                    hasBeenAdd.set(true);
                }
            }
        });
        return result.get();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abccccdd"));
    }
}
