// reverse string and add to stack until '(' ecountered
class Solution {
    public int calculate(String s) {
        int n = s.length();
        int operand = 0;
        int sign = 1;
        int res = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                operand = (int) operand * 10  + (int) (c - '0');
            } else if(c =='+') {
                res += sign * operand;
                sign = 1;
                operand = 0;
            } else if(c == '-') {
                res += sign * operand;
                sign = -1;
                operand = 0;
            } else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                
                sign = 1;
                res = 0;
            } else if(c == ')') {
                res += sign * operand;
                res *= stack.pop();
                res += stack.pop();
                operand = 0;
            }
        }
        if(operand != 0)    res += (sign * operand);
        return res;
    }
}