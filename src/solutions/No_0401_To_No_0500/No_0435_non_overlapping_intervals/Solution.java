package solutions.No_0401_To_No_0500.No_0435_non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * Example 1:
 *
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * Example 2:
 *
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 * Example 3:
 *
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * Constraints:
 *
 * 1 <= intervals.length <= 105
 * intervals[i].length == 2
 * -5 * 104 <= starti < endi <= 5 * 104
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题目要求:
 * 比如[[1,2],[2,3],[3,4],[1,3]], 去掉其中的n个区间, 使得剩下的区间互不重叠, 最少去掉n个能满足要求
 * 解题思路:
 * 贪心算法, 先将区间做排序, 排序优先级为区间左边点-区间右边点
 * 然后从第一个区间开始, 判断下一个区间与之是否有重叠, 如果有重叠, 直接去掉下一个区间, 因为下一个区间右边界必然大于或者等于当前区间的右边界, 这样留给下一个区间的空间就较小了
 * 这里思路就是利用贪心算法, 尽可能的为后面区间争取更大的空间, 这样需要去除的区间数自然就是最小了
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().eraseOverlapIntervals(new int[][]{new int[]{0,2}, new int[]{1,3}, new int[]{3,5}, new int[]{2,4}, new int[]{4,6}}));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        sortIntervals(intervals);
        for(int[] interval : intervals){
            System.out.println(Arrays.toString(interval));
        }
        int eraseCount = 0;
        int currentIntervalIndex = 0;
        for(int nextIntervalIndex = 1; nextIntervalIndex < intervals.length; nextIntervalIndex++){
            int[] currentInterval = intervals[currentIntervalIndex];
            int[] nextInterval = intervals[nextIntervalIndex];
            /*如果两个区间没有相交, 跳过*/
            if(nextInterval[0] >= currentInterval[1]){
                currentIntervalIndex = nextIntervalIndex;
                continue;
            }
            /*如果两个区间有相交, 去除右边界比较大的区间, 这里的判断是如果next区间右边界小, 就去掉current区间, 取next区间作为新的current区间*/
            if(nextInterval[1] <= currentInterval[1]){
                currentIntervalIndex = nextIntervalIndex;
            }
            eraseCount++;
        }
        return eraseCount;
    }

    /**
     * 区间按左区间点-右区间点排序
     * @param intervals
     */
    public void sortIntervals(int[][] intervals){
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
    }

}


