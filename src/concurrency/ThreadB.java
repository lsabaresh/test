package concurrency;

/**
 * Created by Sabaresh on 5/21/2016.
 */
public class ThreadB implements Runnable{

    TestSharedObject testSharedObject;

    public ThreadB(TestSharedObject testSharedObject) {
        this.testSharedObject = testSharedObject;
    }

    public void run(){
        testSharedObject.method2();
    }

}
