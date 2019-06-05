package solutions.No_412_fizz_buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * Example:
 * n = 15,
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历即可
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> resultList = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            if(i % 3 == 0 && i % 5 != 0){
                resultList.add("Fizz");
                continue;
            }
            if(i % 3 != 0 && i % 5 == 0){
                resultList.add("Buzz");
                continue;
            }
            if(i % 3 == 0 && i % 5 == 0){
                resultList.add("FizzBuzz");
                continue;
            }
            resultList.add(String.valueOf(i));
        }
        return resultList;
    }
}
