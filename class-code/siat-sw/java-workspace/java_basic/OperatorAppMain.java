public class OperatorAppMain {
    public static void main(String[] args) {
        OperatorApp op = new OperatorApp();
        op.example01();
        String result = op.example02("Hello", "World");
        System.out.println(result);


        OperatorApp obj = new OperatorApp();
        obj.example01();
        String result1 = obj.example02("kk", "광현킴");
        System.out.println(result1);


        System.out.println("1~100 사이 숫자 인가?"+obj.example04(300));

    }
}
