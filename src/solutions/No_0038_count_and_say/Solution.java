package solutions.No_0038_count_and_say;


/**
 * https://leetcode.com/problems/count-and-say/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 * Example 1:
 * Input: 1
 * Output: "1"
 * Example 2:
 * Input: 4
 * Output: "1211"
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 以12334为例
 * 首先将11加到目标字符串中
 * 然后依次判断下一个字符,如果和前一个字符相同就+1,不同则加上新的表达式,于是这个处理过程为:
 * 1     2      3       3        4
 * 11=>1112=>111213=>111223=>11122314
 */
public class Solution {
    public String countAndSay(int n) {
        String currentExpression = "1";
        while(n > 1){
            String transExpression = "1" + currentExpression.charAt(0);
            for(int i = 1 ; i < currentExpression.length() ; i++){
                if(currentExpression.charAt(i)==transExpression.charAt(transExpression.length()-1)){
                    transExpression = transExpression.substring(0,transExpression.length()-2)+(Integer.valueOf(transExpression.substring(transExpression.length()-2,transExpression.length()-1))+1)+transExpression.substring(transExpression.length()-1);
                }else{
                    transExpression = transExpression + "1" + currentExpression.charAt(i);
                }
            }
            currentExpression = transExpression ;
            n--;
        }
        return currentExpression ;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(5));
    }
}
