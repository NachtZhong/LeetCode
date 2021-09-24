package solutions.No_0501_To_No_0600.No_0524_longest_word;

import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 * Example 1:
 * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * Output: "apple"
 * Example 2:
 * Input: s = "abpcplea", dictionary = ["a","b","c"]
 * Output: "a"
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 左边的字符串去掉n个字符, 可以变为右边字典数组里面的某个词, 取右边字典里面的某个字符串, 使得n最小, 如果n相等, 取字符串最小(指的是字符串比较的顺序, 比如abc<abe), 如果没有, 返回空字符串
 * 解题思路:
 * 双指针, 左边一个指针, 右边一个指针, 一个词一个词进行匹配, 并记录最满足条件的一个词
 * 决定自信一点, 不测了, 一次AC!!!
 */
public class Solution {

    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for(int i = 0; i < dictionary.size(); i++){
            String word = dictionary.get(i);
            /*如果s长度比字符串长度还短, 直接跳过*/
            if(s.length() < word.length()){
                continue;
            }
            int left = 0, right = 0;
            while(left < s.length() && right < word.length()){
                /*如果字符不同, 只移动左边指针, 如果字符相同, 移动两边指针*/
                if(s.charAt(left) == word.charAt(right)){
                    right++;
                }
                left++;
            }
            /*如果遍历完右边指针没走到尽头, 说明左边不能通过移除n个字母使之和右边一样, 走到了尽头说明可以*/
            if(right == word.length()){
                /*只有长度比原来的长才比原来的结果优, 如果相等则按字符串比较的方式进行比较, 取较小的一个*/
                if(word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)){
                    result = word;
                }
            }
        }
        return result;
    }
}
