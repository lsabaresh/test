package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sabaresh on 5/22/2016.
 */
public class ReentrantLockTest {

    public static void main(String[] args) {


        ReentrantLock lock = new ReentrantLock();

        lock.lock();
    }
}
