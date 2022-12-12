class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch))
                map.put(ch, Arrays.asList(i, i));
            else 
                map.get(ch).set(1, i);
        }
        // System.out.println(map.toString());
        
        List<List<Integer>> intervals = new ArrayList<>(map.values());
        LinkedList<List<Integer>> finalIntervals = new LinkedList<>();
        
        Collections.sort(intervals, (a,b) -> Integer.compare(a.get(0), b.get(0)));        
        
        for(List<Integer> interval: intervals) {
            int start = interval.get(0), end = interval.get(1);
            if(finalIntervals.size() == 0 || finalIntervals.getLast().get(1) < start)
                finalIntervals.add(interval);
            else
                finalIntervals.getLast().set(1, Math.max(end, finalIntervals.getLast().get(1)));
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<finalIntervals.size(); i++) {
            int start = finalIntervals.get(i).get(0), end = finalIntervals.get(i).get(1);
            result.add(end - start + 1);
        }
        
        return result;
    }
}