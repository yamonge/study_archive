package 날짜와시간;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMain {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        // 원하는 형식으로 변경해서 출력
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat adf2 = new SimpleDateFormat("yyyy년 MM일 dd일 HH시 mm분 ss초");
        System.out.println(sdf.format(date));
        System.out.println(adf2.format(date));

        SimpleDateFormat sdf3 = new SimpleDateFormat("HH시 mm분 ss초");
        System.out.println(sdf3.format(date));
    }
}
