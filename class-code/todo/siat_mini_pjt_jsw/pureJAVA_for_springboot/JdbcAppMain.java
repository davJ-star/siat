import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import todo.model.domain.TodoResponseDTO;

public class JdbcAppMain {
    public static void main(String[] args) {
        JdbcDao dao = new JdbcDao();


        // 입력
        // System.out.println(">>> 입력");
        // TodoRequestDTO request = TodoRequestDTO.builder()
        //                                         .title("JDBC")
        //                                         .content("jdbc")
        //                                         .priority(5)
        //                                         .build();
        
        // int insertFlag = dao.insertRow(request) ; 
        // if (insertFlag != 0) {
        //     System.out.println("1 row insert ok");
        // } else {
        //     System.out.println("1 row insert fail");
        // }


        // 삭제
        // System.out.println(">>> 삭제");
        // int deleteFlag = dao.deleteRow(1) ; 
        // if (deleteFlag != 0) {
        //     System.out.println("1 row delete ok");
        // } else {
        //     System.out.println("1 row delete fail");
        // }


        // 업데이트
        // System.out.println(">>> 업데이트");
        // Map<String,Object> map = new HashMap<>();
        // map.put("content", "자바데이터베이스커넥티비티");
        // map.put("status","Y");
        // map.put("seq",2);

        // int updateFlag = dao.updateRow(map) ;
        // if (updateFlag != 0) {
        //     System.out.println("1 row update ok");
        // } else {
        //     System.out.println("1 row update fail");
        // }
        

        // 전체보기
        // System.out.println(">>> 전체보기");
        // List<TodoResponseDTO> list = dao.selectRow1();
        // for(TodoResponseDTO response : list){
        //     System.out.println(response);
        // }


        // 상세보기
        System.out.println(">>> 상세보기");
        Optional<TodoResponseDTO> op = dao.selectRow(2);
        if (op.isPresent()) {
            System.out.println(op.get());
            }
        }
    
}
