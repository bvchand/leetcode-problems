// bit manipulation
class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        // int[] bits = new int[n];
        for(int i = 0; i<n; i++)
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for(int i=0; i<n; i++)
            arr[i] %= 10001;
        
        return arr;
    }
}