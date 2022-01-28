# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:    return None
        if not head.next:   return head
        
        n, curr = 1, head

        while curr.next:  
            n += 1
            curr = curr.next
        curr.next = head        # 0 -> 1 -> 2 -> 0..
                                                
        index = n - (k%n) - 1    # 3-(3%3)-1 = 2
        newTail = head
        for i in range(index):
            newTail = newTail.next
        
        newHead = newTail.next
        newTail.next = None
            
        return newHead
                
                
            