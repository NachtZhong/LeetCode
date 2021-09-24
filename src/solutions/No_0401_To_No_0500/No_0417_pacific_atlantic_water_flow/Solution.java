package solutions.No_0401_To_No_0500.No_0417_pacific_atlantic_water_flow;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Example 2:
 *
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 一个矩阵, 每个元素代表了其上陆地的高度, 在某块陆地上倒水, 水只能流向水位比其低的陆地, 左边和上边是太平洋, 右边和下边是大西洋, 求所有倒水既可以流到太平洋又可以流到大西洋的陆地坐标集合
 * 解题思路:
 * 从上往下的思想遍历, 分支太多, 判断太多, 逆向思维, 从能最终流向海洋的两条边向上深度遍历, 得出能流向两个大洋的陆地集合, 再取两者并集
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().pacificAtlantic(new int[][]{new int[]{10,10,10}, new int[]{10,1,10}, new int[]{10,10,10}});
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        /*处理边界条件*/
        if(heights.length == 0 || heights[0].length == 0){
            return new ArrayList<>();
        }
        /*左和上为太平洋*/
        int[][] pacificNodes = new int[heights.length][heights[0].length];
        /*对上边每个节点做dfs操作*/
        for(int i = 0; i < heights[0].length; i++){
            dfs(0, i, heights, pacificNodes);
        }
        /*对左边每个节点做dfs操作*/
        for(int i = 0; i < heights.length; i++){
            dfs(i, 0, heights, pacificNodes);
        }
        /*右和下为大西洋*/
        int[][] atlanticNodes = new int[heights.length][heights[0].length];
        /*对下边每个节点做dfs操作*/
        for(int i = 0; i < heights[0].length; i++){
            dfs(heights.length - 1, i, heights, atlanticNodes);
        }
        /*对右边每个节点做dfs操作*/
        for(int i = 0; i < heights.length; i++){
            dfs(i, heights[0].length - 1, heights, atlanticNodes);
        }
        /*取合集加入返回集合中*/
        List<List<Integer>> resultList = new ArrayList<>();
        for(int i = 0 ; i < heights.length ; i++){
            for(int j = 0 ; j < heights[0].length ; j++){
                if (pacificNodes[i][j] == 1 && atlanticNodes[i][j] == 1){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    resultList.add(list);
                }
            }
        }
        return resultList;
    }

    /**
     * 以某个节点为起点进行搜索, 将所有能流水到这个节点的节点记录到nodes中
     * @param i
     * @param j
     * @param heights
     * @param nodes
     */
    private void dfs(int i, int j, int[][] heights, int[][] nodes) {
        /*自己肯定可以, 先加入nodes*/
        nodes[i][j] = 1;
        /*左节点*/
        if(j - 1 >= 0 && heights[i][j -1] >= heights[i][j] && nodes[i][j - 1] != 1){
            dfs(i, j - 1, heights, nodes);
        }
        /*右节点*/
        if(j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j] && nodes[i][j + 1] != 1){
            dfs(i, j + 1, heights, nodes);
        }
        /*上节点*/
        if(i - 1 >= 0 && heights[i - 1][j] >= heights[i][j] && nodes[i - 1][j] != 1){
            dfs(i - 1, j, heights, nodes);
        }
        /*下节点*/
        if(i + 1 < heights.length && heights[i + 1][j] >= heights[i][j] && nodes[i + 1][j] != 1){
            dfs(i + 1, j, heights, nodes);
        }
    }


}
