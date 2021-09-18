package solutions.No_0401_To_No_0500.No_0406_queue_reconstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
 *
 * Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
 *
 *
 *
 * Example 1:
 *
 * Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * Explanation:
 * Person 0 has height 5 with no other people taller or the same height in front.
 * Person 1 has height 7 with no other people taller or the same height in front.
 * Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
 * Person 3 has height 6 with one person taller or the same height in front, which is person 1.
 * Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
 * Person 5 has height 7 with one person taller or the same height in front, which is person 1.
 * Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
 * Example 2:
 *
 * Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 有个二维数组, 两个元素指的是人的身高, 和原队列中排在他前面有多少个人身高不低于他, 比如[7,0]表示身高为7, 在他前面没有人身高大于或者等于7, 要求恢复原队列的顺序
 * 解题思路:
 * 先按身高从大到小, 第二个元素从小到大排序, 这样在同等的身高里面顺序就是对的了, 然后不同身高的时候根据第二个元素插入到正确的位置就行, 由于身高是从小到大, 不会影响到之前已经插入的元素的顺序
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        /*排序*/
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < people.length; i++){
            /*在已经按上面的逻辑排序之后, 第二个元素为k的people就应该处于数组的第k位*/
            list.add(people[i][1], people[i]);
        }
        int[][] result = new int[people.length][];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
