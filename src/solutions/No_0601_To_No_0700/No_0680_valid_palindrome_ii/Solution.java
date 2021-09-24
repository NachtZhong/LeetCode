package solutions.No_0601_To_No_0700.No_0680_valid_palindrome_ii;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 判断一个字符串是否能满足在最多删除一个字符的前提下成为一个回文字符串
 * 解题思路:
 * 双指针, 从右到左遍历, 碰到不同的, 尝试删除左边/右边指针所在的字符, 如果有一个可以使得剩下中间的字符串是回文字符串, 就满足条件, 如果两个都不行, 就不满足条件
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("abca"));
    }

    public boolean validPalindrome(String s) {
        /*处理边界条件*/
        if(s.length() <= 2){
            return true;
        }
        int left = 0, right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) == s.charAt(right)){
                left ++;
                right --;
            }else{
                return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    /**
     * 判断字符串中某个位置的子串是否为回文字符串
     * @param s
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindrome(String s, int left, int right) {
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
