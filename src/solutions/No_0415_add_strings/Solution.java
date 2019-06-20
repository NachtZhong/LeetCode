package solutions.No_0415_add_strings;

/**
 * https://leetcode.com/problems/add-strings/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 从后向前,取每一个数字相加即可
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        String result = "";
        int carry = 0 ;
        int length1 = num1.length();
        int length2 = num2.length();
        int loopCount = Math.max(length1,length2);
        for(int i = 1 ; i <= loopCount ; i++){
            int num1Char = length1 - i >= 0 ? num1.charAt(length1 - i) - '0' : 0;
            int num2Char = length2 - i >= 0 ? num2.charAt(length2 - i) - '0' : 0;
            int sumChar = num1Char + num2Char + carry >= 10 ? (num1Char + num2Char + carry) % 10 : num1Char + num2Char + carry;
            result = sumChar + result;
            carry = num1Char + num2Char + carry >= 10 ? 1 : 0;
        }
        return carry == 1? "1" + result : result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("999","1"));
    }
}
