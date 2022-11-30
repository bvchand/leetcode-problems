class Solution {
    private final int UNVISITED = 0, VISITED = 1, PROCESSED = 2;
    private int numCourses;
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    private int[] visited;
    
    public boolean detectCycle(int course) {
        if (visited[course] == VISITED)
            return true;
        if (visited[course] == PROCESSED)
            return false;
        
        visited[course] = VISITED;
        List<Integer> nextCourses = this.adjList.getOrDefault(course, new ArrayList<Integer>());
        for(int nextCourse=0; nextCourse<nextCourses.size(); nextCourse++) {
            if(detectCycle(nextCourses.get(nextCourse)))
                return true;
        }
        visited[course] = PROCESSED;
        
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        this.visited = new int[numCourses];
        Arrays.fill(this.visited, UNVISITED);
        
        for(int[] courses: prerequisites) {
            int course = courses[0];
            int prereq = courses[1];
            this.adjList.computeIfAbsent(prereq, val -> new ArrayList<Integer>()).add(course);
        }
        
        for(int course=0; course<numCourses; course++) {
            if(this.visited[course] == UNVISITED) {
                if(detectCycle(course)) 
                    return false;
            }
        }
        return true;
    }
}