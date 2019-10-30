package solutions.No_0434_number_of_segments_in_a_string;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 先将前后空格去掉, 然后将多个空格替换成一个, 然后判断以空格分割后的String数组长度即可
 */
public class Solution {
    public int countSegments(String s) {
        return "".equals(s.trim())?0:s.trim().replaceAll(" +"," ").split(" ").length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSegments("     "));
    }
}
