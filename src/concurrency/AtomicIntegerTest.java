package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by Sabaresh on 5/14/2016.
 */
public class AtomicIntegerTest {

    private static int i = 0;


    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);


        List<Future<Integer>> list = new ArrayList<>();

        IntStream.range(0,10).forEach(i -> {
            System.out.println("i "+i+" submitted");
                    list.add(executor.submit(atomicInt::incrementAndGet));
        }
        );

        list.forEach(future ->  {
            try {
                System.out.println( future.get());
            }
            catch (Exception e) {
                throw new IllegalStateException(e);
            }
        });

        System.out.println(atomicInt.get());    // => 1000

        System.out.println("############################################");

        AtomicInteger atomicInt1 = new AtomicInteger(0);
        List<Future<?>> list1 = new ArrayList<>();

        IntStream.range(0, 10)
                .forEach(i -> {
                    Callable<Integer> task = () -> atomicInt1.updateAndGet(n -> i + n);
                    list1.add(executor.submit(task));
                });

        list1.forEach(future ->  {
            try {
                System.out.println( future.get());
            }
            catch (Exception e) {
                throw new IllegalStateException(e);
            }
        });

        System.out.println("atomicInt : "+atomicInt1.get());
        System.out.println("############################################");

        AtomicInteger  atomicInt2 = new AtomicInteger(0);
        List<Future<Integer>>  list2 = new ArrayList<>();

        IntStream.range(0, 10)
                .forEach(i -> {
                    Callable<Integer> task = () -> atomicInt2.accumulateAndGet(i, (n, m) -> {
                        System.out.println("n "+n+", m "+m);
                        return n + m;});
                    list2.add(executor.submit(task));
                });

        list2.forEach(future ->  {
            try {
                System.out.println( future.get());
            }
            catch (Exception e) {
                throw new IllegalStateException(e);
            }
        });

        System.out.println("atomicInt2 "+atomicInt2.get());
        executor.shutdown();
    }
}
