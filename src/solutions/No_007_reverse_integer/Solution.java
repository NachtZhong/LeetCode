package solutions.No_007_reverse_integer;

/**
 * https://leetcode.com/problems/reverse-integer/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output: 321
 * Example 2:
 * Input: -123
 * Output: -321
 * Example 3:
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 将数字拆分到数组中, 反向遍历数组计算出reverse之后的值即可
 * 因为入参x的类型为int,不可能为7463847412,所以如果结果为2147483647可判断发生了溢出,返回0
 */
public class Solution {
    public int reverse(int x) {
        String xAbsString = String.valueOf(x).replace("-","");
        int result = 0 ;
        int[] xArray = new int[xAbsString.length()];
        for(int i = 0 ; i < xAbsString.length() ; i++){
            xArray[i] = Integer.valueOf(String.valueOf(xAbsString.charAt(i)));
        }
        for(int i = xArray.length-1 ; i >= 0 ; i--){
            result += xArray[i] * Math.pow(10,i);
        }
        if(x > 0){
            return result == 2147483647 ? 0:result;
        }else{
            return result == 2147483647 ? 0:-result;
        }
    }

}
