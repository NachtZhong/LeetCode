package solutions.No_1301_To_No_1400.No_1342_number_of_steps_to_reduce_a_number_to_zero;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 * Example 1:
 *
 * Input: num = 14
 * Output: 6
 * Explanation:
 * Step 1) 14 is even; divide by 2 and obtain 7.
 * Step 2) 7 is odd; subtract 1 and obtain 6.
 * Step 3) 6 is even; divide by 2 and obtain 3.
 * Step 4) 3 is odd; subtract 1 and obtain 2.
 * Step 5) 2 is even; divide by 2 and obtain 1.
 * Step 6) 1 is odd; subtract 1 and obtain 0.
 * Example 2:
 *
 * Input: num = 8
 * Output: 4
 * Explanation:
 * Step 1) 8 is even; divide by 2 and obtain 4.
 * Step 2) 4 is even; divide by 2 and obtain 2.
 * Step 3) 2 is even; divide by 2 and obtain 1.
 * Step 4) 1 is odd; subtract 1 and obtain 0.
 * Example 3:
 *
 * Input: num = 123
 * Output: 12
 *
 * Constraints:
 * 0 <= num <= 10^6
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 循环
 */
public class Solution {
    public int numberOfSteps (int num) {
        int count = 0;
        while(num != 0){
            num = num % 2 == 0 ? num >> 1 : num - 1 ;
            count ++ ;
        }
        return count ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSteps(123));
    }
}
