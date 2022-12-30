class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;
        
        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];
        int[][] boxes = new int[N][N];
        
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(board[r][c] == '.')
                    continue;
                
                int pos = board[r][c] - '1'; // 0 indexed eg: 5 --> 4th index
                
                if(rows[r][pos] == 1)
                    return false;
                rows[r][pos] = 1;
                
                if(cols[c][pos] == 1)
                    return false;
                cols[c][pos] = 1;
                
                int index = (r/3) * 3 + (c/3); // index transforms box into a row and pos is the col
                // System.out.println(r + " " + c + " " + index);
                if(boxes[index][pos] == 1)
                    return false;
                boxes[index][pos] = 1;
                
            }
        }
        return true;
    }
}