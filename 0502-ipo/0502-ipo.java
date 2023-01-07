class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair<Integer, Integer>> minCap = new PriorityQueue<>((a,b) -> a.getKey() - b.getKey());  // asc
        PriorityQueue<Integer> maxProf = new PriorityQueue<>((a,b) -> b - a);         // desc
        
        for(int i=0; i<profits.length; i++)
            minCap.offer(new Pair(capital[i], profits[i]));
        
        int cap = w;
        // pick k projects
        for(int i=0; i<k; i++) {
            while(!minCap.isEmpty() && minCap.peek().getKey() <= cap) {
                maxProf.offer(minCap.poll().getValue());
            }
            if(maxProf.isEmpty())
                return cap;
            cap += maxProf.poll();
        }
        return cap;
    }
}