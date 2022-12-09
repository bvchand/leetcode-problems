// class Foo {
    
//     private boolean firstDone = false;
//     private boolean secondDone = false;

//     public Foo() {
//     }

//     public synchronized void first(Runnable printFirst) throws InterruptedException {
        
//         // printFirst.run() outputs "first". Do not change or remove this line.
//         printFirst.run();
//         this.firstDone = true;
//         notifyAll();
//     }

//     public synchronized void second(Runnable printSecond) throws InterruptedException {
        
//         while(!this.firstDone) {
//             wait();
//         }
//         // printSecond.run() outputs "second". Do not change or remove this line.
//         printSecond.run();
//         this.secondDone = true;
//         notifyAll();
//     }

//     public synchronized void third(Runnable printThird) throws InterruptedException {
//         while(!this.secondDone) {
//             wait();
//         }
//         // printThird.run() outputs "third". Do not change or remove this line.
//         printThird.run();
//     }
// }

class Foo {
    private Semaphore s2;
    private Semaphore s3;
    
    public Foo() {
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        printSecond.run();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        printThird.run();
    }
}