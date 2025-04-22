# 개요

# 요약


# 목표
## 목표 프론트엔드 반응형 웹과 redux, axios 통신과 디자이너 툴 협업에 대해 상세하게 경험이 있는 것.
## 최적화 및 cs 지식 적용 가능한 점.(cache랑 섹션등 백엔드 이해 및 ai 개발 연구보조.)


# [contents-4.21 실습 내용]("")

## 개요

## 요약

양방향 통신이 된다.

virtual dom 	-> 	script
		-> 	browser dom


props로 재사용한다..


npm
npx(e) -> node package(binaries) execute

npx create-react-app siat-react
컴포넌트 -> 함수로 활용 / return으로 html 다룸.
styled-components css-modules




:3000이랑 :8088 sharing되어진다. 여기서 cors에러를 해결하기 위해서 
백엔드에서 @CrossOrigin(origin="http://localhost:3000") 처리



@CrossOrigin을 통해서 cors 에러를 해결한다. sharing이 되도록 설정한다.
백엔드에서 처리해주는게 가장 해결율이 높다.




----------------------------------------------------------
## return 주기
users.map((user) => {
                        // <User name={user.name} info={user.info}/>
                        console.log(user)
                        console.log(user.name)
                        console.log(user.info)
                        return (
                            <li key={user}>
                                <User name={user.name} info={user.info}/>
                            </li>
                        );


                    })


return을주지 않아서 컴포넌트로 반환되지 못했다. -> 실수
----------------------------------------------------------
## get에서 body를 못받는 이유 & 저장하지 못하는 이유
GET으로 안되었던 이유는 headers: {"Content-Type": "application/json"}
get은 일단 쿼리 스트링으로 보내는 것만 지원한다.(일반적으로!)
	=> 'Content-Type'을 'application/json'으로 세팅해놨고, Config 옵션에 {params: ~}를 의미하는 {params}로 넣어놨어서 쿼리스트링으로 전달된 상황이다.
	해당 상황이라서 requestBody로 받는다고 명시했을때 spring boot 내부적으로 자동으로 쿼리 스트링을 json 즉, requestBody에서 자동 변환을 해줬다.
----------------------------------------------------------
## useEffect에서 
나는 일단 useEffect에서 컴포넌트 마운트한다음에 처리하는 로직이 필요하다는 부분을 이해하기 어려웠다.
-> 해당부분이 일단 오류가 나서 제거했다.

왜그런지 파악이 필요하다.

==> 











************

----------------------------------------------------------
## 경로문제 해결 
### Module not found: Error: Can't resolve 'axios' in 'C:\siat-sw\react\siat-react\src\api'
Did you mean './axios'가 발생했다. 경로 문제로 이해할 수 있다.

```

ERROR in ./src/api/axios.js 3:0-26
Module not found: Error: Can't resolve 'axios' in 'C:\siat-sw\react\siat-react\src\api'
Did you mean './axios'?
Requests that should resolve in the current directory need to start with './'.
Requests that start with a name are treated as module requests and resolve within module directories (node_modules, C:\siat-sw\react\siat-react\node_modules).
If changing the source code is not an option there is also a resolve options called 'preferRelative' which tries to resolve these kind of requests in the current directory too.

```


현재 InterLocking.js에서 다음과 같이 import하고 있습니다:

```js
import api from './api/axios.js'; // ../api/axios.jsx이랑  ../../api/axios.jsx도 에러가 났던걸로 기억하긴함. -> 그땐 jsx였다.
```
이 코드는 현재 파일 위치(src/test) 기준에서 api/axios.js를 찾으려고 시도합니다.
즉, src/test/api/axios.js를 찾으려다 없으니 오류가 나는 것입니다.
----------------------------------------------------------
## 비동기 통신에서 async await를 진행해야하는 이유
async await를 제공해서 진행해야된다. -> 실수



### 비동기 작업의 결과를 반드시 처리하려면 then/catch/await 중 하나를 사용해야 합니다
```paintext
비동기 작업의 결과를 사용할 수 없다:
Promise는 비동기 작업이 끝났을 때 결과(성공/실패)를 then/catch/finally 또는 await로 받아서 처리해야 합니다. 아무런 후속 처리(then, catch, await 등)를 하지 않으면, 비동기 작업의 결과값이나 에러가 코드상 어디에도 전달되지 않습니다. 즉, 작업이 실제로 완료되어도 그 결과를 활용할 방법이 없습니다.

에러(Reject) 발생 시 처리되지 않는다:
만약 Promise가 reject(실패)된다면, catch나 await 등으로 에러를 받아서 처리하지 않으면 해당 에러는 "UnhandledPromiseRejection" 상태가 됩니다. 이는 콘솔에 경고 메시지가 출력되거나, Node.js 환경에서는 프로세스가 종료될 수도 있습니다.

실행 흐름에는 영향이 없다:
Promise 객체 자체는 생성과 동시에 실행되지만, then/catch/await 등으로 결과를 받지 않으면, 단순히 비동기 작업이 백그라운드에서 실행되고 끝나는 것뿐입니다. 동기 코드의 흐름에는 영향이 없습니다.
```


