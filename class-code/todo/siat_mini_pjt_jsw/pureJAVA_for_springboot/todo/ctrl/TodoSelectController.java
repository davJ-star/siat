package todo.ctrl;
import java.util.List;
import todo.service.*;
import todo.model.domain.*;

public class TodoSelectController {
    
    private TodoService service;

    //factory 만들기 전 문제가 발생한 이유
    // public TodoSelectController(){
    //     service = new TodoService();
    // }

    //factory 연결을 위한 기본 생성자, 스폐셜 생성자를 만들어야 한다.
    //기본생성자 :  직접 객체를 생성할 경우 대비하여 필요함.
    public TodoSelectController(){
    }

    //스폐셜 생성자 : Factory 패턴을 적용할 때 같은 TodoService 인스턴스를 공유하도록 하기 위해 필요함.
    public TodoSelectController(TodoService service){
        this.service=service;
    }


    public List<TodoResponseDTO> selectTodo1(){
        System.out.println(">>> TodoSelectController selectTodo1");
        // return null;
        return service.selectService1();
    }
    
}
