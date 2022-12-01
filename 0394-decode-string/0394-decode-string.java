/*
recursion
time: O(maxK.n)
space: O(n)
*/
class Solution {
    private Stack<Integer> stack = new Stack<>();
    
    int index = 0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while(index < s.length() && s.charAt(index) != ']') {
            if(!Character.isDigit(s.charAt(index)))
                sb.append(s.charAt(index++));
            else {
                int k = 0;
                while(index < s.length() && 
                      Character.isDigit(s.charAt(index))) {
                    k = k*10 + s.charAt(index++) -'0';
                }
                index++; // to avoid '['
                String decodedString = decodeString(s);
                while (k > 0) {
                    sb.append(decodedString);
                    k--;
                }  
                index++; // to avoid ']'
            }
        }
        return sb.toString();
        
    }
}