class Solution {
    private int[] parent;
    private int[] rank;
    
    // to find the parent of a curr node
    public int find(int node) {
        int result = node;
        
        while (parent[result] != result) {
            parent[result] = parent[parent[result]];
            result = parent[result];
        }
        return result;
    }
    
    // if the parents of each node is different, 
    // union combines the nodes by assigning a parent based on the ranks of the nodes
    // returns 0 if no union is performed; 1 otherwise
    public int union(int node1, int node2) {
        int p1 = find(node1);
        int p2 = find(node2);
        
        if (p1 == p2)
            return 0;
        
        if (rank[p2] > rank[p1]) {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        
        return 1;
    }
    
    public int countComponents(int n, int[][] edges) {
        this.parent = new int[n];
        this.rank = new int[n];
        
        int res = n;
        
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for (int[] edge: edges) {
            // if union happens
            if (union(edge[0], edge[1]) == 1)
                res--;
        }
        
        return res;
    }
}