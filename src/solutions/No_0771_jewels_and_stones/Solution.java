package solutions.No_0771_jewels_and_stones;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 替换掉所有jewels,看去掉了多少jewels即可
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        int sLength = S.length();
        for(char c : J.toCharArray()){
            S = S.replace(String.valueOf(c),"");
        }
        return sLength - S.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numJewelsInStones("aA","aAAbbbb"));
    }
}
