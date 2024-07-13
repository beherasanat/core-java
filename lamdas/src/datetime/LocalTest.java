package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
        System.out.println(now2.format(format));

        System.out.println(now2.getYear()+"/"+now2.getMonthValue()+"/"+now2.getDayOfMonth()+" "+now2.getHour()+":"+now2.getMinute()+":"+now2.getSecond());

        LocalDate date = LocalDate.of(2016, 12, 15);
        System.out.println(date);

        LocalDateTime now3 = now2.withHour(23).withMinute(59).withSecond(59);
        System.out.println(now3);

    }
}
