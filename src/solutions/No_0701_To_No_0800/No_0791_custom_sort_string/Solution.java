package solutions.No_0701_To_No_0800.No_0791_custom_sort_string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/custom-sort-string/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 * Return any permutation of T (as a string) that satisfies this property.
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 * Note:
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用一个map记录各个字符的权值,排序时根据权值排序即可
 */
public class Solution {
    public String customSortString(String S, String T) {
        Map<Character,Integer> orderMap = new HashMap<>();
        for(int i = 0 ; i < S.length() ; i++){
            orderMap.put(S.charAt(i),i);
        }
        Character[] TCharArray = new Character[T.length()];
        for(int i = 0 ; i < T.length();i++){
            TCharArray[i] = T.charAt(i);
        }
        Arrays.sort(TCharArray, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int o1Order = orderMap.containsKey(o1)?orderMap.get(o1):Integer.MAX_VALUE;
                int o2Order = orderMap.containsKey(o2)?orderMap.get(o2):Integer.MAX_VALUE;
                return o1Order - o2Order;
            }
        });
        String result = "";
        for(char c : TCharArray){
            result+=c;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().customSortString("cba","abcd"));
    }
}
