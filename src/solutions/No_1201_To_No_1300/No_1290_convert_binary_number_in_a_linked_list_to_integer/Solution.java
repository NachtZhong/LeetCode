package solutions.No_1201_To_No_1300.No_1290_convert_binary_number_in_a_linked_list_to_integer;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * @author Nacht
 * Created on 2019/5/27
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 遍历后调用Integer的api转为十进制即可
 */
public class Solution {
    public int getDecimalValue(ListNode head) {
        String binaryStr = "";
        while(head != null){
            binaryStr += head.val;
            head = head.next;
        }
        return Integer.valueOf(binaryStr, 2);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(1);
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        System.out.println(new Solution().getDecimalValue(listNode1));
    }
}
