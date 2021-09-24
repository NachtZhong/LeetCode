package solutions.No_0001_To_No_0100.No_0079_word_search;

/**
 * https://leetcode.com/problems/word-search/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 给一个矩阵, 一个元素是一个字母, 看矩阵里面是否能找到需要的词(上下左右相邻连续的元素能否组成这个词)
 * 解题思路:
 * 深度优先搜索, 先遍历整个矩阵, 第一个字母和要求的word第一个字母相同就开始深度遍历这个元素, 要注意的是遍历的过程中要给已经遍历过的字母打上便签, 防止遍历到下一个字母又回头遍历, 遍历完之后又要去掉标签, 其实是回溯法
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{new char[]{'a', 'b'}}, "ab"));
    }

    public boolean exist(char[][] board, String word) {
        /*处理边界条件*/
        if(board.length == 0 || board[0].length == 0 || board.length * board[0].length < word.length()){
            return false;
        }
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(dfs(i, j, board, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断从(i,j)位置的元素开始是否能找到一个路径, 使得这个路径上面的字符和word从wordIndex开始到结尾的子串相等
     * @param i
     * @param j
     * @param board
     * @param word
     * @param wordIndex
     * @return
     */
    private boolean dfs(int i, int j, char[][] board, String word, int wordIndex) {
        /*第一个都匹配不上已经遍历就回家睡觉觉*/
        if(board[i][j] != word.charAt(wordIndex)){
            return false;
        }
        /*如果已经到了最后一个字母, 匹配上了就ok了*/
        if(wordIndex == word.length() - 1){
            return true;
        }
        /*如果没到最后一个字母, 继续深度遍历上下左右节点, 有匹配就返回true, 没有就返回false, 注意这里要先去掉当前位置的元素, 避免重复遍历*/
        /*先去掉当前节点的字符, 避免重复匹配*/
        char tmp = board[i][j];
        board[i][j] = '1';
        /*上节点*/
        if(i - 1 >= 0 && dfs(i - 1, j, board, word, wordIndex + 1)){
            return true;
        }
        /*下节点*/
        if(i + 1 <= board.length - 1 && dfs(i + 1, j, board, word, wordIndex + 1)){
            return true;
        }
        /*左节点*/
        if(j - 1 >= 0 && dfs(i, j - 1, board, word, wordIndex + 1)){
            return true;
        }
        /*右节点*/
        if(j + 1 <= board[0].length - 1 && dfs(i, j + 1, board, word, wordIndex + 1)){
            return true;
        }
        /*恢复当前节点的字符*/
        board[i][j] = tmp;
        return false;
    }
}
