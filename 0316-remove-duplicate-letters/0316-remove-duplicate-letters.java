/**
DS used
monotonically increasing stack --> to track the increasing letters
array[26] --> to track the freq of the letters
array[26] --> visited array (T/F)
*/
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashSet<Character> visited = new HashSet<>();
        
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        
        for (int i=0; i<s.length(); i++)
            freq[s.charAt(i)-'a']++;
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            
            // haven't visited the curr char so far
            if (!visited.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                    char top = stack.pop();
                    visited.remove(top);
                }
                stack.push(c);
                visited.add(c);
                freq[c-'a']--;
            } else {
                freq[c-'a']--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character c:stack)
            sb.append(c.charValue());
        
        return sb.toString();   
    }
}