package sendit.pl;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Date {
    public static void main (String [] args)
    {
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId london = ZoneId.of("America/Chicago");

        LocalTime lc1 = LocalTime.now(london);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String datka = lc1.format(formatter2);

        String tt = String.valueOf(lc1);
        System.out.println(tt);
        System.out.println("Londyn " +lc1);
        Date d = new Date();
        LocalDate dzis= LocalDate.now();
        java.util.Date newDate= new java.util.Date();
        SimpleDateFormat formatowanie=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println(formatowanie.format(d));
        System.out.println("new" + dzis);
        LocalDate plus=dzis.plusDays(2);
        System.out.println(plus);
        LocalDate outcome=dzis.minusWeeks(6);
        System.out.println("outcome"+outcome);
        LocalDate jutro= dzis.plusDays(1);
        System.out.println(jutro);

        LocalDate heh= LocalDate.of(2018,5,30);
        System.out.println(heh);



        System.out.println(heh.getDayOfWeek());

        DateTimeFormatter formatter= DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.getDefault());






    }

    }
