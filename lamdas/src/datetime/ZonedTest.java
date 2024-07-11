package datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedTest {
    public static void main(String[] args) {
        ZonedDateTime currentZone = ZonedDateTime.now();
        System.out.println(currentZone);

        ZoneId zid = ZoneId.of("Asia/Tokyo");
        System.out.println(zid);

        ZonedDateTime tokyoTime = currentZone.withZoneSameInstant(zid);
        System.out.println(tokyoTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(tokyoTime));
    }
}
