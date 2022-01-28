# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        curr = head
        list_len = 0
        while curr:
            list_len += 1
            curr = curr.next
        
        index = list_len - n
        prev, curr = None, head
        
        while index > 0:
            prev = curr
            curr = curr.next
            index -= 1
        if prev:    prev.next = curr.next
        else:   head = curr.next
            
        return head
                
        
            
            