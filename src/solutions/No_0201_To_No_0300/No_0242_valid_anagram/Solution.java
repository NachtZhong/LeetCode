package solutions.No_0201_To_No_0300.No_0242_valid_anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/valid-anagram/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用一个map存储各个char和个数的映射, 在s中时, 计数加1, 在t中时, 计数-1, 最后判断是否map中的各个key的值都为0即可
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character, AtomicInteger> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            map.computeIfAbsent(s.charAt(i), key -> new AtomicInteger()).incrementAndGet();
            map.computeIfAbsent(t.charAt(i), key -> new AtomicInteger()).decrementAndGet();
        }
        return map.keySet().stream().allMatch(key -> map.get(key).get() == 0);
    }
}
