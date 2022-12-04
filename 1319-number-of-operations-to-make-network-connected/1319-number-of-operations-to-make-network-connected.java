class Solution {
    private int[] parent;
    private int[] rank;
    
    public int find(int node) {
        int result = node;
        while(this.parent[result] != result) {
            this.parent[result] = this.parent[parent[result]];
            result = this.parent[result];
        }
        return result;
    }
    
    public void union(int node1, int node2) {
        int par1 = find(node1), par2 = find(node2);
        if(par1 != par2) {
            if(rank[par2] > rank[par1]) {
                this.parent[par1] = par2;
                this.rank[par2] += this.rank[par1];
            } else {
                this.parent[par2] = par1;
                this.rank[par1] += this.rank[par2];
            }    
        }    
    }
    
    public int makeConnected(int n, int[][] connections) {
        this.parent = new int[n];
        this.rank = new int[n];
        
        for(int i=0; i<n; i++)
            this.parent[i] = i;
        
        Arrays.fill(this.rank, 1);
        
        for(int[] nodes: connections) {
            union(nodes[0], nodes[1]);
        }
        
        Set<Integer> set = new HashSet();
        for(int i=0;i < n;i++)
            set.add(find(i));
        // System.out.println(Arrays.asList(parent).toString());
        // System.out.println(set.toString());
        
        // Set<Integer> set = new HashSet(Arrays.asList(parent));

        return connections.length < n-1 ? -1 : set.size()-1;
    }
}