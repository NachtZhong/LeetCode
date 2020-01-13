package solutions.No_0860_lemonade_change;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lemonade-change/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * At a lemonade stand, each lemonade costs $5.
 *
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 *
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 *
 * Note that you don't have any change in hand at first.
 *
 * Return true if and only if you can provide every customer with correct change.
 *
 *
 *
 * Example 1:
 *
 * Input: [5,5,5,10,20]
 * Output: true
 * Explanation:
 * From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change, we output true.
 * Example 2:
 *
 * Input: [5,5,10]
 * Output: true
 * Example 3:
 *
 * Input: [10,10]
 * Output: false
 * Example 4:
 *
 * Input: [5,5,10,10,20]
 * Output: false
 * Explanation:
 * From the first two customers in order, we collect two $5 bills.
 * For the next two customers in order, we collect a $10 bill and give back a $5 bill.
 * For the last customer, we can't give change of $15 back because we only have two $10 bills.
 * Since not every customer received correct change, the answer is false.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用Map<Integer, Integer>来存储当前有的零钱, 遍历判断即可
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> currentCharge = new HashMap<>();
        for(int bill : bills){
            if(bill == 5){
                if(currentCharge.containsKey(5)){
                    currentCharge.put(5, currentCharge.get(5)+1);
                }else{
                    currentCharge.put(5,1);
                }
            }
            if(bill == 10){
                if(!currentCharge.containsKey(5) || currentCharge.get(5) < 1){
                    return false;
                }
                currentCharge.put(5, currentCharge.get(5) -1);
                if(currentCharge.containsKey(10)){
                    currentCharge.put(10, currentCharge.get(10)+1);
                }else{
                    currentCharge.put(10, 1);
                }
            }
            if(bill == 20){
                if(currentCharge.getOrDefault(10, 0)>= 1 && currentCharge.getOrDefault(5, 0) >= 1){
                    currentCharge.put(10, currentCharge.get(10)-1);
                    currentCharge.put(5, currentCharge.get(5)-1);
                    continue;
                }
                if(currentCharge.getOrDefault(5, 0) >= 3){
                    currentCharge.put(5, currentCharge.get(5) -3);
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(new int[]{5,5,10,10,20}));
    }
}