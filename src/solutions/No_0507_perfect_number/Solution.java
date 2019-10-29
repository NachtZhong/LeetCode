package solutions.No_0507_perfect_number;

/**
 * https://leetcode.com/problems/perfect-number/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 检查除数即可
 * 记得检查从2开始检查到num的开方数即可,大于开方数的约数用num/较小的约数就可以得到
 * 不要傻逼的一个个查
 */
public class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <= 2){
            return false ;
        }
        int sum = 1 ;
        for(int divideNum = 2 ; divideNum * divideNum < num ; divideNum++){
            if(num % divideNum == 0 ){
                sum += divideNum + num/divideNum ;
            }
        }
        return sum == num;
    }
}
