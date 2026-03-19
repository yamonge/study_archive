package 문자열다루기;
// StringBuffer, StringBuilder : 문자열을 추가하거나 변경할때 사용
public class StringMain {
    public static void main(String[] args) {
        String rst = "Hello";
        rst += " ";
        rst += "Java";
        rst += " ";
        rst += "Programming";
        System.out.println(rst);

        StringBuffer sb = new StringBuffer();
        sb.append("Hello");
        sb.append(" ");
        sb.append("Java");
        sb.append(" ");
        sb.append("Programming");
        System.out.println(sb);
    }
}
