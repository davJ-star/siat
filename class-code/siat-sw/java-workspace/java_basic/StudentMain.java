public class StudentMain {
    public static void main(String[] args) {
        // 항상 템플릿 == 클래스라고 이해하도록 한다.
        // 그렇기 때문에 인스턴스 생성해서 써야된다. => 습관화!!
        Student stu = new Student();
        String name = stu.name;
        char gender = stu.gender;
        System.out.println("당신의 이름은 : " + name);
        System.out.println("당신의 성별은 : " + gender);
    }
}
