package solutions.No_0001_To_No_0100.No_0051_n_queens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 * Example 2:
 *
 * Input: n = 1
 * Output: [["Q"]]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 有个N*N的棋盘, 要在里面放N个皇后, 返回所有可能的摆法
 * 解题思路:
 * 由于要放n个皇后, 所以每一行必定有一个, 不然无法满足不会相互攻击的条件
 * 因此, 只需要遍历第一行, 然后针对每个点放皇后的情况进行深度遍历即可, 要注意放了一个皇后之后, 要将其攻击范围缓存起来, 作为下一个落点的参考依据(横, 竖, 斜, 通过y = ax + b的方式记录, 所以只需要记录a和b就行)
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(1));
    }

    public List<List<String>> solveNQueens(int n) {
        /*处理边界条件*/
        if(n == 0){
            return new ArrayList<>();
        }
        if(n == 1){
            return Collections.singletonList(Collections.singletonList("Q"));
        }
        /*返回结果*/
        List<List<String>> result = new ArrayList<>();
        /*用于记录当前有那些线不能再放置皇后*/
        List<int[]> forbidAreaExpressions = new ArrayList<>();
        /*放置记录, 第i个元素代表第i行的皇后被放在了第placeHistory[i]的位置*/
        int[] placeHistory = new int[n];
        /*从第0行开始放置*/
        dfs(0, result, forbidAreaExpressions, placeHistory, n);
        return result;
     }

    /**
     * 从第i行开始放置, 放置受到forbidAreaExpressions限制, 放置成功后加入placeHistory中
     * @param i
     * @param result
     * @param forbidAreaExpressions
     * @param placeHistory
     * @param n
     */
    private void dfs(int i, List<List<String>> result, List<int[]> forbidAreaExpressions, int[] placeHistory, int n) {
        /*走到了尽头, 将结果加入结果集*/
        if(i == n){
            List<String> list = new ArrayList<>();
            for(int j = 0 ; j < n ; j ++){
                String s = "";
                for(int k = 0 ; k < n ; k++){
                    s += k == placeHistory[j] ? "Q" : ".";
                }
                list.add(s);
            }
            result.add(list);
        }

        for(int j = 0 ; j < n ; j++){
            /*能通过之前所有的表达式验证就放在当前位置*/
            if(canPlaceInLocation(i, j, forbidAreaExpressions)){
                placeHistory[i] = j;
                /*y = j不行*/
                forbidAreaExpressions.add(new int[]{0, j});
                /*y = x + j - i不行*/
                forbidAreaExpressions.add(new int[]{1, j - i});
                /*y = -x + j + i不行*/
                forbidAreaExpressions.add(new int[]{-1, j + i});
                dfs(i + 1, result, forbidAreaExpressions, placeHistory, n);
                /*这个节点处理过后删除原有的限制*/
                forbidAreaExpressions.remove(forbidAreaExpressions.size() - 1);
                forbidAreaExpressions.remove(forbidAreaExpressions.size() - 1);
                forbidAreaExpressions.remove(forbidAreaExpressions.size() - 1);
            }
        }
    }

    /**
     * 判断某个节点是否在限制区域之外
     * @param i
     * @param j
     * @param forbidAreaExpressions
     * @return
     */
    private boolean canPlaceInLocation(int i, int j, List<int[]> forbidAreaExpressions) {
        for(int[] ab : forbidAreaExpressions){
            int a = ab[0];
            int b = ab[1];
            if(i * a + b == j){
                return false;
            }
        }
        return true;
    }
}
