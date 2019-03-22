package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sabaresh on 5/14/2016.
 */
public class ExecutorInvokeAny {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                callable("task1", 5),
                callable("task2", 4),
                callable("task3", 3));

        try {
            System.out.println(executor.invokeAny(callables));
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }

    public static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            System.out.println("result  "+result+ "running");
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }
}
