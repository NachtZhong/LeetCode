package solutions.No_0801_To_No_0900.No_0884_uncommon_words_from_two_sentences;

import java.util.*;

/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用map做对比即可
 */
public class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> mapA = new HashMap<>();
        Map<String,Integer> mapB = new HashMap<>();
        List<String> uncommonWordList = new ArrayList<>();
        for(String s : A.split(" ")){
            mapA.put(s,mapA.containsKey(s)?mapA.get(s)+1:1);
        }
        for(String s : B.split(" ")){
            mapB.put(s,mapB.containsKey(s)?mapB.get(s)+1:1);
        }
        for(String s : mapA.keySet()){
            if(mapA.get(s) == 1 && !mapB.containsKey(s)){
                uncommonWordList.add(s);
            }
        }
        for(String s : mapB.keySet()){
            if(mapB.get(s) == 1 && !mapA.containsKey(s)){
                uncommonWordList.add(s);
            }
        }
        String[] strs = new String[uncommonWordList.size()];
        int i = 0;
        for(String s : uncommonWordList){
            strs[i++] = s;
        }
        return strs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().uncommonFromSentences("apple apple","banana")));
    }
}
