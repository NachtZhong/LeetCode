package solutions.No_1001_To_No_1100.No_1029_two_city_scheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/two-city-scheduling/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 *
 *
 * Example 1:
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 *
 * Note:
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 一个二维数组, 分别记录了每个人到A和到B两个城市所需要的花费, 在满足每个城市分配相同的人的前提下求最小花费之和
 * 解题思路:
 * 先遍历整个数组, 记录未满足[每个城市分配相同的人]这个前提下的最小花费(也就是每一个人到A和B两个城市中的最小花费之和), 并记录如果将这个人转为另一个城市所需要的多余的花费
 * 然后判断分配到两个城市的人是否相等
 * 如果不相等的话, 要将分配的人比较多的那个城市的人转移一部分到分配的人比较少的那个城市
 * 此时将分配的人比较多的城市所记录的每一个转移到另外一个城市所需的多余的花费从小到大排序, 从小到大取转移人数的数量个元素, 加到结果即可(优先转移从一个城市到另一个城市所需花费小的人)
 */
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int totalCost = 0;
        List<Integer> cityAChangeToCityBCharges = new ArrayList<>();
        List<Integer> cityBChangeToCityACharges = new ArrayList<>();
        for(int[] cost : costs){
            if(cost[0] < cost[1]){
                totalCost += cost[0];
                cityAChangeToCityBCharges.add(cost[1] - cost[0]);
            }else{
                totalCost += cost[1];
                cityBChangeToCityACharges.add(cost[0] - cost[1]);
            }
        }
        /*A城市的人比较多*/
        if(cityAChangeToCityBCharges.size() > cityBChangeToCityACharges.size()){
            Collections.sort(cityAChangeToCityBCharges);
            for(int i = 0 ; i < (cityAChangeToCityBCharges.size() - cityBChangeToCityACharges.size()) / 2; i++){
                totalCost += cityAChangeToCityBCharges.get(i);
            }
        }
        /*B城市的人比较多*/
        if(cityAChangeToCityBCharges.size() < cityBChangeToCityACharges.size()){
            Collections.sort(cityBChangeToCityACharges);
            for(int i = 0 ; i < (cityBChangeToCityACharges.size() - cityAChangeToCityBCharges.size()) / 2; i++){
                totalCost += cityBChangeToCityACharges.get(i);
            }
        }
        return totalCost;
    }
}
