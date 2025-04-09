package todo.front;

import todo.ctrl.TodoSelectController;
import todo.ctrl.TodoSortController;
import todo.ctrl.TodoUncheckController;
import todo.ctrl.TodoUpdateController;
import todo.ctrl.TodoinsertController;
import todo.factory.BeanFactory;
import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import todo.ctrl.TodoCheckController;
import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoReadController;


public class FrontController {

    //factory 를 통해서 가져온다.
    private BeanFactory factory;
    public FrontController(){
        factory=BeanFactory.getInstance();
    }




    // 1 : 전체보기, 2 : 입력 3 : 삭제 4 : 수정 5: 상세보기


    public TodoResponseDTO read(int seq){
        System.out.println(">>> FrontController read");
        TodoReadController readCtrl =  (TodoReadController)factory.getCtrl("read");
        // TodoResponseDTO readFlag = readCtrl.selectTodo(seq);
        // return readFlag;

        return readCtrl.selectTodo(seq);
    }



    public List<TodoResponseDTO> list(){
        System.out.println(">>> FrontController list");
        // TodoSelectController selectCtrl = new TodoSelectController();
        TodoSelectController selectCtrl = (TodoSelectController)factory.getCtrl("list"); 
        List<TodoResponseDTO> list = selectCtrl.selectTodo1();
        return list;
    }

    public int register(String title,String content,int priority){
        System.out.println(">>> FrontController register");
        // TodoinsertController insertCtrl = new TodoinsertController();
        TodoinsertController insertCtrl = (TodoinsertController)factory.getCtrl("register"); 
        TodoRequestDTO request = TodoRequestDTO.builder()
                                .title(title)
                                .content(content)
                                .priority(priority)
                                .build();
        int insertFlag = insertCtrl.insertTodo(request);
        return insertFlag;
    }

    public int update(int seq, String content, String check){
        System.out.println(">>> FrontController update");
        // TodoUpdateController updateCtrl = new TodoUpdateController();
        TodoUpdateController updateCtrl = (TodoUpdateController)factory.getCtrl("update"); 
        
        //TodoRequestDTO에서는 seq를 가져올 수 없다. 그렇다고 TodoResponseDTO에서 가져올수도 없다.(DB에서 꺼내오는 DTO이기 때문에)
        // TodoRequestDTO request = TodoRequestDTO.builder()
        //                         .seq(seq) 
        //                         .content(content)
        //                         .build();
        //int updateFlag = updateCtrl.updateTodo(request);
        //return updateFlag;

        //그래서 map을 활용한다.
        Map<String,Object> map = new HashMap<>();
        map.put("seq",seq);
        map.put("content",content);
        map.put("status",check);
        int updateFlag = updateCtrl.updateTodo(map);
        return updateFlag;
    }

    public int delete(int seq){
        System.out.println(">>> FrontController delete");
        // TodoDeleteController deleteCtrl = new TodoDeleteController();
        TodoDeleteController deleteCtrl = (TodoDeleteController)factory.getCtrl("delete");
        int deleteFlag = deleteCtrl.deleteTodo(seq);
        return deleteFlag;
    }


    ///// subMenu
    
    public List<TodoResponseDTO> checkList(){
        System.out.println(">>> FrontController checkList");
        // TodoSelectController selectCtrl = new TodoSelectController();
        TodoCheckController checkCtrl = (TodoCheckController)factory.getCtrl("check"); 
        List<TodoResponseDTO> list = checkCtrl.checkTodo();
        return list;
    }

    public List<TodoResponseDTO> uncheckList(){
        System.out.println(">>> FrontController unCheckList");
        TodoUncheckController unCheckCtrl = (TodoUncheckController)factory.getCtrl("uncheck");
        List<TodoResponseDTO> list = unCheckCtrl.unCheckTodo();
        return list;
    }


    public List<TodoResponseDTO> sort(){
        System.out.println(">>> FrontController cortList");
        TodoSortController sortCtrl = (TodoSortController)factory.getCtrl("sort");
        List<TodoResponseDTO> list = sortCtrl.sortTodo();
        return list;
    }



    
}
