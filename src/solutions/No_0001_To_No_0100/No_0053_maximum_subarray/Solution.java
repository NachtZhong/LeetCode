package solutions.No_0001_To_No_0100.No_0053_maximum_subarray;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 从第一个元素开始, 依次计算以该元素作为结束元素的最优和, 并存储起来
 * 比如[a,b,c,d,e,f,g]
 * 先计算以a为结尾的数组的最优解, 也就是只有[a]一个, 存储以a为结尾的数组的最优和
 * 然后计算以b为结尾的数组的最优解, 此时只需要比较(前一个最优和+b) 和(b)哪个最优即可得出以b元素结尾的最优和, 并存储以b为结尾的数组的最优和
 * 因为以b为结尾的只有前面的最优解+b和b两种情况, 只需要比较两者即可
 * 依次类推, 直到遍历完全部元素
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        /*整体最优和*/
        int maxSum = nums[0];
        /*以当前元素为结尾的情况下的最优和*/
        int currentSum = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            /*比较当前元素&前一个最优和加上当前元素的和  选出新的最优和*/
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            /*记录整体最优和*/
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-1,2}));
    }
}
