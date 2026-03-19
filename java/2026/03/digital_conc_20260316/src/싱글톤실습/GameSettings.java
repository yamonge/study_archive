package 싱글톤실습;

public class GameSettings {
    String resolution;
    int volume;
    String difficulty;

    private static final GameSettings gameSettings = new GameSettings();

    private GameSettings() {
    }

    public static GameSettings getInstance() {
        return gameSettings;
    }
}
