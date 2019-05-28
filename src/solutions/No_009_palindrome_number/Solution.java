package solutions.No_009_palindrome_number;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Example 1:
 * Input: 121
 * Output: true
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Coud you solve it without converting the integer to a string?
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 本想转String,题目要求不能转,那么算一下调转之后的值对比即可
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false ;
        }
        int reverseNum = 0 ;
        int num = x ;
        while(num > 0){
            reverseNum = num%10 + reverseNum*10;
            num /= 10 ;
        }
        if(reverseNum == x){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(12321));
    }
}
