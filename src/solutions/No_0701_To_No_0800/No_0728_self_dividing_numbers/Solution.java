package solutions.No_0701_To_No_0800.No_0728_self_dividing_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/self-dividing-numbers/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 暴力循环即可
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> resultList = new ArrayList<>();
        for(int num = left ; num <= right ; num++){
            int i = num ;
            boolean isSelfDividingNumber = true ;
            for(char c : String.valueOf(i).toCharArray()){
                int divideNum = c - '0';
                if(divideNum == 0 || i % divideNum != 0){
                    isSelfDividingNumber = false;
                    break;
                }
            }
            if(isSelfDividingNumber) {
                resultList.add(num);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().selfDividingNumbers(1,22));
    }
}
