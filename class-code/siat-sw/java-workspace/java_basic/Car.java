public class Car {
    //String maker = null, model = null; 
    public String maker = "Audi", model = "A4"; // 일단 위에 대로 작성하는게 원칙이자만 생성자를 아직 안배운 상황이다.

    public int price = 100000;

    // 메소드
    // [접근지정자] 반환타입 메서드명([매개변수]){}
    public void drive(){
        System.out.println("매개변수도 없고, 반환값도 없습니다.");
        System.out.println("운전을 시작합니다.");
    }
    public String repaire() {
        return "차량이 수리되었습니다.";
    }
    public void performence(String fuel) {
        System.out.println("매개변수 있고, 반환타입이 없습니다.");
        System.out.println(fuel + "충전되었습니다.");
    }
    public String speed(int speed) {
        System.out.println("매개변수 있고, 반환타입이 존재한다.");
        
        return "과속중입니다.";
    }
}
