package 제너릭실습;

public class DeviceController <T extends Device>{
    private T device;

    public T getDevice() {
        return device;
    }

    public void setDevice(T device) {
        this.device = device;
    }

    public void PowerOn(){
        device.turnOn();
    }

    public void PowerOff(){
        device.turnOff();
    }
}
