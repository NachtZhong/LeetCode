package solutions.No_0401_To_No_0500.No_0452_burst_ballons;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 *
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 *
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * Example 2:
 *
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 * Example 3:
 *
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 我来用人话翻译一下: 每个区间视为一个气球, 可以打出一个点, 视为一支箭, 落在气球的区间里面就视为将气球射爆, 怎么用最少的箭射爆所有的气球
 * 也是贪心算法的思想, 首先将所有的区间按左边界点-右边界点的优先级排序, 然后从第一个区间开始射箭, 第一支箭在射中第一个区间的基础上, 尽量多射中几个区间, 直到实在无法射到下一个区间为止, 这个思路一直处理所有的区间, 就能得出最小的箭的数量
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findMinArrowShots(new int[][]{new int[]{10,16}, new int[]{2,8}, new int[]{1,6}, new int[]{7,12}                    }));
        System.out.println(new Solution().findMinArrowShots(new int[][]{new int[]{-2147483646,-2147483645}, new int[]{2147483646,2147483647}          }));
    }

    public int findMinArrowShots(int[][] points) {
        if(points.length <= 1){
            return points.length;
        }
        /*对气球进行排序*/
        sortBallons(points);
        int arrowsCount = 1;
        /*第一支箭的区间取第一个气球的区间*/
        int arrowBeginIndex = points[0][0];
        int arrowEndIndex = points[0][1];
        for(int nextBallonIndex = 1; nextBallonIndex < points.length; nextBallonIndex++){
            int targetBeginIndex = points[nextBallonIndex][0];
            int targetEndIndex = points[nextBallonIndex][1];
            if(arrowEndIndex < targetBeginIndex){
                /*如果箭的范围无法射中下一个区间, 新射一支箭*/
                arrowsCount++;
                arrowBeginIndex = targetBeginIndex;
                arrowEndIndex = targetEndIndex;
            }else{
                /*如果箭的范围能射中下一个区间, 取交集作为新的箭的范围, 在这个范围内能射中更多的气球*/
                arrowBeginIndex = Math.max(arrowBeginIndex, targetBeginIndex);
                arrowEndIndex = Math.min(arrowEndIndex, targetEndIndex);
            }
        }
        return arrowsCount;
    }

    private void sortBallons(int[][] points){
        Arrays.sort(points, (o1, o2) ->  {
            if(o1[0] > o2[0]){
                return 1;
            }
            if(o1[0] == o2[0]){
                if(o1[1] > o2[1]){
                    return 1;
                }
                if(o1[1] == o2[1]){
                    return 0;
                }
                return -1;
            }
            return -1;
        });
    }

}
