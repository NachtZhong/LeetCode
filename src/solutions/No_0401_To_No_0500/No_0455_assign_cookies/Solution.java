package solutions.No_0401_To_No_0500.No_0455_assign_cookies;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 *
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 * Example 1:
 *
 * Input: g = [1,2,3], s = [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 * Example 2:
 *
 * Input: g = [1,2], s = [1,2,3]
 * Output: 2
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 贪心算法, 思路是优先用饱腹值最小的饼干满足饥饿度最小的孩子, 这样可以满足尽量多的孩子
 * 1. 两个数组排序
 * 2. 从小到大遍历右边的饼干数组, 从小到大遍历左边的孩子数组, 满足饥饿度则两边指针都向后移, 不满足则饼干数组指针向后移, 记录下能满足的孩子个数
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        /*两种情况, 不能满足 -> cookie指针后移, 能满足 -> child指针后移, cookie指针后移*/
        while (child < g.length && cookie < s.length){
            if(s[cookie++] >= g[child]){
                child ++;
            }
        }
        return child;
    }
}
