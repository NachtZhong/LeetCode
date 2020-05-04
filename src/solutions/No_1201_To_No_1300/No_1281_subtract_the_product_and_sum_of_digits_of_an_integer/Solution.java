package solutions.No_1201_To_No_1300.No_1281_subtract_the_product_and_sum_of_digits_of_an_integer;

/**
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 *
 *
 * Example 1:
 *
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 * Example 2:
 *
 * Input: n = 4421
 * Output: 21
 * Explanation:
 * Product of digits = 4 * 4 * 2 * 1 = 32
 * Sum of digits = 4 + 4 + 2 + 1 = 11
 * Result = 32 - 11 = 21
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 直接算就好
 */
public class Solution {
    public int subtractProductAndSum(int n) {
       return String.valueOf(n).chars().map(c -> c - '0').reduce(1, (x, y) -> x * y) - String.valueOf(n).chars().map(c -> c - '0').sum();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subtractProductAndSum(4421));
    }
}
