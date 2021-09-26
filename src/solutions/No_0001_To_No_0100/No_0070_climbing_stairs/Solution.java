package solutions.No_0001_To_No_0100.No_0070_climbing_stairs;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 每次只能跳一个或者两个楼梯, 求跳到第n个楼梯有多少中跳法
 * 解题思路:
 * 动态规划思想, 既然每次可以跳1个或者2个, 那么跳到第n个可以先跳到第n-2个楼梯跳两步, 也可以跳到第n-1个楼梯跳一步, 所以f(n) = f(n-1) + f(n-2), 递归回溯即可
 * 但是实际测试递归会超时, 改用循环
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(45));
    }
    public int climbStairs(int n) {
        /*1级楼梯, 跳一步*/
        if(n == 1){
            return 1;
        }
        /*2级楼梯, 跳一次两步或者两次一步*/
        if(n == 2){
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        for(int i = 3; i <= n; i++){
            int tmp = f2;
            f2 = f1 + f2;
            f1 = tmp;
        }
        return f2;
    }
//    public int climbStairs(int n) {
//        /*1级楼梯, 跳一步*/
//        if(n == 1){
//            return 1;
//        }
//        /*2级楼梯, 跳一次两步或者两次一步*/
//        if(n == 2){
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

}
