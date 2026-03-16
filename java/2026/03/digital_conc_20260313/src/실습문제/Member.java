package 실습문제;

public class Member {
    private static int count = 0;
    private int id;
    private String name;
    private String userId;
    private String password;
    private int age;

    public Member(String name, String userId, String password, int age){
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.age = age;
        count++;
        id = count;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean login(String userId, String password) {
        if (this.userId.equals(userId) && this.password.equals(password)) {
            System.out.println(name + "님 환영합니다.");
            return true;
        } else {
            if (!this.userId.equals(userId)) {
                System.out.println("존재하지 않는 아이디입니다.");
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
            }
            return false;
        }
    }

    public void changePassword(String oldPassword, String newPassword){
        if(this.password.equals(oldPassword)){
            this.password = newPassword;
            System.out.println("비밀번호가 변경되었습니다.");
        }else{
            System.out.println("현재 비밀번호가 일치하지 않습니다.");
        }
    }

    public void updateProfile(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("프로필이 업데이트되었습니다.");
    }

    public void printInfo(){
        System.out.printf("이름: %s\n", name);
        System.out.printf("아이디: %s\n", userId);
        System.out.printf("나이: %d\n", age);
    }

    public static void deleteAccount(){
        count--;
    }
}
