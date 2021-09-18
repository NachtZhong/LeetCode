package solutions.No_0001_To_No_0100.No_0055_jump_game;

/**
 * https://leetcode.com/problems/jump-game/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 一个数组, 每一个元素表示了在当前位置可以跳的范围, 要求写一个函数判断能否找到路线从第一个位置跳到最后一个位置
 * 解题思路:
 * 经典贪心算法, 每一步都保证自己跳的下一步有着最远的可跳范围, 最终就能得出可以跳到的最远范围, 如果这个最远可跳范围比最后一个元素要大, 则说明可以从第一个元素跳到最后一个元素
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2,3,1,1,4}));
    }

    public boolean canJump(int[] nums) {
        /*处理边界条件*/
        if(nums.length <= 1){
            return true;
        }
        /*预处理, 该数组代表每个位置能跳到的最远index*/
        int[] maxDistances = new int[nums.length];
        for(int j = 0; j < nums.length; j++){
            maxDistances[j] = j + nums[j];
        }
        /*从index为0位置开始*/
        int i = 0;
        int longestDistance = maxDistances[0];
        /*i <= longestDistance => 代表已经走到了能走到的最远位置, 如果还没有出现新的更远位置, 说明已经到了最远的极限了*/
        /*longestDistance <= nums.length - 1 => 如果能走到nums.length - 1这个位置, 说明已经符合要求, 不用继续走下去了*/
        while(i <= longestDistance && longestDistance <= nums.length - 1){
            /*如果当前这一步能走到比上一步更远, 取当前这个位置能走到的最远位置作为新的最远位置*/
            if(maxDistances[i] > longestDistance){
                longestDistance = maxDistances[i];
            }
            i++;
        }
        return longestDistance >= nums.length - 1;
    }
}
