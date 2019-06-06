package solutions.No_0290_word_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 将前面的首次出现的单词和字符映射关系放到两个map中, 依次检查接下来的是否符合映射关系即可
 * 比如abba和dog dog dog dog
 * 第一次记录下a => dog 和 dog => a
 * 第二次判断b <=> dog的关系是否满足已有映射关系, 如果不满足则返回false
 * 注意这道题是双向映射,也就是模式为abba的话a和b对应的单词必须不一样
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length){
            return false ;
        }
        Map<Character,String> pToWordDictMap = new HashMap<>();
        Map<String,Character> wordToPDictMap = new HashMap<>();
        for(int i = 0 ; i < pattern.length() ; i++){
            if(!pToWordDictMap.containsKey(pattern.charAt(i)) && !wordToPDictMap.containsKey(words[i])){
                pToWordDictMap.put(pattern.charAt(i),words[i]);
                wordToPDictMap.put(words[i],pattern.charAt(i));
            }
            if(pToWordDictMap.containsKey(pattern.charAt(i))){
                if(!pToWordDictMap.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
            }
            if(wordToPDictMap.containsKey(words[i])){
                if(wordToPDictMap.get(words[i]) != pattern.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
