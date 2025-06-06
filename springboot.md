

# 4.14


[정형화된 구조를 만들수있다.]



주입시킨다. -> 객체 생성


servlet -> 사라지는 것처럼 보인다.
factory-> 사라진다. => spring container (매핑해서 컨트롤러를 제공해주는 역할인데 dao, service등을 객체 생성을 관리 생성한다.)

=> 객체를 생성하고 관리한다. -> 제어의 역행
의존성 주입시켜준다.
이러한 세팅을 두가지로 한다. xml파일(스키마 베이스)에 하거나 annotation기반

maven vs gradle
.pom  vs .properties()
--------------------------
=> 매개변수랑 메소드명은 개발자 마음대로~!

그러나 return 타입이 있는 경우 




--------------------------
springboot 내부적으로 was가 있다. 즉 tomcat이  동작중
--------------------------
// class에 매핑할 수도 있고, 메서드에 매핑할 수도 있다.
 // class에 매핑할 경우, 메서드에 매핑된 URL 경로는 class에 매핑된 URL 경로를 기준으로 한다.
    // 예를 들어, class에 "/test"가 매핑되어 있고, 메서드에 "/test2"가 매핑되어 있다면, 실제 URL 경로는 "/test/test2"가 된다.
--------------------------

[메소드 단위] -> 이전에는 클래스 단위로 controller를 만들었다. (todoInsertCtrl class로 만들었다.)
@RequestMapping("insert") // URL 경로를 지정하는 annotation
public void insert() {
        System.out.println("insert() 호출");
    }
```
어노테이션으로 등록할 수 있다. (객체 생성 위임 -> 객체를 생성하고 관리한다. -> 제어의 역행
의존성 주입시켜준다.)
매핑만 맞으면 spring container에 있는 insert()를 호출한다.
```

[클래스 단위]
@RequestMapping("/test") // URL 경로를 지정하는 annotation
public class TestCtrl {

}

```
class에 매핑할 경우, 메서드에 매핑된 URL 경로는 class에 매핑된 URL 경로를 기준으로 한다.
    // 예를 들어, class에 "/test"가 매핑되어 있고, 메서드에 "/test2"가 매핑되어 있다면, 실제 URL 경로는 "/test/test2"가 된다.
```

프론트 컨트롤러를 이용해서 항상 요청과 응답을 받는다. jsp는 그냥 이동이 된다.
그렇기 때문에 web-inf에 넣어서 숨겨준다.

항상 이를 통해서 넘겨준다고 생각하자. 그림이 그려져야한다.

프로젝트 설정: application.properties
라이브러리 설정: build.gradle     
--------------------------
버전 잘 생각해두기
-> 3.0에서는 jakarta로 가져온다. ('org.glassfish.web:jakarta.servlet.jsp.jstl')
->  compile('javax.servlet:jstl:1.2')이 아니라



```
DI을 통해서 사용해서 의존성 주입을 하고 있고, 이는 객체 생성을 하며 연결관계 즉 의존성을 가지게 된다.


viewResolver를 통해서 forward를 통해 분기가 된다.
@controller



mybtis, jpa등 ORM을 통해서 매핑하는 클래스를 끼워주는 친구들이 있다.


박싱을 통해 Integer를 사용할 수 있었다.
이와 동일하게 작동한다. object로 해당된다.
dbms는 테이블로 매핑된다.
```


#### 참고 anntation

```paintext

/*
 * IOC(Inversion of Control) : 제어의 역전. 객체의 생성과 생명주기를 Spring이 관리하는 것. -> Spring Container에서 관리
 * - DI(Dependency Injection) : 의존성 주입. 객체 간의 의존성을 Spring이 관리하는 것.
 * - DL(Dependency Lookup) : 의존성 조회. 객체 간의 의존성을 Spring이 관리하지 않는 것.
 */

/*
 * 사용자 요청과 관련된 Annotation
 *   * @RequestMapping : HTTP 요청을 처리하는 메서드에 붙이는 annotation
 * 
 */

 /*
  * 의존성 관리를 위한 annotation
    *  * @Autowired : Spring에서 관리하는 객체를 주입받는 annotation
    *  * @Injection : Spring에서 관리하는 객체를 주입받는 annotation
    *  * @Resource : Spring에서 관리하는 객체를 주입받을 때, 어떤 객체를 주입받을지 지정하는 annotation
    *  * @Qualifier : Spring에서 관리하는 객체를 주입받을 때, 어떤 객체를 주입받을지 지정하는 annotation
  */


/*
 객체 생성과 관련된 annotation
    * @Component : Spring에서 관리하는 일반적인 컴포넌트에 붙이는 annotation
    * @Controller : Spring MVC에서 Controller 역할을 하는 클래스에 붙이는 annotation
    * @Service : 비즈니스 로직을 처리하는 클래스에 붙이는 annotation
    * @Repository : 데이터베이스와의 상호작용을 처리하는 클래스에 붙이는 annotation
 */

 // class에 매핑할 수도 있고, 메서드에 매핑할 수도 있다.
    // class에 매핑할 경우, 메서드에 매핑된 URL 경로는 class에 매핑된 URL 경로를 기준으로 한다.
    // 예를 들어, class에 "/test"가 매핑되어 있고, 메서드에 "/test2"가 매핑되어 있다면, 실제 URL 경로는 "/test/test2"가 된다.
    
    

```

