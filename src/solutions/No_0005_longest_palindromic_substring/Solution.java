package solutions.No_0005_longest_palindromic_substring;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author Nacht
 * Created on 2019/5/30
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解决思路:
 * 将字符串插入#,可以不用判断字符个数为奇偶数的情况
 * 插入#之后依次以各个元素为圆心向两边扫描,碰到非回文数则停止跳到下一个字符
 * 记录最大回文子字符串即可
 */
public class Solution {
    public String longestPalindrome(String s) {
        if ("".equals(s)){
            return "";
        }
        String currentMaxSubString = s.substring(0,1);
        int currentMaxSubStringLength = 1;
        s = fillWithExtraSymbol(s);
        for(int i = 0 ; i < s.length() ; i++){
            int maxTestScope = Math.min(i,s.length()-i-1);//最大半径范围
            int minTestScope = currentMaxSubStringLength/2;
            for(int scope = minTestScope ; scope <= maxTestScope ; scope++){
                String testSubString = s.substring(i-scope,i+scope+1);
                if(!isPalindromicString(testSubString)){
                    break;
                }else{
                    int realLength = testSubString.replace("#","").length();
                    if (realLength > currentMaxSubStringLength){
                        currentMaxSubStringLength = realLength;
                        currentMaxSubString = testSubString;
                    }
                }
            }
        }
        return currentMaxSubString.replace("#","");
    }

    /**
     * 是否为回文字符串
     * @param s
     * @return
     */
    public boolean isPalindromicString(String s){
        return new StringBuilder(s).toString().equals(new StringBuilder(s).reverse().toString());
    }

    /**
     * 返回用#填充后的字符串
     * 例如abc会返回a#b#c,abba返回a#b#b#a
     * 这样可以不用区分单数和双数情况下的回文字符串
     * @param s
     * @return
     */
    private String fillWithExtraSymbol(String s) {
        String resultString = "#";
        int i = 0 ;
        while(i<s.length()){
            resultString = resultString + s.charAt(i) + "#";
            i++;
        }
        return resultString;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("ccc"));
    }
}
