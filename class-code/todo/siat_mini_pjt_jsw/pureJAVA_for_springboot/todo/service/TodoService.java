package todo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import todo.model.dao.TodoDao;
import todo.model.dao.TodoOracleDao;
import todo.model.domain.*;;
public class TodoService {
    
    // private TodoDao dao;
    private TodoOracleDao dao;

    public TodoService(){
        dao = new TodoOracleDao();
    }

    //입력
    public int insertService(TodoRequestDTO request){
        System.out.println(">>> service insertService");
        return dao.insertRow(request);
        // return 0 ; 초기화
    }

    //상세보기 기본
    // public TodoResponseDTO selectService(int seq){
    //     System.out.println(">>> service selectService");
    //     // return null;
    //     return dao.selectRow(seq);
    // }

    //상세보기 optional
    public Optional<TodoResponseDTO> selectService(int seq){
        System.out.println(">>> service selectService");
        // return null;
        return dao.selectRow(seq);
    }

    //삭제
    public int deleteService (int seq){
        System.out.println(">>> service deleteService");
        // return 0;
        return dao.deleteRow(seq);
    }

    //수정 초반
    // public int updateService (TodoRequestDTO request){
    //     System.out.println(">>> service updateService");
    //     // return 0;
    //     return dao.updateRow(request);
    // }

    
    //수정 factory
    public int updateService (Map<String,Object> map){
        System.out.println(">>> service updateService");
        // return 0;
        return dao.updateRow(map);
    }


    //전체보기
    public List<TodoResponseDTO> selectService1(){
        System.out.println(">>> service selectService1");
        // return null;
        return dao.selectRow1();
    }
}
