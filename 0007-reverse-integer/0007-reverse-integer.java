class Solution {
    public int reverse(int x) {
        long res = 0;
        boolean neg = false;
        
        if (x < 0) {
            neg = true;
            x = x*-1;
        }
 
        while (x > 0) {
            int temp = x % 10;
            x = x / 10;
            res = res * 10 + temp;
        }
        
        if (res > Integer.MAX_VALUE)
            return 0;
        
        return neg ? (int)(-1*res) : (int)res; 
    }
}