class Solution {
    static Map<String, Integer> map = new HashMap<>();

    static{
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }
    
    public int romanToInt(String s) {
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