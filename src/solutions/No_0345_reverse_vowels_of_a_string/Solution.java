package solutions.No_0345_reverse_vowels_of_a_string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 一个头指针, 一个尾指针, 向中间遍历, 两个元音则交换
 */
public class Solution {
    public String reverseVowels(String s) {
        int head = 0 ;
        int tail = s.length()-1;
        char[] chars = s.toCharArray();
        while(head < tail){
            if(!isVowel(chars[head])){
                head++;
                continue;
            }
            if(!isVowel(chars[tail])){
                tail--;
                continue;
            }
            char c = chars[head];
            chars[head++] = chars[tail];
            chars[tail--] = c;
        }
        return new String(chars);
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("leetcode"));
    }
}
