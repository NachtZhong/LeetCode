package solutions.No_0201_To_No_0300.No_0299_bulls_and_cows;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 *
 * Please note that both secret number and friend's guess may contain duplicate digits.
 *
 * Example 1:
 *
 * Input: secret = "1807", guess = "7810"
 *
 * Output: "1A3B"
 *
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * Example 2:
 *
 * Input: secret = "1123", guess = "0111"
 *
 * Output: "1A1B"
 *
 * Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 先遍历, 记录出secret中有每个数字和对应的个数,放到HashMap中,  然后遍历两个字符串比较, 如果出现bull(数字位置都同)或者cow(数字同, 位置不同), 则将对应的数字的个数-1
 * 如果遍历出bull, 但是该数字对应的个数为0 , 说明有一个cow占用了这个bull的数字, 将cow的数量-1(bull优先级大于cow)
 * 这个sb题目定的游戏规则是真的sb
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int bullCount = 0 ;
        int cowCount = 0;
        Map<Integer, Integer> secretNumMap = new HashMap<>();
        for(char c : secret.toCharArray()){
            int value = c - '0';
            secretNumMap.putIfAbsent(value, 0);
            secretNumMap.put(value, secretNumMap.get(value) + 1);
        }
        for(int i = 0 ; i < secret.length() ; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bullCount++;
                int value = secret.charAt(i) - '0';
                /*如果遍历出bull, 但是该数字对应的个数为0 , 说明有一个cow占用了这个bull的数字, 将cow的数量-1(bull优先级大于cow)*/
                if (secretNumMap.get(value) == 0){
                    cowCount--;
                }else{
                    secretNumMap.put(value, secretNumMap.get(value) - 1);
                }
            }else{
                int value = guess.charAt(i) - '0';
                if(secretNumMap.getOrDefault(value, 0) > 0 ){
                    cowCount++;
                    secretNumMap.put(value, secretNumMap.get(value) - 1);
                }
            }
        }
        return bullCount+"A"+cowCount+"B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1123","0111"));
    }
}
