package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchronizedIncrementTest {

    int count = 0;
    int count1 = 0;

    public static void main(String[] args) {
        ExecutorService executor = Executors
                .newFixedThreadPool(2);

        SynchronizedIncrementTest instance = new SynchronizedIncrementTest();

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(instance::increment));

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(instance::incrementWithSynchronized));

        ConcurrentUtils.stop(executor);

        System.out.println("Count : "+instance.count);
        System.out.println("Count - synchronized : "+instance.count1);

    }

    synchronized void incrementWithSynchronized() {
        count1 = count1 + 1;
    }

    void increment() {
        count = count + 1;
    }
}
