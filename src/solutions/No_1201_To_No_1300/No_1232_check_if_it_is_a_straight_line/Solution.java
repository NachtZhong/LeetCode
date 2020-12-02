package solutions.No_1201_To_No_1300.No_1232_check_if_it_is_a_straight_line;

/**
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 根据前面两个点判断出直线y=kx+b的k和b的值, 之后遍历所有的点判断是否符合直线方程即可
 * y1 = kx1+b, y2=kx2+b
 * k = (y1 - y2)/(x1-x2)
 * b = y1 - x1 * k
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2){
            return true;
        }
        double x1  = coordinates[0][0];
        double y1 = coordinates[0][1];
        double x2 = coordinates[1][0];
        double y2 = coordinates[1][1];
        /*如果是x=b的情况, 直接判断横坐标是否相等即可, 不能计算k, 不然会因为除0报错*/
        if(x1 == x2){
            for (int i = 2; i < coordinates.length; i++) {
                double x = coordinates[i][0];
                if (x != x1) {
                    return false;
                }
            }
            return true;
        }else {
            double k = (y1 - y2) / (x1 - x2);
            double b = y1 - x1 * k;
            for (int i = 2; i < coordinates.length; i++) {
                double x = coordinates[i][0];
                double y = coordinates[i][1];
                if (x * k + b != y) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkStraightLine(new int[][]{new int[]{2,1},new int[]{4,2}, new int[]{6,3}}));
    }
}
