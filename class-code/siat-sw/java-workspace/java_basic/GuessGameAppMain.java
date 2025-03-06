import siat.study.guess.GuessGameApp;

public class GuessGameAppMain {
    public static void main(String[] args) {
        // System.out.println(args);
        int answer = GuessGameApp.generatorNan();
        System.out.println("정답: " + answer);

        GuessGameApp app1 = GuessGameApp.builder()
                                .build();
        String result1 = app1.gameFor(answer);
        String result2 = app1.gameWhile(answer);
        String result3 = app1.gameDoWhile(answer);

        System.out.println(result1);     
        System.out.println(result2);
        System.out.println(result3);
        
    }
}
