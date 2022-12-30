/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> (a.start - b.start));
        
        for(List<Interval> list: schedule) {
            for(Interval interval: list) {
                pq.offer(interval);
            }
        }
        
        Interval curr = pq.poll();
        while(!pq.isEmpty()) {
            Interval next = pq.poll();
            if(curr.end >= next.start)
                next.end = Math.max(curr.end, next.end);
            else {
                res.add(new Interval(curr.end, next.start));
            }
            
            curr = next;
        }
        
        return res;
    }
}