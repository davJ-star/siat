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
6. 문자열 비교


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

=> 다중 구현을 이용한다.
=> 다형성: 객체 다형성 활용(왜냐하면 그리고 클라이언트즉 변수명이 노출되는건 좋지 않다.)
	=> 오버라이딩으로 자식에 접근가능하다. (유일하게 자식에 접근할 수 있는 방법이다.)
	
```paintext
static 메소드는 변수에 접근할 수 없다. static이어야만 가능!
~~~~~~~~~~~~~~~~~~~
팩토리 패턴 및 싱글톤 패턴
한번만 생성하도록 null일때라는 if문 걸어주고, 해당 바디에서 "클래스 생성" 
	=> 하나만 하고, 변수도 숨긴다. private로 진행한다.
	=> ...

```

```paintext

	package siat.study.oop.factory;
	
	import siat.study.oop.abstraction.LgTV;
	import siat.study.oop.abstraction.SamsungTV;
	import siat.study.oop.abstraction.TV;
	
	public class TVFactory {
	    private static TVFactory instance;
	    private TV [] ary;
	    private TVFactory(){
	        // 초기화
	
	
	        // 여기서 부터 옵션이다.
	        ary = new TV[2];
	        ary[0] = new SamsungTV();
	        ary[1] = new LgTV();
	    }
	
	    public static TVFactory getInstance(){
	        if (instance == null) {
	            // TVFactory에 대한 것을 만들어야하는데 instance로 이미 공유하기로한것만 쓴다.
	            // 클래스내에서 공유하되, 외부에서 접근햇을때 내부에서 생성한다. 
	            // 내부니 클래스에내에서 공유중이며, 한번만 생성하도록한다.
	            instance = new TVFactory();
	        }
	
	        return instance;
	    }
	    
	    public TV getBrand(String brandName){
	        TV tv = (brandName.equals("samsung")) ? ary[0] : ary[1];
	        return tv;
	    }
	}
		
```



```paintext

	import siat.study.oop.abstraction.LgTV;
	import siat.study.oop.abstraction.TV;
	import siat.study.oop.factory.TVFactory;
	
	public class TVAppMain {
	    public static void main(String[] args) {
	        TV tv = new LgTV();
	        // TV tv = new SamsungTV();
	        // tv = new SamsungTV();으로 바로 볼수 있다.
	        // 사용자는 굳이 삼성제품인지 알필요가 없다.      
	        
	        // 객체 생성하는 것도 숨기도록 한다.
	
	        TVFactory tvFactory = TVFactory.getInstance(); // 해당 내부에서 해당 클래스 생성시 생성자에서 TV에 대해 생성한다. 배열로 만든다..
	        // 외부에서 인스턴스를 생성해서 쓸껄  내부에서 쓰게 만들었으니 전역변수로 만들고, static으로 만들어서 공유하도록해야한다.
	        TV tv1 = tvFactory.getBrand("samsung");
	        TV tv2 = tvFactory.getBrand("lg");
	        System.out.println(tv1);
	        System.out.println(tv2);
	
	        
	        
	    }
	}

```

#### 문자열 비교

```paintext
변수에 할당하는 값을 리터널이라고 한다.
문자열을 리터널로 생성하면 ==를 쓰던 .equal()을 쓰던 사용하던 문제가 생기지 않는다.
하지만 객체 생성으로 문자열 생성하면 .equal()을 써야한다.

혹시라더라도 매개변수로 String으로 객체 생성한 값이 넘어왔는데 문자열 비교가 있는 경우에 문제가 생긴다.
```


# contents-3.12 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)

### *tip* 
- *주소값을 받는 참조타입만 null을 쓴다*
- =현업에서는 List lst = new Vector()나 List lst = new ArrayList()로 사용한다. (클래스 다형성을 활용하는 방법이다. 도한 메소드 다형성도 포함되긴함..)
- 현업에서는 단일 타입으로 collection을 쓰는것을 원한다. <>를 사용한다.(generic)
	-> 컴파일시점에서 안정성을 확보할 수 있다.
	=> 예를 들어 <PersonVO>
		- 불필요한 다운캐스팅 지양할 수 있다.(매개변수라고 생각하면된다.)
 
