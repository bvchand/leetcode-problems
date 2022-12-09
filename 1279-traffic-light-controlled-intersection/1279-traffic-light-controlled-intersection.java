class TrafficLight {
    private Lock lock;
    private boolean isRoadAGreen;

    public TrafficLight() {
        this.lock = new ReentrantLock(true);
        this.isRoadAGreen = true;
    }
    
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) throws InterruptedException {
        lock.lock();
        try {
            if((roadId == 1 && !isRoadAGreen) || (isRoadAGreen && roadId == 2)) {
                isRoadAGreen = !isRoadAGreen;
                turnGreen.run();
            }
            crossCar.run();
        } finally {
            lock.unlock();
        }
    }
}