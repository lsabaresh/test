package general;

import java.io.File;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class ZonedDataTimeTest {

    public static void main(String[] args) {


        LocalDateTime localDateTime = LocalDateTime.now();

        ZonedDateTime losAngelesDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/Los_Angeles"));

//        losAngelesDateTime.with

        System.out.println("losAngelesDateTime : "+losAngelesDateTime);

        System.out.println("Europe/Berlin : "+losAngelesDateTime.withZoneSameInstant(ZoneId.of("Europe/Berlin")));

        System.out.println("losAngelesDateTime : "+losAngelesDateTime);

//        ZonedDateTime.ofInstant()

        System.out.println("Instant : "+Instant.now());
        System.out.println("ZonedDateTime : "+ZonedDateTime.now());




        System.out.println("Instant before 24 : "+ZonedDateTime.ofInstant(Instant.ofEpochMilli(Instant.now().minus(1, ChronoUnit.DAYS).toEpochMilli()), ZoneOffset.UTC));

        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).minusMinutes(1440);

        ZonedDateTime inputTime = ZonedDateTime.ofInstant(Instant.now(), ZoneOffset.UTC).minusMinutes(1441);

        System.out.println("zdt 24 before time : "+zdt);
        System.out.println("inputTime time : "+inputTime);

        System.out.println("Backed 24 hours before : "+inputTime.isAfter(zdt));

    }
}
