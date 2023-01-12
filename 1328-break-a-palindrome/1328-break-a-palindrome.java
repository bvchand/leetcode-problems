class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1)
            return "";
        
        for(int i=0; i<n/2; i++) {
            char c = palindrome.charAt(i);
            if(c != 'a')
                return palindrome.substring(0,i) + "a"+ palindrome.substring(i+1, n);
        }
        
        return palindrome.substring(0,n-1) + "b";
    }
}