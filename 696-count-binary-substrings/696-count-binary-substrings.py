class Solution:
#     def countBinarySubstrings(self, s: str) -> int:
#         count, prev, curr = 0, 0, 1
        
#         for i in range(1, len(s)):
#             if s[i] != s[i-1]:
#                 count += min(prev, curr)
#                 prev, curr = curr, 1
#             else:
#                 curr += 1
            
#             print(i, prev, curr)
        
#         return count + min(prev, curr)


    def countBinarySubstrings(self, s: str) -> int:
        groups = [1]
        result = 0
        
        for i in range(1, len(s)):
            if s[i] != s[i-1]:
                groups.append(1)
            else:
                groups[-1] += 1
            # print(i, groups)
        
        for i in range(1, len(groups)):
            result += min(groups[i], groups[i-1])
            
        return result