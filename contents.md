# 전반 tip
1. 프로그래밍은 항상 가변적인 데이터를 생각해야한다.
2. [최신 문법이더라도 사내 명세서에서 따라가기]()



# 전반 요약

# 코드 tip
### [반복문for에서 인덱스와 이터레이터 어떻게 잘 활용할 수 있나?](https://github.com/davJ-star/siat/edit/main/contents.md#tip)
### [ㅇ](https://github.com/davJ-star/siat/edit/main/contents.md#tip)
### [while과 for문 차이]()
### [있나?](https://github.com/davJ-star/siat/edit/main/contents.md#tip)
### [있나?](https://github.com/davJ-star/siat/edit/main/contents.md#tip)
### [있나?](https://github.com/davJ-star/siat/edit/main/contents.md#tip)
### [있나?](https://github.com/davJ-star/siat/edit/main/contents.md#tip)
### [있나?](https://github.com/davJ-star/siat/edit/main/contents.md#tip)
### [있나?](https://github.com/davJ-star/siat/edit/main/contents.md#tip)


# contents-1.14 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)


인터프리터 vs 컴파일: type 관점
source.file -> compile -> byte code -> runtime -> exec

: 데이터를 담는 동사적인 의미
: 데이터를 가지고하는 행위

함수(ㅇ) vs 메소드(x): **단독**으로 실행 가능 여부

### *tip* 
- :int와 같이 최근 문법을 추천하지 않는다. 하지만, 익혀두는건 필요하다...(명세서 지침을 바꿀수 있는 위치가 된다면 가능)
- **type을 체크하고 쓸 수 있어야 확실하게 접근할 수 있다.**

## 에러항목

### concatenate 에러(str)

<img src="https://github.com/user-attachments/assets/0f14454b-f3bf-45ea-b0cd-75c11bfc4d59" width="300" height="300" alt="이미지 설명">

### dictionary : mapping이니깐 인덱싱과 슬라이싱이 리스트와 동일한 방식으론 불가능하다.
key는 항상 string으로 불러서 쓴다.


<img src="https://github.com/user-attachments/assets/38514bcf-8577-4f87-a526-5c1a0def5f93" width="300" height="200" alt="이미지 설명">

### tuple : sequence(순서)이니깐 인덱싱과 슬라이싱이 리스트와 동일한 방식으로 가능하다. -> 무조건 []로 숫자값을 토대로 사용은 확실히 가능


### string : sequence(순서)이니깐 인덱싱과 슬라이싱이 리스트와 동일한 방식으로 가능하다. -> 무조건 []로 숫자값을 토대로 사용은 확실히 가능



### list : sequence이니깐 인덱싱과 슬라이싱이 리스트와 동일한 방식으로 가능하다. -> 무조건 []로 숫자값을 토대로 사용은 확실히 가능
[start: end: step]




# contents-1.15 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)
oop: object oriented programming

python: function 기반 oop
java: class 기반 oop



object --> class --> instance(프로그래밍상)


* class: instance를 만들기 위한 template
- **명사적: 변수**
- **동사적: 함수**


문자열 함수 

#### 문자열 수정할 때, 사용한다. 다만, 공통적 제거하고 싶은 문자열은 자주 쓰이니 함수로 만들어졌다. 여기선 공백.
- strip() # 공백 제거
  - lstrip()
  - rstrip()

#### 
- find # 해당 문자열 해당하는 인덱스번호 찾기

#### 끝 문자열(확장자)에 관심이 있으면 해당 메소드 이용 가능 -> 인덱스로 알 수 없거나 인덱스 사용하면 복잡한 경우 추천. 
- endswith()
feat. startwith()도 있다.

#### 열거형등 모인 그룹을 가진 리스트에서 포함 여부 상황에서 조건 판단!
- in, not in



### 대용량의 데이터를 다루기 위한 중요한 변수타입은 list
순서, 중복, 수정, 삭제 가능
#### append - 최소 arg 1개
#### insert - 최소 arg 2개
#### pop - 최소 arg 1개
#### 

##### index - 최소 arg 1개


=> 그러면 링크드 리스트랑 딕셔너리 자료 구조 체크
1. #### 링크드리스트
**삭제가 많은 상황에서 유용하다.** (노드 간 링크만 수정하면 되기 때문입니다)
리스트랑 딕셔너리보다는 디스크에 저장 부담이 줄어든다.
**연속적 공간 사용이 생각보다 중요하다.**

