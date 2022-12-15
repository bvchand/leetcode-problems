class TimeMap {
    Map<String, List<Pair<Integer, String>>> timeMap;

    public TimeMap() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!this.timeMap.containsKey(key)) {
            this.timeMap.put(key, new ArrayList());
        }
        this.timeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!this.timeMap.containsKey(key)) {
            return "";    
        }
        
        List<Pair<Integer, String>> timestampArray = this.timeMap.get(key);
        return binarySearch(timestampArray, timestampArray.size(), timestamp);
    }
    
    public String binarySearch(List<Pair<Integer, String>> list, int n, int timestamp) {
        int left = 0, right = n;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(list.get(mid).getKey() <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return right == 0 ? "" : list.get(right-1).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 
 - hashmap of array of pairs
 - binary search on the pairs
 */