package concurrency;

/**
 * Created by Sabaresh on 5/21/2016.
 */
public class TestSharedObject {

    public synchronized void method1() throws InterruptedException {
        System.out.println("method 1 is called");
        Thread.sleep(10 * 1000);
        System.out.println("method 1 is Completed");
    }

    public synchronized void method2() {
        System.out.println("method 2 is called");
        System.out.println("method 2 is Completed");
    }
}
