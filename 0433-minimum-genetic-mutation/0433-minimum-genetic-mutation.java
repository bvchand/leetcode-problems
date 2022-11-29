class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] geneChars = new char[]{'A', 'C', 'G', 'T'};
        Set<String> bankSet = new HashSet<String>();
        
        for (String str: bank)
            bankSet.add(str);
        
        if (!bankSet.contains(endGene))
            return -1;
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.offer(new Pair(startGene, 0));
        seen.add(startGene);
        
        while (!queue.isEmpty()) {
            Pair<String, Integer> curr = queue.poll();
            String currGene = curr.getKey();
            int currStep = curr.getValue();
            
            for (char c: geneChars) {
                for (int i=0; i<currGene.length(); i++) {
                    String newGene = currGene.substring(0, i) + c + currGene.substring(i+1, currGene.length());
                    if (newGene.equals(endGene))
                        return currStep+1;
                    if (bankSet.contains(newGene) && !seen.contains(newGene)) {
                        seen.add(newGene);
                        queue.offer(new Pair(newGene, currStep+1));
                    }
                }
            }
        }
        return -1;
    }
}