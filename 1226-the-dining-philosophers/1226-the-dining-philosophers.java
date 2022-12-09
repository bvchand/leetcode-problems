class DiningPhilosophers {

    public Lock[] forkLocks;

    public DiningPhilosophers() {
        this.forkLocks = new ReentrantLock[5];
        for (int i=0; i<5; i++) {
            this.forkLocks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public synchronized void wantsToEat(int phil,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        // int nextPhil = (phil + 1) % 5;
        
//         int leftFork = (phil + (phil % 2)) % 5;
//         int rightFork = (phil + ((phil + 1) % 2)) % 5;
        
        int leftFork = phil;
        int rightFork = (phil+1) % 5;
        
        if (leftFork > rightFork) {
            int temp = rightFork;
            rightFork = leftFork;
            leftFork = temp;
        }
        
        
        this.forkLocks[leftFork].lock();         // fork 1
        this.forkLocks[rightFork].lock();        // fork 2
        
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        
        this.forkLocks[leftFork].unlock();         // fork 1
        this.forkLocks[rightFork].unlock();        // fork 2
    
    }
}