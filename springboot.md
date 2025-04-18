

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

#### 요약
```

```
# 에러 해결

처음에 dispatcherServlet에서 문제가 발생했다. 그래서 extension 문제인지 알았는데 일단 cache를 모두 지우고 나머지 활동을 진행하는게 중요하다는 것을 알았다.
