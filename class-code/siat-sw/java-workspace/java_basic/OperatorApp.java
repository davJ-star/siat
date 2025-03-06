public class OperatorApp {
    OperatorApp(){

    }

    // 반환값 x, 매개변수 x인 example01 메소드
    public void example01(){
        System.out.println("example1 메소드 호출");
        System.out.println(">>> 산술연산자 +, -, *, /, %");
        int x = 100, y = 100, result = 0;

        System.out.println(" + " + (x + y)); // 서로다른 타입의 데이터를 더하면 연결 연산자로 파악하면된다.
        
        
        System.out.println(">>> 증감연산자 ++, --" ); // 서로다른 타입의 데이터를 더하면 연결 연산자로 파악하면된다.
        System.out.println(" ++ " + (x++) + (++x)); // 서로다른 타입의 데이터를 더하면 연결 연산자로 파악하면된다.

        int number = 20;
        result = ++number + 3; // 21 + 3
        System.out.println("++ result : " + result); // 24

        int number2 = 20;
        result = number2++ + 3; // 20 + 3
        System.out.println("result ++ : " + result); // 23
        
        System.out.println(">>> 삼항 연산자");

        // 삼항 연산자로도 elif를 구현할 수 있다.
        String strMsg = (number > 0) ? "양수" : (number == 0) ? "0" : "음수";
        System.out.println("strMsg : " + strMsg);
        System.out.println(">>> 논리연산자 &, |, !, &&, ||"); // if A && ++a로 쓸수있다.
        
        System.out.println(">>> 비교연산자 ==, !=, >, <, >=, <=");



    }

    // 반환값 String, 매개변수 문자열 두개를 입력받는 example02 메소드
    public String example02(String str1, String str2) {
        return str1 + "\t" + str2;
    }
    // 반환값 String, 매개변수 정수값 한 개를 입력받아서 홀수인지 짝수인지를 판별하는 example03 메소드
    // public String example03(int number) {
    //     return (number % 2 == 0) ? "짝수" : "홀수";
    // }    
    
    // 나는 이렇게 선택권을 주는게 명확하게 하는게 좋은 것 같다. -> "이게 더 좋은 선택"
    public boolean example03(int number) {
        return (number % 2 == 0);
    }   
    // 반환값 boolean, 매개변수 정수값 한 개를 입력받아서 홀수인지 짝수인지를 판별하는 example04 메소드
    // public boolean example04(int number) {
    //     // 1~100사이 값인지(true) 아닌지(false) 판단
    //     return (number < 101 && number > 0); // number < 101과 number > 1로 실수했다. 양끝값은 항상 체크한다.
    // }   
    // 가독성 좋게 할려면 일단 return 변수를 설정해두고 return 값을 넣어둔다.
    public boolean example04(int number) {
        // 1~100사이 값인지(true) 아닌지(false) 판단
        boolean isFlage = true;   
        return (number < 101 && number > 0); // number < 101과 number > 1로 실수했다. 양끝값은 항상 체크한다.
    }   
}
