class Solution {
    public String decodeMessage(String key, String message) {
        char[] dict = new char[26];
        int alphabet='a';   // 97
        for(int i=0; i<key.length(); i++) {
            char c = key.charAt(i);
            if (c == ' ')
                continue;
            if(dict[c-'a'] == 0) {
                dict[c-'a'] = (char) alphabet++;
            }
        }
                
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<message.length(); i++) {
            char c = message.charAt(i);
            if(c == ' ')
                sb.append(" ");
            else {
                sb.append(dict[c-'a']);
            }
        }
        return sb.toString();
    }
}