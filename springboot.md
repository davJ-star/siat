

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





# 에러 해결

처음에 dispatcherServlet에서 문제가 발생했다. 그래서 extension 문제인지 알았는데 일단 cache를 모두 지우고 나머지 활동을 진행하는게 중요하다는 것을 알았다.