**검색과 조회는 O(n) 시간복잡도를 가집니다. 배열과 달리 연속된 메모리 공간을 사용하지 않아 캐시 효율성이 떨어질 수 있습니다**
```paintext
- 검색: 링크를 통해 검색을 하기 때문에 원하는 결과가 나올 때까지 찾는다.(배열과 동일하게 일단 해당 기본 블럭만큼 건너뛴다. 다만 링크가 걸릴수도?)
- 조회: 링크를 통해 조회를 하기 때문에 원하는 결과가 나올 때까지 찾는다.(배열과 동일하게 일단 해당 기본 블럭만큼 건너뛴다. 다만 링크가 걸릴수도?)
```

- 수정: 수정하는데, 해당 과정도 리스트랑 동일하다.

- *삭제: 삭제하고 나서 다른 것들은 그냥 링크만 연결해주면 된다.

2. #### 리스트
**연속적 공간 사용이 생각보다 중요하다.**
- 검색
- 조회
- 수정
- 삭제

**간단한 데이터 저장 및 관리**
```paintext
순서가 중요한 데이터 저장: 리스트는 요소들의 순서를 유지하므로, 순서가 중요한 데이터를 다룰 때 유용합니다1.
다양한 타입의 데이터 저장: 리스트는 여러 타입의 데이터를 함께 저장할 수 있어 유연성이 높습니다2.
간단한 데이터 구조가 필요한 경우: 복잡한 관계나 구조가 필요하지 않은 간단한 데이터 저장에 적합합니다
```
**간단한 데이터 저장 및 관리**
```paintext
순서가 중요한 데이터 저장: 리스트는 요소들의 순서를 유지하므로, 순서가 중요한 데이터를 다룰 때 유용합니다1.
다양한 타입의 데이터 저장: 리스트는 여러 타입의 데이터를 함께 저장할 수 있어 유연성이 높습니다2.
간단한 데이터 구조가 필요한 경우: 복잡한 관계나 구조가 필요하지 않은 간단한 데이터 저장에 적합합니다
```


3. #### 딕셔너리
*조회할 때 빠르게 찾을 수 있다.
다만, 메모리 디스크 용량을 많이 요구한다.(그래서 느리다. 삭제랑 수정에 불리함.) 

**--> 메모리/디스크 용량을 많이 요구해서 느리다는 설명은 정확하지 않습니다. (디스크 용량을 많이 가지긴함)**
**--> 해시 테이블 기반으로 평균 O(1) 시간복잡도로 검색, 삽입, 삭제가 가능합니다.**
*검색 중심으로 할 때 유용하다.

- *검색: 인덱스에 해당하는 key를 알고 있기 때문에 빠르다.
- !조회: 인덱스에 해당하는 key를 알고 있기 때문에 빠르다.
- 수정: key를 토대로 수정하긴하지만, 리스트랑 비슷하지만 조금 더 느린걸로..
- 삭제: key, value 둘다 삭제하므로, 느리다.

4. #### 트리
  관계를 살펴본다. 그리고 분리한 설계 가능
  *탐색(조회)에서 많이 쓴다.
  **계층적 데이터 구조를 표현하는 데 유용합니다**

5. #### 그래프
  트리의 일반화된 자료구조이다.
  
6. #### 튜플
  중복제거 & 순서 중요한 경우
  **중복 제거(또는 집합)** 또는 immutable하다.(순서를 가짐) - 확실하게 **순서**가 중요한 경우 사용!
  **리스트보다 메모리 효율적이고 접근 속도가 빠릅니다**

```paintext
[요약]

데이터 *삽입/삭제*가 빈번한 경우: 링크드 리스트
빠른 *검색/조회*가 필요한 경우: 딕셔너리(해쉬테이블을 이용하면 삽입, 삭제도 빠르다고 함)
계층적 데이터 구조: 트리
복잡한 관계 표현: 그래프
'불변성'이 필요하고 메모리 효율성이 중요한 경우: 튜플


```


# contents-1.16 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)


