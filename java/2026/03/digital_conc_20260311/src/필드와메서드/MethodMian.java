package 필드와메서드;

public class MethodMian {
    public static void main(String[] args) {
        class sample{
            int x = 200;
            int y = 300;

            int sum(int x, int y){
                return x + y;
            }

            void hello(){
                System.out.println("Hello");
            }

            String rtnHello(){
                return "안녕하세요";
            }

            int rtnNum(){
                return x + y;
            }
            int sum2(int... nums){
                int sum = 0;
                for(int num : nums){
                    sum += num;
                }

                return sum;
            }
        }
    }
}
