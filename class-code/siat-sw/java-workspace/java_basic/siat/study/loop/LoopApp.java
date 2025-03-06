package siat.study.loop;

import lombok.Builder;

/*
 * 반복구문(for, while, do ~ while)
 */
@Builder
public class LoopApp {
    public int sumOneToTen() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }
    // public int sumStartToEnd(int start, int end) {
    //     int sum = 0;
    //     for (int i = start; i <= end; i++) {
    //         sum += i;
    //     }
    //     return sum;
    // }

    public String sumStartToEnd(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return "start: " + start + " ~ " + "end: " + end;
    }
    public String sumStartToEndWhile(int start, int end) {
        int sum = 0;
        int i = start;
       while(i <= end) {
              sum+=i;
              i++;
       }
        
        return "start: " + start + " ~ " + "end: " + end;
    }

    // 동일하게 나오는 이유는 처음에 그냥 들어가도 동일한 결과가 출력되기 때문이다.1회성 체크하고 갈리는 경우 do ~ while 쓰면 된다. 
    public String sumStartToEndDoWhile(int start, int end) {
        int sum = 0;
        int i = start;
        do {
            sum+=i;
            i++;
        }while(i <= end);
        
    
        return "start: " + start + " ~ " + "end: " + end;
    }

    // 매개변수로 입력 받은 값을 1 ~ 차례대로 누적하여 합을 구하다가
    // 입력 받은 값을 넘으면 중단하고
    // 마지막으로 더해진 값과 그때까지의 합을 출력하고 싶다면?
    // 입력값) 100
    // 출력 예시) 20 104 
    
    // 이미 더한 값을 출력한다. => 그러면 "합을 더하고 나서 break를 진행하면된다."
    public void loopbreakDoWhile(int number) {
        int i = 1;
        int sum = 0;
    
        do {
            sum += i;
            i++;
            System.out.println(sum);
            System.out.println(i);
        } while(sum <= number);
        System.out.println(" 마지막으로 더해진 값과 그때까지의 합을 출력");
        System.out.println(sum);
        System.out.println(i);
    }
    // 이미 더한 값을 출력한다. => 그러면 "합을 더하고 나서 break를 진행하면된다."
    public void loopbreak(int number) {
        int i = 1;
        int sum = 0;
    
        while(true){
            sum += i;
            i++;
            System.out.println(sum);
            System.out.println(i);
            if (sum > number) {
                break;
            }
        }
        System.out.println(" 마지막으로 더해진 값과 그때까지의 합을 출력");
        System.out.println(sum);
        System.out.println(i);
    }
    
    // 이미 더한 값을 출력한다. => 그러면 "합을 더하고 나서 break를 진행하면된다."
    public void loopbreakFor(int number) {
        int sum = 0;
        int i = 0;
        for(i = 1; ; i++){
            sum += i;
            System.out.println(sum);
            System.out.println(i);
            if (sum > number) {
                break;
            }
        }
        System.out.println(" 마지막으로 더해진 값과 그때까지의 합을 출력");
        System.out.println(sum);
        System.out.println(i);
    }
    public void gugudanCol(int dan){
        for(int i = 1; i <= 9; i++){
            System.out.println(dan + " * " + i + " = " + dan * i);
        }
    }
    public void gugudanTables(){
        for (int dan = 2; dan <= 9; dan++){
            for(int i = 1; i <= 9; i++){
                System.out.println(dan + " * " + i + " = " + dan * i);
            }
        }
    }
    public void gugudanTables2(){
        System.out.println("---check---");
        for (int dan = 2; dan <= 6; dan++){
            int i = dan;
            System.out.print(i);
            System.out.print(++i);
            System.out.print(++i);
            System.out.print(++i);
            System.out.print(++i);
            System.out.println();
            
        }
    }

}
