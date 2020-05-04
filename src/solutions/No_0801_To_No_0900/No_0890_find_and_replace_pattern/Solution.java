package solutions.No_0801_To_No_0900.No_0890_find_and_replace_pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 比较的时候, 用一个map来存储映射, 如果出现与已有映射冲突的情况即判断不符合pattern
 */
public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> resultList = new ArrayList<>();
        for(String word : words){
            Map<Character, Character> mapping = new HashMap<>();
            Map<Character, Character> mapping2 = new HashMap<>();
            boolean flag = true;
            for(int i = 0 ; i < word.length() ; i++){
                if(!mapping.containsKey(pattern.charAt(i))){
                    mapping.put(pattern.charAt(i), word.charAt(i));
                }else{
                    if(word.charAt(i) != mapping.get(pattern.charAt(i))){
                        flag = false;
                        break;
                    }
                }
                if(!mapping2.containsKey(word.charAt(i))){
                    mapping2.put(word.charAt(i), pattern.charAt(i));
                }else{
                    if(pattern.charAt(i) != mapping2.get(word.charAt(i))){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                resultList.add(word);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }
}
