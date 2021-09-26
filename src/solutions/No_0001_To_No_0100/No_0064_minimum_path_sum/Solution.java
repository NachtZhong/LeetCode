package solutions.No_0001_To_No_0100.No_0064_minimum_path_sum;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 给一个矩阵, 求从左上角到右下角怎么走才使路径上数字的总和最小, 要求只能向右或者向下
 * 解题思路:
 * 动态规划的思想, 由于只能向右或者向下, 那么对于某个节点来说, 到这个节点的最小路径dp[i][j] = min(dp[i][j-1], dp[i-1][j]) + grid[i][j]
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j ++){
                /*左上角的节点路径长度就是本身的值*/
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                /*位于上边界的节点只能从左边走过来*/
                if(i == 0){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                /*位于左边界的节点只能从上边走过来*/
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
