package solutions.No_1221_split_a_string_in_balanced_strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of splitted balanced strings.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * Example 2:
 *
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 * Example 3:
 *
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用栈来做
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int result = 0 ;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            if('L' == c){
                if(stack.peek() == 'R'){
                    stack.pop();
                }else{
                    stack.push(c);
                }
                if(stack.isEmpty()){
                    result += 1;
                    continue;
                }
            }
            if('R' == c){
                if(stack.peek() == 'L'){
                    stack.pop();
                }else{
                    stack.push(c);
                }
                if(stack.isEmpty()){
                    result += 1;
                    continue;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().balancedStringSplit("LLLLRRRR"));
    }
}
