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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummyHead = new ListNode(0);
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(int i=0; i<k; i++) {
            if(lists[i] != null)
                queue.offer(lists[i]);
        }
        
        ListNode point = dummyHead;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            point.next = node;
            point = point.next;
            
            ListNode next = point.next;
            if(next != null)
                queue.offer(next);
        }
        return dummyHead.next;
    }
}