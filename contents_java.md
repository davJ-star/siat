# 전반 tip
1. 프로그래밍은 항상 가변적인 데이터를 생각해야한다.
2. [최신 문법이더라도 사내 명세서에서 따라가기]()
3. 

# 전반 요약

# 코드 tip
### [반복문for에서 인덱스와 이터레이터 어떻게 잘 활용할 수 있나?](https://github.com/davJ-star/siat/edit/main/contents.md#tip)
### [while과 for문 차이]()


# contents-2.27 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)


인터프리터 vs 컴파일: type 관점
source.file -> compile -> byte code -> runtime -> exec

: 데이터를 담는 동사적인 의미
: 데이터를 가지고하는 행위

함수(ㅇ) vs 메소드(x): **단독**으로 실행 가능 여부

### *tip* 
- :int와 같이 최근 문법을 추천하지 않는다. 하지만, 익혀두는건 필요하다...(명세서 지침을 바꿀수 있는 위치가 된다면 가능)
- **type을 체크하고 쓸 수 있어야 확실하게 접근할 수 있다.**

## 진행사항
1. JDK 설치
2. main 메소드 만들기
3. 

### main 메소드
실행가능한 클래스만 main 메소드를 가진다.
instance 가능하다(?)
컴파일 가능(?)

### 대문자로 시작되는건 class다.

### 저장하면 자동으로 컴파일된다. 
.class 파일이 만들어진다.
#### 타입 체크는 컴파일 시점에 이뤄진다.

## has a 관계
객체 생성

## like는 메소드~


# contents-2.28 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)


### *tip* 
- :int와 같이 최근 문법을 추천하지 않는다. 하지만, 익혀두는건 필요하다...(명세서 지침을 바꿀수 있는 위치가 된다면 가능)
- **type을 체크하고 쓸 수 있어야 확실하게 접근할 수 있다.**

## 진행사항
1. JDK 설치
2. 

### postDTO
// model view controller
// model: service, model(entity인데 DTO에 해당할 수 있다.), repository
// MODEL(ENTITY DTO) -> REPOSITORY(JPA) -> SERVICE

#### DTO
// DTO(프론트엔드에서 받은 데이터 담는다.) vs VO(db로 부터 받은 데이터를 담아 프론트에 보낸다.) vs Entity()

// 프론트엔드에서 받은 데이터를 저장하는 DTO (data transfer object)
// DTO는 데이터베이스와 프론트엔드의 데이터를 매핑하는 역할을 한다.

```
requestBody / responseBody로 체크를 해보면된다.

requsetMapping / getMapping또는 postMapping등 설정가능하다.

해당 url을 토대로 데이터를 받아야된다. requsetBody에 존재한다. 그리고 DTO나 일단 Response값을 줘야하는 경우 또는 응답 상태를 나타내야하는경우 ResponseEntity를 사용할 수 있다.
```

#### VO
// VO : Value Object로 데이터베이스에서 가져온 데이터를 담아 프론트로 전달할 객체
// DTO하나로 통일 시킬 수 있다. requestDTO, responseDTO를 수 있다.
#### ENTITY

### DAO
// DAO(Data Access Object) : 데이터베이스에 접근하는 객체



## lombook
```java
package siat.study;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    
}


```

### builder로 생성
```java
// 
import siat.study.PostDTO; // 패키지 import 안하면 에러 발생

public class PostMain {
    public static void main(String[] args) {
        PostDTO post = PostDTO.builder()
                            .title("제목")
                            .regDate("2021-07-01")
                            .writer("광현")
                            .content("내용")
                            .viewCnt("0")
                            
                            .build();

        System.out.printf("제목 : %s \n등록일 : %s \n작성자 : %s \n내용 : %s \n조회수 : %s\n", post.getTitle(), post.getRegDate(), post.getWriter(), post.getContent(), post.getViewCnt());

    }
}

```

# contents-3.4 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)


### *tip* 
- 

## 진행사항
1. 제어구문, 반복문
2. builder 패턴 이용한 인스턴스 생성

### 기본 인식 타입
#### 실수: double (8byte)
만약 float으로 사용할려면 casting하거나 F를 붙이면 된다.
#### 정수: int
더하기 하면 
### 제어문

#### if

#### switch

```java
package siat.study.control;

public class ControlApp {
    /**
     * 
     */
    public String woodMan(int number) {
        String msg = null;
        // 제거할 수 있다. switch문에서 default여도 상관없다면 굳이..?
        if (!(number >= 1 && number <= 3)) {
            return "1~3 사이의 값이 아닙니다.";
            
        }
        System.out.println("산신령이 나타났습니다. ^*^");
        switch (number) {
            case 1:
                msg = "거짓말을 하는구나";
                break;
            case 2:
                msg = "또 거짓말을 하는구나";
                break;        
            case 3:
                msg = "정직하구나 너에게 모든 도끼를 주겠다.";
                break;
            
            default:
                msg = "죽을래~";
                break;
        }

        return msg;
    }
}

```

#### 상세하게 출력하기 위한 강사님 코드
**중첩 if문을 &&로 단일 if로 만들수 있다.**
**if 단독으로 사용하는 경우 흐름 제어 및 각각 상세 body로 컨트롤 하기 위해서 사용할 수 있다.**
=> 점수 분기 외에 왜 fail 되는지 상세 설명할때도 가능... _뭉친걸: 같이 고려해야할 조건들~!을 쪼개서 각각 조건에 대해 컨드롤(body)해야되는 경우_

```java
double avg1 = (kor+eng+math)/3;
        if (kor >= 40 && eng >= 40 && math >= 40 && avg1 >= 60) {
            msg = "합격";
        }else {
            if (avg1 < 60) {
                msg = "평균 점수 미달로 불합격";
            }
            if (kor < 39) {
                msg = "국어 점수 미달로 불합격";
            }
            if (eng < 39) {
                msg = "영어 점수 미달로 불합격";
            }
            if (math < 39) {
                msg = "수학 점수 미달로 불합격";
            }
            
        }

        return msg;
```



### 반복문

#### for
for(초기식; 조건식; 증감식){

}

#### while
while(조건식){
    증감식
}

#### do ~ while
do {
    증감식
}(조건식){
    
}


#### break
다만 주의해야될 부분은 중첩 for 루프를 가질땐, 가장 안의 for 만 벗어난다.(중첩 if라도...)


#### builder
builder로 생성하면 생성자가 private로 바뀐다.

## 에러항목

### 에러






