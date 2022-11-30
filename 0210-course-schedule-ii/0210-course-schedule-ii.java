/*
DFS + stack
steps:
1. detect if cycle exists --> if yes: return [] else mark all courses as 2
2. perform dfs to perform topological sort
*/
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
        
        this.visited[course] = BLACK;   // mark course as visited
        List<Integer> prereq = this.adjList.getOrDefault(course, new ArrayList<Integer>());
        for(int nextCourse=0; nextCourse<prereq.size(); nextCourse++) {
            if(detectCycleHelper(prereq.get(nextCourse)))
                return true;
        }
        this.visited[course] = GRAY;    // mark course as processed
        return false;
    }
    
    // technique for detecting cycle: graph coloring technique (dfs)
    public boolean detectCycle() {
        for(int course=0; course<this.numCourses; course++) {
            if(this.visited[course] == WHITE)
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
            if(this.visited[prereq.get(nextCourse)] == GRAY) {
                this.visited[prereq.get(nextCourse)] = WHITE;
                dfs(prereq.get(nextCourse));
            }
        }
        stack.add(course);
    }
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        this.visited = new int[numCourses];
        Arrays.fill(this.visited, WHITE);
        
        for(int[] courses: prerequisites) {
            this.adjList.computeIfAbsent(courses[1], val -> new ArrayList<Integer>()).add(courses[0]);
        }
           
        // detect if cycle exists
        if(detectCycle())
            return this.result;
            
        // topological sort
        for(int course=0; course<numCourses; course++) {
            if(this.visited[course] == GRAY) {
                dfs(course);
            }
        }
        
        this.result = new int[numCourses];
        for(int i=0; i<numCourses; i++)
            this.result[i] = stack.pop();
        
        return this.result;
    }
}