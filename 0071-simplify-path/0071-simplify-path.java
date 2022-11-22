class Solution {    
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");
        
        System.out.println(Arrays.toString(array));
        
        for (int i = 0; i < array.length; i++) {
            String str = array[i].trim();
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