package solutions.No_0961_n_repeat_element_in_2n_array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * Return the element repeated N times.
 * Example 1:
 * Input: [1,2,3,3]
 * Output: 3
 * Example 2:
 * Input: [2,1,2,5,3,2]
 * Output: 2
 * Example 3:
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 * Note:
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length is even
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用set做,水题不解释
 */
public class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int num:A){
            if(set.contains(num)){
                return num;
            }else{
                set.add(num);
            }
        }
        return 0;
    }
}
