# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        curr = head
        
        length, odd = 0, False
        while curr:
            length += 1
            curr = curr.next
        odd = (length%2 != 0)
        
        curr, stack = head, []
        
        for i in range(length):  
            if odd and i == length//2:
                curr = curr.next
                continue
            if i < length//2:
                stack.append(curr.val)
            elif stack[-1] == curr.val:  stack.pop() 
            curr = curr.next
        return len(stack) == 0
        
        
        
        # while curr:
        #     if len(stack) == 0 or stack[-1] != curr.val:
        #         stack.append(curr.val)
        #     else:  stack.pop() 
        #     curr = curr.next
        # return len(stack) == 0
            