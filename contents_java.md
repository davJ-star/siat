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



# contents-3.5 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)


### *tip* 
- 

## 진행사항
1. 

### 

```java


```





# contents-3.6 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)


### *tip* 
- 

## 진행사항
1. JPA는 Entity로 보고, request 파라미터 데이터는 DTO로 본다. response에 대한 데이터는 VO(response DTO)다.
2. service는 비지니스로직을처리한다. DAO(Data Access Object)를 통해서 DB(DBMS)에 접근한다. => JPA나 JDBC는 어떻게?
3. DB에서 주는건 VO(Value Object)다. = response DTO

### 

```paintext
제대로 내가 원하는대로 출력이 안된 이유는 regiser()를 등록하지 않고 1번을 눌렀기 때문이다.

register하려면, (CREATE에 해당)
DAO에서 requsetDTO로부터 파라미터를 받아야한다.

DAO에서 DTO []에 저장한다.(지금 DB가 없으니,) -> responseDTO로 생각했는데 아닌가봄. requsetDTO에 저장한다.

selectRow()를 통해서 전체 반환해준다.
--------------------------
View에 보여주기 위해서 DAO를 활용해서 데이터를 출력한다.
service를 통해서 보여줄수 있으니 service는 일단 dao를 호출한다.
view에서 dao를 호출해서 데이터를 뿌리면된다.



근데 굳이 PostMain.java로 작업해서 view를 때왔다고 생각하면된다.
그렇기때문에 view.menu()에 필요한 작업을 위에 view 생성시 넣으면된다.
view 생성하고 dao를 builder로 생성한다.
	WHY? => view에서 dao를 호출해서 데이터를 뿌리면된다.
DAO에는
	WHY? => DAO에서 requsetDTO로부터 파라미터를 받아야한다.

```


# contents-3.7 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)

### *tip* 
- 

## 진행사항
1. OOP 및 SOLID
2. 생성자: 기본 / special 말하면서 생성자 오버로딩

### 

```paintext

```
### 1. 단일 책임 원칙 (SRP: Single Responsibility Principle)
클래스는 오직 하나의 책임만 가져야 합니다. 예를 들어, 주문 처리와 송장 생성을 별도의 클래스로 분리하여 각 클래스가 단일 책임을 갖도록 해야 합니다.

### 2. 개방-폐쇄 원칙 (OCP: Open-Closed Principle)
소프트웨어 요소는 확장에는 열려 있으나 수정에는 닫혀 있어야 합니다. 이는 기존 코드를 변경하지 않고 새로운 기능을 추가할 수 있도록 설계해야 함을 의미합니다.

### 3. 리스코프 치환 원칙 (LSP: Liskov Substitution Principle)
상위 타입의 객체를 하위 타입의 객체로 치환해도 프로그램의 정확성이 보장되어야 합니다.

### 4. 인터페이스 분리 원칙 (ISP: Interface Segregation Principle)
클라이언트는 자신이 사용하지 않는 메서드에 의존하지 않아야 합니다34. 큰 인터페이스를 여러 개의 작은 인터페이스로 분리하여 필요한 기능만 구현할 수 있도록 해야 합니다.

### 5. 의존성 역전 원칙 (DIP: Dependency Inversion Principle)
고수준 모듈은 저수준 모듈에 의존해서는 안 되며, 둘 다 추상화에 의존해야 합니다47. 예를 들어, Chef 클래스가 구체적인 Pizza 구현이 아닌 Pizza 인터페이스에 의존하도록 설계해야 합니다.

SOLID 원칙을 적용하면 코드의 재사용성이 높아지고, 유지보수가 용이해지며, 확장성이 향상됩니다56. 이는 결과적으로 높은 응집도와 낮은 결합도를 가진 소프트웨어 설계로 이어집니다


# contents-3.10 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)

```paintext
다형성을 이용
	- 매개변수의 다형성
		매개변수에서 사용하는 경우: 메소드 한개만 만들고 이용할 수 있다.

	- 

오버로딩: 타입과 매개변수가 달라야한다. (같은 클래스 내에서)
오버라이딩: 상속관계에서 구현부가 달라저야한다.
```

```paintext
상수: static final


참조 타입: enum, class, 배열

enum으로 코드상으로 묵시적으로 정의
상수값은 컴파일시점에서 체크할 수 있다. 그래서 안전하게 관리할 수 있다.


Exception in thread "main" java.lang.NullPointerException: Cannot invoke "siat.study.oop.domain.constructor.PersonVO.personInfo()" because "ary[i]" is null
        at PolymorphismMain.main(PolymorphismMain.java:17)

=> 이를 위해서 if ( != null) 체크한다.

system 검색하면 out에서 필드는 static으로 선언되어 있다.
```

```paintext
for (PersonVO personVO : perAry) {
            if (person == personVO.getName()) {
                return personVO;
            }
        }

여기서person == personVO.getName() 쓰면 안된다. .equal()을 써야한다.
```




# contents-3.11 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)
### *tip* 
- 현장에서 가장 중요한 것은 표준을 만든다 => api 명세서를 만드는것이 예시 (표준화를 만들기 위해서 추상화를 만든다.)
- 강한 응집도와 약한 결합도를 지향한다.(아키텍처) => 해당 관점에서 추상화(abstraction)
	- 은닉화를 구현할 수 있다.(여기서 은닉화는 변수타입을 숨기는 것)
 	- 예를 들면 짜장면 주문하는 입장에서 레시피가 궁금하지 않다.
	```paintext
		예를 들면 짜장면 주문하는 입장에서 레시피가 궁금하지 않다.
	```

- a has b  관계: a <- b (a에서 b를 생성한다.)
- 

## 진행사항
1. 표준 -> 추상화
2. 응집도와 결합도
3. has-a관계
4. interface랑 abstract class
5. 확장


```paintext
has a 관계를 가진다. 이렇게 된다. 
- LgTV랑 SamsungTV에서 각각 클래스 생성하면 일단 has 관계가 두개가 생기므로 결합도가 높아진다.
- 그리고 클라이언트즉 변수명이 노출되는건 좋지 않다.


```paintext
java에서는 interface랑 abstract class로 구현한다.
인스턴스(객체) 생성 둘다 안된다.
- 추상클래스는 말그대로 클래스이므로, 클래스 성격을 가진다.
설계 시점에서 부모 역할을 한다.(const가 아니다.) -> 상속받는 클래스를 넣는다. 즉 자식을 담을 수 있게 된다.
추상클래스에서 추상메소드는 오버라이딩을 강제한다.(표준을 지켜야도록 만든다.)
	이에 추상클래스가 되지 않기위해서는 추상메소드로 선언한 것은 모두 오버라이딩을 해야한다.(일반 클래스가 되기 위해서는 모두 오버라이딩해서 구현해야한다.)

상속에서 PersonVO 생성하는데 TeacherVO 할당해준것을 떠올리면 된다.
근데 이제 강제한다는 것을 떠올리면된다.(상속 -> 구현)
```

```paintext
bike랑 tiger를 추가로 요청했을때 확장이 문제
반드시 오버라이딩해야된다는게 문제다. 그렇기 때문에 인터페이스로 따로 빼고, 강제시킬수있는 것을 구분해서 tiger랑 bike에 강제하지 않도록한다.


그러면, 일단 여러가지 분리놓고 따로 partical하게 만든다.
=> 최소기능으로 만든다. 근데 이걸 설계하기위해서는 어떻게 구성하는게 좋은지 아키텍처가 있으면 좋다.
(최소 기능 및 제품 설계를 하도록한다.)

```


## 에러항목

### 에러






