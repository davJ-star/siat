# 4.23

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


# 4.29


```
<고전 방법>
1. 로그인
2. 세션을 만들어서 사용자 정보로 넘겨준다. (세션을 포함해서 응답을 보내준다.)
3. 사용자는 body에 세션 정보(세션id)를 담아서 서버에 보낸다.
4. 


---------------
<토큰 방법>
토큰 방법이 등장했다. -> **jwt랑 쿠키랑 세션에 대한 면접 질문이 나올 수 있으니, 해당 내용을 정리한다.**
1. 로그인
2. 서버에서 token을 발급받고(access / refresh token 생성)
3. http의 헤더에 access / refresh token을 담아 보낸다.
4. 클라이언트에서 토큰을 심는 작업을 진행한다.
5. 토큰을 포함해서 요청을 보낸다.
6. 클라이언트의 토큰이 유효한지 검증을 한다.(filter 제작)
6-1. 검증 성공
6-2. 검증 실패


[만료되었던 상황]
1. 토큰이 만료되었습니다.로 막는다.

1. 토큰을 
2. 
3. 

---------------
사용자 응답을 받을 수 없는 문제가 발생한다.
---------------

```
.then((response) => {
            console.log('Login successful:', response.data);
            // console.log(response.data);
            // console.log(response.status);
            // console.log(response.statusText);


// **4번에 대한 코드**
            console.log(response.headers);
            localStorage.setItem('accessToken', response.data.accessToken);
            localStorage.setItem('refreshToken', response.data.refreshToken);
}
```

---------------

개발자입장에선 body부분이 중요하다.
보안입장에선 header부분이 중요하다.


---------------
	.setSubject(email)  // JWT의 subject 설정 (사용자 이메일)
        	.setIssuedAt(new Date()) // JWT 발급 시간 설정
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // JWT 만료 시간 설정 (1시간 후) 1초 * 1000 = 1ms, 1분 * 60 = 1s, 1시간 * 60 = 1m
            .signWith(key) // 서명 알고리즘 설정
            .compact();

UserResponseDTO response = UserResponseDTO.builder()
                // => 빼고 반환하는게 맞다.  .email(params.getEmail()) // email
                .accessToken(accToken) // access token
                .refreshToken(reToken) // refresh token
                .build(); // UserResponseDTO를 생성한다.
        return response; // response를 반환한다.



// -> .header("Authorization", "Bearer "+response.getAccessToken()) // JWT Access Token을 헤더에 추가한다.  "Bearer "+response.getAccessToken()
@PostMapping("/login") // @RequestMapping("/login")과 @PostMapping("/login")은 같은 의미이다.
    // 현재 endpoint는 /api/v1/auth/login이다.
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO params) { // @RequestBody 어노테이션을 사용하여 JSON 데이터를 DTO로 변환한다.
        System.out.println("debug >> Login(ctrl) endpoint hit");
        System.out.println("debug >> Login(ctrl) params : " + params.toString());
        UserResponseDTO response = authService.loginService(params); // service를 호출한다.
        return ResponseEntity.ok()
                                .header("Authorization", "Bearer "+response.getAccessToken()) // JWT Access Token을 헤더에 추가한다.  
                                .header("Refresh-token", response.getRefreshToken()) // JWT Refresh Token을 헤더에 추가한다.
                                .body(response); // ResponseEntity를 반환한다.
    }
---------------
filter를 만들어서 체크해본다.
-> public class JwtFilter implements Filter {} => @override를 체크한다.

@Override
doFilter값을 토대로 체크한다.    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {}

```
String path = req.getRequestURI(); // 요청 URI를 가져옵니다.
해당 경로에서 패스가 /swagger-ui 또는 /v3/api-docs인 경우, JWT 검증을 건너뜁니다.
uri가 해당 규칙을 반영하는지? -> 체크하는 메소드를 만들었고, boolean


```
``` filter를 통해서 이걸 들어올 수 있는데, filter에서 체크가 안되기 때문에 필터에서 작업을 해야한다.

        registry
                .addMapping("/**") // 모든 경로에 대해 CORS 설정을 적용합니다.
                .allowedOrigins("http://localhost:3000") // 허용할 출처를 지정합니다. (예: React 앱의 주소)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메소드를 지정합니다.
                .allowedHeaders("*") // 모든 헤더를 허용합니다.
                .allowCredentials(true) // 자격 증명(쿠키 등)을 허용합니다.
                .exposedHeaders("Authorization", "Refresh-Token"); // 클라이언트가 접근할 수 있는 헤더를 지정합니다.
```



근데, filter에서 프로그램과 상관없는 부분까지도 막아버렸다.
swagger랑 app부분
---------------


### 4.30

```
<현재 문제>

최초로그인시 생성되는 것.
-> 토근 만료시에만 토큰을 만들기!

데이터는 없다. -> in-memory db이기 때문이다.
// 실제로 만들땐, ddl = none이 필요하다.

// 실제로 header에 token을 넘겨줘야한다. 

---------------------------------------------------------
원래대로라면, 로그인 시점에 토큰 생성하거나 갱신을 해야한다.
지금 우리는 회원가입이 없으므로, 로그인 시점에서 한번만 토큰 생성해야한다.


---------------------------------------------------------






---------------------------------------------------------
JOIN이 필요하거나 다대다 매핑, 일대다 매핑이 필요한 경우는 JPA가 꼬이게 되니,
설정이 필요하거나 mybatis를 쓴다.
---------------------------------------------------------
entity.isPresent() -> optional로 담겨있기때문에, .isPresent()로 null인지 아닌지 체크




accessToken은 request를 통해서 체크하고, 필요하면, refresh token을 통해서 갱신이 필요하다./
1. 그러면 token은 header에 담겨서 요청될 것이고, 이를체크하는 작업
1-1. if (op.isPresent()) {} // User가 존재하면 -> refresh token이 있다.

1-2. JwtProvider에서 발급 받을 수 있다.
-> 지금은 generateReToken, generateAccToken로 받고 있다.





```
public String renewToken(String token) {
        System.out.println("debug >> JwtProvider renewToken() method called");
        // JWT Refresh Token 갱신 로직
        // JWT를 파싱하여 만료 시간을 갱신합니다.
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey()) // JWT 서명에 사용할 키를 가져옵니다.
                .build()

                .parseClaimsJws(token) // JWT를 파싱합니다.
                .getBody() // JWT의 본문을 가져옵니다.
                .getSubject(); // JWT의 subject를 가져옵니다.
    }
```
```
private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)); // JWT 서명에 사용할 키를 가져옵니다.
    }

```


// 토큰을 파싱한다.
Jwts.parserBuilder()
                .setSigningKey(getSigningKey()) // JWT 서명에 사용할 키를 가져옵니다.
                .build()

// header를 만든다.

.parseClaimsJws(token) // JWT를 파싱합니다.
                .getBody() // JWT의 본문을 가져옵니다.
                .getSubject(); // JWT의 subject를 가져옵니다.

------------------------------------------------------------------
로그아웃: 서버사이드에서 토큰을 날린다. -> 어떻게?

=> 이렇게 관리할 수 없다. 프론트에서 날려버려야한다.
리액트에서 localstorage에서 체크할 수 있다.


여기서 headers에 담아서 보내준다.
```
const response = await axios.get('http://localhost:8088/api/v1/hello', {
            headers:{
                Authorization: `Bearer ${accessToken}`,
            }
        });
        console.log('response:', response.data);
```
------------------------------------------------------------------
1-2.

# 콘솔로그 찍는 방법
```jsx
const response = await axios.post('http://localhost:8088/auth/login', {
            email: email,
            pwd: password
        })
```
------------------------------------------------------------------
renew하는 방법이란?


------------------------------------------------------------------
```
@PostMapping("/login") // @RequestMapping("/login")과 @PostMapping("/login")은 같은 의미이다.
    // 현재 endpoint는 /api/v1/auth/login이다.
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO params) { // @RequestBody 어노테이션을 사용하여 JSON 데이터를 DTO로 변환한다.
        System.out.println("debug >> Login(ctrl) endpoint hit");
        System.out.println("debug >> Login(ctrl) params : " + params.toString());
        UserResponseDTO response = authService.loginService(params); // service를 호출한다.
        return ResponseEntity.ok()
                                .header("Authorization", "Bearer "+response.getAccessToken()) // JWT Access Token을 헤더에 추가한다.  
                                .header("Refresh-token", response.getRefreshToken()) // JWT Refresh Token을 헤더에 추가한다.
                                .body(response); // ResponseEntity를 반환한다.
    }
```

# 해당 try-catch로 체크한다.
```

try {
        // JWT Access Token을 검증하고, 유효한 경우 새로운 JWT Access Token을 생성한다.
        String newToken = authService.renewToken(token); // service를 호출한다.
        return ResponseEntity.ok()
                                .header("Authorization", "Bearer "+newToken) // JWT Access Token을 헤더에 추가한다.  
                                .build(); // ResponseEntity를 반환한다.
       } catch (Exception e) {
        // TODO: handle exception
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("재발급 실패"); // 401 Unauthorized 응답을 반환한다.
       }

```
--------------------------
*통신이 안되도록 설정해야한다.*

axios의 intercepter가 필요하다.
react의 intercepter..!




```요청 인터셉터



```


```응답 인터셉터
```
--------------------------



```





---------------

ddl = none으로 체크

------------------
문제해결: axios에서 무조건 @requestBody라던지 등등을 이용한다면, 
값을 무조건 넣어줘야한다.









```
