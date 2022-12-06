class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> times = new HashMap<>();
        List<String> names = new ArrayList<>();
        
        for(int i=0; i<keyName.length; i++) {
            String name = keyName[i], time = keyTime[i];
            String[] timeSplit = time.split(":");
            int timeStamp = Integer.parseInt(timeSplit[0])*60 + Integer.parseInt(timeSplit[1]);
            // System.out.println(timeStamp);
            times.computeIfAbsent(name, val -> new ArrayList<>()).add(timeStamp);
            
        }
        
        // System.out.println(times.toString());
        
        for(String name: times.keySet()) {
            List<Integer> timesPerPerson = times.get(name);
            Collections.sort(timesPerPerson);
            // System.out.println("hi");
            // System.out.println(timesPerPerson.toString());
            Queue<Integer> queue = new LinkedList<>();
            for(int t: timesPerPerson) {
                queue.offer(t);
                if(t - queue.peek() > 60)
                    queue.poll();
                
                if(queue.size() >= 3) {
                    names.add(name);
                    break;
                }
            }
            
        }
        Collections.sort(names);
        // System.out.println(names.toString());
        return names;
    }
}