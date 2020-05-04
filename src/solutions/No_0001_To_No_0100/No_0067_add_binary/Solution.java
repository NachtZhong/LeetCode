package solutions.No_0001_To_No_0100.No_0067_add_binary;

/**
 * https://leetcode.com/problems/add-binary/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 二进制加法,不多bb
 */
public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0 ;
        String result = "";
        for(int i = 0 ; i < Math.max(a.length(),b.length()) ; i++){
            int aNum = i >= a.length() ? 0 : a.charAt(a.length()-1-i)-'0';
            int bNum = i >= b.length() ? 0 : b.charAt(b.length()-1-i)-'0';
            result = (aNum + bNum + carry) % 2  + result;
            carry = (aNum + bNum + carry) >= 2 ? 1 : 0;
        }
        if (carry == 1){
            result = "1" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1010","1011"));
    }
}
