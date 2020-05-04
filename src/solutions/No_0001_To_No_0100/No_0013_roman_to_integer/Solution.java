package solutions.No_0001_To_No_0100.No_0013_roman_to_integer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II.
 * The number twenty seven is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * Example 1:
 * Input: "III"
 * Output: 3
 * Example 2:
 * Input: "IV"
 * Output: 4
 * Example 3:
 * Input: "IX"
 * Output: 9
 * Example 4:
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历运算, 如果是I,X,C这种判断一下是否能与下一个组成IV,IX...之类的即可
 */
public class Solution {
    public int romanToInt(String s) {
        Map<String,Integer> romanMap = getRomanMap();
        Set<Character> combineSet = new HashSet();
        combineSet.add('I');
        combineSet.add('X');
        combineSet.add('C');
        int result = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            //如果为1,10,100,判断与下一个元素是否能组成4,9,40,90..等等
            if(combineSet.contains(s.charAt(i)) && i < s.length()-1){
                if (romanMap.containsKey(s.substring(i,i+2))){
                    result += romanMap.get(s.substring(i,i+2));
                    i++;
                }else{
                    result += romanMap.get(s.substring(i,i+1));
                }
            }else{
                result += romanMap.get(s.substring(i,i+1));
            }
        }
        return  result;
    }

    private Map<String,Integer> getRomanMap() {
        Map<String,Integer> romanMap = new HashMap<>();
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);
        romanMap.put("IV",4);
        romanMap.put("IX",9);
        romanMap.put("XL",40);
        romanMap.put("XC",90);
        romanMap.put("CD",400);
        romanMap.put("CM",900);
        return romanMap;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }
}
