package concurrency;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sabaresh on 5/22/2016.
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

        queue.put("1");


//        System.out.println(queue.take());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll(10, TimeUnit.SECONDS));
    }
}
