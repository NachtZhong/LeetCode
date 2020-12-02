package solutions.No_1301_To_No_1400.No_1347_make_two_strings_anagram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 *
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * Example 3:
 *
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 * Example 4:
 *
 * Input: s = "xxyyzz", t = "xxyyzz"
 * Output: 0
 * Example 5:
 *
 * Input: s = "friend", t = "family"
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s and t contain lower-case English letters only.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用map存储两个字符串的字符, 字符 -> 个数, 相同的进行抵消, 将该字符的value减一, 最终map里面存储的是两个字符传中有差异的字符以及它们的个数
 * 最后把所有的值加起来/2即可
 */
public class Solution {
    public int minSteps(String s, String t) {
        Map<Character, AtomicInteger> charMap = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char sI = s.charAt(i);
            char tI = t.charAt(i);
            charMap.computeIfAbsent(sI, key -> new AtomicInteger()).incrementAndGet();
            charMap.computeIfAbsent(tI, key -> new AtomicInteger()).decrementAndGet();
        }
        int count = 0;
        for(AtomicInteger c : charMap.values()){
            count += Math.abs(c.get());
        }
        return count/2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSteps("friend","family"));
    }
}
