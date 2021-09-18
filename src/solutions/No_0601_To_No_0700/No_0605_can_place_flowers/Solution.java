package solutions.No_0601_To_No_0700.No_0605_can_place_flowers;

/**
 * https://leetcode.com/problems/can-place-flowers/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: fal
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 题目意思是在n个屎坑里面种花, 数组代表屎坑, 1的代表已经种了花, 且有花的坑位隔壁不能种花
 * 解决思路其实也是贪心算法的思想, 尽可能利用坑位, 先种了再说, 后面发现前面的有种再拔掉
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int placeNum = 0;
        /*记录前一位置是否有种花*/
        boolean previousHasFlower = false;
        for(int i = 0; i < flowerbed.length; i++){
            /*如果当前位置没有种花*/
            if(flowerbed[i] == 0 ){
                if(!previousHasFlower){
                    placeNum++;
                    previousHasFlower = true;
                }else{
                    previousHasFlower = false;
                }
            }
            /*如果当前位置有种花且前一个位置有种花, 把前一个位置的拔掉*/
            if(flowerbed[i] == 1){
                if(previousHasFlower) {
                    placeNum--;
                }else{
                    previousHasFlower = true;
                }
            }
            /*如果已经能判断够位置种了, 直接返回*/
            if(placeNum >= n + 1){
                return true;
            }
        }
        return placeNum >= n;
    }
}
