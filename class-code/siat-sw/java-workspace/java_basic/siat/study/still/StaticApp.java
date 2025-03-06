package siat.study.still;

public class StaticApp {
    public int nonStaticVar;
    public static int StaticVar;
    public void sumRandom(){
        int nan = (int)(Math.random() * 100)+1;
        System.out.println(nan);

        int sum = 0;
        for(int i = 0; i <= nan; i++){
            sum+=i;
        }
        System.out.println(sum);
    }
    

}
