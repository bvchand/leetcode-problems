class Solution {
    
    private final int WHITE = 0, BLACK = 1, GRAY = 2;
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private Stack<Integer> stack = new Stack<>();
    private int[] result = {};
    private int numCourses;
    private int[] visited;
    
    public boolean detectCycleHelper(int course) {
        
        // if a course is visited
        if(this.visited[course] == BLACK)
            return true;
        // if a course is visited and processed (all child nodes are visited)
        if(this.visited[course] == GRAY)
            return false;
        
        this.visited[course] = BLACK;
        List<Integer> prereq = this.adjList.getOrDefault(course, new ArrayList<Integer>());
        // System.out.println(prereq.size());
        for(int nextCourse=0; nextCourse<prereq.size(); nextCourse++) {
            if(detectCycleHelper(prereq.get(nextCourse)))
                return true;
        }
        this.visited[course] = GRAY;
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
        this.visited[course] = WHITE;
        List<Integer> prereq = adjList.getOrDefault(course, new ArrayList<Integer>());
        for(int nextCourse=0; nextCourse<prereq.size(); nextCourse++) {
            if(visited[prereq.get(nextCourse)] == GRAY) {
                visited[prereq.get(nextCourse)] = WHITE;
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
                
        Arrays.fill(this.visited, WHITE);
        if(detectCycle())
            return this.result;
                    
        for(int course=0; course<numCourses; course++) {
            if(visited[course] == GRAY) {
                dfs(course);
            }
        }
        
        this.result = new int[numCourses];
        for(int i=0; i<numCourses; i++)
            this.result[i] = stack.pop();
        
        return this.result;
    }
}