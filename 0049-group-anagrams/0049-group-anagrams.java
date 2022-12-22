class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {        
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        
        for(String str: strs) {
            Arrays.fill(count, 0);
            
            // get the count of every word in the input array
            for(char c: str.toCharArray())
                count[c-'a']++;
            
            // convert this count array into a string to add as a key into the map
            StringBuilder sb = new StringBuilder();
            for(int cnt: count)
                sb.append(cnt + "#");
            
            // consolidate all the anagrams under one key
            ans.computeIfAbsent(sb.toString(), val -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList(ans.values());
    }
}

// time and space: O(N*K)