class SparseVector:
    def __init__(self, nums: List[int]):
        self.vect = []
        for idx, val in enumerate(nums):
            if val != 0:
                self.vect.append((idx, val))
        

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        dot_prod = 0
        i = j = 0
        
        while i < len(self.vect) and j < len(vec.vect):
            i_idx, i_val = self.vect[i]
            j_idx, j_val = vec.vect[j]
            
            if i_idx == j_idx:
                dot_prod += i_val * j_val
                i += 1
                j += 1
            elif i_idx < j_idx:
                i += 1
            else:
                j += 1
        return dot_prod
            
            
            

# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector(nums1)
# v2 = SparseVector(nums2)
# ans = v1.dotProduct(v2)