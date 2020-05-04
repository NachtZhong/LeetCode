package solutions.No_0001_To_No_0100.No_0002_add_two_numbers;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author Nacht
 * Created on 2019/5/20
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 用普通的加法做, 超过10就进位+1
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1 ;
        ListNode p2 = l2 ;
        int carry = 0 ;
        ListNode headNode = new ListNode(0) ;
        ListNode currentNode = headNode ;
        while(p1 != null || p2 != null){
            int p1Value = p1 == null ? 0 : p1.val ;
            int p2Value = p2 == null ? 0 : p2.val ;
            int sumValue = (p1Value + p2Value + carry) % 10 ;
            currentNode.next = new ListNode(sumValue) ; ;
            currentNode = currentNode.next ;
            carry = (p1Value + p2Value) >= 10 ? 1 : 0 ;
            p1 = p1 == null ? null : p1.next ;
            p2 = p2 == null ? null : p2.next ;
        }
        if(carry == 1){
            currentNode.next = new ListNode(carry);
        }
        return headNode.next ;
    }
}
