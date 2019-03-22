package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class ScheduledExecutor {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


        Runnable job1 = () -> System.out.println("job 1");

        //------------------

        System.out.println("---------Schedule after some time ---------");

        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(job1, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1500);

        System.out.println("Delay "+scheduledFuture.getDelay(TimeUnit.MILLISECONDS));


        //------------------

        System.out.println("---------Schedule at Fixed Rate - doesn't take into account the actual duration of the task.  ---------");

        scheduledExecutorService.scheduleAtFixedRate(job1, 0, 2, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(6);

        scheduledExecutorService.shutdown();

        //------------------

        System.out.println("---------Schedule at Fixed Delay -  wait time period applies between the end of a task and the start of the next task. ---------");

        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Scheduling: " + System.nanoTime());
            }
            catch (InterruptedException e) {
                System.err.println("task interrupted");
            }
        };

        scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleWithFixedDelay(task, 0, 2, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(10);

        scheduledExecutorService.shutdown();

    }


}
