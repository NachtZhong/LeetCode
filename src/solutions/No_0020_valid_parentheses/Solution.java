package solutions.No_0020_valid_parentheses;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * Example 1:
 * Input: "()"
 * Output: true
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * Input: "(]"
 * Output: false
 * Example 4:
 * Input: "([)]"
 * Output: false
 * Example 5:
 * Input: "{[]}"
 * Output: true
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 1.正常思路:新建一个栈,遍历s的字符如果是([{则入栈,如果是)]}则首先判断栈是否有元素,如果没有则返回false,然后判断栈顶元素是否为对应的另一个字符,不对应则返回false
 *   遍历完之后还要判断栈的size是否为0,不为0则证明有元素没有对应的闭括号
 * 2.我的沙雕思路:循环删除()[]{},判断是否能全部删完:)
 */
public class Solution {
//    public boolean isValid(String s) {
//        while(s.contains("()")||s.contains("[]")||s.contains("{}")){
//            s = s.replace("()","").replace("[]","").replace("{}","");
//        }
//        return "".equals(s)?true:false;
//    }
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            if(c == ')'){
                if(stack.size() == 0){
                    return false;
                }
                if(stack.pop() != '('){
                    return false;
                }
            }
            if(c == ']'){
                if(stack.size() == 0){
                    return false;
                }
                if(stack.pop() != '['){
                    return false;
                }
            }
            if(c == '}'){
                if(stack.size() == 0){
                    return false;
                }
                if(stack.pop() != '{'){
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{{]}}"));
    }
}
