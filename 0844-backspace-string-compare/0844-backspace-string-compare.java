class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if(c == '#') {
                if(sb.length() > 0)
                    sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(c);
            }
        }
        String newS = sb.toString();
        sb.setLength(0);
        for(char c: t.toCharArray()) {
            if(c == '#') {
                if(sb.length() > 0)
                    sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(c);
            }
        }
        String newT = sb.toString();
        
        // System.out.println(newS + " " + newT);
        
        return newS.equals(newT);
    }
}