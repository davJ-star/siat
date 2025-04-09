package todo.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import todo.model.domain.*;

public class TodoDao {
    // TodoView, FrontController 작성 후
    private List<TodoResponseDTO> list;
    private int idx;
    public TodoDao(){
        list = new ArrayList<TodoResponseDTO>();
    }

    
    //입력
    public int insertRow(TodoRequestDTO request){
        System.out.println(">>> dao insertRow");
        TodoResponseDTO response = TodoResponseDTO.builder()
                                    .seq(idx++)
                                    .title(request.getTitle())
                                    .content(request.getContent())
                                    .check(0)
                                    .startDate(request.getStartDate())
                                    .endDate(request.getEndDate())
                                    .priority(request.getPriority())
                                    .build();
        list.add(response);
        return 0 ;
    }

    //상세보기
    // public TodoResponseDTO selectRow(int seq){
    //     System.out.println(">>> dao selectRow");
    //     TodoResponseDTO response = null;
    //     for(int idx = 0 ; idx < list.size() ; idx++){
    //         if (list.get(idx).getSeq()==seq) {
    //             response = list.remove(idx);
    //             break;
    //         }
    //     }
    //     // return null;
    //     return response;
    // }

    //상세보기 optional
    public Optional<TodoResponseDTO> selectRow(int seq){
        System.out.println(">>> dao selectRow");
        Optional<TodoResponseDTO> response = Optional.empty();
        for(int idx = 0 ; idx < list.size() ; idx++){
            if (list.get(idx).getSeq()==seq) {
                response = Optional.of(list.get(idx));
            }
        }
        // return null;
        return response;
    }

    //삭제
    public int deleteRow(int seq){
        System.out.println(">>> dao deleteRow");
        int flag = 0 ;
        // for(TodoResponseDTO dto : list){
        //     if (dto.getSeq()==seq) {
        //         list.remove(seq);
        //         break;
        //     }
        // }
        for(int idx = 0 ; idx < list.size() ; idx++){
            if (list.get(idx).getSeq()==seq) {
                list.remove(idx);
                break;
            }
        }
        // return 0; //초기화
        return flag;
    }

    //수정 초반
    // public int updateRow(TodoRequestDTO request){
    //     System.out.println(">>> dao updateRow");
    //     return 0;
    // }

    //수정 factory
    public int updateRow(Map<String,Object> map){
        System.out.println(">>> dao updateRow");
        int flag = 0 ;
        for(int idx = 0 ; idx < list.size() ; idx++){
            if (list.get(idx).getSeq()==(Integer)(map.get("seq"))) {
                list.get(idx).setContent((String)(map.get("content")));
                list.get(idx).setCheck((Integer)map.get("check"));
                list.get(idx).setCheck((Integer)map.get("uncheck"));
                flag = 1;
            }
        }
        // return 0; //초기화
        return flag;
    }
    //하고 난 후에 TodoResponse에서 @Setter 삽입

    //전체보기
    public List<TodoResponseDTO> selectRow1(){
        System.out.println(">>> dao selectRow1");
        return list;
    }

    // //전체보기 Optional
    // public List<TodoResponseDTO> selectRow1(){
    //     System.out.println(">>> dao selectRow1");
    //     return list;
    // }


}
