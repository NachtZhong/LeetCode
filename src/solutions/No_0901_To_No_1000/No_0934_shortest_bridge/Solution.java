package solutions.No_0901_To_No_1000.No_0934_shortest_bridge;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/shortest-bridge/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * In a given 2D binary array grid, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 * Example 1:
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * Constraints:
 * 2 <= grid.length == grid[0].length <= 100
 * grid[i][j] == 0 or grid[i][j] == 1
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 一个矩阵, 0代表海洋, 1代表陆地, 相连的陆地称为一个岛屿, 已知矩阵中共有两个岛屿, 求两个岛屿之间的最短路径长
 * 解题思路:
 * 先用DFS深度遍历找到第一个岛屿, 然后针对第一个岛屿的每一个节点, 进行广度优先遍历, 遍历过程中第一次触碰到第二个岛屿时的路径长度就是最短的路径长度, 注意遍历过的陆地或者海洋要打上标记, 避免重复遍历
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestBridge(new int[][]{new int[]{0, 1, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 1}}));
    }
    public int shortestBridge(int[][] grid) {
        /*题目明确指出肯定有两个岛屿, 矩阵长和宽大于等于2, 所以这里不做边界条件判断*/
        /*记录是否找到了第一个岛屿*/
        boolean hasFound = false;
        /*记录第一个岛屿周围的海洋点坐标*/
        ArrayDeque<int[]> points = new ArrayDeque<>();
        for(int i = 0 ; i < grid.length; i++){
            if(!hasFound) {
                for (int j = 0; j < grid[0].length; j++) {
                    /*如果找到了陆地节点, 对其进行深度遍历, 将其相邻的所有海洋节点加入到海洋点队列里面*/
                    if(grid[i][j] == 1){
                        dfs(grid, points, i, j);
                        hasFound = true;
                        break;
                    }
                    /*一开始走过的海洋节点其实都可以排除在最短路径之外, 就算可以作为最短路径选择之一, 也必定会有替代的路径, 所以在找到第一个岛屿之前的海洋节点在此全部标记为已遍历*/
                    grid[i][j] = 2;
                }
            }
        }
        /*代表已经进行搜索的次数, 最终也就是路径的最短长度*/
        int pathLength = 0;
        while(!points.isEmpty()){
            pathLength ++;
            int currentSize = points.size();
            for(int i = 0; i < currentSize; i++){
                int[] point = points.poll();
                if(bfs(grid, points, point)){
                    return pathLength;
                }
            }
        }
        return pathLength;
    }

    /**
     * 判断某个节点隔壁是否为第二个岛屿, 如果是, 返回true, 如果没有, 将该节点周围的节点加入到队列中, 以进行下一层遍历
     * @param grid
     * @param points
     * @param point
     * @return
     */
    private boolean bfs(int[][] grid, ArrayDeque<int[]> points, int[] point) {
        int i = point[0], j = point[1];
        int value;
        /*上节点*/
        if(i - 1 >= 0){
            value = grid[i - 1][j];
            /*如果找到陆地直接返回*/
            if(value == 1){
                return true;
            }
            /*如果找到海洋节点加入队列并标记*/
            if(value == 0){
                grid[i - 1][j] = 2;
                points.offer(new int[]{i - 1, j});
            }
        }
        /*下节点*/
        if(i + 1 < grid.length){
            value = grid[i + 1][j];
            /*如果找到陆地直接返回*/
            if(value == 1){
                return true;
            }
            /*如果找到海洋节点加入队列并标记*/
            if(value == 0){
                grid[i + 1][j] = 2;
                points.offer(new int[]{i + 1, j});
            }
        }
        /*左节点*/
        if(j - 1 >= 0){
            value = grid[i][j - 1];
            /*如果找到陆地直接返回*/
            if(value == 1){
                return true;
            }
            /*如果找到海洋节点加入队列并标记*/
            if(value == 0){
                grid[i][j - 1] = 2;
                points.offer(new int[]{i, j - 1});
            }
        }
        /*右节点*/
        if(j + 1 < grid[0].length){
            value = grid[i][j + 1];
            /*如果找到陆地直接返回*/
            if(value == 1){
                return true;
            }
            /*如果找到海洋节点加入队列并标记*/
            if(value == 0){
                grid[i][j + 1] = 2;
                points.offer(new int[]{i, j + 1});
            }
        }
        return false;
    }

    /**
     * 深度遍历找到所有陆地节点, 并将其隔壁的海洋节点加入队列
     * @param grid
     * @param arrayDeque
     * @param i
     * @param j
     */
    private void dfs(int[][] grid, ArrayDeque<int[]> arrayDeque, int i, int j) {
        /*如果超出边界或者已经遍历过, 不再处理直接返回*/
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 2){
            return;
        }
        /*如果是第一个岛屿周围的海洋节点*/
        if(grid[i][j] == 0){
            arrayDeque.offer(new int[]{i, j});
            grid[i][j] = 2;
            return;
        }
        /*0和2都排除了, 剩下的就是陆地节点, 陆地节点就需要继续对其周围的节点进行遍历*/
        grid[i][j] = 2;
        dfs(grid, arrayDeque, i - 1, j);
        dfs(grid, arrayDeque, i + 1, j);
        dfs(grid, arrayDeque, i, j - 1);
        dfs(grid, arrayDeque, i, j + 1);

    }
}
