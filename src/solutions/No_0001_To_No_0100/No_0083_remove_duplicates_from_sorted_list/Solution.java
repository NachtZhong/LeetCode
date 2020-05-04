package solutions.No_0001_To_No_0100.No_0083_remove_duplicates_from_sorted_list;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历即可
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        while( currentNode!=null && currentNode.next!=null){
            if (currentNode.val == currentNode.next.val){
                currentNode.next = currentNode.next.next;
                continue;
            }
            currentNode = currentNode.next;
        }
        return head;
    }
}
