package general;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

public class TimeUnitTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(3000));
        System.out.println(TimeUnit.MILLISECONDS.toSeconds(31726));
//        long l = 1000 * 64;
//        System.out.format("%d hours %d minutes and %d seconds.", TimeUnit.MILLISECONDS.toHours(l), TimeUnit.MILLISECONDS.toMinutes(l), TimeUnit.MILLISECONDS.toSeconds(l) );
//
        long milliseconds = 64 * 60 * 1000 ;
        milliseconds = 4642792;
//        long hours = (milliseconds / 1000) / 60 / 60;
//        long minutes = (milliseconds / 1000) / 60;
//        long seconds = (milliseconds / 1000) % 60;
//        System.out.println();
//        System.out.format("%d hours %d minutes and %d seconds.", hours, minutes, seconds );
//        System.out.println();


        System.out.println(DurationFormatUtils.formatDuration(milliseconds, "HH:mm:ss,SSS"));




    }

}
