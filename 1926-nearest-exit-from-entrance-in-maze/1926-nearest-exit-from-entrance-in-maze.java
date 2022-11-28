/*
BFS
*/
class Solution {
    private final char EMPTY = '.';
    private final char WALL = '+';
    
    
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        int rows = maze.length, cols = maze[0].length;
                
        queue.offer(new int[] {entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = WALL;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0], currCol = curr[1], currDist = curr[2];
                    
            for (int[] dir: directions) {
                int nextRow = dir[0] + currRow, nextCol = dir[1] + currCol;
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && maze[nextRow][nextCol] == EMPTY) {
                    if (nextRow == 0 || nextRow == rows-1 || nextCol == 0 || nextCol == cols-1)
                        return currDist + 1;
                    queue.offer(new int[]{nextRow, nextCol, currDist + 1});
                    maze[nextRow][nextCol] = WALL;
                }
            }
            
        }
        return -1;
    }
}