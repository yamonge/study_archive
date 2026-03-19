package 다운캐스팅;

import java.util.ArrayList;

public class AnimalManager {
    public ArrayList<Animal> addAnimal(ArrayList<Animal> ar) {
        ar.add(new Human());
        ar.add(new Tiger());
        ar.add(new Eagle());
        return ar;
    }
}
