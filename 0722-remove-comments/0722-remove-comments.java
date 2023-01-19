class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean blockActive = false;
        StringBuilder sb = new StringBuilder();
        
        for(String line: source) {
            int n = line.length();
            
            if(!blockActive)
                sb = new StringBuilder();
            
            for(int i=0; i<n; i++) {
                char c = line.charAt(i);
                if(blockActive) {
                    if(i < n-1 && c == '*' && line.charAt(i+1) == '/') {
                        i++;
                        blockActive = false;
                    }
                } else {
                    if(c == '/') {
                        if(i < n-1 && line.charAt(i+1) == '/')
                            break;
                        else if(i < n-1 && line.charAt(i+1) == '*') {
                            blockActive = true;
                            i++;
                        } else {
                            sb.append(c);
                        }
                    } else {
                        sb.append(c);
                    }
                }
            }
            if(!blockActive && sb.length() > 0)
                res.add(sb.toString());
        }
        return res;
    }
}