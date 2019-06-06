package solutions.No_0917_reverse_only_letters;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 * Example 1:
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * Note:
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 两边到中间,跳过非字母字符做交换即可
 */
public class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left < right){
            if(!isLetter(chars[left])){
                left ++ ;
                continue ;
            }
            if(!isLetter(chars[right])){
                right -- ;
                continue ;
            }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp ;
            left ++ ;
            right -- ;
        }
        return String.valueOf(chars);
    }
    public boolean isLetter(char c){
        return (c >= 65 && c <= 90)||(c >= 97 && c <= 122);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
