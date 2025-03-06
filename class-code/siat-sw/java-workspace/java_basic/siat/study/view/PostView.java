package siat.study.view;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import siat.study.post.dao.PostDAO;
import siat.study.post.domain.PostRequestDTO;
import siat.study.post.domain.PostResponseDTO;

// 
@Getter
@AllArgsConstructor
@Builder
public class PostView {
    private PostDAO dao; // 가져야하니, 저장한다. 즉, 화살표 대상이 가져야한다.

    public void main(){
        // System.out.println(">>> Post Ver1.0 <<<");
        // System.out.println("1. 게시글 등록");
        // System.out.println("2. 게시물 보기");
        // System.out.println("99. ");
    }
    public void menu(){
        while (true) {
            System.out.println(">>> Post Ver1.0 <<<");
            System.out.println("1. 게시글 등록");
            System.out.println("2. 게시물 보기");
            System.out.println("99. 프로그램 종료");

            System.out.println("원하시는 서비스를 선택하세요: ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            System.out.println("debug >>> input number " + number);

            switch(number){
                case 1:
                    register();
                    break;
                case 2:
                    select();
                    break;
                case 99:
                    exit();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
        
    }

    public void select(){
        // 
        PostDAO postDAO = PostDAO.builder().build();
        PostRequestDTO [] requestDTOs = dao.selectRow();
        for (PostRequestDTO postRequestDTO : requestDTOs) {
            System.out.println(postRequestDTO);
        }
    }
    public void register(){
        // requset DTO와 동일하게 생각하면된다.
        Scanner scanner = new Scanner(System.in);

        // 
        System.out.println("제목: ");
        String title = scanner.nextLine();
        System.out.println("내용: ");
        String content = scanner.nextLine();
        System.out.println("작성자: ");
        String writer = scanner.nextLine();

        // 해당값을 DAO에 넘겨줘서 DBMS에 저장한다.
        PostRequestDTO request = PostRequestDTO.builder()
                                .title(title)
                                .content(content)
                                .writer(writer)
                                .build()  ;
        
        dao.insertRow(request); 
    }
    public void exit(){
        System.exit(0);
    }
}
