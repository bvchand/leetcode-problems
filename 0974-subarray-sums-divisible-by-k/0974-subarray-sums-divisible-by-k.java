class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        
        for(int num: nums) {
            sum += num;
            int rem = ((sum % k)+k)%k;
            // System.out.println(num +" " + sum + " " + rem);
            if (rem == 0)
                ans++;
            if(map.containsKey(rem))
                ans += map.get(rem);
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return ans;
        
    }
}