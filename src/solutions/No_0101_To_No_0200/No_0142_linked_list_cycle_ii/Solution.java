package solutions.No_0101_To_No_0200.No_0142_linked_list_cycle_ii;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 *
 * Do not modify the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 *
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 *
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 题解:
 * 给一个链表, 如果无环, 返回null, 如果有环, 返回环开始的节点
 * 解题思路:
 * 首先判断链表是否有环, 和题目141的方法一样, 如果无环, 返回null即可
 * 如果有环, 由于是通过快慢指针的方式, 并且快指针走2个节点, 慢指针走一个节点, 所以可以判断的出, 快指针和慢指针相遇的时候, 快指针必定比慢指针走多了一个环
 * 假设环开始的位置和链表头节点的距离为n, 环开始的位置和相遇的节点为k, 那么快指针走了n+k+一个环, 慢指针走了n+k, 而快指针走的路程为慢指针的2倍
 * 所以n+k+一个环 = 2n+2k
 * 两边相减可得环的长度=n+k => 环的长度-k=n, 而环的长度-k就是慢指针距离环开始的节点的距离, 所以此时头节点到环开始节点的距离n和慢指针到环开始的节点是相等的
 * 此时让快指针从头节点开始遍历, 不过每次只遍历一个节点, 那么它和慢指针就会在环开始的节点相遇, 返回相遇时所在的节点就是题目要求的环开始的节点
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*边界条件判断*/
        if(head == null){
            return null;
        }
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(fastPointer == slowPointer){
                break;
            }
        }
        /*如果快指针走到尽头, 说明无环, 返回null*/
        if(fastPointer.next == null || fastPointer.next.next == null){
            return null;
        }
        /*如果两者相遇了, 说明有环, 快指针从头开始, 慢指针继续走, 直到两者相遇*/
        fastPointer = head;
        while (fastPointer != slowPointer){
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        /*返回二者相遇的节点*/
        return fastPointer;
    }
}
