package solutions.No_0201_To_No_0300.No_0205_isomorphic_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用一个map记录s中每个字母到t的关系, 同时用一个set记录是否有两个字母映射到了同一个字母, 如果有重复/不对应的映射, 返回false
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> transformMap = new HashMap<>();
        Set<Character> usedCharacterSet = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            if(!transformMap.containsKey(sChar)){
                if(usedCharacterSet.contains(tChar)){
                    return false ;
                }
                transformMap.put(sChar, tChar);
                usedCharacterSet.add(tChar);
            }else{
                if(!transformMap.get(sChar).equals(tChar)){
                    return false;
                }
            }
        }
        return true ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("abb","cdd"));
    }
}
