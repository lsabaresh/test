package concurrency;

/**
 * Created by Sabaresh on 5/21/2016.
 */
public class ThreadA implements Runnable{

    TestSharedObject testSharedObject;

    public ThreadA(TestSharedObject testSharedObject) {
        this.testSharedObject = testSharedObject;
    }

    public void run(){
        try {
            testSharedObject.method1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
