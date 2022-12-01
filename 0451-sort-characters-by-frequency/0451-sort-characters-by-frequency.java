/*
Hashmap + bucket sort
time: O(n)
space: O(n) 
*/
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        
        for (char ch: s.toCharArray()) {
            int val = freqMap.getOrDefault(ch, 0)+1;
            freqMap.put(ch, val);
            maxFreq = Math.max(maxFreq, val);
        }
        
        List<List<Character>> buckets = new ArrayList<>();
        for (int i=0; i<=s.length(); i++) {
            buckets.add(new ArrayList<Character>());
        }
        
        for (char ch: freqMap.keySet()) {
            int freq = freqMap.get(ch);
            buckets.get(freq).add(ch);
        }
         
        StringBuilder res = new StringBuilder();
        for(int i=maxFreq; i >= 0; i--) {
            List<Character> chars = buckets.get(i);
            for (char ch: chars) {
                int times = freqMap.get(ch);
                while (times-- > 0)
                    res.append(ch);
            }
        }
        return res.toString();
    }
}


// /*
// Hashmap + priority queue
// time: O(n + klogk) or O(n log n) ; k --> heap size; log k --> time for sorting/popping a heap (height)
// space: O(n) 
// */
// class Solution {
//     public String frequencySort(String s) {
//         HashMap<Character, Integer> freqMap = new HashMap<>();
        
//         for (char ch: s.toCharArray()) {
//             int val = freqMap.getOrDefault(ch, 0);
//             freqMap.put(ch, val+1);
//         }
        
//         PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(freqMap.get(b), freqMap.get(a)));
        
//         for(char ch: freqMap.keySet()) {
//             maxHeap.add(ch);
//         }
                
//         StringBuilder res = new StringBuilder();
//         while(!maxHeap.isEmpty()) {
//             char ch = maxHeap.poll();
//             int times = freqMap.get(ch);
//             while (times-- > 0)
//                 res.append(ch);
//         }
//         return res.toString();
//     }
// }