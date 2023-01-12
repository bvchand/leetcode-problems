// priority queue
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] bits = new int[10001];
        for(int num: arr)
            bits[num] = Integer.bitCount(num);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(bits[a] == bits[b])
                return a - b;
            return bits[a] - bits[b];
        });
        
        for(int num: arr)
            pq.add(num);
        
        int index = 0;
        int[] res = new int[n];
        while(!pq.isEmpty()) {
            res[index++] = pq.poll();
        }
        
        return res;
    }
}

// bit manipulation
// class Solution {
//     public int[] sortByBits(int[] arr) {
//         int n = arr.length;
//         // int[] bits = new int[n];
//         for(int i = 0; i<n; i++)
//             arr[i] += Integer.bitCount(arr[i]) * 10001;
        
//         System.out.println(Arrays.toString(arr));
//         Arrays.sort(arr);
//         System.out.println(Arrays.toString(arr));
//         for(int i=0; i<n; i++)
//             arr[i] %= 10001;
        
//         return arr;
//     }
// }