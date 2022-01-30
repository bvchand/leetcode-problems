# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        
        smallHead, largeHead = ListNode(), ListNode()
        s, l = smallHead, largeHead
        
        while head:
            if head.val < x:
                s.next = head
                s = s.next
                # print("s ",s.val)
            else:
                l.next = head
                l = l.next
                # print("l ", l.val)
            temp = head.next
            head.next = None
            head = temp
        s.next = largeHead.next
        
        return smallHead.next
        
        