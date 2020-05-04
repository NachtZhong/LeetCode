package solutions.No_0001_To_No_0100.No_0054_spiral_matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * Example 1:
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 向右=>向下=>向左=>向上的顺序遍历
 * 如果到了边界或者已经遍历过的点就改变方向
 * 如果改变方向后下一个点还是已经遍历过的点则完成遍历
 */
public class Solution {
    private final static int GORIGHT = 0;
    private final static int GODOWN = 1;
    private final static int GOLEFT = 2;
    private final static int GOUP = 3;
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 ){
            return new ArrayList<>();
        }
        if(matrix.length == 1){
            List<Integer> list = new ArrayList<>();
            for(int num:matrix[0]){
                list.add(num);
            }
            return list;
        }
        if(matrix[0].length == 1){
            List<Integer> list = new ArrayList<>();
            for(int[] nums:matrix){
                list.add(nums[0]);
            }
            return list;
        }
        int currentDirection = Solution.GORIGHT;
        List<Integer> resultList = new ArrayList<>();
        Set<String> addedPoints = new HashSet<>();
        int i = 0 ;
        int j = 0 ;
        while(0 == 0){
            if(addedPoints.contains(String.valueOf(i)+String.valueOf(j))){
                break;
            }
            resultList.add(matrix[i][j]);
            addedPoints.add(String.valueOf(i)+String.valueOf(j));
            if(currentDirection == GORIGHT){
                if(j == matrix[0].length -1 || addedPoints.contains(String.valueOf(i)+String.valueOf(j+1))){
                    i++;
                    currentDirection = GODOWN;
                }else{
                    j++;
                }
            }else if(currentDirection == GODOWN){
                if(i == matrix.length -1 || addedPoints.contains(String.valueOf(i+1)+String.valueOf(j))){
                    j--;
                    currentDirection = GOLEFT;
                }else{
                    i++;
                }
            }else if(currentDirection == GOLEFT){
                if(j == 0 || addedPoints.contains(String.valueOf(i)+String.valueOf(j-1))){
                    i--;
                    currentDirection = GOUP;
                }else {
                    j--;
                }
            }else{
                if(i == 0 || addedPoints.contains(String.valueOf(i-1)+String.valueOf(j))){
                    j++;
                    currentDirection = GORIGHT;
                }else {
                    i--;
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{1,2,3};
//        int[] b = new int[]{4,5,6};
//        int[] c = new int[]{7,8,9};
//        int[][] d = new int[3][3];
//        d[0] = a;
//        d[1] = b;
//        d[2] = c;
        int[][] d = new int[1][1];
        d[0][0] = 1;
        System.out.println(new Solution().spiralOrder(d));
    }
}
