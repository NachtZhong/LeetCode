package solutions.No_1401_To_No_1500.No_1408_string_matching_in_an_array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/string-matching-in-an-array/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array of string words. Return all strings in words which is substring of another word in any order.
 * <p>
 * String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 * Example 2:
 * <p>
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 * Example 3:
 * <p>
 * Input: words = ["blue","green","bu"]
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] contains only lowercase English letters.
 * It's guaranteed that words[i] will be unique.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历
 */
public class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String compareWord = words[j];
                if(word.length() > compareWord.length()){
                    if(word.contains(compareWord)){
                        resultSet.add(compareWord);
                    }
                }else{
                    if(compareWord.contains(word)){
                        resultSet.add(word);
                    }
                }
            }
        }
        List<String> resultList = new ArrayList<>(resultSet);
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().stringMatching(new String[]{"mass","as","hero","superhero"}));
    }
}
