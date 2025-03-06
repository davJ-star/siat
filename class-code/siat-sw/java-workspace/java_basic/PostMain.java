// 
import siat.study.PostDTO; // 패키지 import 안하면 에러 발생
import siat.study.post.dao.PostDAO;
import siat.study.post.domain.PostRequestDTO;
import siat.study.service.PostService;
import siat.study.view.PostView;

public class PostMain {
    public static void main(String[] args) {
        // PostView view2 = PostView.builder()
        //                     .build();
        PostView view = PostView.builder()
                            .dao(
                                PostDAO.builder()
                                .requestAry(new PostRequestDTO[10])
                                .build()
                            )
                            .build();
        // PostService service = PostService.builder()
        //                     .build();
        
        // PostDTO post = PostDTO.builder()
        //                     .title("제목")
        //                     .regDate("2021-07-01")
        //                     .writer("광현")
        //                     .content("내용")
        //                     .viewCnt("0")

        //                     .build();
        // PostDTO post = new PostDTO();
        // post.setTitle("제목");
        // post.setRegDate("2021-07-01");
        // post.setWriter("광현");
        // post.setContent("내용");
        // post.setViewCnt("0");

        // System.out.println("제목 : " + post.getTitle());
        // System.out.println("등록일 : " + post.getRegDate());
        // System.out.println("작성자 : " + post.getWriter());
        // System.out.println("내용 : " + post.getContent());
        // System.out.println("조회수 : " + post.getViewCnt());
        // System.out.println(post);
        // System.out.printf("제목 : %s \n등록일 : %s \n작성자 : %s \n내용 : %s \n조회수 : %s\n", post.getTitle(), post.getRegDate(), post.getWriter(), post.getContent(), post.getViewCnt());

        view.menu();

    }
}
