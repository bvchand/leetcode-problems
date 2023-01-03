class Leaderboard {
    
    private Map<Integer, Integer> scores;
    private Map<Integer, Integer> sortedScores;

    public Leaderboard() {
        this.scores = new HashMap<>();
        this.sortedScores = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        int newScore = score;
        if(this.scores.containsKey(playerId)) {
            int prevScore = this.scores.get(playerId);
            int prevCount = this.sortedScores.get(prevScore);
            
            this.sortedScores.put(prevScore, prevCount-1);
            
            newScore += prevScore;
        }        
        this.scores.put(playerId, newScore);
        this.sortedScores.put(newScore, this.sortedScores.getOrDefault(newScore, 0)+1);
    }
    
    public int top(int k) {
        int sum = 0, count = 0;
        for(Map.Entry<Integer, Integer> scoreEntry: this.sortedScores.entrySet()) {
            int score = scoreEntry.getKey(), times = scoreEntry.getValue();
            for(int i=0; i<times; i++) {
                sum += score;
                count++;
                if(count == k)  break;
            }
            if(count == k)  break;
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int score = this.scores.get(playerId);
        this.sortedScores.put(score, this.sortedScores.get(score)-1);
        
        if(this.sortedScores.get(score) == 0)
            this.sortedScores.remove(score);
        
        this.scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */