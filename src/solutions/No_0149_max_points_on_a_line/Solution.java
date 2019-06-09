package solutions.No_0149_max_points_on_a_line;

import java.util.*;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * Example 1:
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 首先将所有的点放到一个map里面,以x:y作为key,点的个数作为value
 * 然后将这个map里面的点两两组合,分为y=ax+b和x=b两种情况,分别以a:b和:b两种形式作为key,注意a要用分数,并且要约分到最简,否则会出现由于精度丢失而判断错误的情况
 * 如果是相同的一条直线则将点加入到该直线的点集合中
 * 最后统计所有点集合的个数,返回最大的值即可
 */
public class Solution {
    public int maxPoints(int[][] points) {
        //如果没有点,直接返回0
        if(points.length == 0){
            return 0;
        }
        //直线到点的映射map,如果是y=ax+b形式的直线,以a:b为key,如果是x=b形式的直线,以:b为key
        Map<String,Set<String>> lineToPointsMap = new HashMap<>();
        //点到点个数的映射map,以x:y为key
        Map<String,Integer> pointsMap = new HashMap<>();
        for(int[] point:points){
            String key = point[0]+":"+point[1];
            pointsMap.put(key,pointsMap.containsKey(key)?pointsMap.get(key) + 1 : 1);
        }
        //如果点到点个数的映射map只有一个元素,说明所有点重合了,直接返回点个数即可
        if(pointsMap.size() == 1){
            return points.length;
        }
        String[] pointsMapKeyArray = new String[pointsMap.size()];
        int index = 0 ;
        for(String key : pointsMap.keySet()){
            pointsMapKeyArray[index++] = key;
        }
        for(int i = 0 ; i < pointsMapKeyArray.length - 1 ; i++){
            for(int j = i + 1 ; j < pointsMapKeyArray.length ; j++){
                int x1 = Integer.valueOf(pointsMapKeyArray[i].split(":")[0]);
                int y1 = Integer.valueOf(pointsMapKeyArray[i].split(":")[1]);
                int x2 = Integer.valueOf(pointsMapKeyArray[j].split(":")[0]);
                int y2 = Integer.valueOf(pointsMapKeyArray[j].split(":")[1]);
                String key ;
                //x=b的直线的情况
                if(x1 == x2){
                    key = ":"+x1;
                }
                //y=ax+b的情况
                else{
                    int gcd = gcd(x1-x2,y1-y2);
                    String a = (y1-y2)/gcd + "/" + (x1-x2)/gcd ;
                    String b = String.valueOf(y1 - (x1 * ((y1-y2)/gcd)/((x1-x2)/gcd)));
                    key = a + ":" +b;
                }
                if(!lineToPointsMap.containsKey(key)){
                    lineToPointsMap.put(key,new HashSet<>());
                    lineToPointsMap.get(key).add(x1+":"+y1);
                    lineToPointsMap.get(key).add(x2+":"+y2);
                }else{
                    lineToPointsMap.get(key).add(x1+":"+y1);
                    lineToPointsMap.get(key).add(x2+":"+y2);
                }
            }
        }
        int maxPointCount = 1;
        for(Set<String> set : lineToPointsMap.values()){
            int pointCount = 0 ;
            for(String key : set){
                pointCount += pointsMap.get(key);
            }
            if (pointCount > maxPointCount){
                maxPointCount = pointCount;
            }
        }
        return maxPointCount;
    }

    /**
     * 求两个数的最大公约数
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y){
        if(y == 0)
            return x;
        else
            return gcd(y,x%y);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxPoints(new int[][]{new int[]{1,1},new int[]{1,1},new int[]{2,2},new int[]{2,2}}));
    }
}
