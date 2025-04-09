package todo.ctrl;

import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoCheckController {
    private TodoService service;

    public TodoCheckController(){

    }

    public TodoCheckController(TodoService service){
        this.service=service;
    }

    public List<TodoResponseDTO> checkTodo(){
        System.out.println(">>>TodoCheckContorller checkTodo");
        List<TodoResponseDTO> list =service.selectService1();
        return list.stream().filter(s -> s.getCheck() == 1).toList();
                    
    }

}
