public class VariableApp {
    public static void main(String[] args) {
        int age = 20;
        double height = 176.8;
        char gender = 'M';
        String name = "swJeong";
        boolean isMarriage = false;


        System.out.println(age);
        System.out.println(height);
        System.out.println(gender);
        System.out.println(name);
        System.out.println(isMarriage);
        ////////////////////////////////////
        byte x = 10, y = 10, sum = 0;
        sum = (byte)(x+y); // +면 기본적으로 bite machine은 정수 연산으로 보기 때문에 에러가 난다.
        // down casting 해야한다.

        char charValue01 = 'A';
        char charValue02 = 'B';

        System.out.println('a' + 'b'); // 195 char -> int
        System.out.println("a" + "b"); // ab
        System.out.println(charValue01 + charValue02); // 131
        System.out.println((char)97); // A

    }
}

/**
 * 
 * // 변수: 하나의 값을 저장할 수 있는 메모리 공간
        // 변수 선언: 자료형 변수명;
        // 변수 초기화: 변수명 = 값;
        // 변수 선언과 초기화: 자료형 변수명 = 값;
        // 변수 사용: 변수명
        // 변수명: 소문자로 시작, 카멜 표기법
        // 자료형: 기본타입, 참조타입
        // 기본타입: 숫자(정수, 실수), 문자, 문자열, 논리
        // 참조타입: 9개 기본타입을 제외한 나머지
        // 변수명은 소문자로 시작하고 카멜 표기법을 사용한다.
        // 변수명은 의미를 부여하여 작성한다.
        // 변수명은 자바 예약어를 사용할 수 없다.
        // 변수명은 중복을 허용하지 않는다.
        // 변수명은 숫자로 시작할 수 없다.
        // 변수명은 특수문자는 '_'와 '$'만 사용할 수 있다.
        // 변수명은 대소문자를 구분한다.
        // 변수명은 길이에 제한이 없다.
        // 변수명은 자바 예약어를 사용할 수 없다.
        // 변수명은 중복을 허용하지 않는다.
        // 변수명은 숫자로 시작할 수 없다.
        // 변수명은 특수문자는 '_'와 '$'만 사용할 수 있다.
        // 변수명은 대소문자를 구분한다.
        // 변수명은 길이에 제한이 없다.
        // 변수명은 자바 예약어를 사용할 수 없다.
        // 변수명은 중복을 허용하지 않는다.
        // 변수명은 숫자로 시작할 수 없다.
        // 변수명은 특수문자는 '_'와 '$'만 사용할 수 있다.
        // 변수명은 대소문자를 구분한다.
        // 변수명은 길이에 제한이 없다.
        // 변수명은 자바 예약어를 사용할 수 없다.
        // 변수명은 중복을 허용하지 않는다.
        // 변수명은 숫자로 시작할 수 없다.
        
 */