##### 그외 생성과 관련된 annotation 
```java


/*
 객체 생성과 관련된 annotation
    * @Controller : Spring MVC에서 Controller 역할을 하는 클래스에 붙이는 annotation
    * @RestController : @Controller + @ResponseBody. JSON/XML 형태로 응답을 보내는 Controller에 붙이는 annotation
    * @Service : 비즈니스 로직을 처리하는 클래스에 붙이는 annotation
    * @Repository : 데이터베이스와의 상호작용을 처리하는 클래스에 붙이는 annotation
    * @Component : Spring에서 관리하는 일반적인 컴포넌트에 붙이는 annotation
    * @Configuration : Spring의 설정 정보를 담고 있는 클래스에 붙이는 annotation
    * @Bean : Spring에서 관리하는 객체를 생성하는 메서드에 붙이는 annotation
    * @Autowired : Spring에서 관리하는 객체를 주입받는 annotation
    * @Value : Spring에서 관리하는 프로퍼티 값을 주입받는 annotation
    * @Qualifier : Spring에서 관리하는 객체를 주입받을 때, 어떤 객체를 주입받을지 지정하는 annotation
    * @Primary : Spring에서 관리하는 객체를 주입받을 때, 기본적으로 주입받을 객체를 지정하는 annotation
    * @Scope : Spring에서 관리하는 객체의 범위를 지정하는 annotation
 */

```

# 4.15
```
mybatis -> 업무로직 복잡
jpa -> 간단하게 읽기 전용으로 select 용도로 사용한다.
--------------------------------------------------------------------

설정

 --------------resources---------------------------
static
외부자원으로 생각
예를 들어 mybatis 설정 resources에 들어가게된다.
--------------------------------------------------------------------
application.properties파일에 추가한다.

connection pull 세팅이 필요한데, 편하게 hikari 쓰기위해서 사용. (지우게 되면 내부적으로 tomcat)

# DB property Setting 
spring.datasource.hikari.driver-class-name=
spring.datasource.hikari.jdbc-url=
spring.datasource.hikari.username=
spring.datasource.hikari.password=

--------------------------------------------------------------------
프레임워크가 가장 먼저 시작할때 application.properties파일 보고 진행

mappers 폴더에 orm에 해당하는 내용을 추가한다.
.xml파일을 만들어 query

.xml에 config (환경정보)하면서 별칭을 설정등을 할 수 있다. 



업무로 나눠 업무당 xml을 만드는 회사도 있고 쿼리당 만드는 회사도 있다.



영속적인 활동을 한다. -> @repository


mapper태그가 어디서 오는지 연결되는지 알아야한다.
namespace로 패키지를 등록한다.
식별자를 갖는 태그가 가져온다.



# query가 java가 아니라 xml로 빠졌다.

resoures 폴더 -> mappers 폴더에 생성하구 해당 경로를 
application.properties에 등록한다.  등록해놨으니 사용할 수 있게된다.
(아직은 config를 제대로 작성하진 않아서 별칭을 주진 않았다.)

이제 @mapper를 주고 interface를 만들어주면 query를 xml로 매핑된다.
메소드명을 그대로 id로 작성하고, namespace로 interface를 만들어주면 query를 xml로 연결해주기 위해 패키지 경로를 작성한다.
xml에 이제 jdbc에서 잦바처리한 코드를 태그로 감싸고, 안에 query문을 작성한다.

우리는 이제 객체만 넘겨준다. mapper가 아니라 mybatis가 꺼내서 query를 처리한다.




namespace
paramType
resultType

<!CDATA[[

]]>


orm으로 하면 객체랑 매핑을 하는 작업이기 때문에 
Integer로 작업하는게 박싱이 안되고 효율적이고 좋다.


jpa할때 optional을 사용한다.





```



