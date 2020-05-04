package solutions.No_0801_To_No_0900.No_0807_max_increase_to_keep_city_skyline;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 *
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well.
 * <p>
 * At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.
 * <p>
 * What is the maximum total sum that the height of the buildings can be increased?
 * <p>
 * Example:
 * Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * Output: 35
 * Explanation:
 * The grid is:
 * [ [3, 0, 8, 4],
 * [2, 4, 5, 7],
 * [9, 2, 6, 3],
 * [0, 3, 1, 0] ]
 * <p>
 * The skyline viewed from top or bottom is: [9, 4, 8, 7]
 * The skyline viewed from left or right is: [8, 7, 9, 3]
 * <p>
 * The grid after increasing the height of buildings without affecting skylines is:
 * <p>
 * gridNew = [ [8, 4, 8, 7],
 * [7, 4, 7, 7],
 * [9, 4, 8, 7],
 * [3, 3, 3, 3] ]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 先遍历, 找出各行各列的最大值, 然后一一对比即可
 */
public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[] xMax = new int[grid.length];
        int[] yMax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int max = grid[i][0];
            for (int j : grid[i]) {
                max = max < j ? j : max;
            }
            xMax[i] = max;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int max = grid[0][i];
            for (int[] j : grid) {
                max = max < j[i] ? j[i] : max;
            }
            yMax[i] = max;
        }
        System.out.println(Arrays.toString(xMax));
        System.out.println(Arrays.toString(yMax));

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result += Math.min(xMax[i], yMax[j]) - grid[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][4];
        int[] row1 = new int[]{3, 0, 8, 4};
        int[] row2 = new int[]{2, 4, 5, 7};
        int[] row3 = new int[]{9, 2, 6, 3};
        int[] row4 = new int[]{0, 3, 1, 0};
        grid[0] = row1;
        grid[1] = row2;
        grid[2] = row3;
        grid[3] = row4;
        System.out.println(new Solution().maxIncreaseKeepingSkyline(grid));
    }
}
