class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLen = beginWord.length();
        Map<String, List<String>> wordMap = new HashMap<>();
        
        for(String word: wordList) {
            for(int i=0; i<wordLen; i++){
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, wordLen);
                wordMap.computeIfAbsent(newWord, val -> new ArrayList<String>()).add(word);
            }
        }
        
        // System.out.println(wordMap.toString());
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        
        while (!queue.isEmpty()) {
            Pair<String, Integer> curr = queue.poll();
            String currWord = curr.getKey();
            int currStep = curr.getValue();
            
            for (int i=0; i<wordLen; i++) {
                String newWord = currWord.substring(0, i) + '*' + currWord.substring(i+1, wordLen);
                
                List<String> combinations = wordMap.getOrDefault(newWord, new ArrayList<String>());
                for(String word: combinations) {
                    if (word.equals(endWord))
                        return currStep + 1;
                    if (!visited.contains(word)) {
                        queue.offer(new Pair(word, currStep+1));
                        visited.add(word);
                    }
                }
            }
        }
        
        return 0;
    }
}

// /*
// BFS
// time: O(wordList length*word len + 26^word len)
// */
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> wordSet = new HashSet<>();
        
//         for(String word: wordList)
//             wordSet.add(word);
        
//         Queue<Pair<String, Integer>> queue = new LinkedList<>();
//         Set<String> visited = new HashSet<String>();
//         queue.offer(new Pair(beginWord, 1));
//         visited.add(beginWord);
        
//         while (!queue.isEmpty()) {
//             Pair<String, Integer> curr = queue.poll();
//             String currWord = curr.getKey();
//             int currStep = curr.getValue();
            
//             for(int ch=0; ch<26; ch++) {
//                 char c = (char) ('a' + ch);
//                 // System.out.println(c);
//                 for (int i=0; i<currWord.length(); i++) {
//                     String newWord = currWord.substring(0, i) + c + currWord.substring(i+1, currWord.length());
//                     // System.out.println(newWord + " " + (currStep + 1));
//                     if (wordSet.contains(newWord) && !visited.contains(newWord)) {
//                         if (newWord.equals(endWord))
//                             return currStep + 1;
//                         queue.offer(new Pair(newWord, currStep+1));
//                         visited.add(newWord);
//                         // System.out.println(queue.toString());
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
// }