class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> result = new LinkedList<>();
        
        for(int i = 0; i < intervals.length; i++) {
            int[] currInterval =  intervals[i];
            
            if(result.isEmpty() || result.getLast()[1] < currInterval[0]) {
                result.add(currInterval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], currInterval[1]);
            }
            
        }
            
        return result.toArray(new int[result.size()][2]);
    }
}