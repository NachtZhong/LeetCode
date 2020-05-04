package solutions.No_1001_To_No_1100.No_1078_occurrences_after_bigram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/occurrences-after-bigram/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
 *
 * For each such occurrence, add "third" to the answer, and return the answer.
 *
 *
 *
 * Example 1:
 *
 * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
 * Output: ["girl","student"]
 * Example 2:
 *
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历即可
 */
public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> resultList = new ArrayList<>();
        for(int i = 0 ; i < words.length - 2 ; i++){
            if(first.equals(words[i]) && second.equals(words[i+1])){
                resultList.add(words[i+2]);
            }
        }
        return resultList.stream().toArray(String[] :: new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findOcurrences("we will we will rock you", "we", "will")));
    }
}
