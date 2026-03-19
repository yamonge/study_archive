package 제너릭기본;

public class GenericPrinter <T extends Material>{
    public T material;

    public void setMaterial(T material){
        this.material = material;
    }

    public T getMaterial(){
        return material;
    }
    @Override
    public String toString(){
        return material.toString();
    }
}
