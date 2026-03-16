package 테레비전;

public class TvMain {
    public static void main(String[] args) {
        Television tv1 = new Television();
        Television tv2 = new Television();
        Television tv3 = new Television();
        Television tv4 = new Television();
        Television tv5 = new Television();

        tv1.setPower(true);
        tv1.setVolume(13);
        tv1.setChannel(15);
        tv1.printTV();
        tv1.setPower(false);
    }
}
