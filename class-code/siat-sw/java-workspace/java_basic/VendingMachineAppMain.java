import siat.study.machine.VendingMachineApp;

public class VendingMachineAppMain {
    public static void main(String[] args) {
        VendingMachineApp app = VendingMachineApp.builder()
                                    .build();
        app.init("if");
    }
}
