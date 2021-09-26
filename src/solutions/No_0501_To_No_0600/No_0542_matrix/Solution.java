package solutions.No_0501_To_No_0600.No_0542_matrix;

/**
 * https://leetcode.com/problems/01-matrix/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 * <p>
 * <p>
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 * Accepted
 * 170,700
 * Submissions
 * 396,477
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 一个矩阵, 里面是0和1, 求每个元素到最近的0的距离
 * 解题思路:
 * 第一反应是用bfs广度遍历求最短路径, 但是每个元素都要对周围的四个元素做遍历的话复杂度会很高, 所以这里用动态规划来做
 * 先从左上到右下做一次动态规划, 再从右下到左上做一次动态规划
 * 首先定义一个dp矩阵, 将所有元素的值都初始化为Integer.max - 1
 * 然后在遍历的过程中对其进行判断和初始化(注意有些时候由于前面的元素节点还没初始化, 这时候就说明未初始化的它们离0的距离比当前元素还要远, 那么在下一次反方向动态规划搜索再按反顺序初始化即可, 因为初始化的顺序总是从离0近的到离0远的
 * 规律就是左上到右下的时候为min(dp[i-1][j], dp[i][j-1])+1, 右下到左上的时候为min(dp[i+1][j], dp[i][j+1])+1
 */
public class Solution {
    public static void main(String[] args) {

    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        /*初始化dp矩阵*/
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE - 1;
            }
        }
        /*左上到右下*/
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0){
                    dp[i][j] = 0;
                }else if(i == 0 && j == 0){
                    /*不做任何处理*/
                }else if(i == 0){
                    /*这里之所以要用上一个节点+1和当前节点作对比取最小是防止前面一个节点还没有求值的情况, 这样可以保持当前节点处于未计算状态, 在下一次反向dp再计算*/
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
                }else if(j == 0){
                    /*这里之所以要用上一个节点+1和当前节点作对比取最小是防止前面一个节点还没有求值的情况, 这样可以保持当前节点处于未计算状态, 在下一次反向dp再计算*/
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                }else{
                    /*这里要取三者最小值*/
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + 1);
                }
            }
        }
        /*右下到左上*/
        for(int i = mat.length - 1; i >= 0; i--){
            for(int j = mat[0].length - 1; j >= 0; j--){
                if(mat[i][j] == 0){
                    dp[i][j] = 0;
                }else if(i == mat.length - 1 && j == mat[0].length - 1){
                    /*不做任何处理*/
                }else if(i == mat.length - 1){
                    /*这里之所以要用上一个节点+1和当前节点作对比取最小是防止前面一个节点还没有求值的情况, 这样可以保持当前节点处于未计算状态, 在下一次反向dp再计算*/
                    dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
                }else if(j == mat[0].length - 1){
                    /*这里之所以要用上一个节点+1和当前节点作对比取最小是防止前面一个节点还没有求值的情况, 这样可以保持当前节点处于未计算状态, 在下一次反向dp再计算*/
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                }else{
                    /*这里要取三者最小值*/
                    dp[i][j] = Math.min(dp[i][j], dp[i][j+1] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j] + 1);
                }
            }
        }
        return dp;
    }
}
