class Solution {
    Map<Integer, Set<Integer>> adjList = new HashMap<>();
    int[] result, count;
    int rootDistSum = 0;
    int n;

    public int dfs(int curr, int parent, int depth) {
        int nNodes = 1;
        Set<Integer> children = adjList.getOrDefault(curr, new HashSet<>());
        for(int child: children) {
            if(child != parent) {
                nNodes += dfs(child, curr, depth + 1);
                rootDistSum += depth + 1;
            }
        }
        count[curr] = nNodes;
        return nNodes;
    }
    
    public void dfs2(int curr, int parent, int currDistSum) {
        result[curr] = currDistSum;
        Set<Integer> children = adjList.getOrDefault(curr, new HashSet<>());
        for(int child: children) {
            if(child != parent) {
                int childDistSum = currDistSum - count[child] + (n - count[child]);      // dist(parentNode) - closerNodes + fartherNodes
                dfs2(child, curr, childDistSum);
            }
        }
    }
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        result = new int[n];
        count = new int[n];
        
        Arrays.fill(count, 1);
        
        for(int[] edge: edges) {
            adjList.computeIfAbsent(edge[0], val -> new HashSet<>()).add(edge[1]);
            adjList.computeIfAbsent(edge[1], val -> new HashSet<>()).add(edge[0]);
        }
        
        dfs(0, -1, 0);
        // System.out.println(rootDistSum);
        
        dfs2(0, -1, rootDistSum);
        
        return result;
    }
}