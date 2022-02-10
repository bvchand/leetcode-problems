class Solution:
    def mostVisitedPattern(self, username: List[str], timestamp: List[int], website: List[str]) -> List[str]:
        result = []
        
        site_patterns = defaultdict(set)
        user_history = defaultdict(list)
        
        for i in range(len(username)):
            user_history[username[i]].append((timestamp[i], website[i]))
        # print(user_history)
        
        for user, site in user_history.items():
            site.sort()
            sites = [s[1] for s in site]
            if len(sites) == 3:
                 site_patterns[tuple(sites)].add(user)
            else:
                for s in list(itertools.combinations(sites, 3)):
                     site_patterns[s].add(user)
        # print(site_patterns)
        
        max_score = 0
        for pattern, users in site_patterns.items():
            max_score = max(max_score, len(users))
                
        for pattern, users in site_patterns.items():
            if len(users) == max_score:
                result.append(pattern)
            
        # print(max_score) 
        return sorted(result)[0]
            
            