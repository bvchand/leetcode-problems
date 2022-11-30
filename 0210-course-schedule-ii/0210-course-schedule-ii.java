class Solution {
    
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Stack<Integer> stack = new Stack<>();
    private int[] result = {};
    private int numCourses;
    private int[] visited;
    
    public boolean detectCycleHelper(int course) {
        
        // if a course is visited
        if(this.visited[course] == 1)
            return true;
        // if a course is visited and processed (all child nodes are visited)
        if(this.visited[course] == 2)
            return false;
        
        this.visited[course] = 1;
        List<Integer> prereq = this.adjList.getOrDefault(course, new ArrayList<Integer>());
        // System.out.println(prereq.size());
        for(int nextCourse=0; nextCourse<prereq.size(); nextCourse++) {
            if(detectCycleHelper(prereq.get(nextCourse)))
                return true;
        }
        this.visited[course] = 2;
        return false;
    }
    
    // technique for detecting cycle: graph coloring technique (dfs)
    public boolean detectCycle() {
        for(int course=0; course<this.numCourses; course++) {
            if(this.visited[course] == 0)
                if(detectCycleHelper(course))
                    return true;
        }
        return false;
    }
    
    
    // topological sort - DFS
    public void dfs(int course) {
        this.visited[course] = 0;
        List<Integer> prereq = adjList.getOrDefault(course, new ArrayList<Integer>());
        for(int nextCourse=0; nextCourse<prereq.size(); nextCourse++) {
            if(visited[prereq.get(nextCourse)] == 2) {
                visited[prereq.get(nextCourse)] = 0;
                dfs(prereq.get(nextCourse));
            }
        }
        stack.add(course);
    }
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        this.visited = new int[numCourses];
        
        for(int[] courses: prerequisites) {
            this.adjList.computeIfAbsent(courses[1], val -> new ArrayList<Integer>()).add(courses[0]);
        }
                
        Arrays.fill(this.visited, 0);
        if(detectCycle())
            return this.result;
                    
        for(int course=0; course<numCourses; course++) {
            if(visited[course] == 2) {
                dfs(course);
            }
        }
        
        this.result = new int[numCourses];
        for(int i=0; i<numCourses; i++)
            this.result[i] = stack.pop();
        
        return this.result;
    }
}