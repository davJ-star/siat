package todo.ctrl;
import todo.service.*;

import java.util.Optional;

import todo.model.domain.*;

public class TodoReadController {

    private TodoService service;

    // public TodoReadController(){
    //     service = new TodoService();
    // }

    public TodoReadController(){

    }
    
    public TodoReadController(TodoService service){
        this.service=service;
    }

    //상세보기 기본
    // public TodoResponseDTO selectTodo(int seq){
    //     System.out.println(">>> TodoReadController selectTodo");
    //     // return null;
    //     return service.selectService(seq);
    // }

    //상세보기 optional 좋은 코드는 아니다?
    public TodoResponseDTO selectTodo(int seq){
        System.out.println(">>> TodoReadController selectTodo");
        Optional<TodoResponseDTO> response = service.selectService(seq);
        if (response.isPresent()) {
            return response.get();
        }else{
        return null;
        }
    }


    
    //이렇게 하면 안되나? 쌤은 todoselectController를 따로 만들어서 함
    // public List<TodoRequestDTO> selectTodo(){
    //     System.out.println(">>> TodoReadController selectTodo");
    //     // return null;
    //     return service.selectService();
    // }
}
