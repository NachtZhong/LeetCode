package solutions.No_1301_To_No_1400.No_1395_count_number_of_teams;

/**
 * https://leetcode.com/problems/count-number-of-teams/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 * <p>
 * You have to form a team of 3 soldiers amongst them under the following rules:
 * <p>
 * Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
 * A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 * Example 1:
 * Input: rating = [2,5,3,4,1]
 * Output: 3
 * Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
 * Example 2:
 * Input: rating = [2,1,3]
 * Output: 0
 * Explanation: We can't form any team given the conditions.
 * Example 3:
 * Input: rating = [1,2,3,4]
 * Output: 4
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 从第二个数开始 遍历到倒数第二个数
 * 1. 统计出在该数左边区间内比它小的数的个数, 右边区间比它大的数的个数
 * 2. 统计出在该数左边区间内比它大的数的个数, 右边区间比它小的数的个数
 * 两者相加即可得到以当前数为中间数的team的个数
 * 将各个元素满足条件的team个数相加即可得到结果
 */
public class Solution {
    public int numTeams(int[] rating) {
        int totalTeamCount = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int leftSmallerNumCount = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftSmallerNumCount++;
                }
            }
            int rightLargerNumCount = 0;
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > rating[i]) {
                    rightLargerNumCount++;
                }
            }
            int incrementTeamCount = leftSmallerNumCount * rightLargerNumCount;
            int leftLargerNumCount = i - leftSmallerNumCount;
            int rightSmallerNumCount = rating.length - 1 - i - rightLargerNumCount;
            int decrementTeamCount = leftLargerNumCount * rightSmallerNumCount;
            totalTeamCount = totalTeamCount + incrementTeamCount + decrementTeamCount;
        }
        return totalTeamCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTeams(new int[]{2,5,3,4,1}));
    }
}
