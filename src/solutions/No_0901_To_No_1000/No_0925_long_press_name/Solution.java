package solutions.No_0901_To_No_1000.No_0925_long_press_name;

/**
 * https://leetcode.com/problems/long-pressed-name/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 * Example 1:
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 两个指针,从两个字符串开始处理
 * 遍历的过程中记得要判断typed中多余的字符是否是name中所对应的字符
 * 记得要如果name先遍历完,判断typed剩下的字符是否和name的最后一个字符相等
 * 如果是typed先遍历完,返回false
 * 如果两个同时遍历完,返回true
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nameIndex = 0 ;
        int typedIndex = 0 ;
        char lastNameChar = '#';
        while(nameIndex < name.length() && typedIndex < typed.length()){
            if(name.charAt(nameIndex) == typed.charAt(typedIndex)){
                lastNameChar = name.charAt(nameIndex);
                nameIndex ++;
                typedIndex ++;
            }else{
                if(typedIndex < typed.length() && typed.charAt(typedIndex)!=lastNameChar){
                    return false;
                }
                typedIndex ++;
            }
        }
        if(nameIndex == name.length()&&typedIndex == typed.length()){
            return true;
        }else if(nameIndex == name.length()){
            for(int i = typedIndex ; i < typed.length() ; i++){
                if(typed.charAt(i)!=lastNameChar){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isLongPressedName("alex","aalllexxx"));
    }
}
