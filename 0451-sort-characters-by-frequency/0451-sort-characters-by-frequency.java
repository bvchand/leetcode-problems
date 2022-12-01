class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        for (char ch: s.toCharArray()) {
            int val = freqMap.getOrDefault(ch, 0);
            freqMap.put(ch, val+1);
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(freqMap.get(b), freqMap.get(a)));
        
        for(char ch: freqMap.keySet()) {
            maxHeap.add(ch);
        }
                
        StringBuilder res = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int times = freqMap.get(ch);
            while (times-- > 0)
                res.append(ch);
        }
        return res.toString();
    }
}