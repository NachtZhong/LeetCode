package solutions.No_0801_To_No_0900.No_0888_fair_candy_exchange;

/**
 * https://leetcode.com/problems/fair-candy-swap/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 *
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 *
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 *
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 *
 * Example 1:
 *
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * Example 2:
 *
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * Example 3:
 *
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 * Example 4:
 *
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 先算出总和,然后找出两个数组中差为差值的两个元素即可
 */
public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0 ;
        int sumB = 0;
        for(int num:A){
            sumA += num;
        }
        for(int num: B){
            sumB += num;
        }
        int evenCount = (sumA+sumB)/2;
        //交换后和原来相差的值
        int swapCount = sumA - evenCount;
        int[] result = new int[2];
        for(int numA : A){
            for(int numB:B){
                if(numA-numB == swapCount){
                    result[0] = numA;
                    result[1] = numB;
                    break;
                }
            }
        }
        return result;
    }
}
