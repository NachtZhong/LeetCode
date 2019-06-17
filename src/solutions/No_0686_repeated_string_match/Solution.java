package solutions.No_0686_repeated_string_match;

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
        if(A.contains(B)){
            return 1;
        }
        int i = 1;
        int index = 0;
        for(int tmp = 0 ; tmp < A.length() ; tmp++){
            if(B.contains(A.substring(tmp))){
                index = tmp;
            }
        }
        if(index == 0){
            return -1;
        }
        String duplicateA = A.substring(index);
        while (duplicateA.length() <= B.length() && !duplicateA.equals(B)) {
            duplicateA += A;
            i++;
        }
        return duplicateA.indexOf(B) >= 0 ? i : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println("abcdabcdabcd".indexOf("cdabcdab"));
    }
}

