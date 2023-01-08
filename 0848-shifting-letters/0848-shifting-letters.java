class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder();
        int prevShifts = 0;
        for(int i = shifts.length-1; i >= 0; i--) {
            shifts[i] = (shifts[i] + prevShifts)%26 ;
            prevShifts = shifts[i];
        }
        
        for(int i=0; i<s.length(); i++) {
            int currIndex = s.charAt(i) -'a';
            char shiftTo = (char) ((currIndex + shifts[i]) % 26 + 'a');
            sb.append(shiftTo);
        }
        return sb.toString();
    }
}