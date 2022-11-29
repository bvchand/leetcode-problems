class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0, j=0;
        int res = 0;
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        while (i <= s1.length || j <= s2.length) {
            int v1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
            int v2 = j < s2.length ? Integer.parseInt(s2[j]) : 0;
            
            System.out.println(v1 + " " + v2);
            
            if (v1 < v2) {
                return -1;
            }
            else if (v1 > v2) {
                return 1;
            }
            else {
                i++;
                j++;
            }
        }
        return res;
    }
}