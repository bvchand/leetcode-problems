class Solution {
    public int connectSticks(int[] sticks) {
        int minCost = 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((x,y) -> Integer.compare(x,y));
        
        for (int stick: sticks) {
            minHeap.add(stick);
        }
        
        for (int i = minHeap.size(); i > 1; i--) {
            int v1 = minHeap.poll(), v2 = minHeap.poll();
            int newStick = v1+v2;
            minHeap.add(newStick);
            
            minCost += newStick;
        }
        
        return minCost;
    }
}