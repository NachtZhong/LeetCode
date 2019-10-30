package solutions.No_0970_powerful_integers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/powerful-integers/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given two positive integers x and y, an integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
 *
 * Return a list of all powerful integers that have value less than or equal to bound.
 *
 * You may return the answer in any order.  In your answer, each value should occur at most once.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation:
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * Example 2:
 *
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 求出x和y最大可能的次方数作为上限, 然后组合测试符合要求的数即可
 */
public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int xLimit = x == 1 ? 0 : (int) (Math.log(bound) / Math.log(x));
        int yLimit = y == 1 ? 0 : (int) (Math.log(bound) / Math.log(y));
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0 ; i <= xLimit ; i++){
            for(int j = 0 ; j <= yLimit ; j++){
                int sum = (int) (Math.pow(x,i) + Math.pow(y,j));
                if(sum <= bound){
                    if(!resultList.contains(sum)){
                        resultList.add(sum);
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().powerfulIntegers(3,5,15));
    }
}
