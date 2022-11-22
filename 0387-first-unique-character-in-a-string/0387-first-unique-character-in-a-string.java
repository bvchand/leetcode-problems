class Solution {
    public int firstUniqChar(String s) {
        int[] charFreq = new int[26];
        Arrays.fill(charFreq, 0);
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            charFreq[c-'a']++;
        }
        
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (charFreq[c-'a'] == 1)
                return i;
        }
        return -1;
    }
}

/**
space: O(1)
time: O(N)
*/