package concurrency;

import java.util.concurrent.DelayQueue;

/**
 * Created by Sabaresh on 5/22/2016.
 */
public class DelayQueueExample {

    public static void main(String[] args) throws InterruptedException {

        DelayObject d1 = new DelayObject("1", 5000L);
        DelayObject d2 = new DelayObject("2", 1000L);

        DelayQueue queue = new DelayQueue();

        queue.put(d1);
        queue.put(d2);

        System.out.println(queue.take());
        System.out.println(queue.take());

    }
}


