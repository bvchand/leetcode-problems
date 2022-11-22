/*
Strategy: Math (decrementing one element by one is equilvalent to incrementing n-1 elements by one)
- Try to find the distance between each element and the min element in the array

time: O(n)
space: O(1)
*/

class Solution {
    public int minMoves(int[] nums) {
        int moves = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        
        for (int i=0; i<nums.length; i++) {
            moves += nums[i] - min;
        }
        
        return moves;
    }
}















// /*
// Strategy: Sorting
// time: O(nlogn)
// space: O(1)
// */
// class Solution {
//     public int minMoves(int[] nums) {
//         int moves = 0;
        
//         Arrays.sort(nums);
        
//         for (int i=0; i<nums.length; i++) {
//             moves += nums[i] - nums[0];
//         }
        
//         return moves;
//     }
// }