package todo.ctrl;

import java.util.Comparator;
import java.util.List;

import todo.model.domain.TodoResponseDTO;
import todo.service.TodoService;

public class TodoSortController {
    private TodoService service;

    public TodoSortController(){

    }

    public TodoSortController(TodoService service){
        this.service=service;
    }

    public List<TodoResponseDTO> sortTodo(){
        System.out.println(">>>TodoSortContorller sortTodo");
        List<TodoResponseDTO> list = service.selectService1();
        return list.stream()
                    // .sorted(Comparator.comparing(TodoResponseDTO::getPriority));
            .sorted(Comparator.comparing(TodoResponseDTO::getPriority).reversed())
            .toList();
    }

}
