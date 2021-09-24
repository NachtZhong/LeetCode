package solutions.No_0501_To_No_0600.No_0547_friend_circles;

/**
 * https://leetcode.com/problems/number-of-provinces/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 * Example 1:
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 一个矩阵, 元素为1时其纵坐标横坐标和纵坐标代表了第i个城市和第j个城市关联, 同时间接关联的也属于同一个圈子, 问一共有多少个圈子
 * 解题思路:
 * 深度搜索, 由提议不难看出, 每一行其实都代表了一个城市, 所以可以以行为单位开始遍历, 遍历出所有与之有关系的行直到没有任何其他行能与这个圈子关联, 遍历过的行记录在数组里避免重复遍历, 同时记录圈子数
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findCircleNum(new int[][]{new int[]{1,1,0}, new int[]{1,1,0}, new int[]{0,0,1}}));
    }
    public int findCircleNum(int[][] isConnected) {
        /*处理边界条件*/
        if(isConnected.length == 0 || isConnected[0].length == 0){
            return 0;
        }
        int circleCount = 0;
        /*数组第n个元素为1代表第n行已经被处理过了*/
        int[] countedCities = new int[isConnected.length];
        for(int i = 0; i < isConnected.length; i++){
            /*未处理过的才进行处理*/
            if(countedCities[i] != 1){
                dfs(isConnected, countedCities, i);
                circleCount += 1;
            }
        }
        return circleCount;
    }

    /**
     * 判断某个城市和其他城市的关联情况, 有关联的记录在数组说明已经统计过圈子即可
     * @param countedCities
     * @param i
     * @return
     */
    private void dfs(int[][] isConnected,int[] countedCities, int i) {
        countedCities[i] = 1;
        for(int n = 0 ; n < isConnected[i].length; n++){
            /*自己和自己关联的不统计*/
            if(n != i){
                /*第n个元素为1, 说明和第n行有关联, 同时要过滤掉已经关联过的城市*/
                if(isConnected[i][n] == 1 && countedCities[n] != 1){
                    dfs(isConnected, countedCities, n);
                }
            }
        }
    }

}
