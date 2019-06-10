package solutions.No_0541_reverse_string_2;

/**
 * https://leetcode.com/problems/reverse-string-ii/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 直接思路,没思路
 */
public class Solution {
    public String reverseStr(String s, int k) {
        if(k == 1 ){
            return s ;
        }
        String resultString = "";
        int currentIndex = 0 ;
        while(currentIndex + 2*k  < s.length()){
            resultString += reverseFirstKCharacter(s.substring(currentIndex,currentIndex + 2*k),k);
            currentIndex += 2*k ;
        }
        if(s.length() - currentIndex <= k) {
            resultString += new StringBuilder(s.substring(currentIndex, s.length())).reverse().toString();
        }else{
            resultString += reverseFirstKCharacter(s.substring(currentIndex, currentIndex+k),k) + s.substring(currentIndex + k , s.length());
        }
        return resultString;
    }

    private String reverseFirstKCharacter(String substring , int k) {
        return new StringBuilder(substring.substring(0,k)).reverse().append(substring.substring(k,substring.length())).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg",2));
    }
}
