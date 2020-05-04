package solutions.No_1301_To_No_1400.No_1304_find_n_unique_integers_sum_up_to_zero;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 判断一下n的奇偶即可
 */
public class Solution {
    public int[] sumZero(int n) {
        if(n % 2 == 0){
            int[] result = new int[n];
            for(int i  = 1 , index = 0 ; i <= n / 2 ; i ++){
                result[index++] = i;
                result[index++] = -i;
            }
            return result;
        }else{
            int[] result = new int[n];
            result[0] = 0;
            for(int i  = 1 , index = 1 ; i <= (n - 1) / 2 ; i ++){
                result[index++] = i;
                result[index++] = -i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sumZero(1)));
    }
}
