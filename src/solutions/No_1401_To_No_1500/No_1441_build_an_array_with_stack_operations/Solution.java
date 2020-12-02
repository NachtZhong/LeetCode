package solutions.No_1401_To_No_1500.No_1441_build_an_array_with_stack_operations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/build-an-array-with-stack-operations/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.
 * <p>
 * Build the target array using the following operations:
 * <p>
 * Push: Read a new element from the beginning list, and push it in the array.
 * Pop: delete the last element of the array.
 * If the target array is already built, stop reading more elements.
 * You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.
 * <p>
 * Return the operations to build the target array.
 * <p>
 * You are guaranteed that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = [1,3], n = 3
 * Output: ["Push","Push","Pop","Push"]
 * Explanation:
 * Read number 1 and automatically push in the array -> [1]
 * Read number 2 and automatically push in the array then Pop it -> [1]
 * Read number 3 and automatically push in the array -> [1,3]
 * Example 2:
 * <p>
 * Input: target = [1,2,3], n = 3
 * Output: ["Push","Push","Push"]
 * Example 3:
 * <p>
 * Input: target = [1,2], n = 4
 * Output: ["Push","Push"]
 * Explanation: You only need to read the first 2 numbers and stop.
 * Example 4:
 * <p>
 * Input: target = [2,3,4], n = 4
 * Output: ["Push","Pop","Push","Push","Push"]
 * <p>
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历, 水题
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        int current = 1;
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < target.length; ) {
            resultList.add("Push");
            if (target[i] != current) {
                resultList.add("Pop");
            }else{
                i++;
            }
            current ++;
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().buildArray(new int[]{1,2},4));
    }
}
