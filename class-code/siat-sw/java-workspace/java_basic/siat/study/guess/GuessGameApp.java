package siat.study.guess;

import java.util.Scanner;

import lombok.Builder;

@Builder
public class GuessGameApp {
    public static int generatorNan(){
        int answer = (int)(Math.random()*100) + 1; 

        return answer;
    }

    /**
     * 
     * 
     * @param answer
     * @return
     */
    public String gameFor(int answer) {
        Scanner scanner = new Scanner(System.in);
        for (int index = 0; index < 10; index++) {
            // 맞으면 break;
            if (answer == scanner.nextInt()) {
                return "정답입니다.";
            }
        }
        return "오답입니다.";
    }
    public String gameWhile(int answer) {
        Scanner scanner = new Scanner(System.in);
        int index = 0; 
        while(index < 10) {
            // 맞으면 break;
            if (answer == scanner.nextInt()) {
                return "정답입니다.";
            }
            index++;
        }
        return "오답입니다.";
    }
    public String gameDoWhile(int answer) {
        Scanner scanner = new Scanner(System.in);
        int index = 0; 
        do {
            // 맞으면 break;
            if (answer == scanner.nextInt()) {
                return "정답입니다.";
            }
            index++;
        }while(index < 10);
        return "오답입니다.";
    }
}
