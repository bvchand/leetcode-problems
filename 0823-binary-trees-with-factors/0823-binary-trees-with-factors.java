class Solution {
    private int MOD = 1000000007;
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        Arrays.sort(arr);
        
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < n; i++)
            indexMap.put(arr[i], i);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                int curr = arr[i], left = arr[j];
                if(curr % left == 0) {
                    int right = curr / left;
                    if(indexMap.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[indexMap.get(right)]) % MOD;
                    }
                }
            }
        }
        
        long ans = 0;
        for(long x: dp)
            ans += x;
        
        return (int) (ans % MOD);
    }
}