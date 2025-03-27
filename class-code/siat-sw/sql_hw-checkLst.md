# 오답 노트

```sql	
/**
13. 학과 별 휴학생 수를 파악하고자 핚다. 학과 번호와 휴학생 수를 표시하는 SQL 문장을
작성하시오.


 */


-- 내부적으로 표현식을 사용할 수 있다.
-- COUNT(표현식)
-- SUM(표현식을 사용해야한다.)

SUM(CASE ABSENCE_YN WHEN 'Y' THEN 1 WHEN 'N' THEN 0 END)

SELECT 	DEPARTMENT_NO AS "학과 번호" ,
		COUNT(ABSENCE_YN) AS "휴학생 수"
FROM TB_STUDENT ts 
WHERE ABSENCE_YN = 'Y'
GROUP BY DEPARTMENT_NO
```

-------------------------------------------------

```sql	
/**
14. 춘 대학교에 다니는 동명이인(同名異人) 학생들의 이름을 찾고자 핚다. 어떤 SQL 
문장을 사용하면 가능하겠는가?

 */

SELECT STUDENT_NAME, COUNT(STUDENT_NAME)
FROM TB_STUDENT ts 
GROUP BY STUDENT_NAME 
HAVING COUNT(STUDENT_NAME) > 1 ;

```

-------------------------------------------------


```sql	
/**
 *15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과
이름, 평점을 출력하는 SQL 문을 작성하시오.

 */

/*
	
/*
 * STUDENT_NO로 연결한다.
 휴학생이 아닌 학생을 고른다.TB_STUDNENT
 평점이 4.0이상인 학생을 고른다. - TB_GRAGE
 */
SELECT STUDENT_NO , AVG(POINT) 
FROM TB_GRADE tg
GROUP BY STUDENT_NO
HAVING AVG(POINT) > 4.0


SELECT *
FROM TB_STUDENT ts 
WHERE ABSENCE_YN = 'N'

-- 한번에 합쳐서 체크하는 건 이렇게 여러개가 나올 수 없다. 나중에 합치는건 괜찮을지도
-- SUB QUERY


SELECT 
FROM TB_STUDENT ts 
JOIN TB_GRADE tg USING(STUDENT_NO)
WHERE 	ts.ABSENCE_YN = 'N'


SELECT AVG(POINT), STUDENT_NO  
			FROM TB_GRADE tg 
			GROUP BY STUDENT_NO
			HAVING AVG(POINT) > 4.0


--		AND 
--		ts.STUDENT_NO IN (
--			
--		)


SELECT *
FROM TB_STUDENT ts 
JOIN TB_GRADE tg USING(STUDENT_NO)
WHERE ABSENCE_YN = 'N'

*/
      
SELECT STUDENT_NO , STUDENT_NAME , DEPARTMENT_NAME, AVG(POINT) 
FROM TB_STUDENT ts 
JOIN TB_DEPARTMENT td USING(DEPARTMENT_NO)
JOIN TB_GRADE tg USING(STUDENT_NO)
WHERE ABSENCE_YN = 'N'
GROUP BY STUDENT_NO , STUDENT_NAME , DEPARTMENT_NAME
HAVING AVG(POINT) >= 4.0; 
```
-------------------------------------------------

```sql	
/**
 * 19. 춘 기술대학교의 "홖경조경학과"가 속핚 같은 계열 학과들의 학과 별 젂공과목 평점을
파악하기 위핚 적젃핚 SQL 문을 찾아내시오. 단, 출력헤더는 "계열 학과명", 
"젂공평점"으로 표시되도록 하고, 평점은 소수점 핚 자리까지맊 반올림하여 표시되도록
핚다.

 */

SELECT *
FROM TB_DEPARTMENT td
JOIN TB_CLASS tc USING(DEPARTMENT_NO)
JOIN TB_GRADE tg USING(CLASS_NO);
WHERE ;


SELECT *
FROM TB_DEPARTMENT td 
WHERE DEPARTMENT_NAME  = '환경조경학과'	

```

