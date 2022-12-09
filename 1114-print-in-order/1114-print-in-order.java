class Foo {
    
    private boolean firstDone = false;
    private boolean secondDone = false;

    public Foo() {
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.firstDone = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        while(!this.firstDone) {
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        this.secondDone = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(!this.secondDone) {
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}