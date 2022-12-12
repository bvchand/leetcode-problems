class Solution {
    public int compress(char[] chars) {
        int indexAns = 0, i = 0;
        
        while(i < chars.length) {
            char ch = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == ch) {
                i++;
                count++;
            }
            chars[indexAns] = ch;
            indexAns++;
            if(count > 1) {
                for(char c: Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
            }
        }
        return indexAns;
    }
}