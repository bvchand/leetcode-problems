class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};
        
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            // char c1 = s.charAt(i);
            if(i < s.length() - 1) {
                // char c2 = s.charAt(i+1);
                String s1 = s.substring(i, i+2);
                if(map.containsKey(s1)) {
                    res += map.get(s1);
                    i++;
                    continue;
                }
            }
            String s2 = s.substring(i, i+1);
            if(map.containsKey(s2))
                res += map.get(s2);
        }
        return res;
    }
}