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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;

        int remainder = 0;
        // l1 will be returned, so we modify l1
        ListNode head = l1;

        // If l2 is null and remainder is 0, the rest will be stay same, no need to loop
        while(l2 != null || remainder != 0) {
            int val = l1.val + remainder;

            // while l2 is not null, add l2.val to the val
            if(l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            // Update the remainder and l1.val
            remainder = val / 10;
            l1.val = val % 10;

            // If the while loop will iterate but l1.next is equal to null, we create a new node
            if((remainder != 0 || l2 != null) && l1.next == null) {
                l1.next = new ListNode(0, null);
            }

            l1 = l1.next;

        }

        return head;
    }
}