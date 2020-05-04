package solutions.No_0801_To_No_0900.No_0896_monotonic_array;

/**
 * https://leetcode.com/problems/monotonic-array/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 * Example 1:
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 * Input: [1,1,1]
 * Output: true
 * Note:
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历数组, 如果出现了A[i+1]>A[i]的情况, 将isDcreasingArray(降序数组)标志位设为false
 * 如果出现A[i+1]<A[i]的情况, 将isIncreasingArray(升序数组)标志位设为false
 * 返回isIncreasingArray || isDcreasingArray即可
 */
public class Solution {
    public boolean isMonotonic(int[] A) {
        boolean isIncreasingArray = true ;
        boolean isDcreasingArray = true ;
        for(int i = 0 ; i < A.length -1 ; i++){
            if(A[i+1]>A[i]){
                isDcreasingArray = false;
            }
            if(A[i+1]<A[i]){
                isIncreasingArray = false;
            }
        }
        return isIncreasingArray || isDcreasingArray;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMonotonic(new int[]{1,3,2}));
    }
}
