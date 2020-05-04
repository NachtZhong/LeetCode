package solutions.No_0001_To_No_0100.No_0014_longest_common_prefix;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * All given inputs are in lowercase letters a-z.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 以第一个字符串作为测试字符串, 从第一个字符开始测试, 出现不匹配则返回上次得到的子串
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 ){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String result = "";
        for(int i = 0 ; i < strs[0].length() ; i++){
            boolean hasOccuredUnMatching = false ;
            for(String str : strs){
                if(i > str.length()-1 || str.charAt(i)!=strs[0].charAt(i)){
                    hasOccuredUnMatching = true;
                    break;
                }
            }
            if (hasOccuredUnMatching){
                return result;
            }
            result += strs[0].charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"pl","please","pp"}));
    }
}
