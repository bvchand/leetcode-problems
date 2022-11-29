/*
time = O(max(N,M))
space = O(max(N,M))
*/

class Solution {
    public Pair<Integer, Integer> getRevision(String version, int start, int length) {
        if (start >= length)
            return new Pair(0, length);
        
        int end = start;
        while(end < length && version.charAt(end)!='.')
            end++;
        
        int value;
        if (end != length-1)
            value = Integer.parseInt(version.substring(start, end));
        else
            value = Integer.parseInt(version.substring(start, length));
                
        return new Pair(value, end+1);
    }
    
    public int compareVersion(String v1, String v2) {
        int i1 = 0, i2 = 0;
        int len1 = v1.length(), len2 = v2.length();
        
        while (i1 < len1 || i2 < len2) {
            Pair<Integer, Integer> rev1 = getRevision(v1, i1, len1);
            Pair<Integer, Integer> rev2 = getRevision(v2, i2, len2);
            
            int val1 = rev1.getKey(); i1 = rev1.getValue();
            int val2 = rev2.getKey(); i2 = rev2.getValue();
            
            if(val1 != val2)
                return val1 > val2 ? 1 : -1;
        }
        return 0;
    }
}

// /*
// time = O(N+M+max(N,M))
// space = O(N+M)
// */
// class Solution {
//     public int compareVersion(String version1, String version2) {
//         int res = 0;
//         String[] s1 = version1.split("\\.");
//         String[] s2 = version2.split("\\.");
        
//         int maxLength = Math.max(s1.length, s2.length);
//         for (int i=0; i<maxLength; i++) {
//             int v1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
//             int v2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;
            
//             System.out.println(v1 + " " + v2);
            
//             if (v1 < v2) {
//                 return -1;
//             }
//             else if (v1 > v2) {
//                 return 1;
//             }
//         }
//         return res;
//     }
// }