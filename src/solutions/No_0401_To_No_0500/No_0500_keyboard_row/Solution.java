package solutions.No_0401_To_No_0500.No_0500_keyboard_row;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/keyboard-row/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * Example:
 * <p>
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 判断是否包含所有字母即可
 */
public class Solution {
    public String[] findWords(String[] words) {
        return  Stream.of(words)
                .filter(word -> Arrays.asList("q", "w", "e", "r", "t", "y", "u", "i", "o", "p").containsAll(word.chars().mapToObj(c -> (char) c).map(String :: valueOf).map(String :: toLowerCase).collect(Collectors.toList())) || Arrays.asList("a", "s", "d", "f", "g", "h", "j", "k", "l").containsAll(word.chars().mapToObj(c -> (char) c).map(String :: valueOf).map(String :: toLowerCase).collect(Collectors.toList())) || Arrays.asList("z", "x", "c", "v", "b", "n", "m").containsAll(word.chars().mapToObj(c -> (char) c).map(String :: valueOf).map(String :: toLowerCase).collect(Collectors.toList())))
                .map(String :: valueOf)
                .toArray(String[] :: new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(new Solution().findWords(new String[]{"qwert", "dadas"})));
    }
}
