package solutions.No_0401_To_No_0500.No_0453_minimum_moves_to_equal_array_elements;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 3
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 假设每走一步,都是所有数加1,而不是n-1个数加一
 * 那么当每个数都加了m步之后,总共多出来的数也是m
 * 此时一共加了m*n个数,假设已经可以达到目的, 将这m*n个数平分到每个数上, 当做是每个数都加了m个数
 * 然后此时需要做减法减去m个数
 * 画图可知,要想达到每个数相等的目的, 要减去的数为
 * nums[0]=>0
 * nums[1]=>nums[1]-nums[0]
 * nums[2]=>nums[2]-nums[0]
 * 将所有这些数加起来得到的是要减去的步数
 * 由于之前是m个move,每个move多加一个数,所以一共加了m个数,也就是等于要减去的步数
 */
public class Solution {
    public int minMoves(int[] nums) {
        if(nums.length == 0 ){
            return 0;
        }
        int result = 0 ;
        Arrays.sort(nums);
        for(int num : nums){
            result += num - nums[0];
        }
        return result ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMoves(new int[]{1,2,3}));
    }
}
