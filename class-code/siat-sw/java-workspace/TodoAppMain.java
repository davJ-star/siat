import java.util.List;

import todo.ctrl.TodoDeleteController;
import todo.ctrl.TodoInsertController;
import todo.ctrl.TodoSelectController;
import todo.ctrl.TodoUpdateController;
import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class TodoAppMain {
    public static void main(String[] args) {
        // 프론트에서 데이터를 보냈다고 가정하고 dto에 담아놓는 상황을 가정함.
        TodoRequestDTO request = TodoRequestDTO.builder()
                                    .title("씨앗키우기")
                                    .content("잘~")
                                    .startDate("2025-03-17")
                                    .endDate("2025-03-21")
                                    .priority(3)
                                    .build();

// controller에 작성하지만 이부분을 떼와서 여기서 작성한다.                                    
        // 사용자로부터 입력받은 데이터를 TodoInsertController에 전달하여
        // TodoService(insertService) -> TodoDao(insertDao) 작업을 수행하고
        // 실행결과를 반환받는다.

        // TodoInsertController에 전달
        TodoInsertController insertController = new TodoInsertController();
        // insertController.insertTodo(request);
        int insertFlag = insertController.insertTodo(request);
        System.out.println(insertFlag);
        // // TodoService(insertService)
        // // request를 활용한다. -> service에 있다고 가정하고 빼온다. 대신에 해당 내부 구현은 어려우니 insertService는 출력만해주겠지...
        // TodoService service = new TodoService();
        // service.insertService(request); // 넘겨줘야하나 각각 따로 생성한다.

        // // TodoDao(insertDao)
        // TodoDAO dao = new TodoDAO();
        // int row = dao.insertRow(request);

        // System.out.println(row);


        // Quize(상세보기)
        // 사용자로부터 입력받은 키를 TodoReadController(selectTodo) = 추가
        // TodoService(= 추가: selectService) -> TodoDao(= 추가: selectRaw) 작업을 수행하고
        // 실행결과(TodoResponseDTO)를 반환 받는다.

        TodoSelectController selectCtrl = new TodoSelectController();
        TodoResponseDTO selectFlag = selectCtrl.selectTodo(request);
        System.out.println(selectFlag);
        
        // Quize(삭제)
        // 우선 controller 작성 -> service -> dao -> (requestDTO(빈값일듯)를 통해 responseDTO 삭제한다.(requestDTO 삭제도 가능))
        TodoDeleteController deleteCtrl = new TodoDeleteController();
        int deleteFlag = deleteCtrl.deleteTodo(0);
        System.out.println(deleteFlag);
        
        // Quize(수정)
        TodoUpdateController updateCtrl = new TodoUpdateController();
        int updateFlag = updateCtrl.updateTodo(0);
        System.out.println(updateFlag);
        
        
        
        // Quize(전체보기)
        // controller 이름을 표준화시킬수있지만... 
        // TodoSelectController listCtrl = new TodoSelectController();
        // List<TodoResponseDTO> listFlag = listCtrl.selectTodo(request);
        // System.out.println(listFlag);


    }
}
