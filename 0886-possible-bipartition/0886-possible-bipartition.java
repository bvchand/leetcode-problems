class Solution {
    public boolean bfs(int sourceNode, Map<Integer, List<Integer>> adjList, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sourceNode);
        colors[sourceNode] = 0; // RED
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> children = adjList.getOrDefault(curr, new ArrayList<>());
            for(int nextNode: children) {
                // if(!adjList.containsKey(curr))
                //     continue;
                if(colors[nextNode] == colors[curr])
                    return false;
                    
                if(colors[nextNode] == -1) {
                    colors[nextNode] = 1 - colors[curr];
                    queue.offer(nextNode);
                }
            }
        }
        return true;
        
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int[] dislike: dislikes) {
            adjList.computeIfAbsent(dislike[0], val -> new ArrayList<>()).add(dislike[1]);
            adjList.computeIfAbsent(dislike[1], val -> new ArrayList<>()).add(dislike[0]);
        }
        
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1);        // 0 stands for red and 1 stands for blue.
            
        for(int currNode = 1; currNode <= n; currNode++) {
            if(colors[currNode] == -1)
                if(!bfs(currNode, adjList, colors))
                    return false;
        }
        return true;
    }
}