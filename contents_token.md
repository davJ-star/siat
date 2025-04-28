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

```
