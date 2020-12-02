package solutions.No_1301_To_No_1400.No_1387_sort_integers_by_the_power_value;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/sort-integers-by-the-power-value/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * The power of an integer x is defined as the number of steps needed to transform x into 1 using the following steps:
 * <p>
 * if x is even then x = x / 2
 * if x is odd then x = 3 * x + 1
 * For example, the power of x = 3 is 7 because 3 needs 7 steps to become 1 (3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1).
 * <p>
 * Given three integers lo, hi and k. The task is to sort all integers in the interval [lo, hi] by the power value in ascending order, if two or more integers have the same power value sort them by ascending order.
 * <p>
 * Return the k-th integer in the range [lo, hi] sorted by the power value.
 * <p>
 * Notice that for any integer x (lo <= x <= hi) it is guaranteed that x will transform into 1 using these steps and that the power of x is will fit in 32 bit signed integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: lo = 12, hi = 15, k = 2
 * Output: 13
 * Explanation: The power of 12 is 9 (12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1)
 * The power of 13 is 9
 * The power of 14 is 17
 * The power of 15 is 17
 * The interval sorted by the power value [12,13,14,15]. For k = 2 answer is the second element which is 13.
 * Notice that 12 and 13 have the same power value and we sorted them in ascending order. Same for 14 and 15.
 * Example 2:
 * <p>
 * Input: lo = 1, hi = 1, k = 1
 * Output: 1
 * Example 3:
 * <p>
 * Input: lo = 7, hi = 11, k = 4
 * Output: 7
 * Explanation: The power array corresponding to the interval [7, 8, 9, 10, 11] is [16, 3, 19, 6, 14].
 * The interval sorted by power is [8, 10, 11, 7, 9].
 * The fourth number in the sorted array is 7.
 * Example 4:
 * <p>
 * Input: lo = 10, hi = 20, k = 5
 * Output: 13
 * Example 5:
 * <p>
 * Input: lo = 1, hi = 1000, k = 777
 * Output: 570
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= lo <= hi <= 1000
 * 1 <= k <= hi - lo + 1
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 不需要算出每个数要进行几次转换, 同时对每个数进行单次转换, 每次出现第一个转换成1的数时, 将k减一, 当k等于0时, 记录下当前的数, 判断他要转换几次即可
 */
public class Solution {
    public int getKth(int lo, int hi, int k) {
        int[] numList = new int[hi - lo + 1];
        for(int i = lo, index = 0; i <= hi; i++){
            numList[index ++] = i;
        }
        while(k > 0){
            /*遍历数组进行转换*/
            for(int i = 0 ; i < numList.length ; i++){
                /*如果是-1, 代表该数已经被转换成1, 不再进行转换*/
                if(numList[i] == -1){
                    continue;
                }
                /*如果发现遍历到的数字为1, 将k的个数-1, 并将该数字改为-1, 不再进行转换*/
                if(numList[i] == 1){
                    numList[i] = -1;
                    k--;
                    /*如果k=0, 说明当前遍历到的索引为i的数字就是要找的数字, 返回起始数字+i即可*/
                    if(k == 0 ){
                        return lo + i;
                    }
                }else {
                    numList[i] = doTransform(numList[i]);
                }
            }
        }
        return 0;
    }

    private int doTransform(int num){
        if (num % 2 == 0){
            /*用位操作代替除2可以稍微减少运算时间*/
            return num >> 1;
        }else{
            return num * 3 + 1;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().getKth(7,11,4));
        System.out.println(8 >> 1);
    }
}
