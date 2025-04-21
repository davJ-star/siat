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




----------------------------------------------------------

# [contents-4.22 실습 내용]("")



```




