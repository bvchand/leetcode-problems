class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1, j = num2.length()-1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        
        while (i >= 0 || j >= 0) {
            int d1 = i < 0 ? 0 : Character.getNumericValue(num1.charAt(i));
            int d2 = j < 0 ? 0 : Character.getNumericValue(num2.charAt(j));
            
            int temp = carry + d1 + d2;
            
            carry = temp / 10;
            res.append(temp % 10);
            
            i--;
            j--;
        }
        
        if(carry > 0)
            res.append(carry);
        
        return res.reverse().toString();
    }
}