package solutions.No_0383_ransom_note;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 两个字符串拆分放到两个map中,key为字符,value为字符个数
 * 如果magazine的map中某个字符的数少于ransomNote的map中的数量则返回false
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> ransomNoteMap = new HashMap<>();
        Map<Character,Integer> magazineMap = new HashMap<>();
        for(char c : ransomNote.toCharArray()){
            if(ransomNoteMap.containsKey(c)){
                ransomNoteMap.put(c,ransomNoteMap.get(c)+1);
            }else{
                ransomNoteMap.put(c,1);
            }
        }
        for(char c : magazine.toCharArray()){
            if(magazineMap.containsKey(c)){
                magazineMap.put(c,magazineMap.get(c)+1);
            }else{
                magazineMap.put(c,1);
            }
        }
        for(char c : ransomNote.toCharArray()){
            if(magazineMap.get(c)==null||magazineMap.get(c)<ransomNoteMap.get(c)){
                return false;
            }
        }
        return true;
    }
}
