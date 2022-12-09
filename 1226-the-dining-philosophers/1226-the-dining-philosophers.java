class DiningPhilosophers {

    public Semaphore[] forkLocks;

    public DiningPhilosophers() {
        this.forkLocks = new Semaphore[5];
        for (int i=0; i<5; i++) {
            this.forkLocks[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int phil,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        int nextPhil = (phil + 1) % 5;
        
        int leftFork = (phil + (phil % 2)) % 5;
        int rightFork = (phil + ((phil + 1) % 2)) % 5;
        
        
        this.forkLocks[leftFork].acquire();         // fork 1
        this.forkLocks[rightFork].acquire();        // fork 2
        
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        
        this.forkLocks[leftFork].release();         // fork 1
        this.forkLocks[rightFork].release();        // fork 2
    
    }
}