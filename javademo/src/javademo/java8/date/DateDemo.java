package javademo.java8.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * java8 date convertion
 */
public class DateDemo {
    @Test
    public void dateTest() {
        LocalDate nowDate = LocalDate.now();
        System.out.printf("now date is: %s%n", nowDate);
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.printf("now datetime is: %s%n", nowDateTime);
        LocalTime nowTime = LocalTime.now();
        System.out.printf("now time is: %s%n", nowTime);
        ZonedDateTime nowZonedDateTime = ZonedDateTime.now();
        System.out.printf("now zoned date time is: %s%n", nowZonedDateTime);
        Instant nowInstant = Instant.now();
        System.out.printf("now instant is: %s%n", nowInstant);

        System.out.printf("now year:%s, month:%s, day:%s%n", nowDate.getYear(), nowDate.getMonthValue(), nowDate.getDayOfMonth());
        LocalDate inputDate = LocalDate.of(2018, 6, 18);
        LocalDateTime inputDateTime = LocalDateTime.of(2018, 3, 15, 12, 30, 40, 50);
        System.out.printf("input date is: %s, dateTime is: %s%n", inputDate, inputDateTime);
        System.out.printf("input date add 3 days is: %s%n", inputDate.plus(3, ChronoUnit.DAYS));
        if (inputDate.isAfter(nowDate)) {
            System.out.println("inputDate is after nowDate");
        } else {
            System.out.println("inputDate is before nowDate");
        }

        System.out.printf("instant UTC is: %s, systemDefaultZone millis is: %s%n", Clock.systemUTC().instant(), Clock.systemDefaultZone().millis());
        // date和instant转换
        Date date = new Date();
        System.out.println("date => instant:" + inputDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("date => instant:" + date.toInstant());
        System.out.println("instant => date:" + Date.from(Instant.now()));
        // date转localdate
        Instant instant = date.toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("date => localdate:" + localDate);
        // localdate转date
        ZonedDateTime zonedDateTime = nowDate.atStartOfDay(ZoneId.systemDefault());
        Date date1 = Date.from(zonedDateTime.toInstant());
        System.out.println("localdate => date:" + date1);
        // 日期解析，默认格式，不可变且线程安全
        String tomorrow1 = "20180819";
        LocalDate tomorrowParsed1 = LocalDate.parse(tomorrow1, DateTimeFormatter.BASIC_ISO_DATE);
        String tomorrow2 = "2018-08-19T10:15:30";
        LocalDate tomorrowParsed2 = LocalDate.parse(tomorrow2, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("tomorrow => tomorrowParsed1:" + tomorrowParsed1 + ", tomorrowParsed2:" + tomorrowParsed2);
        // 自定义格式解析
        String tomorrow3 = "2018/08/19";
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate tomorrowParsed3 = LocalDate.parse(tomorrow3, pattern);
        System.out.println("tomorrow => " + tomorrowParsed3);
        // 日期格式化
        LocalDate dayAfterTomorrow = nowDate.plusDays(2);
        String dayAfterTomorrowStr = dayAfterTomorrow.format(pattern);
        System.out.println("day after tomorrow => " + dayAfterTomorrowStr);
        Instant plusInstant = instant.plus(Duration.ofDays(4)).plus(Duration.ofHours(4)).plus(Duration.ofMinutes(20));
        System.out.println("plus instant => " + plusInstant);
        // date加7天
        date = new Date();
        Instant instant1 = date.toInstant();
        Instant plus = instant1.plus(7, ChronoUnit.DAYS);
        LocalDate localDate1 = plus.atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("now plus 7 days is localdate1:" + localDate1.toString());
    }
}
