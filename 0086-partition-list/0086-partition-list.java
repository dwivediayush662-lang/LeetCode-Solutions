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
    public ListNode partition(ListNode head, int x) {
         ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);

        // Pointers to build each list
        ListNode small = smallHead;
        ListNode large = largeHead;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        // Prevent a cycle in the linked list by terminating the 'large' list
        large.next = null;

        // Connect the end of the 'small' list to the start of the 'large' list
        small.next = largeHead.next;

        return smallHead.next;
    }
}