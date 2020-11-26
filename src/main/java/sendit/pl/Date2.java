package sendit.pl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class Date2 {
    public static void main (String [] args)
    {
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId london = ZoneId.of("Europe/London");

        LocalDateTime ld = LocalDateTime.now(london);
        System.out.println(ld);
        LocalTime lc1 = LocalTime.now(london);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm G D");
        System.out.println(formatter.format(ld));





    }

    }
