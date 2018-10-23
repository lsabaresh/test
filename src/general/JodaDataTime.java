package general;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.util.Locale;

public class JodaDataTime {

    public static void main(String[] args) {


        DateTime now = DateTime.now();

        System.out.println(now);
        System.out.println(now.toDateTime(DateTimeZone.UTC));
//        System.out.println(DataTim);



        System.out.println(DateTimeFormat.longDate().withLocale(new Locale("IW", "IL")).print(new DateTime()));

        System.out.println(DateTimeFormat.forPattern("dd.mm.yyyy,").withLocale(new Locale("IW", "IL")).print(new DateTime()));
    }
}
