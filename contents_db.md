
# contents-3.20 [실습 내용](https://colab.research.google.com/drive/1Wsa1Je5o_7jNb5LRsE9a7c0ND8Qb__d4#scrollTo=vjw0IKz1so4D)
### *tip* 
- ERD를 작은 플젝에서는 작성하긴하지만,큰 프로젝트 경우 VO를 보고 판단할 수 있다.
- 
 
### 수업 진행 사항
1. ERD와 관계형 데이터베이스
2. <테이블>
   a. 행과 열
   b. 관계
   c. 기본키
   d. 타입
4. ㅇ
5. ㅇ


1. ERD와 관계형 데이터베이스
```paintext
기획 -> 개념설계(entity랑 erd) -> 물리적 설계 -> ?

entity와 Atrribute(Identifier), relationship(포함된다. 속한다.)


1:N 1:1 (N:N)
->--|- relationship(포함된다. 속한다.)
-|--|-

설계하는 단계에서는 N:N이 있을수도 있다.
->--<-
```

2. <테이블>

a. <행과 열>
```paintext
 DB를 다루는 우리 입장에서는 행기준으로 다룬다.(데이터분석에는 컬럼기준으로 다룬다.)
 
 자바에서 dto로 가져왔을때 테이블의 행이된다.(인스턴스)
```
b. <관계>
```paintext
 부모 자식관계
  b가 부모이고, a가 자식이다.
  a가 소속 b에"되어진다."
  
  a는 외래키로 사용되며, b 값 도는 null을 가진다.
```

c. <기본키>
```paintext
1개 컬럼이며, 식별하는게 자신 컬럼이나 소속된 컬럼들



 DML: 데이터 조작
 	- 
 	- 
 	- 
 	- 
 DDL: 데이터 정의
```

d. <타입>
```paintext
 number
 character  (varchar)
 (date)
```

4. d



<행과 열>
DB를 다루는 우리 입장에서는 행기준으로 다룬다.(데이터분석에는 컬럼기준으로 다룬다.)

자바에서 dto로 가져왔을때 테이블의 행이된다.(인스턴스)

<관계>
부모 자식관계
b가 부모이고, a가 자식이다.
a가 소속 b에"되어진다."

a는 외래키로 사용되며, b 값 도는 null을 가진다.



<기본키>
1개 컬럼이며, 식별하는게 자신 컬럼이나 소속된 컬럼들



DML: 데이터 조작
	- 
	- 
	- 
	- 
DDL: 데이터 정의

<타입>
number
character  (varchar)
(date)

information engineering 방식

조건이 NULL일때는 IS NOT NULL이나 IS NULL을 사용한다.

---------------------------------------------------------------
데이터가 어떻게 들어가있는지 봐야한다.

-------------
2번 체크: 연결연산자 || 



# contents-3.24 [실습 내용]()
### *tip* 
- 
- 
### 수업 진행 사항
1. D
2. D


