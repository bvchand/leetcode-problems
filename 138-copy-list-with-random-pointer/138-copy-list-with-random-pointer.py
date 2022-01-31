"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        curr = head
        dummyhead = Node(0)
        copy_curr = dummyhead
        node_hash = {}
        
        # traverse using the next pointer and map copied nodes to original nodes
        while curr:
            copy_curr.next = Node(curr.val)
            node_hash[curr] = copy_curr.next
            copy_curr = copy_curr.next
            curr = curr.next
        
        curr, copy_curr = head, dummyhead.next
        while curr and copy_curr:
            if curr.random == None:
                copy_curr.random = None
            else:
                copy_curr.random = node_hash[curr.random]
            
            curr, copy_curr = curr.next, copy_curr.next
                
        return dummyhead.next