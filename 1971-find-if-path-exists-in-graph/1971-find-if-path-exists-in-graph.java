/*
DFS - iterative
time = O(m+n) ; m: nodes/vertices, n:edges; O(m) for building the map; O(n) for finding the dest
space = O(m+n) ; O(m) for map, O(n) recursive stack call for each node
*/
class Solution {
    
    
    public boolean validPath (int n, int[][] edges, int source, int destination) {     
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            
            // map x -> [y] and y -> [x]
            graph.computeIfAbsent(x, val -> new ArrayList<Integer>()).add(y);
            graph.computeIfAbsent(y, val -> new ArrayList<Integer>()).add(x);
        }
        
        stack.add(source);
        
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            if (currNode == destination)
                return true;
            
            for (int neighbor: graph.get(currNode)) {
                if (visited[neighbor] == false) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }
}

// /*
// DFS - recursive
// time = O(m+n) ; m: nodes/vertices, n:edges; O(m) for building the map; O(n) for finding the dest
// space = O(m+n) ; O(m) for map, O(n) recursive stack call for each node
// */
// class Solution {
//     private Map<Integer, List<Integer>> graph = new HashMap<>();
//     private int destination; 
    
    
//     public boolean validPath (int n, int[][] edges, int source, int destination) {
//         this.destination = destination;
        
//         boolean[] visited = new boolean[n];
//         Arrays.fill(visited, false);
        
//         for (int[] edge : edges) {
//             int x = edge[0], y = edge[1];
            
//             // map x -> [y] and y -> [x]
//             graph.computeIfAbsent(x, val -> new ArrayList<Integer>()).add(y);
//             graph.computeIfAbsent(y, val -> new ArrayList<Integer>()).add(x);
//         }
        
//         return helper(source, visited);
//     }
    
//     public boolean helper (int currNode, boolean[] visited) {
//         if (currNode == destination)
//             return true;

//         if (visited[currNode] == false) {
//             visited[currNode] = true;
//             for (int neighbor : graph.get(currNode)) {
//                 if (helper(neighbor, visited))
//                     return true;
//             }
//         }
//         return false;
//     }
// }