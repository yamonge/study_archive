package 접근제한자;
    // 접근제한자 : 데이터 은닉을 위해서 사용
public class PrivateMain {
        public static void main(String[] args) {
            Child child = new Child();
            System.out.println(child.getName());
            System.out.println(child.getAddress());
            System.out.println(child.getMoney());

            Parent parent = new Parent();

        }
}

class Child extends Parent{
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public int getMoney(){
        return money;
    }
}
