

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



# 에러 해결

처음에 dispatcherServlet에서 문제가 발생했다. 그래서 extension 문제인지 알았는데 일단 cache를 모두 지우고 나머지 활동을 진행하는게 중요하다는 것을 알았다.
