package solutions.No_0801_To_No_0900.No_0821_shortest_distance_to_a_character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 * Example 1:
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 找出所有目标字符的index,然后对于字符串中的每一个字符, 判断出它在哪一个区间, 然后取最短距离即可
 */
public class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> targetCharIndexs = new ArrayList<>();
        int[] resultArray = new int[S.length()];
        for(int i = 0 ; i< S.length() ; i ++){
            if(S.charAt(i) == C ){
                targetCharIndexs.add(i);
            }
        }
        for(int i = 0 ; i < S.length() ; i++){
            if(i <= targetCharIndexs.get(0)){
                resultArray[i] = targetCharIndexs.get(0) - i;
                continue;
            }
            if(i >= targetCharIndexs.get(targetCharIndexs.size()-1)){
                resultArray[i] = i - targetCharIndexs.get(targetCharIndexs.size()-1);
                continue;
            }
            int index = 0 ;
            while(i > targetCharIndexs.get(index+1)){
                index ++ ;
            }
            resultArray[i] = Math.min(i - targetCharIndexs.get(index),targetCharIndexs.get(index+1)-i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shortestToChar("loveleetcode",'e')));
    }
}
