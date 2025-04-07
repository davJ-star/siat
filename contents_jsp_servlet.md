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
