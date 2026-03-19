package 싱글톤실습;

public class Player {
    public void checkSettings(){
        GameSettings settings = GameSettings.getInstance();

        System.out.println("[Player] 현재 해상도: " + settings.resolution);
        System.out.println("[Player] 현재 볼륨: " + settings.volume);
        System.out.println("[Player] 현재 난이도: " + settings.difficulty);
    }

    public void updateSettings(String resolution, int volume, String difficulty) {
        GameSettings settings = GameSettings.getInstance();

        settings.resolution = resolution;
        settings.volume = volume;
        settings.difficulty = difficulty;

        System.out.println("[Player] 게임 설정이 업데이트되었습니다.");
    }
}
