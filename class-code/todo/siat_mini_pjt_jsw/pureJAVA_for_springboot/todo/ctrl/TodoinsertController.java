package todo.ctrl;
import todo.service.TodoService;
import todo.model.domain.TodoRequestDTO;

public class TodoinsertController {

    private TodoService service;

    //factory 만들기 전 문제가 발생한 이유
    // public TodoinsertController(){
    //     service = new TodoService();
    // }

    //factory 연결을 위한 기본 생성자, 스폐셜 생성자를 만들어야 한다.
    public TodoinsertController(){
    }

    public TodoinsertController(TodoService service){
        this.service=service;
    }


    public int insertTodo(TodoRequestDTO request){
        System.out.println(">>> TodoinsertController insertTodo");
        // return 0 ; 초기화
        return service.insertService(request);
        

    }
}