# 4.16
```

@RestController : @Controller + @ResponseBody. JSON/XML 형태로 응답을 보내는 Controller에 붙이는 annotation
    * @Controller : Spring MVC에서 Controller 역할을 하는 클래스에 붙이는 annotation



get 요청시 두가지를 선택할 수있긴한데
@requestParams vs @pathVariable


spa 기반일때 @pathVariable로 일반적으로 넘기고
jsp 기반일때는 @requestParams 일반적으로 넘긴다.


데이터를 심어야하는 경우는 Model을 사용한다.
servlet에서 request.setAttribute를 이용해서 심어줬다.

하지만, spring boot에서는 Model model을 이용해서  addAttribute를 이용한다.

test case로 만들때 dto를 구분하기.



// 

<% -- --%>로 체크한다.


경로문제를 잘 잡아야한다.


todo였는데 

http://localhost:8088/todo/view/4

-> http://localhost:8088/todo/view 여기까지가 경로였다.

"../../todo/delete?seq=${read.seq}"로 처리해보면 /list로 에러가 난다.
"redirect:/list"를 했기때문이다. -> 그렇기 때문에 해당 에러는 


front-controller로 진행한다.

```

# 4.17

```
full browsing 방식 => request, response가 있다. response에서는 



--------------------------
업무에 따라서 구분한다. -> 
??


-----
동일한 이름으로 지정해야한다. -> dto기준

```
session.setAttribute("UserSession", response);
session.invalidate(); // 세션을 무효화한다

```
```
There was an unexpected error (type=Method Not Allowed, status=405).
Method 'GET' is not supported.
org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'GET' is not supported
```



------------*미완성된 낸용*--------------
1. UserMapper.java는 아직이다.

--------------------------
model은 데이터에 해당하는가?


logout이 getMapping이었냐,,,

--------------------------

비동기 방식 즉, spa는 스웨거를 이용한다. -> rest controller

json 방식으로 내려주고, 이는 템플릿을 통해서 내려주는데 ResponseEntity<>를 통해서 내려준다.

내려줄수 없을땐  ResponseEntity<Void>로 내려준다.
```

