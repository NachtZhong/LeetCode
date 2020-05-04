package solutions.No_1101_To_No_1200.No_1147_longest_chunked_palindrome_decomposition;

/**
 * https://leetcode.com/problems/longest-chunked-palindrome-decomposition/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Return the largest possible k such that there exists a_1, a_2, ..., a_k such that:
 *
 * Each a_i is a non-empty string;
 * Their concatenation a_1 + a_2 + ... + a_k is equal to text;
 * For all 1 <= i <= k,  a_i = a_{k+1 - i}.
 *
 *
 * Example 1:
 *
 * Input: text = "ghiabcdefhelloadamhelloabcdefghi"
 * Output: 7
 * Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".
 * Example 2:
 *
 * Input: text = "merchant"
 * Output: 1
 * Explanation: We can split the string on "(merchant)".
 * Example 3:
 *
 * Input: text = "antaprezatepzapreanta"
 * Output: 11
 * Explanation: We can split the string on "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)".
 * Example 4:
 *
 * Input: text = "aaa"
 * Output: 3
 * Explanation: We can split the string on "(a)(a)(a)".
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 从两边往中间.设四个指针取词判断即可
 */
public class Solution {
    public int longestDecomposition(String text) {
        if(text.length() == 0){
            return 0;
        }
        int iTail = 0;
        int iHead = 1;
        int jTail = text.length();
        int jHead = text.length() - 1;
        int result = 0;
        while(iHead <= jHead){
            String frontWord = text.substring(iTail, iHead);
            String tailWord = text.substring(jHead, jTail);
            if(frontWord.equals(tailWord)){
                result += 2;
                iTail = iHead;
                jTail = jHead;
                iHead++;
                jHead--;
            }else{
                iHead++;
                jHead--;
            }
        }
        if(iTail != iHead -1){
            result ++;
        }
        else if(iTail != jTail){
            result ++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestDecomposition("aaa"));
    }
}
