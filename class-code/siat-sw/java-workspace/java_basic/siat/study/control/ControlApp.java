package siat.study.control;

public class ControlApp {
    /**
     * 
     */
    public String woodMan(int number) {
        String msg = null;
        // 제거할 수 있다. switch문에서 default여도 상관없다면 굳이..?
        if (!(number >= 1 && number <= 3)) {
            return "1~3 사이의 값이 아닙니다.";
            
        }
        System.out.println("산신령이 나타났습니다. ^*^");
        switch (number) {
            case 1:
                msg = "거짓말을 하는구나";
                break;
            case 2:
                msg = "또 거짓말을 하는구나";
                break;        
            case 3:
                msg = "정직하구나 너에게 모든 도끼를 주겠다.";
                break;
            
            default:
                msg = "죽을래~";
                break;
        }

        return msg;
    }
    public String woodMan2 (int number) {
        String msg = null;

        return msg;
    }
    
    /**
     * 
     */

    /**
     * @param kor
     * @param eng
     * @param math
     * @return
     */
    
    public String passOrNonpass (int kor, int eng, int math) {
        String msg = null;
        // 각 과목 점수 40점 이상 평균 60점 이상

        // 최소값 구하는 함수
        // 평균 구하는 함수

        // sum
        

        // if문으로 여러 조건을 체크하면서 내려오도록 진행한다. 해당 경우에는
        if (!(kor >= 40 && eng >= 40 && math >= 40)) { // (kor < 39 || < 39 || math < 39
            System.out.println("");
            return "";
        }
        double avg = (kor+eng+math)/3;
        if (!( avg >= 60)) {
            System.out.println("");
            return "";
        }
        msg = "avg >>" + avg;
        // return msg;

        double avg1 = (kor+eng+math)/3;
        if (kor >= 40 && eng >= 40 && math >= 40 && avg1 >= 60) {
            msg = "합격";
        }else {
            if (avg1 < 60) {
                msg = "평균 점수 미달로 불합격";
            }
            if (kor < 39) {
                msg = "국어 점수 미달로 불합격";
            }
            if (eng < 39) {
                msg = "영어 점수 미달로 불합격";
            }
            if (math < 39) {
                msg = "수학 점수 미달로 불합격";
            }
            
        }

        return msg;


    }
            // + - * / %에 대해 switch문을 사용하여 계산기를 만들어보자.
        // 1. 두 수를 입력받는다.
        // 2. 연산자를 입력받는다.
        // 3. switch문을 사용하여 계산한다.
        // 4. 결과를 출력한다.

    public double calc(int x, char oper, int y) {
        double result = 0;
        switch (oper) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = (double)x / y;
                break;
            // case '%':
            //     result = x % y;
            //     break;
            default:
                break;
        }
        return result;
    }
}
