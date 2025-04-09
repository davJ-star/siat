package todo.ctrl;
import todo.service.*;

import java.util.Map;

import todo.model.domain.*;

public class TodoUpdateController {

    private TodoService service;

    // public TodoUpdateController(){
    //     service = new TodoService();
    // }

    public TodoUpdateController(){
    }

    public TodoUpdateController(TodoService service){
        this.service=service;
    }

    //초반
    // public int updateTodo(TodoRequestDTO request){
    //     System.out.println(">>> TodoUpdateController updateTodo");
    //     // return 0;
    //     return service.updateService(request);
    // }

    public int updateTodo(Map<String,Object> map){
        System.out.println(">>> TodoUpdateController updateTodo");
        // return 0;

        // Map<String,Object> map = Map.of("title", request.getTitle(), 
        //                             "content", request.getContent(), 
        //                             "startDate", request.getStartDate(), 
        //                             "endDate", request.getEndDate(), 
        //                             "priority", request.getPriority()
        //                             // "seq", request.getSeq()
        //                             );
        return service.updateService(map);
    }


}
