package siat.study.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
// @NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostService {
    public String savePost(){
        System.out.println("debug >>> service savePost call ");

        return "게시글 작성이 완료되었습니다.";
    }
    public String updatePost() {
        System.out.println("debug >>>> service updatePost call"); 
        return "게시글이 수정되었습니다.";
    }
    public String deletePost() {
        System.out.println("debug >>>> service deletePost call"); 
        return "게시글이 삭제되었습니다.";
    }
}
