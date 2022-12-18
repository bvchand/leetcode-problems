class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();    // (index, value)
        int[] result = new int[temp.length];
        
        // stack.push(new Pair(0, temp[0]));
        
        for(int i=0; i<temp.length; i++) {
            int currTemp = temp[i];
            while(!stack.isEmpty() && stack.peek().getValue() < currTemp) { // curr temperature is warmer than the last value in stack
                Pair<Integer, Integer> prev = stack.pop();
                int prevIndex = prev.getKey(), prevTemp = prev.getValue();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(new Pair(i, currTemp));
        }
        
        return result;
    }
}