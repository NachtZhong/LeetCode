package solutions.No_0201_To_No_0300.No_0202_happy_number;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * Example:
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 12 + 0^2 + 0^2 = 1
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 循环+暴力
 * 如果结果为1跳出循环返回true
 * 如果出现相同结果证明会出现无限循环 返回false
 */
public class Solution {
    public boolean isHappy(int n) {
       Set set = new HashSet();
       while(n!=1){
           int num = n ;
           n = 0;
           while(num > 0){
               int tmp = num % 10 ;
               n += tmp * tmp ;
               num = num/10;
           }
           if(set.contains(n)){
               return false ;
           }else{
               System.out.println(n);
               set.add(n);
           }
       }
       return true;
    }

    public static void main(String[] args) {
        new Solution().isHappy(18);
    }

}
