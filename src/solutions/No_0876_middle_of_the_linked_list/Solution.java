package solutions.No_0876_middle_of_the_linked_list;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * Example 1:
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 先求出链表长度,除以2即为要从头结点开始走的步数
 * 根据步数找到对应的节点返回即可
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 1 ;
        ListNode currentNode = head;
        while(currentNode.next != null){
            length++;
            currentNode = currentNode.next;
        }
        int step = length/2 ;
        ListNode resultNode = head;
        while(step > 0){
            resultNode = resultNode.next;
            step--;
        }
        return resultNode;
    }
}
