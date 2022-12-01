/*
recursion
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
                int n = 0;
                while(index < s.length() && 
                      Character.isDigit(s.charAt(index))) {
                    n = n*10 + s.charAt(index++) -'0';
                }
                index++; // to avoid '['
                String decodedString = decodeString(s);
                index++;
                while (n > 0) {
                    sb.append(decodedString);
                    n--;
                }   
            }
        }
        return sb.toString();
        
    }
}