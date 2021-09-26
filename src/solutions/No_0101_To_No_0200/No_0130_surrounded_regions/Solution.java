package solutions.No_0101_To_No_0200.No_0130_surrounded_regions;

/**
 * https://leetcode.com/problems/surrounded-regions/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * Example 2:
 *
 * Input: board = [["X"]]
 * Output: [["X"]]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 一个矩阵, 里面有O和X, 把全部没直接/间接连接到边上的O的O全部变成X, 就是走不到边上就被包围吃掉的意思
 * 解题思路:
 * 遍历矩阵的边界, 如果是O节点, 进行深度遍历, 记录白名单(和其直接或者间接相连的O不会被删除), 然后遍历除了边界之外的节点, 将所有不在白名单内的O变成X就行了
 */
public class Solution {
    public static void main(String[] args) {

    }

    public void solve(char[][] board) {
        /**
         * 数组中的元素为1代表已经被遍历过且被标记为不用清除
         */
        int[][] whiteLists = new int[board.length][board[0].length];

        /*上边界*/
        for(int j = 0 ; j < board[0].length ; j++){
            dfs(whiteLists, board, 0, j);
        }
        /*下边界*/
        for(int j = 0 ; j < board[0].length ; j++){
            dfs(whiteLists, board, board.length - 1, j);
        }
        /*左边界*/
        for(int i = 0 ; i < board.length ; i++){
            dfs(whiteLists, board, i, 0);
        }
        /*右边界*/
        for(int i = 0 ; i < board.length ; i++){
            dfs(whiteLists, board, i, board[0].length - 1);
        }

        /*处理剩下的节点*/
        for(int i = 1 ; i < board.length - 1 ; i++){
            for(int j = 1 ; j < board[0].length - 1 ; j++){
                if(board[i][j] == 'O' && whiteLists[i][j] != 1){
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 从当前节点开始深度遍历, 遍历过的节点添加到白名单
     * @param whiteLists
     * @param board
     * @param i
     * @param j
     */
    private void dfs(int[][] whiteLists, char[][] board, int i, int j) {
        if(i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == 'X' || whiteLists[i][j] == 1){
            return;
        }
        whiteLists[i][j] = 1;
        dfs(whiteLists, board, i - 1, j);
        dfs(whiteLists, board, i + 1, j);
        dfs(whiteLists, board, i, j - 1);
        dfs(whiteLists, board, i, j + 1);
    }
}
