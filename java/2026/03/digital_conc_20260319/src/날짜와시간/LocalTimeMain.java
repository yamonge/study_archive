package 날짜와시간;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalTimeMain {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now(); // 오늘 날짜
        LocalTime time = LocalTime.now(); // 현재 시간
        LocalDateTime dateTime = LocalDateTime.now(); // 날짜와 시간
        ZonedDateTime zoned = ZonedDateTime.now();

        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(zoned);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEEE zzzz");
//        System.out.println(dateTime.format(formatter));
//
//        String[] patterns = {
//                "yyyy-MM-dd HH:mm:ss",
//                "yyyy/MM/dd",
//                "yyyy년 MM월 dd일",
//                "HH:mm:ss",
//                "hh:mm a",
//                "yyyy-MM-dd E요일",
//                "yyyyMMddHHMS",
//                "yyyy-MM-dd G"
//        };
//        String a = patterns[0];
//        System.out.println(a);
//        for (String pattern : patterns){
//            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(pattern);
//            System.out.println(dateTime.format(formatter2));
//        }

        // 시간대 처리
        ZonedDateTime zoned2 = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(zoned2.format(formatter));
        ZonedDateTime zoned3 = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zoned3.format(formatter));
        ZonedDateTime zoned4 = ZonedDateTime.now(ZoneId.of("Europe/London"));
        System.out.println(zoned4.format(formatter));
    }
}
