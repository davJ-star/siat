import siat.study.still.StaticApp;

public class StaticAppMain {
    public static void main(String[] args) {
        StaticApp.StaticVar = 10;
        System.out.println(StaticApp.StaticVar);

        StaticApp obj1 = new StaticApp();
        obj1.nonStaticVar = 20;
        System.out.println(obj1.nonStaticVar);
        
    }
}
