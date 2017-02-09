package concurrency;

import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/**
 * Created by Sabaresh on 5/20/2016.
 */
public class SyncStaticMethodTest {

    public static void main(String args[]) throws InterruptedException {

        Thread threada = new Thread(new ThreadA(new TestSharedObject()));
        Thread threadb = new Thread(new ThreadB(new TestSharedObject()));
        System.out.println("Starting Thread A");
        threada.start();
        Thread.sleep(1000);
        System.out.println("Starting Thread B");
        threadb.start();
    }
}
