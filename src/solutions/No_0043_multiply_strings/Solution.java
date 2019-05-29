package solutions.No_0043_multiply_strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/multiply-strings/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 将两个字符串的各位数字加权相乘,结果相加即可
 * 这个实现写的太烂,有空重写
 * 注意全程必须用数组进行处理, 不然会出现溢出
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        int[] resultArray = new int[num1.length()+num2.length()];
        for(int i = 0 ; i < num1.length();i++){
            for(int n = 0 ; n<num2.length();n++){
                int x = num1.charAt(i)-'0';
                int y = num2.charAt(n)-'0';
                int xCarry = num1.length()-i-1;
                int yCarry = num2.length()-n-1;
                int[] multiResult = singleNumMulti(x,y,xCarry,yCarry);
                resultArray = arraySum(resultArray,multiResult);
            }
        }
        String resultString = "";
        for(int i : resultArray){
            resultString+=i;
        }
        if(resultString.startsWith("0")){
            resultString = resultString.substring(1,resultString.length());
        }
        return resultString;
    }

    /**
     * 计算两个数字(包含位数信息)相乘返回的数组
     * 例如个位9和个位9,入参为9,9,0,0,结果为[8,1]
     * 十位9和十位9,入参为9,9,1,1,结果为[8,1,0,0]
     * @param x
     * @param y
     * @param xCarry
     * @param yCarry
     * @return
     */
    public int[] singleNumMulti(int x , int y , int xCarry , int yCarry){
        int resultArrayLength = x * y >= 10 ? 2 + xCarry + yCarry : 1 + xCarry + yCarry ;
        int[] resultArray = new int[resultArrayLength];
        for(int i = 0 ; i < resultArrayLength ; i++){
            resultArray[i] = 0;
        }
        if(x * y < 10){
            resultArray[0] = x * y;
        }else {
            resultArray[0] = x * y / 10;
            resultArray[1] = x * y % 10;
        }
        return resultArray ;
    }

    /**
     * 计算两个以数组形式表示的数之和,结果以数组形式返回
     * @param x
     * @param y
     * @return
     */
    public int[] arraySum(int[] x,int[] y){
        //补一下0
        if(x.length>y.length){
            int[] yFillWithZero = fillWithZero( y , x.length);
            return arraySum(x,yFillWithZero);
        }
        if (x.length<y.length){
            int[] xFillWithZero = fillWithZero( x , y.length);
            return arraySum(y,xFillWithZero);
        }
        int length = x.length;
        int[] resultArray = new int[length+1];
        int carry = 0 ;
        for(int i = 1 ; i <= length ; i++){
            int sum = x[length-i]+y[length-i]+carry;
            resultArray[length+1-i] = sum >= 10? sum%10:sum;
            carry = sum>=10?1:0;
        }
        if(carry == 1){
            resultArray[0] = 1;
        }else{
            resultArray = Arrays.copyOfRange(resultArray,1,resultArray.length);
        }
        return  resultArray;
    }

    /**
     * 补0
     * 例如输入[1,2,3]和5,返回[0,0,1,2,3]
     * 该函数只为了方便计算
     * @param array
     * @param targetLength
     * @return
     */
    private int[] fillWithZero(int[] array , int targetLength) {
        int[] resultArray = new int[targetLength];
        for(int i = 1 ; i<=array.length ; i++){
            resultArray[resultArray.length-i] = array[array.length-i];
        }
        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println( new Solution().multiply("123","100"));

    }
}