### 수업 진행 사항
1. 배열과 List 길이 체크
2. ArrayList
3. Set



api로 호출할때는 new를 이용한 객체 생성만하면된다.

collection API는 객체를 받는다.

넣을때: add
꺼낼때: get

```paintext
클래스 다형성 extends
	-> 
메소드 다형성 override
	-> 
매개변수 다형성
	-> Object obj
```




#### 1. ArrayList
	- add(Object obj) 에서 매개변수 다형성 Object obj
	- 
	- 
```java
        List perList = new ArrayList();
        perList.add(new StudentVO("jslim", "seoul", "2018"));
        perList.add(new StudentVO("jslim", "seoul", "2018"));
        perList.add(new StudentVO("jslim", "seoul", "2018 "));

        
```

```java
	// 오버라이딩한 것만 접근 가능하다. 
	for (int i = 0; i < perList.size(); i++) {
            Object obj = perList.get(i);
            System.out.println(obj.personInfo());
        }
	// casting해도 소용없다 어차피 오버라이딩이 안됨
        for (int i = 0; i < perList.size(); i++) {
            Object obj = (PersonVO)perList.get(i);
            System.out.println(obj.personInfo());
        }
	// 오버라이딩 되었지만, 일단 런타임시에 위에 제네릭을 작성하지 않았다. 만약에 사용하지 않았다면 어떻게 됐는지 질문 필요
	// 질문 답변: 
        for (int i = 0; i < perList.size(); i++) {
            // 왜 에러가나는지 알고 있니?: 런타임 안정성때문에?
            PersonVO per = perList.get(i);
            System.out.println(per.personInfo());
        }
```

```java
        List<PersonVO> perList1 = new ArrayList<PersonVO>();
        perList1.add(new StudentVO("jslim", "seoul", "2018"));
        perList1.add(new ManagerVO("jslim", "seoul", "2018"));
        perList1.add(new TeacherVO("jslim", "seoul", "2018 "));
	// for
        for (int i = 0; i < perList1.size(); i++) {
            PersonVO per1 = perList1.get(i);
            System.out.println(per1.personInfo());
        }
	// foreach
        for (PersonVO per2 : perList1) {
            System.out.println(per2.personInfo());
        }
```
	```java
 		System.out.println(">>>> Iterator");
	        Iterator<PersonVO> ite = perList1.iterator();
	        while (ite.hasNext()) {
	            PersonVO per3 = ite.next();
	            System.out.println(per3.personInfo());
	        }
 	```
 
#### 2. Set
일반적으로 HashSet을 많이 쓴다.
중복된 값을 가지고 싶지 않으면 set을 작성한다.

반복자체가 안된다. 순서가 없기때문에~


#### 3. Map({key: value})
Map interface는 Collection에 없다.
https://docs.oracle.com/javase/8/docs/api/java/util/Map.html

ex) 브라우저에서 카테고리가 다르다.
담을때는 put을 쓴다.



단일(한건)로 넘겨줘야는데 dto를 만들기 귀찮을때 map을 이용한다.
xxxDTO
xxxVO
xxxEntity(jpa)



#### 4. 예외처리
파이썬: try - exception

컴파일 -> 런타임(실행)이다보니 두개로 나눠진다.
- 컴파일 예외처리(IOException, )
- 런타임(실행) 예외처리(RuntimeException)

예외는 폭탄이다.
throws를 던져준다.

	ex) throws IOException

명시적 초기화해줘야한다.

```java
String data = null; // 이렇게 배놓지 않으면 try도 지역을 가지기 때문에 밖에서는 의미가 없다.
        // 항상 try할 코드들 밖에서 변수 선언을 다하고 들어간다.
        try {
            data = br.readLine();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
```






