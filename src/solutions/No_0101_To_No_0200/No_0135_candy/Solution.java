package solutions.No_0101_To_No_0200.No_0135_candy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/candy/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * Example 1:
 *
 * Input: ratings = [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 * Example 2:
 *
 * Input: ratings = [1,2,2]
 * Output: 4
 * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 * The third child gets 1 candy because it satisfies the above two conditions.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 贪心算法
 * 题目意思为, 给一个数组, 代表每个小孩子的权重, 然后给他们分糖(至少一颗), 要求权重高的分的糖至少比权重低邻居(注意是相邻的)的分的糖多1颗, 相同权重的可以不一样
 * 思路就是从左到右先遍历一遍, 先处理右边比左边权重大的情况, 如果右边比左边大, 分的糖设置为左边+1
 * 然后从右到左遍历一遍, 处理左边比右边权重大的情况, 如果左边比右边大, 分的糖设置为右边+1
 * 问: 会不会第二次遍历破坏第一次有序性?
 * 不会, 第一次遍历已经确保每个元素得到的糖果数量都会比左边比它权重小元素的糖果数量大, 第二次遍历对于这个元素来说, 如果它比右边的权重大, 只会变得更大, 不会比左边的小
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{1,3,4,5,2}));
    }

    public int candy(int[] ratings) {
        /*如果只有一个小孩子, 给他一颗糖已经可以很满足了。*/
        if(ratings.length == 1){
            return 1;
        }
        /*糖果数组, 全部初始化为0, 最后求和再加上n个candies, 省一次遍历时间*/
        int[] candies = new int[ratings.length];
        /*第一次遍历, 确保右边比左边权重大的糖果数大1*/
        for(int i = 0; i < ratings.length - 1; i++){
            if(ratings[i + 1] > ratings[i] && candies[i + 1] <= candies[i]){
                candies[i + 1] = candies[i] + 1;
            }
        }
        /*第二次遍历, 确保左边比右边权重大的糖果数大1, 同时求和, 省一次遍历求和时间*/
        int sum = 0;
        for(int i = ratings.length - 1; i > 0; i--){
            if(ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]){
                candies[i - 1] = candies[i] + 1;
            }
            sum += candies[i];
        }
        sum += candies[0];
        return sum + candies.length;
    }
}
