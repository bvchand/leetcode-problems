class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word: words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> queue = new PriorityQueue<>(
        (w1, w2) -> wordCount.get(w1).equals(wordCount.get(w2)) ? w2.compareTo(w1) : wordCount.get(w1) - wordCount.get(w2));
        
        Set<String> uniqueWords = wordCount.keySet();
        
        for (String word: uniqueWords) {
            queue.offer(word);
            if (queue.size() > k)
                queue.poll();
        }
        
        List<String> res = new ArrayList<>();
        System.out.println(queue.toString());
        while(!queue.isEmpty())
            res.add(queue.poll());
        Collections.reverse(res);
        return res;
    }
}