#### 참고: wapeer class

Wrapper class가 있다. 기본타입(8가지)를 객체화 시키는 클래스가 존재
	int -> Integer, boolean -> Boolean

1, true를 넣으면, Boxing되어서 int -> Integer, boolean -> Boolean이다.













# contents-3.13 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)



![image](https://github.com/user-attachments/assets/306f0ad9-a1b6-48c8-a904-f343019d4e0b)

```java
       System.out.println(">>> 객체를 담아서 처리하는 방법");
        // 객체를 담아서 작성한다.
        Stream<File> filStream = Stream.of(  new File("siat.txt"), 
                    new File("java.txt"), 
                    new File("jslim.txt"), 
                    new File("siat.txt"));

        // filStream.forEach();를 안쓰는이유? 
        filStream.map(File::getName)
                        .distinct() // 중복 제거
                        .sorted(Comparator.reverseOrder()) // Comparator를 이용해서 내림차순정렬 작성
                        .forEach(System.out::println); // 
```

```java
	
/*
 * 람다식은 하나의 메서들르 식으로 표현하는 것
 * - 메서드 이름이 필요가 없다
 * - 익명메서드(일급객체)
 * 
 * 기존방식)
 *  public String getName(){
 *      return "siat";
 * }
 * 람다식)
 * (매개변수) -> { 실행문}
 * () -> "siat";
 * 
 * [java 제공하는 함수형 인터페이스] -> 이걸 알아야 문서를 이해할 수 있다.
 * - Supplier
 *      : 매개변수없이 반환값만을 가지고 있는 함수형 인터페이스
 * - Consumer
 *      : 
 * - Function
 *      : 
 * - predicate
 *      : 
 * 
 */

 /**람다를 이해하고, 함수형 인터페이스를 이해해야한다. */

import java.util.function.Supplier;

import siat.study.lambda.SiatFunction;

public class LambdaMain {
    public static void main(String[] args) {
        // 1회용으로 쓸려고 람다식을 쓰는 것.
        // 함수만 선언되면 된다.
        // 함수형 인터페이스로 해당 표준을 만들어서 작성할 수 있다.
        SiatFunction lambdaFunction = (x, y) -> x > y ? x : y;
        lambdaFunction = (x, y) -> x * y;
        lambdaFunction = (x, y) -> x + y;
        System.out.println(lambdaFunction.max(100, 20));

        // Supplier는 java.util.function에서 제공해주는 것이다.
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html
        Supplier supplier = () -> "siat";

        System.out.println(supplier.get()
        );
        
    }
    
}

```

# contents-3.17 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)

### *tip* 
- 
 
### 수업 진행 사항
1. 

 * 개발: 컴파일 안정성, 타입을 정할 수 없을때 사용한다.
 * 설계: 코드 효율적 설계(표준화) -> 오버로딩을 하지 않고, 한개 타입으로 처리할 수 있다.(재사용성 증가)
 * 
 * 제너릭?
 * - 컴파일 시점에 타입의 안정성
 * - 불필요한 캐스팅을 지양
 * - 여러 데이터 타입을 표준화한 클래스를 만들 수 있다.
 * T: 타입
 * K: 키
 * V: 값
 * E: 요소의 타입





```paintext

	soild
	s: 단일책임원칙
		각각 클래스는 자기의 역할이 있다.
		-> DAO를 통해서 DBMS를 접근할 수 있다.
		즉 DAO랑 CTRL, VIEW는 비지니스로직을 갖지않는다. 
	has-a 관계 -> relation
		(반환타입)




erd를 만들었으면 dto를 만든다.

---------------------------
seq: primary key(not null, no duplication(unique))

각각 controller마다 객체 생성을 해야한다. 이러한 코드는 좋지 않기 때문에 프레임워크는 우리한테 객체 생성을 맡기지 않는다.




입력 출력 삭제 반환값은 int로 하는게 좋다
// 전체보기
    public List<TodoResponseDTO> selectRow(){
        System.out.println(">>> dao selectRow: List<TodoResponseDTO>");

        return null;
    }

// 체크된것과 상관없이 같이 있기 때문에 완료한 것과 미완료한 것을 구분
// 한번에 다하지말기! -> delete 만들기

select
delete
select

입력받고 반환해준다.


// 현업에서 인터페이스에서 추상메소드를 구현한다: 서비스인플은 구현해놓은 것 / 서비스라고 되어있으면 인터페이스이다.

JDBC랑 ORM(Mybatis JPA)
            
controller들 ->|---- service
일때 service 객체를 하나만 만들어서 controller에 전달해준다. 예시 코드를 한번 복 싶은데...\


누군가에 의해서 만들어지는 객체를 bean이라고 한다.
    // 지금 main에서는 무분별한 객체 생성이 일어난다.
	


# contents-3.18 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)

### *tip* 
- 
 
### 수업 진행 사항
1. ㅇ

![image](https://github.com/user-attachments/assets/2b6e2bdc-d8e5-48dc-9f8f-7d4cc4bc9c54)
InputStream에 해당하는 System.in을 넣어줬다.

![image](https://github.com/user-attachments/assets/6be8f05b-5e4b-4399-a17b-812e0129c126)

ctrl가 각각 service를 생성하다보니 문제가 발생한다.

frontcontroller -> springboot에선 servlet을 이용한다.
--------------------
익혀야할 코드
System.exit(0);

switch는 숫자만 되는가?

----------------------

    private String title; 
    private String content;
    private int priority;
	는 프론트에서 입력받는것들이다.

TodoRequestDTO -> table -> TodoResponseDTO 
반환할 것은 ResponseDTO이다.List에 ResponseDTO가 담긴다.(List에 담김)
insertTodo인데 return을 줘야하나?



```java
package todo.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequestDTO {
    
    private String title; 
    private String content;
    private String startDate;
    // private int check;
    private String endDate;
    private int priority;



}
```

DAO즉 JPA에서 데이터를 접근할 수 있다. 접근은 request를 처리하기 위해서도 가능하고 response를 처리하기에도 가능하다.
*이것도 한번에 섞이면 좋지 않으니 구분하는 편이고, 이 기준을 어떻게 최적화할수 있을지 고민해봐야한다.*

프론트에서 넘겨주는건 servlet을 통해서 넘겨주고, 
이를 각 DTO작업을 거쳐서 넣어주는데 우리는 보기 좋게 DTO를 또 작성하는거지..

(표준을 만들어서 확인할 수 있고, 이를 토대로 만들수있다. 그렇기 때문에 여러개 만들었던것이다.)


TodoResponseDTO response = TodoResponseDTO.builder()
                                        .seq(idx++) // 우리가 주는 코드
                                        .title(requestDTO.getTitle())
                                        .content(requestDTO.getTitle())
                                        .startDate(requestDTO.getStartDate())
                                        .check(0) // 우리가 주는 코드로 백엔드에서 생성하는 것도 있으므로, DTO를 하나로 통일하기는 어렵다.
                                        .endDate(requestDTO.getEndDate())
                                        .priority(requestDTO.getPriority())
                                        .build();
        
        list.add(response);


oop 특징
- 은닉화
- 다형성

클래스
- 

```paintext
// service도 공통으로 만드는게 낫지 않을까?


TodoService service = new TodoService();// 매번 새로 생성하니 일단 해당 List는 남지 않을것..





```
# contents-3.19 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)

np가 발생할 수 있다. 삭제했는데 해당 seq을 접근~
 this.service = service; // 지역변수에서는 지역변수가 매개변수보다 우선순위...

xss문제
Controller에서 validation 체크할 수 있다.(Front 단에서 미리 막을수있지 않을까? 스크립트를 통해서 프론트에서 검증할 수 있다. => 한번더 체크해주는게 좋다)
-> 유효성 체크
-> 화면분기


# contents-3.20 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)




## 에러항목

### 에러