![image](https://github.com/user-attachments/assets/b7b31746-4971-42c6-9c07-1acd3dfb427d)
![image](https://github.com/user-attachments/assets/c3bfd09d-4709-4f90-98c8-69e635601804)

![image](https://github.com/user-attachments/assets/d65e14c8-94ed-4ab1-b841-2957435b803f)
![image](https://github.com/user-attachments/assets/69c4377c-682d-4edc-9f26-67a89742a74a)

#### swagger-ui 관련 annotaton 요약
```

/*
 * ResponseEntity : body, header, status를 포함하는 응답 객체
 * header : 응답 헤더
 *  header는 왜 필요한가?
 *  - 클라이언트와 서버 간의 통신에서 메타데이터를 전달하는 데 사용된다. (클라이언트와 서버 간의 통신에서 필요한 추가 정보를 전달하는 데 사용된다.)
 *  - 클라이언트가 요청한 데이터의 형식이나 인코딩 방식, 캐시 정책 등을 지정할 수 있다.
 *  - 서버가 응답하는 데이터의 형식이나 인코딩 방식, 캐시 정책 등을 지정할 수 있다.
 * body : 응답 본문
 * status : 응답 상태 코드
 */

```java
    @Bean
    public OpenAPI openAPI() {
        // return new OpenAPI()
        //         .components(new Components()
        //                 .addSchemas("UserRequestDTO", new Schema().type("object")
        //                         .addProperties("id", new StringSchema())
        //                         .addProperties("pwd", new StringSchema())
        //                         .addProperties("name", new StringSchema()))
        //                 .addSchemas("UserResponseDTO", new Schema().type("object")
        //                         .addProperties("id", new StringSchema())
        //                         .addProperties("pwd", new StringSchema())
        //                         .addProperties("name", new StringSchema())));
        return new OpenAPI().info(apiInfo());
    }


```
스크립트를 통해서 json 파일을 받게 된다. -> 스크립트를 통해 통신을 하게 된다면, json으로 보낸다.
넘어오는게 @RequestBody라고 명시해준다. 우리가 했을때, json으로 넘겨주지 않기 때문에 굳이 필요가 없었다.
(json을 dto로 converting해주는 것이다.)


스키마에 대해 더 상세하게 설명하는게 가능하다.




// api 엔드포인트가 어떤 그룹에 속하는지를 알려주는 그룹핑 어노테이션
@Tag(name = "Todo", description = "할일 관리 API") // Swagger에서 사용할 태그를 지정한다.
@Bean
@Configuration

    @ApiResponse(responseCode = "200", description = "정상처리") // 200 OK 응답 설명
    @ApiResponse(responseCode = "400", description = "비정상처리", 
                    content = @Content(schema = @Schema(implementation = TodoRequestDTO.class))) // 400 Bad Request 응답 설명



@Schema(description = "Todo 요청 DTO")
// @Schema(name = "UserRequestDTO", description = "UserRequestDTO")
public class UserRequestDTO {
    @Schema(description = "아이디", example = "test")
    private String id;
    @Schema(description = "비밀번호", example = "1234")
    private String pwd;
    @Schema(description = "이름", example = "홍길동")
    private String name;
}


```

# 4.18
반환할때는 viewResolver를 통해서 prefix와 suffix 경로를 참고해서 보낸다.

@Controller는 @RequsetBody를 통해서 json 포맷으로 받을 수 있다.
	 	-> 그게아니면 DTO로 받을 수 있다.

@RestController로도 가능하긴한데, 응답을 @ResponseEntity를 이용한다.



build.gradle -> 라이브러리

-------------유효성 체크------------------


Bean Validation 1.0 은 JSR-303으로 validation 라이브러리를 등록한다.
dto로 json의 유효성을 검증할 수 있다. -> dto에 걸어둔다.
Pattern


-----------------------------
public String insert(@Valid TodoRequestDTO params, BindingResult bindResult) {}

오류가 있다면 알려줄곳이 필요하지 않을까?
처리하지 못한 것을 담아서 보내주기 위해서 BindingResult bindResult를 사용한다.

검증하지 못한 내용들이 BindingResult bindResult담긴다.
 
조건 처리 -> Map 


````
 model.addAttribute("error", map); // 에러메시지를 model에 담는다.
        }

        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map); // 

```


-> validation은 controller에서 체크하는 작업이다.

------------controller 유효성 체크해서 service로 이제 넘겨준다.-----------


db를 연동하는 방법: mybatis -> @Mapper interface로 만든다.(xml과 연결) / jpa -> @Repository로 interface로 만든다.

jpa에서는 일단 query를 구현하고 있는 인터페이스가 처리해준다.

// 테이블로 만들어줄수도 있고,
// crud로 만들어준다.

-> 그렇기 위해서 entity를 만들고 사용하게 된다.
// entity는 테이블과 매핑되는 클래스이다.
다만, entity는 테이블과 1:1로 매핑되는 것이 아니라, 테이블의 컬럼과 1:1로 매핑되는 것이다.
그리고 DTO처럼 쓰면 안된다. -> 그렇기때문에 연결할때 한단계가 더 추가 된다.ㅋㄴ


하이버레이트를 이용한다.
-> 엔티티는 프로그래밍영역에서는 테이블 스키마 역할을 한다.

jpa 프로젝트는 model -> dao -> dto랑 entity 폴더로 나눠짐
--> 서로 구분해야한다.



jpa 보편적으로 해당 설정을 진행한다.
```
# jpa
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect

### auto-type create, update, none -> 실행이 될때, 테이블을 만들어준다.
spring.jpa.hibernate.ddl-auto=create
# spring.jpa.show-sql=true

# 콘솔출력
spring.jpa.properties.hibernate.show_sql=true

# 가독성있는 포맷형식
spring.jpa.properties.hibernate.format_sql=true

# 디버깅이 용이하도록 추가 정보 출력
spring.jpa.properties.hibernate.use_sql_comments=true
```
# 4.28
[참고](https://velog.io/@limsubin/Spring-Security-JWT-%EC%9D%84-%EA%B5%AC%ED%98%84%ED%95%B4%EB%B3%B4%EC%9E%90)

```
--- token(jwt)
[인증과 인가라는 생각이 있어야한다.]
jwt(header, payload, signature)
-> header: 토큰타입, 해싱알고리즘
-> payload: 토큰관련 정보
-> signature: 서명(header의 해싱알고리즘을 풀어서 토큰 체크)


jwt는 spring security와 함께 쓰는 경우가 많다.(인증과 인가가 필요하기 때문이다.)

1. JWT 인증관리는 access token 관리
2. 


user 로그인 -> 서버 받음 -> 세션 생성 -> JSESSIONID를 넘겨준다.

인증(로그인), 인가(특정사용자만 접근할 수 있는 링크)를 활용할 수 있게 되엇다.
"권한을 가진 사람인지 아닌지 체크하는 작업이 인가이다."


[문제점발생]
여러대의 서버(A,B,C)가 있을때, 서버 A에 저장되고 서버B,C에 저장되지 않을때, 공유되지 않는 경우 발생




1. 토근 인증과정
클라이언트 로그인 요청 -> 서버 토큰을 포함한 응답 -> 클라이언트에서 토큰 저장 -> 
-> 토큰을 담아서 서비스 요청 -> 서버에서 토큰 위변조 검증 -> 검증된 경우에 응답

*만약에 문제가 생겼으면, 만료되었다고 사용자에게 알려주고, refresh token체크*

2. 

-----------------------------------------------------------------

/////// 간단하게 사용할 것은 in memory db를 사용할 수 있다.
// 필요하면 mybatis 사용


---------------------------------------------------------------
백엔드 이제 연습하고, 이전에 올려둔것 코드 리뷰 진행한다.

jpa로 체크해서 사용할 수 있도록 코드를 스스로 작성해보자.

``` 파일 위주 체크


```

# 5.7


intercepter -> request, response에 대해 가로채서 헤더에 넣어줘서 처리가 가능했다.

controller에서 요청 데이터 수신, 유효성 검증(데이터 포함)후, service에게 데이터를 넘겨줘야한다.
(필요시, DTO → Entity 변환, 비즈니스 규칙에 대한 추가 검증, )
권한/인증 체크 (Controller 또는 별도 필터/인터셉터에서)

+ 로그 기록(중요한 요청이나 에러 로그 남기기)
+ 트랜잭션 처리(Service에서 필요하다면)
+ 입력값 Sanitizing (XSS, SQL Injection 등 방지)
-----------------------------------------------
spa로 프론트엔드 개발을 시작하자, 토큰이라는 방식이 생겼다.
-----------------------------------------------
<ORM>

- Mybatis로 dao 작성하던지 -> 나머지
=> 양방향 매핑

- jpa로 dao 작성하던지 할 수 있다. -> hibernate라는 ORM 활용한다.
=> 단방향 매핑(in-memory: h2database)
-----------------------------------------------
jpa: 
// table name을 자동으로 생성한다. -> @Table(name = "user")로 변경 가능하다.
// .yaml에서 ddl-auto: update으로 체크해서 진행.
```
jpa:
        
        hibernate: 
            ddl-auto: update
        show-sql: true
```
-> 테이블 생성을 jpa에게 전적으로 위임(update)
-> 테이블 생성을 위임하지 않는다.(none)
-----------------------------------------------
*방향성*
-----------------------------------------------
- 양방향: 
- 단방향: 단순 조회면 굳이 양방향을 쓸 필요가 없다. 해당 테이블로 다른 테이블 조회할 수 있다.
우리는 일단 @OneToMany()이랑 @JoinColumn(name = "member_id")으로 지정해서 post list를 만들었다.

```
    @OneToMany()
    @JoinColumn(name = "member_id") // member_id를 외래 키로 사용합니다.
    // @JoinColumn은 연관관계의 주인 쪽에서 사용합니다.
    private List<PostEntity> posts = new ArrayList<>(); // member가 쓴 글을 나타냅니다. 
```

아래와 같이 쓰지 않았다.
```
// member가 쓴 글이필요하다. post_id를 추가한다.
    @OneToMany(mappedBy = "postEntity") // postEntity 기준으로 매핑합니다.
    // mappedBy는 연관관계의 주인이 아닌 쪽에서 사용합니다.
    private Long postId; // 글 ID 
```

---------------------@OneToMany()의 추가 옵션--------------------------
@OneToMany(mappedBy = "postEntity")



---------------------User 비지니스 로직(토큰 없이)--------------------------
doFilter 없이?

로그인하고, 누가 썼는지 알아야한다.




단방향이라서 MemberEntity기준으로  addPost를 추가한다. member를 토대로 글을 다뤄야한다.
// member에서 posts를 가져온다.



------------------------------------------------------------------------------
private List<PostEntity> posts = new ArrayList<>();를 사용하는게 아니라
        PostResponseDTO를 활용하겠다.




--------------------복습(어노테이션등)---------------

--------------------
pathvariable -> @PostMapping("/{id}/post")
requestBody ->    public String createPost(@PathVariable Long userId, @RequestBody PostRequestDTO params) { // 이렇게 쓸때 pathvariable을 사용하는 것이 좋다.
}


--------------------stream의 map
map: 타입변환시 사용한다.

int sum = widgets.stream()
                      .filter(w -> w.getColor() == RED)
                      .mapToInt(w -> w.getWeight())
                      .sum();
 


# 5.8

7일자 수업 내용복습

------------------------------------
단방향 vs 양방향
단방향 -> 1대m 관계를 가진다. (회원이 가지고 있는 post들)

그래서 핵심 코드

```
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // cascade = CascadeType.ALL // cascade = CascadeType.ALL은 연관된 엔티티를 함께 저장, 삭제하는 옵션입니다.
    @JoinColumn(name = "member_id") // member_id를 외래 키로 사용합니다.
    // @JoinColumn은 연관관계의 주인 쪽에서 사용합니다.
    private List<PostEntity> posts = new ArrayList<>(); // member가 쓴 글을 나타냅니다. 
    //private List<PostResponseDTO> posts = new ArrayList<>(); // member가 쓴 글을 나타냅니다. 

    // MemberEntity가 주인이므로, PostEntity를 주체로 하는 연관관계입니다.
    // member가 쓴 글을 나타내는 List<PostEntity> posts를 추가합니다.
    // member를 토대로 글을
    public void addPost(PostEntity post) {
        posts.add(post); // 글을 추가합니다.
    }

```

@JoinColumn(name = "member_id") /
적용코드: 레포지토리로 멤버엔티티를 변경한다. 외래키관계에 있는 post엔티티는 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)를 통해서 수정가능.
```
      if (op.isPresent()) { // User가 존재하면 -> refresh token이 있다.
            // postRepository.save(post);
            op.get().addPost(post); // User를 가져온다.
            //postRepository.save(op.get());
            memberRepository.save(op.get());
            
            return PostResponseDTO.builder()
                        .title(post.getTitle()) // email
                        .content(post.getContent()) // password
                        .build(); // UserResponseDTO를 생성한다.
           
        } else {
            // 없으면, 에러처리
            return null;
            
        }
```


------------------------------------
// op.isPresent()로 처리하지 않고, orElseThrow(()-> ())처리가능


/*추가적으로 Optional에서 orElseThrow(()-> ()) 또는 orElse(null) 또는 ...*/




// 멤버로부터 post id를 가져와야한다. (바로 접근할수는 있는데 그러면 뭐하러 관계를 가졌고, 회원에 해당하는 목록을 보기 어렵다.)
post entity에서 잡을 수 있도록한다.

/* stream()으로 일단 .filter랑 .map 그리고 .sort(?) 그리고 .reduce */







```
        PostEntity post = member.findPost(params.getId()); // id로 User를 찾는다.


        System.out.println("debug >> updateUserPost(service) post : " + post.toString());
        post.updatePost(params);    // 
```


// .save()는 존재할때 update하고 없으면 create해서 저장한다.
------------------------------------
테이블 스키마를 만들면된다.
양방향이나 단방향을 만들면 된다.


------------------------------------

// PostEntity랑 UserService
------------------------------------

# 5.9
8일 수업 복습
-> 토큰을 활용해서 인증과 인가를 진행할 수 있다. 더 나아가면, roll(admin, user)로 구분되어야한다.

transactional을 했더니 객체 select, update가 이뤄졌다. .save()를 하지 않았어도 됐었다.

=======================================================================
1. 




=======================================================================

1. dirty checking -> 업데이트부분을 내가 원하는 부분만 고치기.
PutMapping -> 전체를 고치는게 아니라 해당 부분만 고치는데     @Transactional을 통해 변경감지를 하다보니, 자동으로 수정한다.
근데 모두 다 바꿔져버린다.

그래서 두가지 방법을 이용해서 해결할 수 있다.
-> dynamic insert등을 해보기(해당 entity에서 바꾸기)
-> jpql



1.1 dynamic insert등을 해보기(해당 entity에서 바꾸기)
```
@PutMapping("/update")
    // Dirty checking(변경 감지)
    // -> jpql
    // -> dynamic insert등을 해보기
    @Transactional
    public String update(@RequestBody Map<String, String> params) { // 원래는 requestDTO를 걸어주는게 맞긴하다.
        //TODO: process POST request
        System.out.println("debug >> update(ctrl) endpoint hit");

        // entity 정보를 가져온다. -> 없는 경우 .orElseThrow(() -> new RuntimeException("not found")); // 근데 해당 코드로 하면ㄷ안됨...
        // 일단 user_id는 일단 기존에 있는걸로 진행한다.
        JpaSampleEntity entity = jpaSampleRepository.findById(params.get("user_id"))
                            .orElseThrow(() -> new RuntimeException("not found"));
        // 아래는 있는 경우에만 실행된다. ->  
        entity.setPasswd(params.get("user_passwd"));
        entity.setName(params.get("user_name"));
        ////////////// 아래를 진행하지 않았다면, 

        jpaSampleRepository.save(entity);

        // // 모든 컬럼에 대해 컬럼이 변경된다. 
        // JpaSampleEntity entity1 = JpaSampleEntity.builder()
        //                             .userId(params.get("user_id"))
        //                             .passwd(params.get("user_passwd"))
        //                             .name(params.get("user_name"))
        //                             .build();
        
        // jpaSampleRepository.save(entity1);


        

        return null;
        /*
         * 
         * return Map.of(
                "accessToken", accToken,
              "refreshToken", reToken
            );
         */
    }

```
-------------------------------------------------------------------------
1.2 jpql를 이용했다.

```


```

-------------------------------------------------------------------------
@Query("SELECT new com.example.demo.domain.entity.JpaSampleEntity.SampleResponseDTO(E.userId, E.user, E.userId, E.userId) FROM JpaSampleEntity E")
    public List<SampleResponseDTO> findByAll();

-------------------------------------------------------------------------
HttpURLConnection




--------복습 필요한 것들----------

-> annotation: @NotNull, @Data, @Valid, @Value()

@Data를 통해서 
@Value()를 통해서 일단 .yaml 파일에 있는 값을 가져올 수 있다











-----------------------------참고하도록한다.------------------------------------
https://www.google.com/search?q=yaml+to+properties&sca_esv=e5eeec09d3fdc8a2&sxsrf=AHTn8zos5Iz2akorH_PWUNfK2wReYXnvNA%3A1745803590966&source=hp&ei=RtkOaIDnOLmi2roPrJPimAQ&iflsig=ACkRmUkAAAAAaA7nVvDy4lf9GJO2NaNsDS5_DyQRBXHo&oq=yaml+to+&gs_lp=Egdnd3Mtd2l6Igh5YW1sIHRvICoCCAAyBRAAGIAEMggQABiABBjLATIFEAAYgAQyBRAAGIAEMgUQABiABDIFEAAYgAQyBRAAGIAEMgUQABiABDIIEAAYgAQYywEyCBAAGIAEGMsBSMwcUABYzQ9wAHgAkAEAmAHiA6ABtw-qAQkwLjUuMS4wLjK4AQPIAQD4AQGYAgigAugPwgIEECMYJ8ICCxAuGIAEGLEDGIMBwgILEAAYgAQYsQMYgwHCAhEQLhiABBixAxjRAxiDARjHAcICCBAAGIAEGLEDwgIKEAAYgAQYQxiKBcICEBAuGIAEGNEDGEMYxwEYigWYAwCSBwkwLjUuMS4wLjKgB7MysgcJMC41LjEuMC4yuAfoDw&sclient=gws-wiz

package com.example.demo.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // table name을 자동으로 생성한다. -> @Table(name = "user")로 변경 가능하다.
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    @Column(name = "id") // column name을 자동으로 생성한다. -> @Column(name = "user_id")로 변경 가능하다.
    private Long id; // ID

    @Column(name = "name") // column name을 자동으로 생성한다. -> @Column(name = "user_name")로 변경 가능하다.
    private String email; // email

    @Column(name = "password") // column name을 자동으로 생성한다. -> @Column(name = "user_password")로 변경 가능하다.
    private String pwd; // password

    @Column(name = "token") // column name을 자동으로 생성한다. -> @Column(name = "user_token")로 변경 가능하다.
    private String token; // token


}


