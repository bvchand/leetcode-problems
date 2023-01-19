class TicTacToe {
    private int[] rows, cols;
    private int n, diag, antidiag;
    
    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diag = 0;
        this.antidiag = 0;
    }
    
    public int move(int r, int c, int player) {
        int id = player == 1 ? 1 : -1;
        rows[r] += id;
        cols[c] += id;
        
        if(r == c)
            diag += id;
        if(c == (n - r - 1))
            antidiag += id;
        
        if(Math.abs(rows[r]) == n || Math.abs(cols[c]) == n || Math.abs(diag) == n || Math.abs(antidiag) == n)
            return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */