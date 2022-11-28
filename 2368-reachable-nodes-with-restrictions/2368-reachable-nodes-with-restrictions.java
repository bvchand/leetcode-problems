/*
DFS
Time: O(V+E)
Space: O(V+E)
*/
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> restrictedSet = new HashSet<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for (int[] edge: edges) {
            int x = edge[0], y=edge[1];
            adjList.computeIfAbsent(x, val -> new ArrayList<Integer>()).add(y);
            adjList.computeIfAbsent(y, val -> new ArrayList<Integer>()).add(x);
        }
        
        for (int node: restricted) {
            restrictedSet.add(node);
        }
        
        stack.push(0);
        visited.add(0);
        
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            
            for (int neighbor: adjList.get(currNode)) {
                if (!visited.contains(neighbor)) {
                    if (restrictedSet.contains(neighbor))
                        continue;
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        
        return visited.size();
        
    }
}