-> public class UserRequestDTO {} private String accessToken; // token

-> public class UserRequestDTO{}  private String refreshToken; // token


```requestBody 떠올리기

public ResponseEntity<Void> login(@RequestBody UserRequestDTO params) {
        System.out.println("debug >> Login(ctrl) endpoint hit");
        return null;
    }
```

-------------------------------

@Component에 대
```
@Component 어노테이션은 Spring Framework에서 개발자가 작성한 클래스를 스프링 빈(Bean)으로 등록할 때 사용합니다. 이 어노테이션을 클래스에 붙이면, 스프링이 해당 클래스를 애플리케이션 구동 시 자동으로 인스턴스화하고 관리합니다.

어떤 역할이 아니면 @Component를 붙이나?
일반적으로, 특별한 역할(예: @Service, @Repository, @Controller 등)이 없는 클래스에 @Component를 붙입니다.

@Service, @Repository, @Controller 등은 각각 서비스 계층, 데이터 접근 계층, 웹 컨트롤러 계층에 특화된 의미를 갖는 어노테이션입니다.

이들 어노테이션은 내부적으로 @Component를 포함하고 있지만, 역할에 따라 구분해서 사용합니다.

만약 특정한 계층이나 역할이 명확하지 않은 일반적인 빈(예: 유틸리티 클래스, 공통 기능 클래스 등)을 만들 때 @Component를 사용합니다.

정리
특정 계층(서비스, 레포지토리, 컨트롤러 등)에 속하지 않는 일반적인 빈을 등록할 때 @Component를 사용한다.

역할이 명확한 경우에는 @Service, @Repository, @Controller를 사용하고, 그렇지 않을 때 @Component를 붙인다
```



