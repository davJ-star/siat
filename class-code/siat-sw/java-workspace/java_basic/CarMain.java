public class CarMain {
    public static void main(String[] args) {
        Car audiCar = new Car();
        
        System.out.println("차 생산기관: " + audiCar.maker);
        System.out.println("차 생산모델: " + audiCar.model);
        System.out.println("------------------");
        // 인스턴스 소유의 메소드 호출하기
        audiCar.drive();

        String result =audiCar.repaire();
        System.out.println("차량 수리 결과: " + result);


        




    }
}
