package solutions.No_1047_remove_all_adjacent_duplicates_in_string;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * We repeatedly make duplicate removals on S until we no longer can.
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * Example 1:
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Note:
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用栈可以, 也可以一个字符一个字符拼接,如果下一个字符相同则删掉最后一个字符
 */
public class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(!stack.isEmpty() && c == stack.peek()){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        String result = "";
        while(!stack.isEmpty()){
            result = String.valueOf(stack.pop())+result;
        }
        return result ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abbaca"));
    }
}
