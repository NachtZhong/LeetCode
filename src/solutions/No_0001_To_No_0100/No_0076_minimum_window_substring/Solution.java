package solutions.No_0001_To_No_0100.No_0076_minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 给一个字符串数组和一个小字符串, 求字符串数组中的一个最小子串, 要满足这个最小子串包含小字符串中的所有字母(小字符串中的字母可能重复)
 * 解题思路:
 * 首先统计小字符串中每个字母以及其个数, 比如a有两个, b有一个这样
 * 然后通过两个指针制造一个滑动窗口, 逻辑是先移动右指针, 使得窗口内的子串可以满足覆盖要求, 在满足了覆盖要求之后, 尽量移动左指针到最右, 使得窗口最小, 并记录下此时窗口的开始位置和大小
 * 记录完之后, 继续移动右指针, 重复上面的操作, 如果有更小的子串就替换掉原来最小窗口的记录, 最后根据记录下来的最小窗口记录获得最小子串
 * 原来思路使用hashmap记录, 后面尝试用数组代替hashmap记录, 速度从100ms提升到了10ms, 看来hashmap做这种算法题效率不太高..
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ab", "A"));
    }

    public String minWindow(String s, String t) {
        /*处理边界条件*/
        if(s.length() == 0 || t.length() == 0 || t.length() > s.length()){
            return "";
        }
        /*统计s中字符以及个数, 数组中的元素代表其对应字母的个数, a-z范围为97~122, A-Z范围为65-90, 总体范围是65-122, 所以通过字母-65的方式定位其对应的元素, 数组长度为58就够了*/
        int[] charsInStr = new int[58];
        for(char c : t.toCharArray()){
            charsInStr[c - 65] += 1;
        }
        /*左指针和右指针*/
        int left = 0, right = 0;
        /*当前窗口内的字符和数量*/
        int[] charsInWindow = new int[58];
        charsInWindow[s.charAt(0) - 65] = 1;
        /*最小窗口的起始点和大小*/
        int minWindowBeginIndex = 0;
        int minWindowSize = Integer.MAX_VALUE;

        while(true){
            /*如果当前窗口内已经能满足要求, 尽量移动左指针*/
            if(charsInWindowCanCover(charsInWindow, charsInStr)){
                while(charsInWindowCanStillCoverAfterRemove(charsInWindow, charsInStr, s.charAt(left))){
                    /*更新窗口统计并移动左指针*/
                    char c = s.charAt(left);
                    if(charsInWindow[c - 65] != 0){
                        charsInWindow[c - 65] -= 1;
                    }
                    left++;
                }
                /*计算此时的窗口大小*/
                int windowSize = right - left + 1;
                if(windowSize < minWindowSize){
                    minWindowBeginIndex = left;
                    minWindowSize = windowSize;
                }
            }
            /*右指针移动*/
            right++;
            if(right == s.length()){
                break;
            }
            /*更新窗口内字母的统计*/
            charsInWindow[s.charAt(right) - 65] += 1;
        }
        /*如果minWindowSize没变过, 说明遍历完也不能找到满足条件的窗口*/
        if(minWindowSize == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minWindowBeginIndex, minWindowBeginIndex + minWindowSize);
    }

    /**
     * 判断窗口内的字符是否能覆盖特定字符串里面的字符
     * @param charsInWindow
     * @param charsInString
     * @return
     */
    private boolean charsInWindowCanCover(int[] charsInWindow, int[] charsInString){
        for(int i = 0; i < charsInString.length; i++){
            if(charsInWindow[i] < charsInString[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断窗口移除某个字符之后是否依然能覆盖特定字符串里面的字符(假定移除前能覆盖)
     * @param charsInWindow
     * @param charsInString
     * @param c
     * @return
     */
    private boolean charsInWindowCanStillCoverAfterRemove(int[] charsInWindow, int[] charsInString, char c){
        /*如果字符串本身不包含这个字符, 移除后当然没影响*/
        return charsInWindow[c - 65] - 1 >= charsInString[c - 65];
    }
}
