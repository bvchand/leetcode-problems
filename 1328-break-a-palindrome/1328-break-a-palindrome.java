class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1)
            return "";
        
        char[] palinArray = palindrome.toCharArray();
        for(int i=0; i<n/2; i++) {
            char c = palindrome.charAt(i);
            if(c != 'a') {
                palinArray[i] = 'a';
                return String.valueOf(palinArray);
            }
                
        }
        palinArray[n-1] = 'b';
        return String.valueOf(palinArray);
    }
}