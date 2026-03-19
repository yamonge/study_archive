package 싱글톤실습;

public class GameMain {
    public static void main(String[] args) {
        Player player1 = new Player();

        player1.checkSettings();

        player1.updateSettings("2560x1440", 80, "Hard");

        System.out.println("최종 볼륨: " + GameSettings.getInstance().volume);
    }
}
