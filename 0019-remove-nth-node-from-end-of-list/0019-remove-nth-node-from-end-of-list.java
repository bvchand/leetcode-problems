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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size = 0;
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        
        if (size == 1) {
            return null;
        }
        
        int indexToBeRemoved = size - n; // index to be removed (0 indexed)
        curr = dummy;
        
        // for (int i=0; i<indexToBeRemoved; i++) {
        //     if (i == indexToBeRemoved-1) {
        //         curr.next = curr.next.next;
        //         break;
        //     }
        //     curr = curr.next;
        // }
        
        while (indexToBeRemoved > 0) {
            curr = curr.next;
            indexToBeRemoved--;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}

/**
space = O(1)
time = O(2n) ; n--> size of linkedlist
*/