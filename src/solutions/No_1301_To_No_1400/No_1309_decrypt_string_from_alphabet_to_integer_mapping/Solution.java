package solutions.No_1301_To_No_1400.No_1309_decrypt_string_from_alphabet_to_integer_mapping;

/**
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 *
 * It's guaranteed that a unique mapping will always exist.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * Example 2:
 *
 * Input: s = "1326#"
 * Output: "acz"
 * Example 3:
 *
 * Input: s = "25#"
 * Output: "y"
 * Example 4:
 *
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 *
 */
public class Solution {
    public String freqAlphabets(String s) {
        return s.replaceAll("10#", "j").replaceAll("11#","k").replaceAll("12#","l").replaceAll("13#","m").replaceAll("14#","n").replaceAll("15#","o").replaceAll("16#","p").replaceAll("17#","q").replaceAll("18#","r").replaceAll("19#","s").replaceAll("20#","t").replaceAll("21#","u").replaceAll("22#","v").replaceAll("23#","w").replaceAll("24#","x").replaceAll("25#","y").replaceAll("26#","z").replaceAll("1","a").replaceAll("2","b").replaceAll("3","c").replaceAll("4","d").replaceAll("5","e").replaceAll("6","f").replaceAll("7","g").replaceAll("8","h").replaceAll("9","i");
    }
}
