package solutions.No_0066_plus_one;

/**
 * https://leetcode.com/problems/plus-one/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 水题一道,小心进位情况即可
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1 ;
        for(int i = digits.length-1 ; i >= 0 ; i-- ){
            digits[i] = (digits[i] + carry) % 10;
            carry = digits[i] == 0 ? 1 : 0;
            if(carry == 0){
                break;
            }
        }
        if(carry == 1){
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            for(int i = 0 ; i < digits.length ; i++){
                newDigits[i+1] = digits[i];
            }
            return newDigits;
        }else{
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] a = new Solution().plusOne(new int[]{9,9,9});
        for (int num:a){
            System.out.print(num+" ");
        }
    }
}