-> fetch를 사용해서 /then/catch를 이용하던 일단 해당 과정이 필요하다.(then 체인 지옥이 발생할 수 있기때문에... 권장하지 않는다.) 비동기 통신이기때문에 항상 필수적임!
(-> axios 사용이 어려움.)
```jsx
fetch('https://api.example.com/data')
  .then(result => result.json())
  .then(data => console.log(data))
  .catch(error => console.error(error));

```

```jsx
async function fetchData() {
  try {
    const result = await fetch('https://api.example.com/data');
    const data = await result.json();
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}
fetchData();
```
----------------------------------------------------------
form -> submit을 통해서 화면을 바꾸는 용도가 아니기 때문에
e.preventDault()를 처리해서 화면을 바꾸지 않고 랜더링할 수 있게 바군다.

----------------------------------------------------------


















----------추가 설명-----------
@RequestBody로 받아서 json 포맷으로 받을 수 있게 만들어야한다.
-> 근데 비표준 방식이라고한다. get은 쿼리파라미터나 pathVariable을 이용한다고한다.



----------------->> config에서 params, headers, data, timeout, baseURL등을 사용할 수 있다고 한다.


---------------------------------------------------
참고

```
function Component() {
  const [data, setData] = useState(null);

  // ✅ useCallback으로 함수 메모이제이션
  const fetchData = useCallback(() => {
    axios.get('/api/data')
      .then(res => setData(res.data));
  }, []);

  // 마운트 시 자동 실행
  useEffect(() => {
    fetchData();
  }, [fetchData]);

  return (
    <div>
      <button onClick={fetchData}>새로고침</button>
      {data && <div>{data}</div>}
    </div>
  );
}

{/*
동작 원리:

useCallback으로 함수 재생성 방지

useEffect로 초기 데이터 자동 로딩

버튼 클릭 시 동일 함수 재사용
*/}

```


axios.get(url, config)
	```jsx
		axios.get(url, { params: { key: 'value' }, headers: { ... } });
	```

axios.delete(url, config)
	```jsx
	# axios.delete(url, { data: body, headers: { ... } }); // config에서 데이터를 넣어줄순 있다. 하지만 권장x
		axios.delete('/api/users/123', {
		  data: { reason: 'no longer needed' },
		  headers: { Authorization: 'Bearer token' }
		});
	```





```paintext
POST: 생성(Create) -> 중복 생성(여러개 생성됨)

PUT: 전체 수정(Replace) -> 덮어쓰기

PATCH: 부분 수정(Partial Update)
```


// POST
axios.post(url, data, config); // url: 요청할 엔드포인트 주소 // data: 서버로 보낼 데이터(JSON, Form 등) // config: 헤더, 파라미터 등 기타 옵션

// PUT
axios.put(url, data, config);

// PATCH
axios.patch(url, data, config);




