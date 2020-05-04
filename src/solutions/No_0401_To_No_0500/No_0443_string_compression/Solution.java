package solutions.No_0401_To_No_0500.No_0443_string_compression;

/**
 * https://leetcode.com/problems/string-compression/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array of characters, compress it in-place.
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * Example 1:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * Example 2:
 * Input:
 * ["a"]
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * Explanation:
 * Nothing is replaced.
 * Example 3:
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 * Note:
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用char数组来存储int的傻逼题目,已经不想多解释了
 */
public class Solution {
    public int compress(char[] chars) {
        int index = 0 ;
        for(int i = 0 ; i < chars.length ; ){
            int count = 1;
            while(i<chars.length-1 && chars[i+1]==chars[i]){
                count ++;
                i++;
            }
            if(count == 1){
                chars[index] = chars[i];
                index ++ ;
            }else{
                chars[index++] = chars[i-1];
                char[] countChars = String.valueOf(count).toCharArray();
                for(char c : countChars) {
                    chars[index++] = c;
                }
            }
            i++;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(new Solution().compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
