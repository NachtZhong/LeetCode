package solutions.No_0001_To_No_0100.No_0037_sudoku_solver;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [['5','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']]
 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is shown below:
 * <p>
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 数独填空
 * 解题思路:
 * 先遍历依次矩阵, 记录每一行已用, 每一列已用, 每一格已用数字
 * 然后用dfs+回溯给每一行填数
 */
public class Solution {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new Solution().solveSudoku(board);
        System.out.println("");
    }

    public void solveSudoku(char[][] board) {
        /*记录每行已经用的情况*/
        int[][] lineUsage = new int[9][9];
        /*记录每列已经用的情况*/
        int[][] columnUsage = new int[9][9];
        /*记录每个格子已经用的情况*/
        int[][] boxUsage = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value != '.') {
                    /*记录使用情况*/
                    lineUsage[i][value - '1'] = 1;
                    columnUsage[j][value - '1'] = 1;
                    boxUsage[(i / 3) * 3 + j / 3][value - '1'] = 1;
                }
            }
        }
        /*从第一个位置开始dfs填数*/
        dfs(board, lineUsage, columnUsage, boxUsage, 0, 0);
    }

    /**
     * 处理矩阵的第i行, 从每行的第j个位置开始填数
     * @param board
     * @param lineUsage
     * @param columnUsage
     * @param boxUsage
     * @param i
     * @param j
     * @return
     */
    private boolean dfs(char[][] board, int[][] lineUsage, int[][] columnUsage, int[][] boxUsage, int i, int j) {
        /*j走到了右边界*/
        if (j == 9) {
            /*开始走下一行*/
            j = 0;
            i++;
            /*走到了最后一位, 说明已经搞定了, 返回true*/
            if(i == 9) {
                return true;
            }
        }
        /*没填数的才填数*/
        int value = board[i][j];
        if (value == '.') {
            /*尝试填数*/
            for (char l = '1'; l <= '9'; l++) {
                if (lineUsage[i][l - '1'] == 0 && columnUsage[j][l - '1'] == 0 && boxUsage[(i / 3) * 3 + j / 3][l - '1'] == 0) {
                    board[i][j] = l;
                    lineUsage[i][l - '1'] = 1;
                    columnUsage[j][l - '1'] = 1;
                    boxUsage[(i / 3) * 3 + j / 3][l - '1'] = 1;
                    /*dfs填下面的数, 成功了就返回*/
                    if (dfs(board, lineUsage, columnUsage, boxUsage, i, j + 1)) {
                        return true;
                    } else {
                        /*失败了就回滚进行下一次循环*/
                        board[i][j] = '.';
                        lineUsage[i][l - '1'] = 0;
                        columnUsage[j][l - '1'] = 0;
                        boxUsage[(i / 3) * 3 + j / 3][l - '1'] = 0;
                    }
                }
            }
            return false;
        }
        return dfs(board, lineUsage, columnUsage, boxUsage, i, j + 1);
    }
}
