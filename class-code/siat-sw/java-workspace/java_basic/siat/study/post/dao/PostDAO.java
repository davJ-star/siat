package siat.study.post.dao;
import siat.study.post.domain.PostRequestDTO;
import siat.study.post.domain.PostResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;



// JPA를 사용할 때는 DAO를 사용하지 않는다. => Repository를 사용한다. 
// DBMS와 작업을 전담하는 역할
// CRUD 작업을 생각하면된다.

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDAO {
    // CRUD 역할이고, SERVICE는 지금 AryMain이다.
    // view는 프론트엔드로 생각하고 dto로 담아서 데이터를 전달하기 때문에 매개변수로 dto를 받는다. SERVICE에서 DAO에 전달한다.
    // DAO는 지금 여기기때문에 dto를 받아서 CRUD를 하면된다.


    private PostRequestDTO [] requestAry;
    private int idx = 0;
    

    // insertRow() 메서드이다.
    // service에서 dto를 받아서 dao에 전달한다. dao에 전달하는 과정은 매개변수로 제공(다만 생성은 무조건 필수.)
    public void insertRow(PostRequestDTO request){
        System.out.println("insertRow() 호출");
        requestAry[idx++] = request;
    }
    // selectRow() 메서드이다.
    // public PostResponseDTO [] selectRow(){ // []생략했다.
    //     PostResponseDTO entity = PostResponseDTO.builder()
    //                                 .title("강사를 고발합니다.")
    //                                 .writer("조영석")
    //                                 .content("뻥이야")
    //                                 .viewCnt(0)
    //                                 .build();

    //     PostResponseDTO [] ary = new PostResponseDTO[10];
    //     ary[0] = entity;
    //     ary[1] = entity;
    //     return ary;
    // }
    

    // 기본 로직 자체로 insertRow()를 받아야 가능하다.
    // 그렇기 때문에 DTO를 전역변수로 설정.
    public PostRequestDTO [] selectRow(){ // controller에서 get 요청하면 굳이 dto에서 뭔가를 파라미터 저장할 필요가 없음.

        // PostRequestDTO [] ary = new PostRequestDTO[10];
        // for (int i = 0; i < idx; i++) {
        //     requestAry[i] = PostRequestDTO.builder()
        //                             .title(ary[i].getTitle())
        //                             .writer(ary[i].getWriter())
        //                             .content(ary[i].getContent())
        //                             .build();
        // }
        return requestAry;
    }
}
