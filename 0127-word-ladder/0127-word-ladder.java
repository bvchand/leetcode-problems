class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        
        for(String word: wordList)
            wordSet.add(word);
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<String>();
        queue.offer(new Pair(beginWord, 1));
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            Pair<String, Integer> curr = queue.poll();
            String currWord = curr.getKey();
            int currStep = curr.getValue();
            
            for(int ch=0; ch<26; ch++) {
                char c = (char) ('a' + ch);
                // System.out.println(c);
                for (int i=0; i<currWord.length(); i++) {
                    String newWord = currWord.substring(0, i) + c + currWord.substring(i+1, currWord.length());
                    // System.out.println(newWord + " " + (currStep + 1));
                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        if (newWord.equals(endWord))
                            return currStep + 1;
                        queue.offer(new Pair(newWord, currStep+1));
                        visited.add(newWord);
                        // System.out.println(queue.toString());
                    }
                }
            }
        }
        return 0;
    }
}