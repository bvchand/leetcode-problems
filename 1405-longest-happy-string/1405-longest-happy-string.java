class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        
        PriorityQueue<Pair<Integer, Character>> queue = new PriorityQueue<>((m, n) -> (n.getKey() - m.getKey()));
        if(a != 0)  queue.offer(new Pair(a, 'a'));
        if(b != 0)  queue.offer(new Pair(b, 'b'));
        if(c != 0)  queue.offer(new Pair(c, 'c'));
        
        while(!queue.isEmpty()) {
            Pair<Integer, Character> pair = queue.poll();
            int count = pair.getKey();
            char ch = pair.getValue();
            
            if(res.length() < 2 || !(res.charAt(res.length() - 1) == ch && res.charAt(res.length() - 2) == ch)) {
                res.append(ch);
                count--;
            } else {
                if(queue.isEmpty())
                    break;
                Pair<Integer, Character> pair2 = queue.poll();
                int count2 = pair2.getKey();
                char ch2 = pair2.getValue();

                res.append(ch2);
                count2--;
                if(count2 != 0)     queue.offer(new Pair(count2, ch2));
            }
            if(count != 0)     queue.offer(new Pair(count, ch));
        }
        return res.toString();
        
    }
}