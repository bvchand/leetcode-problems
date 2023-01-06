class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m, left = 0, right = n;
        int dir = 0;
        
        List<Integer> res = new ArrayList<>();
        
        while(left < right && top < bottom) {
            if(dir == 0) {          // left to right -->
                for(int i=left; i<right; i++)
                    res.add(matrix[top][i]);
                top += 1;
            } else if(dir == 1) {    // top to bottom
                for(int i=top; i<bottom; i++)
                    res.add(matrix[i][right-1]);
                right -= 1;
            } else if(dir == 2) {    // right to left <--
                for(int i=right-1; i>=left; i--)
                    res.add(matrix[bottom-1][i]);
                bottom -= 1;
            } else if(dir == 3) {    // bottom to top
                for(int i=bottom-1; i>=top; i--)
                    res.add(matrix[i][left]);
                left += 1;
            }
            dir = (dir + 1)%4;
        }
        return res;
    }
}