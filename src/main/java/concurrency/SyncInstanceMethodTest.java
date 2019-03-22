package concurrency;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/**
 * Created by Sabaresh on 5/20/2016.
 */
public class SyncInstanceMethodTest {

    public static void main(String args[]) throws InterruptedException {
        TestSharedObject testSharedObject = new TestSharedObject();
        Thread threada = new Thread(new ThreadA(testSharedObject), "Thread A");
        Thread threadb = new Thread(new ThreadB(testSharedObject), "Thread B");

        //------------------

        System.out.println("---------same object - only one synchronized instance method allowed to executed ---------");

        System.out.println("Starting "+Thread.currentThread().getName());
        threada.start();
        Thread.sleep(1000);
        System.out.println("Starting "+Thread.currentThread().getName());
        threadb.start();

        System.out.println("---------method B has to wait till A complete ---------");

        TimeUnit.SECONDS.sleep(10);

        //------------------

        System.out.println("---------different object - does not matter ---------");

        threada = new Thread(new ThreadA(new TestSharedObject()), "Thread A");
        threadb = new Thread(new ThreadB(new TestSharedObject()), "Thread B");


        System.out.println("Starting "+Thread.currentThread().getName());
        threada.start();
        Thread.sleep(1000);
        System.out.println("Starting "+Thread.currentThread().getName());
        threadb.start();

        System.out.println("---------method B did not wait for A to complete ---------");

    }
}

class ThreadA implements Runnable{

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

class ThreadB implements Runnable{

    TestSharedObject testSharedObject;

    public ThreadB(TestSharedObject testSharedObject) {
        this.testSharedObject = testSharedObject;
    }

    public void run(){
        testSharedObject.method2();
    }

}

class TestSharedObject {

    public synchronized void method1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+  " method 1 is called");
        Thread.sleep(4 * 1000);
        System.out.println(Thread.currentThread().getName()+ " method 1 is Completed");
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName()+  " method 2 is called");
        System.out.println(Thread.currentThread().getName()+  " method 2 is Completed");
    }

}

