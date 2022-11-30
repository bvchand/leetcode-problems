class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> minHeap = new PriorityQueue<>((x, y) -> Double.compare(x[0], y[0]));
        
        for(int[] point: points) {
            int x = point[0], y = point[1];
            double distFromOrigin = Math.sqrt((x*x) + (y*y));
            minHeap.add(new double[]{distFromOrigin, x, y});
        }
         
        int[][] res = new int[k][2];
        for(int i=0; i<k; i++) {
            double[] temp = minHeap.poll();
            res[i] = new int[]{(int)temp[1], (int)temp[2]};
        }
        
        return res;
    }
}