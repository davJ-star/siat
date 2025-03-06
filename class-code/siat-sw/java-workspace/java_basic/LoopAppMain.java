import siat.study.loop.LoopApp;

public class LoopAppMain {
    public static void main(String[] args) {

        LoopApp loopDemo = LoopApp.builder()
                                .build();
        System.out.println(loopDemo);
        int result = loopDemo.sumOneToTen();
        System.out.println(result);


        // int result2 = loopDemo.sumStartToEnd(1, 1000);
        // System.out.println(result2);
        
        String result2 = loopDemo.sumStartToEnd(1, 1000);
        System.out.println(result2);
        String result3 = loopDemo.sumStartToEndWhile(1, 1000);
        System.out.println(result3);
        String result4 = loopDemo.sumStartToEndDoWhile(1, 1000);
        System.out.println(result4);

        loopDemo.gugudanTables2();
    }
}
