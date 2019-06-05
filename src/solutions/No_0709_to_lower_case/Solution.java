package solutions.No_0709_to_lower_case;

/**
 * https://leetcode.com/problems/to-lower-case/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * Example 1:
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * Input: "here"
 * Output: "here"
 * Example 3:
 * Input: "LOVELY"
 * Output: "lovely"
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 判断字符是否为大写字符(ascii值在65-90),如果是就+32变成小写字符(97-122)
 */
public class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            sb.append(c >= 65 && c <= 90 ? String.valueOf((char)(c + 32)) : String.valueOf(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().toLowerCase("Hello"));
    }
}
