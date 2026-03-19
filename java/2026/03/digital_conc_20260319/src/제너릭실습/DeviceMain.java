package 제너릭실습;

import java.util.Scanner;

public class DeviceMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeviceController<Device> dc = new DeviceController<>();
        while(true){
            System.out.println("[1] 프린터 [2] 모니터 [3] 키보드");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            if(choice < 1 || choice > 3) break;
            dc.setDevice(EnumDevice.fromInt(choice).create());
            dc.PowerOn();
            dc.PowerOff();
        }
    }
}
