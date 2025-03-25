
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
=> 논리적제한이 필요할때도 함수를 쓴다.
--> 반면에 행의 제한을 둘때는 WHERE사용

### *tip* 
- 단일 행 함수(i: N, o: N) VS 그룹함수: 집계함수를 잘 파악할 수 있어야한다.
- 에러메세지 체크: https://docs.oracle.com/en/error-help/db/ora-00937/?r=23ai

ㅍㅍㅍ  

## 주의사항
- 변환타입중 TO_DATE()함수를 쓸때 숫자를 날짜타입으로 바끌려면, 해당 숫자는 정수값이어야한다.
- 



### 수업 진행 사항
1. D
2. D


단일 행 함수(i: N, o: N) VS 그룹함수: 집계함수

단일 행 함수(i: N, o: N): 
타입: [문자, 숫자, 날짜]
- 문자 
-- SUBSTR(): 지정한 위치에서 지정한 개수만큼의 문자열 반환 (1부터 시작하는데 0으로 하면 자동으로 1로 카운트)

- 숫자
-- ROUND, TRUNC

- 날짜
-- SYSDATE


+ (타입변환)
-- 
- TO_NUMBER()
- TO_CHAR()
- TO_DATE()

-->타입 일치
--> 포맷팅해서 보기 좋게 바꾼다.


-- 숫자를 날짜타입으로 바끌려면, 해당 숫자는 정수값이어야한다.
SELECT MONTHS_BETWEEN('25/01/01', TO_DATE(250324)) 
FROM DUAL ;


``` 참고
SELECT *
FROM EMPLOYEE
WHERE DEPT_ID = 90; -- 묵시적 타입변환이 되었다 TO_CHAR()가 되었다.CHAR가 더 높다.

```

```참고
SELECT 	EMP_NO  ,
		SUBSTR(EMP_NO, 1, 6),
		SUBSTR(EMP_NO, 8, 7),
		SUBSTR(EMP_NO, 1, 6) + SUBSTR(EMP_NO, 8, 7) -- 여기서는 문자열과 문자열을 더하는 건 묵시적으로 오류가 난다.(TO_NUMBER()로 바꿔준다. 문자열 정수인 경우에만 가능)
FROM EMPLOYEE ;

```



예시 - 문법)

/*
-- FORMAT 해당 날짜 포맷으로 변경이 가능하다.
-- YYYY /  YY // YEAR
-- MONTH / MON / MM / RM
-- DY / DAY
-- HH MI SS
-- AM | PM
*/

SELECT 	SYSDATE ,
		TO_CHAR(SYSDATE, 'YEAR'),
		TO_CHAR(SYSDATE, 'MM'),
		TO_CHAR(SYSDATE, 'DAY'),
		TO_CHAR(SYSDATE, 'Q'),
		TO_CHAR(SYSDATE, 'AM HH')
FROM DUAL;


예시 - 활용)

SELECT 	EMP_NAME ,
		TO_CHAR(HIRE_DATE, 'YY "년" MM "월" DD "일"') 
FROM EMPLOYEE ;

```참고
만약 한번에 출력하지 않고 구분해서 할려면 SUBSTR()을 이용할 수 있다.
SELECT 	EMP_NAME ,
		HIRE_DATE,
		SUBSTR(HIRE_DATE, 1, 2)  || '년' ||
		SUBSTR(HIRE_DATE, 4, 2)  || '월' ||
		SUBSTR(HIRE_DATE, 7, 2)  || '일' 
FROM EMPLOYEE ;
```





그룹함수: 집계함수
-- AVG

더미 테이블: DUAL





기타함수

-- IF ~ ELSE 논리를 제한적으로 구현하는 오라클 함수

--- CASE EXPR, [SEARCH, RESULT] ELSE DEFAULT END
--- CASE [WHEN CONDITION THEN RESULT] ELSE DEFAULT END;
--- DECODE(EXPR, [SEARCH, RESULT], DEFAULT)


# contents-3.25 [실습 내용]()
-> 집계함수를 쓰면 일반 컬럼을 쓸수없다.(GROUP BY에 사용된 컬럼 제외)
집계함수는 N개를 1개로 출력된다. 
-- GROUP BY에 사용된 컬럼명은 SELECT절에서 그룹함수를 쓰지 않고 사용할 수 있다. 
한개의 그룹함수에서만 적용가능..

### *tip* 
- GROUP BY에서 함수를 넣어서 그룹핑 VS HAVING이랑 체크! **전후관계이다.**
- 

## 주의사항
- 변환타입중 TO_DATE()함수를 쓸때 숫자를 날짜타입으로 바끌려면, 해당 숫자는 정수값이어야한다.
- 



### 수업 진행 사항
1.  GROUP BY
2.  HAVING
3.  JOIN



-|O----O|<







------------------------



GROUP BY에서 함수를 넣어서 그룹핑 VS HAVING이랑 체크!
전후관계이다.

+ GROUP BY -> HAVING



JOIN
서로 연관되는 다른 테이블에 있는 컬럼까지 한번에 조회하기 위한 대표적 방법

EQUAL JOIN은 앞에 INNER 생략가능 -> 외래키에 대한 비교 조건은 필요하다.
ON -> Optional을 쓸수 없을때 null이 아니므로 
USING -> =이랑 같다.
TABLE명 ALIAS USING(컬럼명)
USING에서 사용한것이 즉 FROM에서 사용한것이기 때문에 활용가능하다.


FROM EMPLOYEE e이 FROM EMPLOYEE e, DEPARTMENT d과 동일한 의미를 가진다.
```
FROM EMPLOYEE e
JOIN DEPARTMENT d USING(DEPT_ID)
JOIN JOB j USING(JOB_ID)
JOIN LOCATION l  ON(l.LOCATION_ID = d.LOC_ID)
```

Outer
-> LEFT JOIN
-> RIGHT JOIN
-> FULL JOIN

Inner


** 키가 없어도 ON을 사용할 수 있다.(equals가 아니어도 된다.)**

self () relationship









