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
        System.out.println("Starting "+threada.getName());
        threada.start();
        Thread.sleep(1000);
        System.out.println("Starting "+threadb.getName());
        threadb.start();
    }

    static class ThreadA implements Runnable{

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

    static class ThreadB implements Runnable{

        TestSharedObject testSharedObject;

        public ThreadB(TestSharedObject testSharedObject) {
            this.testSharedObject = testSharedObject;
        }

        public void run(){
            testSharedObject.method2();
        }

    }

    static class TestSharedObject {

        public static synchronized void method1() throws InterruptedException {
            System.out.println(Thread.currentThread().getName()+  " method 1 is called");
            Thread.sleep(4 * 1000);
            System.out.println(Thread.currentThread().getName()+ " method 1 is Completed");
        }

        public static synchronized void method2() {
            System.out.println(Thread.currentThread().getName()+  " method 2 is called");
            System.out.println(Thread.currentThread().getName()+  " method 2 is Completed");
        }

    }
}

