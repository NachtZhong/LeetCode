package solutions.No_0001_To_No_0100.No_0003_longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author Nacht
 * Created on 2019/5/22
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用两个脑残的for循环遍历各个子字符串,将子字符串的各个字符放到set中,利用set的不可重复特性检测字符串中是否有重复字符
 * 这是一个效率极其低下的菜鸟算法,不要轻易模仿
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //如果为空字符串直接返回0
        if ("".equals(s)){
            return 0;
        }
        int maxLength = 1 ;
        for(int i = 0 ; i < s.length()-1 ; i++){
            for(int end = i + maxLength ; end < s.length()+1 ; end++){
                String subString = s.substring(i,end);
                int subLength = subString.length();
                char[] chars = subString.toCharArray();
                Set set = new HashSet();
                for (char c : chars){
                    set.add(c);
                }
                if(subLength > set.size()){
                    break;
                }
                if(subLength > maxLength){
                    maxLength = subLength;
                }
            }
        }
        return maxLength ;
    }

}
