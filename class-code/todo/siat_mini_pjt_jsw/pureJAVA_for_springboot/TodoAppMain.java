

import java.util.List;
import todo.ctrl.*;
import todo.model.domain.*;

public class TodoAppMain {
    public static void main(String[] args) {
        TodoRequestDTO request = TodoRequestDTO.builder()
                                .title("씨앗키우기")
                                .content("잘~")
                                .startDate("2025-03-17")
                                .endDate("2025-03-21")
                                .priority(3)
                                .build();
        
        //quiz (입력)
        //사용자로부터 입력받은 데이터를 TodoInsertController(insertTodo)에 전달하여
        // TodoService(insertService) -> TodoDao(insertDao) 작업을 수행하고 반환받는다.
        // 실행 결과를 반환받는다.

        //입력
        TodoinsertController insertControl = new TodoinsertController();
        int insert = insertControl.insertTodo(request);
        System.out.println(insert);

        /*  이건 퀴즈 답에 맞지 않다.
        // TodoService service = new TodoService();
        // service.insertService(request);

        // TodoDao dao = new TodoDao();
        // dao.insertRow(request);
        */

        //Quiz (상세보기)
        // 사용자로부터 입력받은 키를 TodoReadController(selectTodo) 전달하여
        // TodoService(selectService) -> TodoDao(selectDao) 작업을 수행하고 반환받는다.
        // 실행 결과(TodoResponsDTO)를 반환받는다.

        // 상세보기
        TodoReadController readControl = new TodoReadController();
        TodoResponseDTO response = readControl.selectTodo(1);
        System.out.println(response);

        //삭제
        TodoDeleteController deleteControl = new TodoDeleteController();
        int delete = deleteControl.deleteTodo(1);
        System.out.println(delete);

        //수정
        TodoUpdateController updateControl = new TodoUpdateController();
        int update = updateControl.updateTodo(request);
        System.out.println(update);

        //전체보기
        TodoSelectController listControl = new TodoSelectController();
        List<TodoResponseDTO> lst = listControl.selectTodo1();
        //반복?
        // for(TodoResponseDTO dto : lst) {
        //     System.out.println( dto ); 
        // }
        System.out.println(lst);
    }
}
