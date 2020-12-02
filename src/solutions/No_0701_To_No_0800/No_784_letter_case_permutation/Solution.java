package solutions.No_0701_To_No_0800.No_784_letter_case_permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 * <p>
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用回溯算法递归解决
 */
public class Solution {
    public List<String> letterCasePermutation(String S) {
        return backTracking(new ArrayList<>(), S, "", 0);
    }

    /**
     * 递归方法
     * @param result 保存所有的结果
     * @param S      标志树的深度
     * @param curr   存储当前组成的字符串
     * @param n      存储当前遍历深度
     * @return
     */
    private List<String> backTracking(List<String> result, String S, String curr, int n) {
        if (n == S.length()) {
            result.add(curr);
        }else {
            if (Character.isLetter(S.charAt(n))) {
                backTracking(result, S, curr + Character.toUpperCase(S.charAt(n)), n + 1);
                backTracking(result, S, curr + Character.toLowerCase(S.charAt(n)), n + 1);
            }else {
                backTracking(result, S, curr + S.charAt(n), n + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b2"));
    }
}