[튜플 자료구조 참고](https://github.com/davJ-star/siat/edit/main/contents.md#%ED%8A%9C%ED%94%8C)

```paintext
  [요약]
   
    
```

 ### **tip**

```paintext

    1. 생성할 때 우선 규칙적 생성은 iterator를 이용해서 만든다고 생각하자. (튜플도 예외없이 생성하는 건 가능!)
    2. 여러 변수를 넣고 싶을 때 format에 넣어서 관리 가능한 이점과 가독성 챙길 수 있음.(물론 이걸 지원하지 않고 f``이나 {}로 하나하나 넣는 것 밖에 안되면 어쩔 수 없긴함) --> print('당신의 이름은 {}입니다.'.format(a))
    3.
    4.
    5.
    6.
    7. 

```

tuple: 튜플
- 읽기 전용
- 순서, 중복 허용
- ...

- 시퀀스이기 때문에 인덱싱과 슬라싱이 가능 []
- 필요에 따라 데이터를 조작해야할 경우
- packing & unpacking


[딕셔너리 자료구조 참고](https://github.com/davJ-star/siat/edit/main/contents.md#%EB%94%95%EC%85%94%EB%84%88%EB%A6%AC)
```paintext
  [요약]
   **내부적으로 인덱스를 가지게 된다**
    반복문으로 처리할 수 있을까? : 시작과 끝이 숫자로 정의되어있지 않아서 불가능 --> 다만 내부적으로 제공해주는 함수가 있다.
    이게 바로 keys(), values(), items()이다. 
        --> 해당 메소드로 반복문으로 활용할 수 있다. (내부 생성되는 인덱싱으로는 접근은 불가능)
    그렇기 때문에 인덱싱 대신 get()을 작성하면 인덱싱에 해당하는 key값이 없을때 keyerror를 뱉지 않고, None 반환
```

### tip
    1. 데이터를 묶을 때, zip함수를 상당히 많이 쓰인다.

```paintext
추가 체크
[추천: 현실적인 사용 사례에서는 확장성과 가독성을 고려해 딕셔너리 방식을 사용하는 것이 더 바람직하다. 성능 차이는 거의 무시할 수 있기 때문이다.]
items['메로나'][0]과 items.get("메로나")[0]의 속도 차이는 미미하지만, 일반적으로 items['메로나'][0]이 더 빠르다.

이유
items['메로나']:

딕셔너리에서 키를 직접 조회한다.
키가 존재하지 않으면 바로 KeyError를 발생시킨다.
불필요한 추가 작업 없이 바로 값을 가져오므로 더 빠르다.
items.get("메로나"):

딕셔너리의 get() 메서드는 내부적으로 키가 있는지 확인한 후 값을 반환한다.
키가 없을 경우 기본값(None 또는 지정된 기본값)을 반환하도록 설계되어 있다.
키가 존재하지 않을 경우의 처리 로직이 추가되므로 약간의 오버헤드가 있다.
실제 속도 비교
차이는 미세하며, 일반적으로 get() 메서드의 오버헤드가 약간 더 많다. 하지만 이는 매우 빠른 연산이기 때문에 실제 차이는 거의 무시할 수 있는 수준이다.

언제 어떤 방식을 사용할까?
items['key']:
키가 존재한다고 확신할 때 사용.
키가 없으면 KeyError가 발생한다.
items.get('key'):
키가 없을 수도 있는 경우 안전하게 처리하려면 사용.
키가 없을 때 기본값을 반환하거나, 처리 논리를 추가할 수 있다.
결론
성능 최적화 관점에서는 **items['key']**가 더 빠르다.
하지만 코드 안전성을 고려하면 **items.get('key')**를 적절히 활용하는 것이 좋다.


비교 기준
'메로나': [300, 20]와 '메로나': {'price': 300}의 구조는 사용 목적에 따라 선택해야 한다. 두 방식의 성능 차이는 미미하지만, 코드의 명확성, 유연성, 확장성 측면에서 차이가 있다.

1. 리스트 방식 ('메로나': [300, 20])
장점:
더 간단한 구조:
데이터가 단순하고 키를 명시적으로 사용할 필요가 없는 경우 적합.
약간 더 빠른 접근 속도:
리스트는 키 대신 정수 인덱스를 사용하므로 약간의 오버헤드를 줄인다.
단점:
명확성 부족:
데이터를 인덱스로 접근하기 때문에 값의 의미를 직관적으로 알기 어렵다.
코드 유지보수가 어렵다 (인덱스를 실수로 잘못 사용하거나, 순서를 바꾸면 문제가 발생할 수 있다).
확장성 부족:
값에 추가적인 속성을 넣으려면 구조가 복잡해진다.
사용 예:
python
복사
편집
items = {
    '메로나': [300, 20],
}

# 가격 가져오기
print("메로나 가격 - ", items['메로나'][0])  # 300
2. 딕셔너리 방식 ('메로나': {'price': 300})
장점:
명확하고 가독성이 뛰어남:
값에 접근할 때 어떤 의미인지 바로 알 수 있다 (items['메로나']['price']).
확장성 우수:
추가적인 속성을 쉽게 추가할 수 있다 (예: {'price': 300, 'stock': 20}).
유연한 키 관리:
키 이름을 바꿔도 문제가 생기지 않고, 코드 의도를 더 명확히 표현할 수 있다.
단점:
약간의 오버헤드:
키를 검색하고 값을 가져오는 과정에서 리스트 방식보다 약간 더 느리다. 하지만 이는 일반적인 프로그램에서 무시할 수 있는 수준이다.
사용 예:
python
복사
편집
items = {
    '메로나': {'price': 300, 'stock': 20},
}

# 가격 가져오기
print("메로나 가격 - ", items['메로나']['price'])  # 300
3. 성능 비교
리스트 방식 (items['메로나'][0]):
더 빠르지만, 속도 차이는 대규모 데이터 처리 시에만 느낄 수 있다.
Python의 딕셔너리 탐색은 해시 테이블을 기반으로 하며, 평균 시간 복잡도는 O(1)이므로 성능 차이는 거의 없다.
딕셔너리 방식 (items['메로나']['price']):
약간 느리지만, 가독성, 확장성, 안전성 면에서 훨씬 뛰어나다.
결론
단순한 데이터 구조가 필요하고, 성능이 매우 중요한 경우:

리스트 방식 ('메로나': [300, 20]) 사용.
명확성과 확장성이 더 중요한 경우:

딕셔너리 방식 ('메로나': {'price': 300}) 사용

```

[튜플 자료구조 참고]([https://github.com/davJ-star/siat/edit/main/contents.md#%EB%94%95%EC%85%94%EB%84%88%EB%A6%AC](https://github.com/davJ-star/siat/edit/main/contents.md#%ED%8A%9C%ED%94%8C)
```paintext
  [요약]
    
```


### tip
    1. 
    2.


[세트 자료구조]("")
```paintext
  [요약]
    casting을 해서 슬라이싱이랑 인덱싱을 진행해야한다. 그렇지 않으면 사용할 수 없다.
```


### tip
    1. 
    2.


# contents-1.17 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=na4SGZlAeJco)

```paintext
  [요약]
    
```

### tip
    1. 타입에 대해 항상 고민해야된다. -> 그렇기 때문에 특히 백엔드에서는 ERD를 쓰면서 데이터 타입을 작성하는 것이다.
    2. **규칙이 없어져서 직접 담아야함(규칙없을때는 일단 리스트에 다 넣는걸 이상하게 생각 x)**
    3. 2월만 변경된다. 그냥 해당 조건일때만, +1하면될 것이다. 이런 생각을 할 수 있어야함.(**규칙과 차이가 거의 없을때 하나만 쓰고 다른 부분만 변경하는게 효율적**)
    4.  A를 안써도 되는이유가 중첩이 되면 and 대신 중첩으로 풀어쓴거기 때문에 이둘을 나눠서 처리해야되는 경우에만.. 일단 전반적 로직 파악하기!
    5. 삼항연산자가 단일 조건일때 성능이 더 좋다. 적극 사용하기를 추천한다.

## standard in out

### standard in: input()


### standard out: print()

## Boolean
semi-boolean으로 파이썬은 '', [], {}, 0, None은 False가 된다. (java는 없다.)
is~로 작성하면 논리값을 넣었구나 암묵적으로 알 수 있다. "코딩 컨벤션"

## if

### 중첩 if
```python
# 등급이 A이고 평균이 95점이상
grade = 'A'
avg = 91

if grade == 'A':
  if avg >= 95:
    print("장학금 지급 대상입니다.")
  else:
    print("장학금 지급 대상이 아닙니다.")

if grade == 'A' and avg >= 95:
  print("장학금 지급 대상입니다.")
else: # A를 안써도 되는이유가 중첩이 되면 and 대신 중첩으로 풀어쓴거기 때문에 이둘을 나눠서 처리해야되는 경우에만..
  print("장학금 지급 대상이 아닙니다.")

```

```python
# 등급이 A이고 평균이 95점이상
grade = 'A'
avg = 91

 # A를 안써도 되는이유가 중첩이 되면 and 대신 중첩으로 풀어쓴거기 때문에 이둘을 나눠서 처리해야되는 경우에만.. 일단 전반적 로직 파악하는게 중요.
if grade == 'A' and avg >= 95:
  print("장학금 지급 대상입니다.")
else:
  print("장학금 지급 대상이 아닙니다.")

```
### 삼항 연산자.
데이터가 분석할 때, 중첩해서 많이 사용한다.


# contents-1.20 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=FLyKLQtcCOwN)
(저장을 안해서... 앞으로 커밋 잘하자..)

# contents-1.21 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=rauHcBK8MqEC)

## 이중 루프 구문
### *tip*
1. 행과 열 둘다 증가해야되니 두개를 컨트롤해야한다. 이때 사용 => 2차원 리스트(대략 배열)로 만들 수 있는 것
```paintext

```

### 이중 루프에서 break과 continue
**접근하고 수정하는 것!**: *idx를 잘 관리할 수 있도록 해야함.*
**접근하는 것!**: *for in을 잘 활용해야함.*

return은 함수

```paintext

```
#### while
##### 조건식, 변수에 대한 초기화가 필요, 조건에 대한 변화

#### 해당 리스트의 인덱스 기준 범위를 len으로 , 범위(숫자)를 range로 처리할 수 있다.(2차원일때는 가장 )
행렬 각 count는 ㅗ가 맞음: 그렇기 때문에 코드 구현상으로 count가 맞음! ==> 특정 행 통째로 가져오는건 반대로 접근해야한다.

코테에서 상하좌우는 count 기준이다. 상은 행을 -1 하는 행을 +1 좌는 열을 -1 우는 +1

#### while 조건에 있어서 list 빈값을 이용한 경우도 가능

```python
# 조건문 체크

lst = ["foo", "bar", "baz"]

while len(lst): # lst도 가능하다.
  print("{} 출력".format(lst.pop()))
```

```python
# 조건문 체크

lst = ["foo", "bar", "baz"]

while lst: # lst도 가능하다.
  print("{} 출력".format(lst.pop()))
```



```python
idx = 0
while len(tmpList) != idx: # 조건문은 true여야함. len(tmpList) > cnt 도 가능하다.
  # 탈출 여부 #if - break는 True가 아니기도하고, 모두 실행해야되기 때문에 미포함.
  print("{}번째 요소는 {}이다.".format(idx, tmpList[idx]))
  # 조건변화(가 마지막에 있다면 그 앞에 내용은 조건문에 걸리지 않고 들어올 수 있다는 것.) #cnt+=1
  # 마지막에 변화를 주면서 변화 중 값에 대해 미리 조건 체크하고 들어온다는 것. 그렇기 때문에 초기값이 필수. 처음에는 당여히 초기값 조건 체크하고 들어오는 것임.
  
  idx+=1
```


# contents-1.22 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=uy9GxtMJuQ6Q)
## 함수
행위를 정의하는 영역

### *tip*
1. 타입(str등) 강제성이 없다. 힌트만 제공
```python

def greetingMsg(message:str):
  print(message)

greetingMsg(msg)
```
## lambda
```python

```

## map()
```python

```

## filter()
```python

```

## reduce()
```python

```

# contents-1.23 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=_8niTh1QebYJ)

## class: 웹애플리케이션을 제작하려면 파이썬에서도 알아야한다.


## 예외처리
모든 예외를 알고 처리할 수 없다.
예외 처리하는 방법을 알자!



# contents-1.24 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=SDPUhxhzoMHT)


## class:  객체지향(oop)
object
명사적 의미: 변수
동사적 의미: 메소드

class는 단순히 템플릿이며, 변수랑 메소드를 보유하고 있지 않다.(인스턴스의 소유.)
클래스를 만들때 그냥 문서 작성 가이드를 만든다는 관점으로 접근









































