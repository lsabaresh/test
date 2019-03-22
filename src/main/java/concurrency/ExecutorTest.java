package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Sabaresh on 5/14/2016.
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3");

        try {
            executor.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    //.map(Future::get)
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            System.out.println(executor.invokeAny(callables));
        } catch (Exception e) {
            e.printStackTrace();
        }




        executor.shutdown();
    }
}
