package solutions.No_0601_To_No_0700.No_0686_repeated_string_match;

/**
 * https://leetcode.com/problems/repeated-string-match/
 *
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 * <p>
 * For example, with A = "abcd" and B = "cdabcdab".
 * <p>
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * Note:
 * The length of A and B will be between 1 and 10000.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 让A重复一直到长度比B长为止,然后判断是否包含B即可, 第一个A要从和B第一个字符相匹配的字符开始截取
 */
public class Solution {
    public int repeatedStringMatch(String A, String B) {
        String s = "";
        int Acount = 0;
        while(s.length()<B.length()+2*A.length()){
            if(s.contains(B)){
                return Acount;
            }
            s = s + A;
            Acount ++ ;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println("abcdabcdabcd".indexOf("cdabcdab"));
    }
}

