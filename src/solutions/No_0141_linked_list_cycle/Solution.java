package solutions.No_0141_linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用set判断
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode currentNode = head;
        while(currentNode!=null){
            if(set.contains(currentNode)){
                return true;
            }
            set.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(0);
        a.next = b;
        b.next = c;
        c.next = a ;
        System.out.println(new Solution().hasCycle(a));
    }
}