![image](https://github.com/user-attachments/assets/98acb350-e821-46a6-8273-3cbf28b37312)
![image](https://github.com/user-attachments/assets/d5ec9604-bf70-44ab-967d-6748e785d77a)
![image](https://github.com/user-attachments/assets/c85fcdf0-7c39-4bef-8934-fbfc1b76f0ed)
![image](https://github.com/user-attachments/assets/7cccbe0f-9880-4be1-99e5-16cdd3f23b58)
![image](https://github.com/user-attachments/assets/0c26ed66-80f7-48b1-bf96-78543dfab71e)




----------------------------------------------------------

# [contents-4.22 실습 내용]("")



```
앨리멘트: 보여준 역할을 담당하는 가장 작은 단위


"readOnly"인 가장작은 빌딩 블럭이다.
클래스(컴포넌트) -> 객체(엘리먼트)로 이해하면되며, props를 통해서 다양화된다.


중괄호로 생성되었다는건 스크립트라는 의미고, 무조건 자바스크립트 코드가 들어간다.


컴포넌트 합성





*props는 화면을 랜더링하기 위해서 만든 것*
문법 포맷을 체크해보자.
1. 스크립트를 넣을거면, {}로 진행
2. style을 객체로 담아서 key:value로 진행한다. {}여러개면 묶어줄순 있겠지...
json 포맷과 차이는?
3. 
4. 



-----------ㅇㅇ-------------
```
const styles = {
    commentContainer : {

    },
    nameTxt : {

    },
    commentTxt : {

    }
}
```

-----------props는 화면을 랜더링하기 위해서 만든 것-----------
요약
props는 컴포넌트가 어떤 화면을 보여줄지 결정하는 "입력값"이기 때문에, 화면을 렌더링(그리기)하기 위해 반드시 필요합니다.

props가 변경되면, 리액트는 변경된 데이터를 기반으로 다시 렌더링하여 최신 화면을 보여줍니다
(리액트 컴포넌트는 props(입력값)를 받아서, 그 값을 바탕으로 어떤 UI를 어떻게 보여줄지(렌더링)를 결정합니다. 즉, props가 바뀌면 컴포넌트는 새로운 props를 반영해서 다시 화면을 그립니다)
(props는 컴포넌트가 외부로부터 전달받는 "상태"이기 때문에, props가 변경되면 해당 컴포넌트와 그 하위 컴포넌트들은 다시 렌더링되어 변경된 데이터를 화면에 반영합니다)



-----------state를 통해서 script를 통해 동기화(virtual <--> browser)를 하고 양뱡항 통신을 할 수 있게 된다.-------------
virtual dom에서 broswer dom에게 뿌려줘야한다. 이걸 state(상태) 기준으로 된다.
---> 랜더링이나, 데이터흐름에 사용되는 값만 state에 포함시켜야한다.


script를 통해 동기화(virtual <--> browser) => reloading없이 변경하려고한다 : 
life-cycle을 통해서 컴포넌트 생명주기를 다룬다.
	- 처음로딩시
	- 특정상태변경시, -> 재랜더링시켜서 스크립트 동작시킨다.
	- 제거시

<useState>


Component내에서 동작하니 top level에 호출하면 안된다.
state에 대해서 컴포넌트 내부에서 사용하고 변경(리랜더링 즉, 변경된 부분 업데이트 필요해서 그려달라는것임/)

setState로 하나만 작업할때는 굳이 함수를 정의해서 쓰지 않아도된다.(중요하지 않은 작업 및 일회성이나 5번이내등등 많이 안사용할땐 바로 쓰는게 좋을듯)
<button onClick={setCount(count+1)}>증가</button> -> 이렇게 쓰면 안된다.


# 이렇게 되면 Counter를 너무 많이 호출하게된다.
```
	<button onClick={countHandler}>상태관리</button>
            <button onClick={()=>setCount(count+1)}>증가</button>
```

의존성배열을 안넣었을때 unMount, mount에 대해 사용된다.

useEffect(countHandler, [count])일때 문제는 mount에 동작해보고, 이게 트래거를 일으킨다. 업데이트에도 영향을 미쳐서 계속 무한반복이된다. (set을 넣는걸 추천하지 않는다. 일반적으론!)
단순히 componentdidUpdate될때 사용하고자 하면, useRef()를 활용해야한다.
=> const isFirstRender = useRef(true);
useEffect(() => {
  if (isFirstRender.current) {
    isFirstRender.current = false;
    return;
  }
  // 여기에 업데이트 시 실행할 코드
}, [count]);




<useCallback>
props랑 useMemo랑 무분별한 업데이트를 방지하는경우
고비용, 외부통신, props, 등...

*새로고침시, 같이 사용하게되는 것같다.* 해당 예제 기반으로 체크하자.

<useEffect>


->sideEffect에 의해서 동기화시켜주는 작업이 필요하다.

--------최적화--------------
랜더링 최적화
- 컴포넌트 쪼개기 
상태 변경이 자주 일어나는 부분과 그렇지 않은 부분을 분리해, 꼭 필요한 부분만 리렌더링되게 합니다.
- 불변성 유지
상태를 불변 객체로 관리하면 변경 감지가 빨라져 불필요한 렌더링을 줄일 수 있습니다.
- key 속성 최적화
리스트 렌더링 시 고유한 key를 사용해 불필요한 리렌더를 방지합


+ 심화: React.memo, useMemo, useCallback
불필요한 재렌더링과 함수 재생성을 방지할 수 있습니다. 특히 연산 비용이 큰 컴포넌트나 함수에 적용하면 효과적입니다


로딩 최적화
- 윈도우잉(Windowing) 기법(랜더링할 것 자체를 줄어준다.)
긴 리스트나 테이블은 react-window, react-virtualized 같은 라이브러리로 화면에 보이는 항목만 렌더링

- 코드 스플리팅
React.lazy, Suspense 등을 활용해 필요한 시점에만 코드를 로드



```














