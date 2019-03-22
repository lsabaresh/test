package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * Created by Sabaresh on 5/22/2016.
 */
public class ReentrantLockTest {

    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        ReentrantLockTest r = new ReentrantLockTest();

        r.increment();

        ExecutorService service = Executors.newFixedThreadPool(2);

        IntStream.range(1, 10000).forEach( v -> service.submit(r::increment));

        TimeUnit.SECONDS.sleep(4);

        System.out.println("count : "+r.count);

        service.shutdownNow();

    }

    int count = 0;

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
