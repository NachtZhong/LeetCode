package solutions.No_0001_To_No_0100.No_0015_3sum;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 先将数组排序
 * 用一个set存储已经处理过的数字, 如果是相同的数字直接不处理, 跳到下一个数字
 * 对数组中的每一个元素,在剩下元素的两边开始向中间遍历, 寻找适合与该元素和为0的两个元素
 * 对求出来的和加以利用,通过判断和比0大还是比0小来判断移动左边指针还是右边指针
 * 然而还是tm的在后5%
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Set<Integer> judgedNumSet = new HashSet<>();
        Arrays.sort(nums);
        for(int index = 0 ; index < nums.length -2 ; index++){
            if(judgedNumSet.contains(nums[index])){
                continue ;
            }
            int leftIndex = index + 1;
            int rightIndex = nums.length -1;
            while(leftIndex < rightIndex){
                int sum = nums[index] + nums[leftIndex] + nums[rightIndex];
                if (sum == 0 ){
                    List list = new ArrayList();
                    list.add(nums[index]);
                    list.add(nums[leftIndex]);
                    list.add(nums[rightIndex]);
                    if (!resultList.contains(list)){
                        resultList.add(list);
                    }
                    leftIndex++;
                    rightIndex--;
                }else if(sum < 0 ){
                    leftIndex ++;
                }else{
                    rightIndex --;
                }
            }
            judgedNumSet.add(nums[index]);
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4,-1}));
    }
}
