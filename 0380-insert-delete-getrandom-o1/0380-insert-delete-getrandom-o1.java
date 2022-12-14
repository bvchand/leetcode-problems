class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> array;
    Random rand = new Random();

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.array = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        // System.out.println("insert: " + map.toString());
        if(this.map.containsKey(val))
            return false;
        
        int index = this.array.size();
        this.map.put(val, index);
        this.array.add(index, val);
        return true;
    }
    
    public boolean remove(int val) {
        // System.out.println("remove: " + map.toString());
        if(!this.map.containsKey(val))
            return false;
        
        int index = this.map.get(val), lastIndex = this.array.size()-1;
        
        int lastElement = this.array.get(lastIndex);
        this.array.set(index, lastElement);
        this.map.put(lastElement, index);
        
        this.array.remove(lastIndex); 
        this.map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        // System.out.println("random: " + map.toString());
        return this.array.get(rand.nextInt(this.array.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */