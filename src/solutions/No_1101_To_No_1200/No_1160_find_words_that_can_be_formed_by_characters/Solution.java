package solutions.No_1101_To_No_1200.No_1160_find_words_that_can_be_formed_by_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 *
 * Note:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * All strings contain lowercase English letters only.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 先用一个map把chars装起来, key为char, value为个数
 * 然后对每个word做判断, 如果满足的加到结果里
 */
public class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0 ;
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c : chars.toCharArray()){
            charMap.put(c , charMap.containsKey(c)?charMap.get(c)+1:1);
        }
        for(String word : words){
            Map<Character, Integer> wordCharMap = new HashMap<>();
            for(char c : word.toCharArray()){
                wordCharMap.put(c , wordCharMap.containsKey(c)?wordCharMap.get(c)+1:1);
            }
            boolean flag = true ;
            for(char c : wordCharMap.keySet()){
                if(!charMap.containsKey(c) || charMap.get(c) < wordCharMap.get(c)){
                    flag = false ;
                    break ;
                }
            }
            if(flag){
                result += word.length();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"cat","bt","hat","tree"};
        String  chars = "atach";
        System.out.println(new Solution().countCharacters(words,chars));
    }
}
