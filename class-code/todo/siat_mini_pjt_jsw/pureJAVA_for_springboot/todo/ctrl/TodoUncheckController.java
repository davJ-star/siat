package todo.ctrl;

import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoUncheckController {
    private TodoService service;

    public TodoUncheckController(){

    }

    public TodoUncheckController(TodoService service){
        this.service=service;
    }

    public List<TodoResponseDTO> unCheckTodo(){
        System.out.println(">>>TodoCheckContorller unCheckTodo");
        List<TodoResponseDTO> list =service.selectService1();
        return list.stream().filter(s -> s.getCheck() == 0).toList();
                    
    }

}
