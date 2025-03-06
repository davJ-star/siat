import siat.study.control.ControlApp;
import siat.study.loop.LoopApp;

public class ControlAppMain {
    public static void main(String[] args) {
        ControlApp demo = new ControlApp();
        System.out.println(demo.woodMan(1));

        double result = demo.calc(10, '+', 20);
        System.out.println("result : " + result);



    }
    

        
}
