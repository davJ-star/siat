package siat.study.post.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data // 좋은건 아니다.
// 설명한것
public class PostResponseDTO {
    private String title;
    private String writer;
    private String content;
    private int viewCnt;
    private LocalDateTime regDate;
    
}
