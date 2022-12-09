class FizzBuzz {
    private int n;
    private int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(i <= n) {
            if(this.i % 3 == 0 && this.i % 5 != 0) {
                printFizz.run();
                this.i++;
                notifyAll();
            } else
                wait();
        }

    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(i <= n) {
            if(this.i % 5 == 0 && this.i % 3 != 0) {
                printBuzz.run();
                this.i++;
                notifyAll();
            } else
                wait();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i <= n) {
            if(this.i % 5 == 0 && this.i % 3 == 0) {
                printFizzBuzz.run();
                this.i++;
                notifyAll();
            } else
                wait();
        }
        
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
            if(this.i % 5 != 0 && this.i % 3 != 0) {
                printNumber.accept(this.i);
                this.i++;
                notifyAll();
            } else
                wait();
        }
    }
}