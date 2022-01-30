# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        resultHead = result = ListNode()
        rem = 0
        
        while l1 or l2:
            res = rem
            if l1: 
                res += l1.val
                l1 = l1.next
            if l2: 
                res += l2.val
                l2 = l2.next
            rem = res // 10
            result.next = ListNode(res % 10)
            result = result.next
        if rem != 0:    result.next = ListNode(val=rem)
        return resultHead.next
            
            
        