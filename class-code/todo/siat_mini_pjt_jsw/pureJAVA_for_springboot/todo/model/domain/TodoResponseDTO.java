package todo.model.domain;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@ToString
@Setter

public class TodoResponseDTO {
    private int     seq;
    private String  title;
    private String  content;
    private String  startDate;
    private int     check;
    private String  status;
    private String  endDate;
    private int     priority;

}

/* startDate,endDate,check 는 안 적어도 되는데, 다른곳에 연결했던 부분이 오류가 날 수 있으니 놔둠 */