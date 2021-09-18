package solutions.No_0001_To_No_0100.No_0075_sort_colors;

/**
 * https://leetcode.com/problems/sort-colors/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 各大排序算法实现
 */
public class Solution {
    public void sortColors(int[] nums) {
        this.insertSort(nums);
    }

    /**
     * 插入排序
     * 1. 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 2. 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     * @param arr
     */
    private void insertSort(int[] arr) {
        /*第一个元素默认是有序, 从第二个元素开始处理*/
        for(int i = 1; i < arr.length ; i++){
            int tmp = arr[i];
            /*从右往左, 如果判断的元素比当前元素大, 右移一位, 如果到了最左一个数还要右移, 把最左的位置设为当前元素*/
            for(int j = i - 1 ; j >= 0 ; j--){
                if(arr[j] >= tmp){
                    arr[j + 1] = arr[j];
                    if(j ==0){
                        arr[0] = tmp;
                    }
                }else{
                    arr[j + 1] = tmp;
                    break;
                }
            }
        }
    }

    /**
     * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3. 针对所有的元素重复以上的步骤，除了最后一个。
     * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param arr
     */
    public void bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length - 1 ; i++){
            /*增加标志位, 如果单次循环没有发生交换, 说明数组已经有序, 不用继续排序, 重要优化思路*/
            boolean flag = true;
            for(int j = 0 ; j < arr.length - 1 - i ; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    /**
     * 1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 2. 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 3. 重复第二步，直到所有元素均排序完毕。
     * @param arr
     */
    public void selectSort(int[] arr){
        for(int i = 0 ; i < arr.length - 1 ; i++){
            int min = arr[i];
            int minIndex = i;
            for(int j = i + 1 ; j < arr.length ; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = min;
            arr[minIndex] = tmp;
        }
    }
}
