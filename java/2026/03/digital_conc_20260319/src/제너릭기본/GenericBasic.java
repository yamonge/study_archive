package 제너릭기본;
// 제너릭 : 데이터의 타입을 일반화하여, 다양한 타입의 데이터를 하나의 코드로 처리 할 수 있도록 해주는 자바의 기능

public class GenericBasic<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
