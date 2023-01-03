class Solution {
    public String makeFancyString(String s) {
        if(s == null || s.length() < 2)
            return s;
        
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        
        for(int i=2; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c != sb.charAt(sb.length()-1) || c != sb.charAt(sb.length()-2))
                sb.append(c);
        }
        return sb.toString();
    }
}