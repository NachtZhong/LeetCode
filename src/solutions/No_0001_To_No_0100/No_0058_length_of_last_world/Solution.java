package solutions.No_0001_To_No_0100.No_0058_length_of_last_world;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * Example:
 * Input: "Hello World"
 * Output: 5
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 如果s为""返回0
 * 如果s不为"",去掉头尾空格, 然后取最后一个空格字符所在的索引(如果没有则从0开始截取)截取到字符串末尾即可得到所谓的last word
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        return "".equals(s)?0:s.trim().substring(s.trim().lastIndexOf(" ")==-1?0:s.trim().lastIndexOf(" ")+1,s.trim().length()).length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("a"));
    }
}
