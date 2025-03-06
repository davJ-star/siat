import siat.study.PostDTO;
import siat.study.post.dao.PostDAO;
import siat.study.post.domain.PostRequestDTO;
import siat.study.post.domain.PostResponseDTO;
import siat.study.view.PostView;

public class AryMain {
    public static void main(String[] args) {
        /**
         * - 고정된 길이를 갖는다.
         * - 리사이징되지 않는다.
         * - 참조타입으로 취급
         */
        int[] ary = new int[10];
        System.out.println("배열의 길이: " + ary.length);
        for (int i = 0; i < ary.length; i++) {
            System.out.println((i+1) + "번째 배열의 값: " + ary[i]);
        }
        // 메모리상 더 효율적으로 사용할 수 있다.
        for (int i : ary) {
            System.out.println("배열의 값: " + i);
        }
        for (int data : ary) {
            System.out.println("배열의 값: " + data);
        }


        System.out.println("=====================================");
        System.out.println(">>> dto <<<");
        // PostDTO dto = new PostDTO();
        PostDTO dto = PostDTO.builder()
                            .title("제목")
                            .regDate("2021-07-01")
                            .writer("광현")
                            .content("내용")
                            .viewCnt("0").build();
        
        PostDTO [] dtoAry = new PostDTO[10];
        dtoAry[0] = dto;
        /**
         * dtoAry[1] = dto ; 
         * dtoAry[2] = dto ; 
         */
        // 항상 제대로 지정되었는지 null 체크 필요(근데 annotation으로 해결할 수 있는지 체크하는게 중요)
        for (PostDTO postDTO : dtoAry) {
            if (postDTO != null) {
                System.out.println("제목: " + postDTO.getTitle());
                // System.out.println("등록일: " + postDTO.getRegDate());
                // System.out.println("작성자: " + postDTO.getWriter());
                // System.out.println("내용: " + postDTO.getContent());
                // System.out.println("조회수: " + postDTO.getViewCnt());
                
            }
        }
        // quize) postDAO 객체 생성후 selectRow() 메서드 호출후 출력
        // repository로 dbms에 접근하는 객체인데 entity를 사용한다. postDTO 그대로 생각한다.
        
        // 지금은 dto 역전된거라고 생각하자. 

        // aryMain(service)에서 postDAO(repository)를 사용한다.
        // entity와 dto가 동일하므로 dao가 dto를 가져와서 CRUD를 만든다.(ENTITY에서 가져왔다고 생각한다. 역전되긴했지만...)
            // 참고: 심지어 지금 DTO는 request랑 response랑 동일하므로 일단 
        
        // 지금 dao
        PostDAO postDAO = PostDAO.builder().build();
        // postView에서 dao에러가 발생할 것이다.
        PostView postView = PostView.builder().build();
        
        PostDAO dao = PostDAO.builder().build() ; 
        PostResponseDTO [] responseAry = dao.selectRow() ;
        System.out.println(">>> 게시글 출력"); 
        for(PostResponseDTO entity : responseAry) {
            System.out.println(entity); 
        }
        /*
         * public PostResponseDTO[] selectRow(){
        PostResponseDTO entity = PostResponseDTO.builder()
                                    .title("강사를 고발합니다.")
                                    .writer("조영석")
                                    .content("뻥이야")
                                    .viewCnt(0)
                                    .build();

        return null;
    }
         */

    }
    
}
