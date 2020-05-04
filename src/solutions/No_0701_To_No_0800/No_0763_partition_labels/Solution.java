package solutions.No_0701_To_No_0800.No_0763_partition_labels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-labels/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 首先用一个map记录每个字符的右边界
 * 然后开始遍历, 从第一个字符开始记录右边界
 * 如果在当前区间内某个字符的右边界超出了当前右边界, 则将右边界设为当前字符的右边界
 * 当index走到右边界的点时, 说明该区间内所有的字母都仅仅在此区间内出现
 * 此时截取区间的长度放到结果list中, 开始下一个区间的检测
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> resultList = new ArrayList<>();
        Map<Character,Integer> boundMap = new HashMap<>();
        for(char c : S.toCharArray()){
            if(!boundMap.containsKey(c)) {
                boundMap.put(c, S.lastIndexOf(c));
            }
        }
        int currentIndex = 0 ;
        int lastRightBound = 0 ;
        int currentRightBound = 1;
        while(currentRightBound <= S.length()){
            if(currentIndex == currentRightBound){
                resultList.add(currentRightBound - lastRightBound);
                lastRightBound = currentRightBound;
                currentRightBound ++;
                continue;
            }
            char c = S.charAt(currentIndex);
            int characterRightBound = boundMap.get(c);
            if(characterRightBound + 1 > currentRightBound){
                currentRightBound = characterRightBound + 1;
            }
            currentIndex ++;
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
