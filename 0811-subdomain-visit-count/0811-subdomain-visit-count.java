class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainCountMap = new HashMap<>();
        
        for(String cpdomain: cpdomains) {
            String[] domainCount = cpdomain.split(" ");
            int count = Integer.parseInt(domainCount[0]);
            String domain = domainCount[1];
            
            int n = domain.length();
            int index = n-1;
            
            while (index >= -1) {
                if(index == -1 || domain.charAt(index) == '.') {
                    String subDomain = domain.substring(index+1, n);
                    int currCount = domainCountMap.getOrDefault(subDomain, 0);
                    domainCountMap.put(subDomain, currCount+count);
                }
                index--;
            } 
        }
        List<String> res = new ArrayList<>();
        for(String dom: domainCountMap.keySet()) {
            res.add(domainCountMap.get(dom) + " " + dom);
        }
        return res;
    }
}