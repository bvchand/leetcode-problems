# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
#         # hash table
#         nodes_A = set()
        
#         while headA:
#             nodes_A.add(headA)
#             headA = headA.next
        
#         while headB:
#             if headB in nodes_A:    return headB
#             headB = headB.next
        
#         return None
        
    # two pointers
        l1, l2 = headA, headB
        
        while l1 != l2:
            l1 = l1.next if l1 else headB
            l2 = l2.next if l2 else headA
        
        return l1
        
        
            
        
        