class Solution {
    
    public boolean detectCycleHelper(int course, Map<Integer, List<Integer>> adjList, int[] visited) {
        
        // if a course is visited
        if(visited[course] == 1)
            return true;
        // if a course is visited and processed (all child nodes are visited)
        if(visited[course] == 2)
            return false;
        
        visited[course] = 1;
        List<Integer> prereq = adjList.getOrDefault(course, new ArrayList<Integer>());
        // System.out.println(prereq.size());
        for(int i=0; i<prereq.size(); i++) {
            if(detectCycleHelper(prereq.get(i), adjList, visited))
                return true;
        }
        visited[course] = 2;
        return false;
    }
    
    // technique for detecting cycle: graph coloring technique (dfs)
    public boolean detectCycle(Map<Integer, List<Integer>> adjList, int numCourses) {
        int[] visited = new int[numCourses];
        Arrays.fill(visited, 0);
        
        for(int i=0; i<numCourses; i++) {
            if(visited[i] == 0)
                if(detectCycleHelper(i, adjList, visited))
                    return true;
        }
        return false;
    }
    
    
    // topological sort - DFS
    public void dfs(int course, int numCourses, Map<Integer, List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[course] = true;
        List<Integer> prereq = adjList.getOrDefault(course, new ArrayList<Integer>());
        for(int i=0; i<prereq.size(); i++) {
            if(!visited[prereq.get(i)]) {
                visited[prereq.get(i)] = true;
                dfs(prereq.get(i), numCourses, adjList, visited, stack);
            }
        }
        stack.add(course);
    }
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int[] courses: prerequisites) {
            adjList.computeIfAbsent(courses[1], val -> new ArrayList<Integer>()).add(courses[0]);
        }
        
        System.out.println(adjList.toString());
        
        int[] result = {};
        
        if(detectCycle(adjList, numCourses))
            return result;
            
        
        boolean[] visited = new boolean[numCourses];
        Arrays.fill(visited, false);
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                dfs(i, numCourses, adjList, visited, stack);
            }
        }
        
        result = new int[numCourses];
        for(int i=0; i<numCourses; i++)
            result[i] = stack.pop();
        
        return result;
    }
}