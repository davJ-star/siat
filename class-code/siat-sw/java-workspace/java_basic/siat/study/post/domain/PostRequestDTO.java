package siat.study.post.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostRequestDTO {
    private String title;
    private String writer;
    private String content;
    // private int viewCnt;
    // private String regDate;
}
