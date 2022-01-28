# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head:    return False
        
        slow, fast = head, head.next
        
        while fast and fast.next:
            if slow != fast:
                slow = slow.next
                fast = fast.next.next
            else:
                return True
        
        return False
        