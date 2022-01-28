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
        print(index)
        prev, curr = None, head
        while curr:
            print(index, curr.val)
            if prev and index == 0:
                prev.next = curr.next
            elif index == 0:
                head = curr.next
            else:
                prev = curr
                curr = curr.next
            index -= 1
        return head
                
        
            
            