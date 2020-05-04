package solutions.No_0901_To_No_1000.No_0942_di_string_match;

/**
 * https://leetcode.com/problems/di-string-match/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * Example 1:
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 * Input: "DDI"
 * Output: [3,2,0,1]
 * Note:
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 0~N-1之间的数,遍历S,如果为I填入最左的数,如果为D填入最右的数,最后补上最后一个数即可
 * 例如IDID,将0~4填入数组中
 * I => 填0
 * D => 填4
 * I => 填1
 * D => 填3
 * 补上剩余一个数2
 * 即可得到答案[0,4,1,3,2]
 */
public class Solution {
    public int[] diStringMatch(String S) {
        int left = 0 ;
        int right = S.length();
        int[] result = new int[S.length()+1];
        int i = 0 ;
        for(char c : S.toCharArray()){
            if(c == 'I'){
                result[i++] = left++;
            }else{
                result[i++] = right--;
            }
        }
        result[S.length()] = right;
        return result;
    }

    public static void main(String[] args) {
        int[] a = new Solution().diStringMatch("DDI");
        for(int num : a ){
            System.out.println(num);
        }
    }
}
