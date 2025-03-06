package siat.study.tmp;

import java.util.Scanner;



/**
 * 소수란 ? 1과 자기자신으로만 나누어지는 수
 * 판단 로직(for, if)
 * - 0 1은 소수가 아니다.
 * - 어떤 숫자가 소수인지를 판단하려면 2~ 입력된 숫자까지 차례대로 나누어보고
 * = 나머지가 0인 경우가 한번도 없으면 그 수는 소수
 * - 즉, N보다 작은 자연수들로 나누어지는 방버식
 */
public class PrimeApp {
    public String primeNumber(){
        System.out.println("소수 판별을 위해서 숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean isFlage = true;

        if (number < 2) {
            return "1과 2는 소수가 아닙니다.";
        }
        // 2~number-1까지 나누면된다.(1씩증가하느것이므로 규칙적으로 증감식이 있는 for 활용) 나누어지는게 없으면 나누어지는게 없으면 소수 => 판별만 할 것이기 때문!
        // 나누어지는게 있다면 소수가 아님. 한개라도 있으면 아닌거니 그것만 체크해보는게 효율적!
        for (int i = 2; i < number ; i++) {
            if (number % i == 0) {
                isFlage = false;
                break;
            }
        }

        return "소수 판별 결과: " + isFlage;
    }
}
