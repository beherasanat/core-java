package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;

public class _2prog_PeriodAndDuration {
    public static void main(String[] args) {
        periodTest();
        durationTest();
    }

    public static void periodTest() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.withYear(2000).withMonth(12).withDayOfMonth(1);
        Period period = Period.between(localDate1, localDate);
        System.out.println(period);
    }

    public static void durationTest() {
        LocalDateTime localDate = LocalDateTime.now();
        LocalDateTime localDate1 = localDate.withYear(2000).withMonth(12).withDayOfMonth(1).withHour(5).withMinute(5).withSecond(5);
        Duration duration = Duration.between(localDate, localDate1);
        System.out.println(duration);
        Duration d = Duration.of(1, ChronoUnit.DAYS);
        LocalDateTime dd = localDate.plus(d);
        System.out.println(dd+" \n"+localDate);

        System.out.println(localDate.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
    }
}
