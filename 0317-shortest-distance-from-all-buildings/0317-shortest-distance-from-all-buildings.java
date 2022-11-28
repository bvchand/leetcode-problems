class Solution {
    private final int BUILDING = 1;
    private int EMPTY_LAND = 0;
    private final int OBSTACLE = 2;
    
    public int shortestDistance(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] distance = new int[rows][cols];
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        int minDist = Integer.MAX_VALUE;
        
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (grid[r][c] == BUILDING) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c, 0});
                    int localDist = Integer.MAX_VALUE;
                    
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int currRow = curr[0], currCol = curr[1], currDist = curr[2];
                        
                        // System.out.println("***"+currRow +","+ currCol);
                        
                        for (int[] dir: dirs) {
                            int nextRow = dir[0] + currRow, nextCol = dir[1] + currCol;
                            
                            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == EMPTY_LAND) {
                                queue.offer(new int[]{nextRow, nextCol, currDist+1});
                                grid[nextRow][nextCol] -= 1;
                                
                                distance[nextRow][nextCol] += currDist + 1;
                                localDist = Math.min(localDist, distance[nextRow][nextCol]);
                                // System.out.println(nextRow + "," + nextCol + " " + distance[nextRow][nextCol] + " "+ localDist);
                            }
                            
                        }
                    }
                    minDist = localDist;
                    EMPTY_LAND -= 1;
                }
            }
        }
        return minDist != Integer.MAX_VALUE ? minDist : -1;
    }
}