```UserResponseDTO.builder에 대해서 token을 넣어줘야한다.

public UserResponseDTO loginService(UserRequestDTO params) {
        System.out.println("debug >> Login(service) hit");
        System.out.println("debug >> Login(service) params : " + params.toString());
        String accessToken = jwtProvider.generateAccToken(params.getEmail()); // JWT Access Token 생성
        String refreshToken = jwtProvider.generateReToken(params.getEmail()); // JWT Refresh Token 생성


        // UserEntity user = authRepository.findById(params.getId()).orElse(null); // ID로 User를 찾는다.

        return UserResponseDTO.builder()
                .id(params.getId())
                .email(params.getEmail())
                .pwd(params.getPwd())
                .accessToken(accessToken) // JWT Access Token 설정
                .refreshToken(refreshToken) // JWT Refresh Token 설정
                .build(); // UserResponseDTO를 반환한다.
    }
```
----------
react에서 header에 심어준다.

우선 react에게 jwt 토큰을 넘겨줘야한다.
응답해줄때, accessToken이랑 refreshToken을 같이 넘겨줘야한다.
지금상태에서는 react가 header를 읽지 못하니 config에서 WebConfig.java를 만들어서 처리해준다.




리액트는 formㅇ 아니어도 된다. 핸들러를 토대로 체크하면된다 onSubmit, onClick둘다 가능하다.
onChange로 상태를 체크할 수 있다.

