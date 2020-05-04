package solutions.No_0501_To_No_0600.No_0537_complex_number_multipication;

/**
 * https://leetcode.com/problems/complex-number-multiplication/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two strings representing two complex numbers.
 *
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 *
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 *
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 分开计算即可
 */
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int aNumPart = Integer.parseInt(a.split("\\+")[0]);
        int aIPart = Integer.parseInt(a.split("\\+")[1].replace("i",""));
        int bNumPart = Integer.parseInt(b.split("\\+")[0]);
        int bIPart = Integer.parseInt(b.split("\\+")[1].replace("i",""));
        String resultNumPart = String.valueOf(aNumPart * bNumPart + (-1) * aIPart * bIPart);
        String resultIPart = String.valueOf(aNumPart * bIPart + aIPart * bNumPart);
        return resultNumPart + "+" + resultIPart + "i";
    }
    public static void main(String[] args) {
        System.out.println(new Solution().complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
