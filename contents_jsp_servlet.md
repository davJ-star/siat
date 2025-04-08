# 전반 tip
1. 

# 전반 요약

# 코드 tip
### 

# servlet


# contents-4.07 [실습 내용]()


: 



### *tip* 
- 

## 진행사항
1. 

### 


#### 

## 


```

일반 자바는 웹어플리케이션이 아니라서 servlet이 아니면 http 요청과 응답을 받을 수 없다.
그렇기 때문에 servlet을 이용한다.(requset, response를 인식하기 위해서 사용한다. front-controller)
배포한다면, was에 올려줘야한다. (gradle을 사용할 수없으니, eclipse 세팅 그리고 tomcat도 연결)
-----------------------------------------------------------------------------------------
지금까지 배운 자바코드로는 웹애플리케이션으로 동작할 수 없다.
brower에서 http 프로토콜을 사용해서 request, response 인식할 수 없으며, 사용할 수 없다.

해당 문제를 해결하기 위해서 servlet(과 jsp)를 이용해서 
각각 request, response를 해결할 수 있게 된다.

[front-controller]
- servlet: "java" + html => java로 이뤄져 잇으며, browser의 요청을 처리한다. (front-controller)

[viewMain.java]
- jsp: "html" + java =>  html로 이뤄져 잇으며 view를 표현한다. (내부적으론 java인데 html으로 convert)


jvm에 의존 할 수 밖에 없다. jvm + server가 필요하게 된다. (즉, live server 쓸수 없다. )
	Web aplication server: WAS를 쓰게 된다.

servlet, jsp + java를 tomcat을 이용해서 server를 이용


jsp를 통해서 reloading하게된다. 즉 여러 페이지 필요하다.
-----------------------------------------------------------------------------------------
restful api: 비동기 통신

spa: restful api를 통해서 진행한다.
reloading되지 않는다. 스크립트를 통해서 페이지를 스위칭한다.
-----------------------------------------------------------------------------------------

servlet으로 request, response를 받으며 http랑 통신한다.
그러므로 jsp에게도 넘겨준다.



eclipse: 설정을 xml로 세팅할 수 있다. (dependencies나 properties)


URL
http://
	localhost: 8088
	127.0.0.1: 8088
	192.168.100.163: 8088
/testWEB

HttpServlet를 상속받으면, 해당 url과 요청 메소드를 통해 요청하면 자동으로 체크해준다.
--> 자바 스프링이랑 동일하다.
--> 같은 엔드포인트에서 요청방식만 다르다면?



		String msg = request.getParameter("msg");로 전달받으면된다. (값)

String msg = request.getParameter("msg");로 전달받으면된다. 


controller 역할을 servlet으로 작성한다.
근데 각각 controller를 만들고, 해당 service를 만들어야하므로, front-controller하나만 만들고 나머지는 자바로 만든다.
해당 부분이 근데 controller도 포함되는가? 

아닌것같은데? -> 그냥 front-controller servlet으로 만들고 controller는 java로 만든다.


받아와서 dto에 담아서 백엔드에서 처리하기 쉽도록 만든다.

```

```paintext

servlet에서 처리하며, jsp에 값을 넣는다.
servlet의 역할: controller로 분기 및 service로 넘겨준다. 그리고 뷰(client 또는 브라우저 or 프론트)로 심어준다.
				(뷰는 불러온다.)



session을 쓰는걸 권장하지 않는다. (30분동안 해당 데이터에 접근 가능해진다.)
request.setAttribute()를 쓰고 값을 심어준다( = 넘겨준다)
view.forward()를 사용해서 뿌려준다.
```


```java
			HttpSession session = request.getSession();
//			session.setAttribute("msg", id);
			session.setAttribute("msg", result);

```

```java
package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.domain.LoginRequestDTO;
import test.domain.LoginResponseDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientPath = request.getRequestURI();
		System.out.println("debug >>> getRequestURI(): " + clientPath);
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		
		LoginRequestDTO requestDto = new LoginRequestDTO();
		requestDto.setId(id);
		requestDto.setPassword(pwd);
		// 값을 심을 수 있는 영역: request, session, context, page
		// 지금은 request, session으로 심는다.
		
		Boolean flag = true;
		
		// 로그인이 정상적으로 되었다.고 가정한다.
		LoginResponseDTO result = new LoginResponseDTO();
		result.setName("정성욱");
		result.setId(id);
		result.setPasswd(pwd);
		
		
		if (result != null) {
			request.setAttribute("msg", result); // 여기서 심어준다.
			RequestDispatcher view = request.getRequestDispatcher("./ok.jsp"); // msg를 사용해서 가져온 .jsp이며, 이를 화면에 응답으로 처리하기위해 dispatcher를 사용해서 forward를 한다.
			view.forward(request, response); // 요청해서 뿌려놓은 jsp를 응답값으로 반환한다.
			
		} else {
			RequestDispatcher view = request.getRequestDispatcher("./fail.jsp"); // msg를 사용해서 가져온 .jsp이며, 이를 화면에 응답으로 처리하기위해 dispatcher를 사용해서 forward를 한다.
			view.forward(request, response);
		}
		
	}

}

```


# contents-4.08[실습 내용]()


```paintext
jsp: 내부에서 java로 파싱된다.

tomcat이라는 was는 jvm을 포함해야한다.

*.siat

---------------------------------------------------
요청을 받는 역할
파라미터를 전달받는다.
dto로 만들어서 service에 전달
dto로 만들어서 데이터응답
분기(forward / redirect)

-----------------------------------------------------

View를 만든 이유는 분기 때문이다.

-----front-controller-----
request만 담당하고, 나머지는 뒤에 있는 것만한다.
응답 완성된걸 보내주기만한다.



String clientPath = request.getRequestURI();
System.out.println("debug >>> getRequestURI(): " + clientPath);
```
