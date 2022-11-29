/*
BFS
time: O(N)
space: O(N)
*/
class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int index = queue.poll();
            if(arr[index] == 0)
                return true;
            for(int newIndex: new int[]{index + arr[index], index - arr[index]}) {
                if(newIndex >= 0 && newIndex < arr.length && !visited[newIndex]) {
                    queue.offer(newIndex);
                    visited[newIndex] = true;
                }
            }
        }
        return false;
    }
}