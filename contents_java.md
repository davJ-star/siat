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



# contents-2.27 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)


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





