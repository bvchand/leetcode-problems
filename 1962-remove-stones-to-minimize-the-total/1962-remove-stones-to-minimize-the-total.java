class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> Integer.compare(y,x));
        int sum = 0;
        
        for(int stones: piles) {
            maxHeap.add(stones);
            sum += stones;
        }
            
        
        for(int i=0; i<k; i++) {
            int n = maxHeap.poll();
            int floor = n/2;
            
            sum -= floor;
            maxHeap.add(n-floor);
        }
        
        return sum;
    }
}