----------
react에서 axios 요청시 쿠키 세션 값을 세팅해서 보내야한다.
```
	withCredentials : true,
```


```

# 5.12


.yaml 파일에 있는 값을 불러올 때 사용한다.
```
    @Value("${openApi.serviceKey}")
    private String serviceKey;

    @Value("${openApi.callBackUrl}")
    private String callBackUrl;

    @Value("${openApi.dataType}")
    private String dataType;

```

브라우저가 아니기 때문에 httpUrlConnection을 통해 백엔드에서 url 통신을 요청할 수 있다.

HttpURLConnection, InputStream, String으로 
```
        HttpURLConnection http   = null ; 
        InputStream       stream = null ; 
        String            result = null ;
```
URL url = new URL(requestURL); -> http = (HttpURLConnection)url.openConnection();
                   


--------------------------------------------------------

// git security 설정해서 통해서 불러올수 있다.


--------------------------------------------------------
자바의 객체를 json로 바꾸는 것: 직렬화
반대 작업: 역직렬화

body의 <items>라는 노드에 접근해서 <item>를 꺼내고, ForcastResponseDTO에 담아줘야한다.
List<ForcastResponseDTO>으로 받을 것이다.
그리고 매핑을 진행해서 서비스로 진행하면 된다.


매핑을 annotation방식으로 바인딩시킬 것이다. 
@JsonIgnoreProperties(ignoreUnknown = true)을 통해서 영어 대소문자나 null일 수도 있고, property가 없을 수 있다. 이때 에러가 나지 않고 가져온다.
각각 필드에 @JsonProperty("(필드명)") annotation을 작성해준다.


[**매핑을 도와주는 객체가 있다. 서비스에서 일어나야한다.**]
        ObjectMapper mapper = new ObjectMapper();를 이용한다.



문자열이기 때문에 <response>부터 타고 들어가야한다.
```
<response>
<header>
<resultCode>00</resultCode>
<resultMsg>NORMAL_SERVICE</resultMsg>
</header>
<body>
<dataType>XML</dataType>
<items>
<item>

```

=> 반환받는것 ForcastResponseDTO 여러개를 받아야되는데, 지금 이렇게 하면 한개만 돌려준다.
'''mapper.readValue(str, ForcastResponseDTO.class);'''


그렇기 때문에 item을 기준으로 문자열을 끊어서 해줄수 있어야한다. (?)


--------------------------------------------------------

// 배열 체크 우선 <response>를 타고 node내에서 findValue("item")으로 체크한다. 일단 하나만 가져올 수 있다.
// .

// .






#### 요약
```

```
# 에러 해결

처음에 dispatcherServlet에서 문제가 발생했다. 그래서 extension 문제인지 알았는데 일단 cache를 모두 지우고 나머지 활동을 진행하는게 중요하다는 것을 알았다.
