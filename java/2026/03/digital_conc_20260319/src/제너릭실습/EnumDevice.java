package 제너릭실습;

import java.util.function.Supplier;

public enum EnumDevice {
    PRINTER(() -> new Printer()),
    MONITER(() -> new Moniter()),
    KEYBOARD(() -> new Keyboard());

    private final Supplier<Device> supplier;
    EnumDevice(Supplier<Device> supplier){
        this.supplier = supplier;
    }

    public Device create(){
        return supplier.get();
    }

    public static EnumDevice fromInt(int choice){
        int index = choice - 1;
        if(index < 0 || index >= values().length){
            return null;
        }
        return values()[index];
    }
}
