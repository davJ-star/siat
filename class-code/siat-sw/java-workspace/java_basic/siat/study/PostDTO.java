package siat.study;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// DTO(프론트엔드에서 받은 데이터 담는다.) vs VO(db로 부터 받은 데이터를 담아 프론트에 보낸다.) vs Entity()
// model view controller
// model: service, entity, repository


// 프론트엔드에서 받은 데이터를 저장하는 DTO (data transfer object)
// DTO는 데이터베이스와 프론트엔드의 데이터를 매핑하는 역할을 한다.

// VO : Value Object로 데이터베이스에서 가져온 데이터를 담아 프론트로 전달할 객체
// DTO하나로 통일 시킬 수 있다. requestDTO, responseDTO를 수 있다.
// DAO(Data Access Object) : 데이터베이스에 접근하는 객체
@Getter
@Setter
@NoArgsConstructor // 기본 생성자를 만들어준다.
@AllArgsConstructor // 5개에 대한 생성자를 만들어준다.
@Builder // PostDTO.builder().title("제목").regDate("2021-07-01").writer("광현").content("내용").viewCnt("0").build();방식으로 생성할 수 있다. 다만, AllArgsConstructor가 있어야 가능하다.
public class PostDTO {
    
    private String title;
    private String regDate;
    private String writer;
    private String content;
    private String viewCnt;

    // public void setTitle(String title) {
    //     this.title = title;
    // }

    // public void setRegDate(String regDate) {
    //     this.regDate = regDate;
    // }

    // public void setWriter(String writer) {
    //     this.writer = writer;
    // }

    // public void setContent(String content) {
    //     this.content = content;
    // }

    // public void setViewCnt(String viewCnt) {
    //     this.viewCnt = viewCnt;
    // }

    // public String getTitle() {
    //     return title;
    // }

    // public String getRegDate() {
    //     return regDate;
    // }

    // public String getWriter() {
    //     return writer;
    // }

    // public String getContent() {
    //     return content;
    // }

    // public String getViewCnt() {
    //     return viewCnt;
    // }
    

    
}
