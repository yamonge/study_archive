package 연습문제3;

    // 기능 설계
    // - 전원 기능
    // - 온도 설정기능 1도 단위
    // 현재온도 표시기능
    // 냉방기 온오프 기능
    // 난방기 온오프 기능
    // 바람세기 설정 1,2,3단계
    // 에어컨 전체 정보 상태 메서드
public class AirCon {
    private boolean power;
    private int currentTemp;
    private int mode;
    private int windPower;

    public AirCon() {
        power = false;
        currentTemp = 18;
        mode = 0;
        windPower = 0;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getModeNema(){
        if(mode == 0){
            return "없음";
        }else if(mode == 1){
            return "냉방모드";
        }else{
            return "난방모드";
        }
    }

    public String getWindName(){
        if(windPower == 0){
            return "꺼짐";
        }else if(windPower == 1){
            return "1단계";
        }else if(windPower == 2){
            return "2단계";
        }else{
            return "3단계";
        }
    }

        public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public int getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(int currentTemp) {
        this.currentTemp = currentTemp;
    }

    public int getWindPower() {
        return windPower;
    }

    public void setWindPower(int windPower) {
        this.windPower = windPower;
    }
    }
