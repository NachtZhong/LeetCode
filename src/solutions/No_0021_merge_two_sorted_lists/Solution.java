package solutions.No_0021_merge_two_sorted_lists;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历比较大小即可,记得判断链表为空的情形
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode currentNode = headNode;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                currentNode.next = l1;
                l1 = l1.next;
                currentNode = currentNode.next;
            }else{
                currentNode.next = l2;
                l2 = l2.next;
                currentNode = currentNode.next;
            }
        }
        if(l1 == null){
            currentNode.next = l2 ;
        }else{
            currentNode.next = l1;
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);
        l2.next.next.next = new ListNode(6);
        ListNode l3 = new Solution().mergeTwoLists(l1,l2);
        while(l3!=null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}