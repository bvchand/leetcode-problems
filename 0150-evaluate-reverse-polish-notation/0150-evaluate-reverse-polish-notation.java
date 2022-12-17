class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operations = new HashSet<>(Arrays.asList("+", "-", "/", "*"));
        
        for(int i=0; i<tokens.length; i++) {
            if(!operations.contains(tokens[i]))
                stack.push(Integer.parseInt(tokens[i]));
            else {
                int b = stack.pop(), a = stack.pop();
                switch(tokens[i]) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                }
            }
            // System.out.println(stack.toString());
        }
        return stack.pop();
    }
}