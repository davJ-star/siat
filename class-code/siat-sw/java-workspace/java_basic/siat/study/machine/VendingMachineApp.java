package siat.study.machine;

import java.util.Scanner;

import lombok.Builder;

@Builder
public class VendingMachineApp {
    // 콜라, 물, 비타민음료 변수정의
    // public static final String COLA = "콜라"; // 상수는 public 그리고 final과 static이니 그렇다. 
    // public static final String WATER = "물";
    // public static final String VITAMIN = "비타민음료";

    public static final int COLA = 800; // 상수는 public 그리고 final과 static이니 그렇다. 
    public static final int WATER = 500;
    public static final int VITAMIN = 1500;
    private Scanner scanner = null;
    private int choiceNum;
    private int inputMoney;
    int [] money = {1000, 500, 100};


    // init() // type = if, switch
    public void init(String type) {
        if (type == "if") {
            menuIf();
        }
        else if (type == "switch") {
            menuSwitch();
        }
    }

    // menuIf
    public void menuIf(){
        System.out.println(">>> IF Ver Vending Menu <<<");
        menu();
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("원하시는 음료를 선택주세요");
        // int choiceNum = scanner.nextInt();
        // System.out.println("투입구에 돈을 넣어주세요"); 
        // int inputMoney = scanner.nextInt();
        /**
         * 조건판단 및 잔액 반환을 생각
         * - 선택한 메뉴와 금액을 판단하여 조건 
         * - 잔액은 천원짜리, 오백원짜리, 백원짜리로 나누어서 생각
         * - 반환금액 출력
         */
        int [] menuPrices = {COLA, WATER, VITAMIN};
        if (choiceNum<1 && choiceNum>4) {
            System.out.println("번호를 잘못입력하셨습니다.");
            return;
        }



        int num = inputMoney - menuPrices[choiceNum-1]; // inputMoney - menuPrices[choiceNum];
        System.out.println("debug >>" + num + "원을 반환합니다."); //
        if (num < 0) {
            System.out.println(num + "원을 더 투입하셔야합니다.");
            return ; // 이거를 주석처리하면 그다음을 계산할 수 있겠지.
        }
        // else {
            
        // }

        // 1000, 500, 100로 나누기!
        int [] money = {1000, 500, 100};
        int [] cnt = {0, 0, 0};


        // 최소한으로 나눠줄려고한다. 몫 기준으로? / 근데 일단 %가 0이면 괜찮지만 나머지 0이 아니라면, 나머지 받아서 또 나머지 받는다.
        // 안나눠지는경우에는? 제외해야되나? 일단 그대로 나온다.
        idx기준으로 한다. 근데 일단 foreach를 쓸순잇지만 일단 cnt를 해야한다. 그게아니라면 그냥 출력해줄듯 

        근데 중간에 0원으로 안나눠지는 것도 체크해봐야될듯하다.
        for문을 쓰는게 좋을 것 같다. 
        num % money[idx] != 0 라면 num %= money[idx] 및 cnt[idx]++
        for (int idx = 0; idx < menuPrices.length; idx++) {
            
        }

        int idx = 0;
        while (num != 0){
            System.out.println(idx);
            System.out.println(num);
            
            // num -= money[idx];
            // idx++;
            // % /
            // 안나눠떨어지면 
            // if (num % money[idx] == 0) {
            //     System.out.println("1000: " + cnt[0] + "500: " + cnt[1] + "100: " + cnt[2]);
            //     break;
            // }
            
            // if (num<0) {
            //     System.out.println("잔돈으로 거스름돈을 줄수 없습니다. 담당 연락처로 문의하세요.");
            // }
        }
        if (num<0) {
            System.out.println("잔돈으로 거스름돈을 줄수 없습니다. 담당 연락처로 문의하세요.");
        }else {
            System.out.println("거스름돈을 반환합니다.");
        }


    }

    // menuSwitch
    public void menuSwitch(){
        System.out.println(">>> SWITCH Ver Vending Menu <<<");
        menu();
        int num = inputMoney - menuPrices[choiceNum-1];;
        switch (choiceNum) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
        
            default:
                break;
        }


    }
    private void menu(){
        System.out.println(">>> Vending Menu <<<");
        System.out.println("1. 콜라(800) 2. 생수(500) 3. 비타민워터(1500)");
        System.out.println("원하시는 음료번호를 입력하고 투입구에 돈을 넣어주세요");

        // 굳이 여기다가 넣지 않을려고하지만, 넣는다면!
        // 반환값 제공해주는 경우 vs 전역변수 선언해서 사용하는 경우
        // 의도하는건 바로 쓸수 있도록하는 것 같다.
        scanner = new Scanner(System.in);
        System.out.println("원하시는 음료를 선택주세요");
        choiceNum = scanner.nextInt();
        System.out.println("투입구에 돈을 넣어주세요");
        inputMoney = scanner.nextInt();

    }
    
}
