class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for(char c: s.toCharArray()) {
            count[c]++;
        }
        
        int ans = 0;
        // char c appears n times
        for(int n: count) {
            ans += n / 2 * 2;
            if(n % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }
}