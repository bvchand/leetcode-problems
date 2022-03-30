"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

class Solution:
    def flatten(self, head: 'Optional[Node]') -> 'Optional[Node]':
        dummyhead = curr = head
        stack = []
        
        while curr:
            if curr.child:
                if curr.next:
                    stack.append(curr.next)
                curr.next = curr.child 
                curr.child.prev = curr
                curr.child = None
            
            if not curr.next and stack:
                curr.next = stack.pop()
                curr.next.prev = curr
            
            curr = curr.next 
        return dummyhead
                
            
                
            
                
        