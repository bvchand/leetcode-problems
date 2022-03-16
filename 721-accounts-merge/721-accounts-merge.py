class UnionFind():
    def __init__(self, n):
        self.parents = [i for i in range(n)]
        self.rank = [1] * n
        
    def find(self, x):
        if self.parents[x] == x: return x
        
        self.parents[x] = self.find(self.parents[x])
        return self.parents[x]
    
    def union(self, x, y):
        r1, r2 = self.find(x), self.find(y)
        
        if r1 == r2:    return
        
        if self.rank[r1] > self.rank[r2]:
            r1, r2 = r2, r1
        
        self.parents[r1] = r2
        self.rank[r2] += self.rank[r1]
    
class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        email_name_map = {}
        
        accountsCount = len(accounts)
        uf = UnionFind(accountsCount)
        
        for i, acct in enumerate(accounts):
            name = acct[0]
            for email in acct[1:]:
                if email not in email_name_map:
                    email_name_map[email] = i
                else:
                    uf.union(i, email_name_map[email])
        
        mergedAccounts = defaultdict(set)
        for email in email_name_map.keys():
            id = uf.find(email_name_map[email])
            mergedAccounts[id].add(email)
        
        res = []
        
        for id, emails in mergedAccounts.items():
            res.append([accounts[id][0]] + sorted(list(emails)))
        
        return res
        
            
            
            
            
            
        
        
        
                    
        
        
        
                    
                    
        
        
        