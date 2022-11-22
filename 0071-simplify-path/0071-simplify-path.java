class Solution {    
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");
                
        for (String str: array) {
            // String str = array[i].trim();
            if (str.equals(".") || str.isEmpty()) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(str);
            }
        }
        
        if (stack.isEmpty()) 
            return "/";
        
        StringBuilder sb = new StringBuilder();
        for (String str: stack)
            sb.append("/" + str);
        return sb.toString();
    }
}