package todo.model.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString

public class TodoRequestDTO {
    private String  title;
    private String  content;
    private String  startDate; 
    //private Date  startDate; 
    private String  endDate; 
    private String  status; 
    private int     priority; 
}
/* startDate,endDate 는 안 적어도 되는데, 다른곳에 연결했던 부분이 오류가 날 수 있으니 놔둠 */