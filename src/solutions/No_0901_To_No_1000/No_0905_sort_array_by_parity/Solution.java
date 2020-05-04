package solutions.No_0901_To_No_1000.No_0905_sort_array_by_parity;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 自定义一个排序器
 */
public class Solution {
    public int[] sortArrayByParity(int[] A) {
        Integer[] a = new Integer[A.length];
        for(int i = 0 ; i < A.length ; i++){
            a[i] = A[i];
        }
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1%2-o2%2;
            }
        });
        for(int i = 0 ; i < A.length ; i++){
            A[i] = a[i];
        }
        return A;
    }
}
