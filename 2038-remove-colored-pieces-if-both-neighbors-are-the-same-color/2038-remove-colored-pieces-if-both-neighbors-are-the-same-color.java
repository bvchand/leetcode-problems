class Solution {
    public boolean winnerOfGame(String colors) {
        int movesA = 0, movesB = 0;
        int i = 1;
        
        char[] arr = colors.toCharArray();
        int n = arr.length;
        
        while(i < n-1) {
            if(arr[i] == arr[i-1] && arr[i] == arr[i+1]) {
                if(arr[i] == 'A')
                    movesA++;
                else
                    movesB++;
            }
            i++; 
        }
        return movesA > movesB;
    }
}