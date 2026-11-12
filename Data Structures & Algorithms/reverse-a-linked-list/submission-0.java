/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        prev.next = null;
        // prev = 0 curr = 1
        // <- 0  1 -> 2 -> 3 
        while (curr != null) {
            // curr.next() = 3 = temp
            ListNode temp = curr.next;
            curr.next = prev;
            // <- 0 <- 1 <- 2
            // curr = 3, prev = 2
            prev = curr;
            curr = temp;
            
        }
        head = prev;
        return head;
    }
}
