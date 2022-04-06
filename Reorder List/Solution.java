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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        /**
         Merge 2 linkedlist.
         First linkedlist is first half of the given linkedlist
         Second linkedlist is second half of the given linkedlist but reversed
        */

        ListNode l1 = head, prev = null, l2 = head, fast = head;

        while(fast != null && fast.next != null) {
            prev = l2;
            l2 = l2.next;
            fast = fast.next.next;
        }

        /**
         prev is the tail of first linkedlist. We use it only for setting its next to null.
         So that we can seperate it from the second linkedlist.
        */

        prev.next = null;

        l2 = reverse(l2);

        merge(l1, l2);
    }

    public ListNode reverse(ListNode node) {
        if (node == null || node.next == null)
            return node;

        ListNode rest = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return rest;
    }

    public void merge(ListNode l1, ListNode l2) {
        while(l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = next;
        }

        /** Sample Simulation:
        l1 = 1 , 2
        l2 = 4 , 3
        Answer should be = 1 , 4 , 2 , 3

        There will be 3 loops.

        Loop 1
            next = 2
            1 -> 4 -> 3 (l1.next = l2)
            l1 = 4, 3
            l2 = 2


        Loop 2
            next = 3
            4 -> 2 (l1.next = l2)
            l1 = 2
            l2 = 3


        Loop 3
            next = null (next of 2 is null (remember that we set prev.next = null))
            2 -> 3 (l1.next = l2)
            l1 = 3
            l2 = null

        As a result head -> 1 -> 4 -> 3 -> 2 -> null
        */
    }
}