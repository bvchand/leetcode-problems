/*
bottom-up DP
time: O(n)
space: O(1)
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if(n == 0)
            return 0;
        
        int next2NextHouse = 0, nextHouse = 0;
        
        for(int i = 0; i < n; i++) {
            int temp = Math.max(nums[i] + next2NextHouse, nextHouse);
            next2NextHouse = nextHouse;
            nextHouse = temp;
        }
        
        return nextHouse;
    }
}


/*
bottom-up DP
time & space: O(n)
*/

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] amountRobbed = new int[n+1];
        
//         amountRobbed[n] = 0;
//         amountRobbed[n-1] = nums[n-1];
        
//         for(int i = n-2; i >= 0; i--) {
//             amountRobbed[i] = Math.max(nums[i] + amountRobbed[i+2], amountRobbed[i+1]);
//         }
        
//         return amountRobbed[0];
//     }
// }

