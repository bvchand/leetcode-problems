class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char c: s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        
        int ans = 0;
        // char c appears n times
        for(char c: count.keySet()) {
            int n = count.get(c);
            ans += n / 2 * 2;
            if(n % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }
}