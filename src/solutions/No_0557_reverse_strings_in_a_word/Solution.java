package solutions.No_0557_reverse_strings_in_a_word;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 拆分成一个个单词reverse然后拼接即可
 */
public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        String result = "";
        for(String str : strs){
            result += new StringBuilder(str).reverse().toString() + " ";
        }
        return result.trim() ;
    }
}
