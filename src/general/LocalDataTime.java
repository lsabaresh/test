package general;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.File;
import java.time.*;

public class LocalDataTime {

    public static void main(String[] args) {


        LocalDateTime localDateTime = LocalDate.now().atTime(LocalTime.MIDNIGHT);

        File file = new File("/Users/sabaresh/Documents/work/Tomcat/gdpr-services/bin/devops_configdata_backup.yml");




        LocalDateTime date =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault());




        System.out.println(localDateTime);
        System.out.println(date);

        System.out.println(date.isAfter(localDateTime));



    }
}
