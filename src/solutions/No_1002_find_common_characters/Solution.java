package solutions.No_1002_find_common_characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-common-characters/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 *
 * You may return the answer in any order.
 * Example 1:
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 * Note:
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 所有字符串放到各自的map中, key为字符, value为字符数, 取第一个map, 判断其他map中有多少个一样的字符即可
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        if(A.length == 0 ){
            return new ArrayList<String>();
        }
        List<Map<Character,Integer>> characterMapList = new ArrayList<>();
        for(String s : A){
            Map<Character , Integer> characterMap = new HashMap<>();
            for(char c : s.toCharArray()){
                characterMap.put(c,characterMap.containsKey(c)?characterMap.get(c)+1:1);
            }
            characterMapList.add(characterMap);
        }
        List<String> resultList = new ArrayList<>();
        for(char c : characterMapList.get(0).keySet()){
            int commonCount = characterMapList.get(0).get(c);
            for(Map<Character,Integer> map : characterMapList){
                commonCount = Math.min(commonCount,map.get(c)==null?0:map.get(c));
            }
            for(int i = 0 ; i < commonCount ; i++){
                resultList.add(String.valueOf(c));
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().commonChars(new String[]{"bella","label","roller"}));
    }
}
