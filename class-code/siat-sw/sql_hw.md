-- 학과 TB_DEPARTMENT
-- 학생 TB_STUDENT
-- 과목 TB_CLASS
-- 과목 교수 TB_CLASS_PROFESSOR
-- 교수 TB_PROFESSOR
-- 성적 TB_GRADE


/*
 1. 춘 기술대학교의 학과 이름과 계열을 표시하시오. 단, 출력 헤더는 "학과 명", "계열"
으로 표시하도록 핚다.
 
 학과 TB_DEPARTMENT
 */

--SELECT *
--FROM TB_DEPARTMENT;

SELECT DEPARTMENT_NAME AS "학과 명" , CATEGORY AS "계열"
FROM TB_DEPARTMENT;


/*
 2. 학과의 학과 정원을 다음과 같은 형태로 화면에 출력핚다.
 => || 연결 연산자를 이용한다.

 학과 TB_DEPARTMENT
 */

SELECT *
FROM TB_DEPARTMENT;

SELECT (DEPARTMENT_NAME  || '의 ' || CAPACITY  || '명 입니다.') AS "학과 정원"
FROM TB_DEPARTMENT;
/*
 3. "국어국문학과" 에 다니는 여학생 중 현재 휴학중인 여학생을 찾아달라는 요청이
들어왔다. 누구인가? (국문학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서
찾아 내도록 하자)

 학생 TB_STUDENT	
 학과 TB_DEPARTMENT
 */

SELECT *
FROM TB_STUDENT;

SELECT 	STUDENT_NAME
FROM 	TB_STUDENT
WHERE 	DEPARTMENT_NO
		= (
			SELECT DEPARTMENT_NO 
			FROM TB_DEPARTMENT 
			WHERE DEPARTMENT_NAME = '국어국문학과'
		)
		AND ABSENCE_YN = 'Y'
		AND STUDENT_SSN LIKE '______-2______'; -- ()는 학과테이블에서 가져와야함
		
		
/*
	4. 도서관에서 대출 도서 장기 연체자 들을 찾아 이름을 게시하고자 핚다. 그 대상자들의
	학번이 다음과 같을 때 대상자들을 찾는 적젃핚 SQL 구문을 작성하시오.
	A513079, A513090, A513091, A513110, A513119

 */



SELECT STUDENT_NAME 
FROM TB_STUDENT 
WHERE STUDENT_NO IN ('A513079', 'A513090', 'A513091', 'A513110', 'A513119');
/*
 5. 입학정원이 20 명 이상 30 명 이하인 학과들의 학과 이름과 계열을 출력하시오.
 학과 TB_DEPARTMENT
 
 */



SELECT *
FROM TB_DEPARTMENT;

SELECT DEPARTMENT_NAME , CATEGORY  
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;
/*
 6. 춘 기술대학교는 총장을 제외하고 모든 교수들이 소속 학과를 가지고 있다. 그럼 춘
기술대학교 총장의 이름을 알아낼 수 있는 SQL 문장을 작성하시오.

 교수 TB_PROFESSOR
 */

SELECT PROFESSOR_NAME 
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;


/*
 7. 혹시 젂산상의 착오로 학과가 지정되어 있지 않은 학생이 있는지 확인하고자 핚다.
어떠핚 SQL 문장을 사용하면 될 것인지 작성하시오.

 
 학생 TB_STUDENT	
 */

SELECT *
FROM TB_STUDENT
WHERE DEPARTMENT_NO IS NULL;


SELECT DEPARTMENT_NAME AS "학과 명" , CATEGORY AS "계열"
FROM TB_DEPARTMENT;

/*
8. 수강신청을 하려고 핚다. 선수과목 여부를 확인해야 하는데, 선수과목이 존재하는
과목들은 어떤 과목인지 과목번호를 조회해보시오.

 
 학과 TB_DEPARTMENT
 */

SELECT *
FROM TB_CLASS;

SELECT CLASS_NO  
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;

/*
9. 춘 대학에는 어떤 계열(CATEGORY)들이 있는지 조회해보시오.

 학과 TB_DEPARTMENT
 */

SELECT *
FROM TB_DEPARTMENT;

SELECT DISTINCT CATEGORY  
FROM TB_DEPARTMENT;


/*
10. 02 학번 전주 거주자들의 모임을 맊들려고 핚다. 휴학한 사람들은 제외한 재학중인
학생들의 학번, 이름, 주민번호를 출력하는 구문을 작성하시오.


 
학생 TB_STUDENT

 */

SELECT *
FROM TB_STUDENT;

SELECT STUDENT_NO , STUDENT_NAME , STUDENT_SSN 
FROM 	TB_STUDENT
WHERE 	ABSENCE_YN = 'N'
		AND STUDENT_ADDRESS LIKE '전주%'
		AND STUDENT_NO LIKE 'A2%';

	
	
	


-- "1~11까지 풀어보기"
/*
 * 학과 TB_DEPARTMENT  
 * 학생 TB_STUDENT
 * 과목 TB_CLASS
 * 과목 교수 TB_CLASS_PROFESSOR
 * 교수 TB_PROFESSOR
 * 성적 TB_GRADE

 */




/**
 1. 영어영문학과(학과코드 002) 학생들의 학번과 이름, 입학 년도를 입학 년도가 빠른
순으로 표시하는 SQL 문장을 작성하시오.( 단, 헤더는 "학번", "이름", "입학년도" 가
표시되도록 핚다.)
 */

--SELECT *
--FROM TB_DEPARTMENT ;

SELECT STUDENT_NO , STUDENT_NAME , ENTRANCE_DATE 
FROM TB_STUDENT 
WHERE DEPARTMENT_NO = '002'
ORDER BY ENTRANCE_DATE ;

/**
 3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오. 
 
 단
이때 나이가 적은 사람에서 맋은 사람 순서로 화면에 출력되도록 맊드시오. (단, 교수 중
2000 년 이후 출생자는 없으며 출력 헤더는 "교수이름", "나이"로 핚다. 나이는 ‘맊’으로
계산핚다.)

 */

-- 교수 나이가 없나? -> 없다 교수 주민번호 토대로 진행!그냥 ORDER BY로 진행하면 될 것 같다.

-- 음수가 나오는 경우 DECODE로 처리하면 되지 않을까 생각하는데..?
--SELECT 	PROFESSOR_NAME ,
--		CASE ROUND(MONTHS_BETWEEN(SYSDATE , SUBSTR(PROFESSOR_SSN, 1,6)) / 12) 
--			WHEN ROUND(MONTHS_BETWEEN(SYSDATE , SUBSTR(PROFESSOR_SSN, 1,6)) / 12) < 0 THEN 100 + ROUND(MONTHS_BETWEEN(SYSDATE , SUBSTR(PROFESSOR_SSN, 1,6)) / 12) 
--		ELSE ROUND(MONTHS_BETWEEN(SYSDATE , SUBSTR(PROFESSOR_SSN, 1,6)) / 12) 
--		END AS "나이"
--FROM TB_PROFESSOR 
--ORDER BY PROFESSOR_SSN DESC;

SELECT 	PROFESSOR_NAME ,
		PROFESSOR_SSN,
		ROUND(MONTHS_BETWEEN(SYSDATE , SUBSTR(PROFESSOR_SSN, 1,6)) / 12) AS "나이",
		125 - SUBSTR(PROFESSOR_SSN, 1,2)
		-- 
FROM TB_PROFESSOR 
ORDER BY PROFESSOR_SSN DESC;





/**
4. 교수들의 이름 중 성을 제외핚 이름맊 출력하는 SQL 문장을 작성하시오. 출력 헤더는
‚이름‛ 이 찍히도록 핚다. (성이 2 자인 경우는 교수는 없다고 가정하시오)

SUBSTR( , 2,2)
 */
SELECT SUBSTR(PROFESSOR_NAME, 2, 2) AS "이름"
FROM TB_PROFESSOR ;


/**
 5. 춘 기술대학교의 재수생 입학자를 구하려고 핚다. 어떻게 찾아낼 것인가? 이때, 
19 살에 입학하면 재수를 하지 않은 것으로 갂주핚다.

학번과 나이 체크 - 차이가 19여야한다.

 */

SELECT STUDENT_NAME 
FROM TB_STUDENT 
WHERE ROUND(SUBSTR(TO_CHAR(ENTRANCE_DATE)  , 1,2) - SUBSTR(STUDENT_SSN, 1,2)) > 19;
--
---- 날짜로 계산해서 빼는 방법
--SELECT MONTHS_BETWEEN(ENTRANCE_DATE  , SUBSTR(STUDENT_SSN , 1, 6)) / 12
--FROM TB_STUDENT ;
--
--SELECT MONTHS_BETWEEN(ENTRANCE_DATE  , SUBSTR(STUDENT_SSN , 1, 6)) / 12
--FROM TB_STUDENT ;


SELECT 	PROFESSOR_NAME AS "교수이름",
		TO_NUMBER(TO_CHAR()     ) 
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, 8,1) = '1' 
ORDER BY 2 ASC;

/**
 6. 2020 년 크리스마스는 무슨 요일인가?
 TO_CHAR(SYSDATE, 'DAY'),
 * TO_CHAR(SYSDATE, 'Q'),
 
 */

SELECT  TO_CHAR(TO_DATE('20-12-25'), 'DAY')
FROM DUAL;


--SELECT TO_CHAR('25/12/25', 'RM')
--FROM DUAL ;

/**
 7. TO_DATE('99/10/11','YY/MM/DD'), TO_DATE('49/10/11','YY/MM/DD') 은 각각 몇 년 몇
월 몇 일을 의미핛까? 또 TO_DATE('99/10/11','RR/MM/DD'), 
TO_DATE('49/10/11','RR/MM/DD') 은 각각 몇 년 몇 월 몇 일을 의미핛까?
 */
SELECT TO_DATE('99/10/11','YY/MM/DD')
FROM DUAL ;


SELECT 	TO_CHAR(TO_DATE('99/10/11'), 'YEAR'),
		TO_CHAR(TO_DATE('99/10/11'), 'MM'),
		TO_CHAR(TO_DATE('99/10/11'), 'DAY'),
		TO_CHAR(TO_DATE('99/10/11'), 'Q'),
		TO_CHAR(TO_DATE('99/10/11'), 'AM HH')
FROM DUAL;





SELECT TO_DATE('49/10/11','YY/MM/DD')
FROM DUAL ;

SELECT 	TO_CHAR(TO_DATE('99/10/11'), 'YY'),
		TO_CHAR(TO_DATE('99/10/11'), 'MM'),
		TO_CHAR(TO_DATE('99/10/11'), 'DD')
FROM DUAL;


SELECT TO_DATE('99/10/11','RR/MM/DD')
FROM DUAL ;

SELECT 	TO_CHAR(TO_DATE('99/10/11'), 'RR'),
		TO_CHAR(TO_DATE('99/10/11'), 'MM'),
		TO_CHAR(TO_DATE('99/10/11'), 'DD')
FROM DUAL;

SELECT TO_DATE('49/10/11','RR/MM/DD')
FROM DUAL ;

SELECT 	TO_CHAR(TO_DATE('99/10/11'), 'RR'),
		TO_CHAR(TO_DATE('99/10/11'), 'MM'),
		TO_CHAR(TO_DATE('99/10/11'), 'DD')
FROM DUAL;
/**
 8. 춘 기술대학교의 2000 년도 이후 입학자들은 학번이 A 로 시작하게 되어있다. 2000 년도
이전 학번을 받은 학생들의 학번과 이름을 보여주는 SQL 문장을 작성하시오.

 */
SELECT STUDENT_NO , STUDENT_NAME 
FROM TB_STUDENT
WHERE STUDENT_NO != 'A%'



/**
 9. 학번이 A517178 인 핚아름 학생의 학점 총 평점을 구하는 SQL 문을 작성하시오. 단,
이때 출력 화면의 헤더는 "평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 핚
자리까지맊 표시핚다.

 */
SELECT AVG(POINT) AS "평점"
FROM TB_GRADE 
WHERE STUDENT_NO = 'A517178';



/**
 10. 학과별 학생수를 구하여 "학과번호", "학생수(명)" 의 형태로 헤더를 맊들어 결과값이
출력되도록 하시오.

 */

--SELECT DEPARTMENT_NO AS "학과번호", CAPACITY AS "학생수(명)"
--FROM TB_DEPARTMENT ;

SELECT DEPARTMENT_NO , COUNT(DEPARTMENT_NO)  
FROM TB_STUDENT 
GROUP BY DEPARTMENT_NO ;


/**
 11. 지도 교수를 배정받지 못핚 학생의 수는 몇 명 정도 되는 알아내는 SQL 문을
작성하시오.

 */
SELECT COUNT(STUDENT_NAME) 
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;




/**
12. 학번이 A112113 인 김고운 학생의 년도 별 평점을 구하는 SQL 문을 작성하시오. 단, 
이때 출력 화면의 헤더는 "년도", "년도 별 평점" 이라고 찍히게 하고, 점수는 반올림하여
소수점 이하 핚 자리까지맊 표시핚다.

 */

SELECT CASE SUBSTR(TERM_NO, 3,2) 
				WHEN '01' THEN '2001년'
				WHEN '02' THEN '2002년'
				WHEN '03' THEN '2003년'
				WHEN '04' THEN '2004년'
			END AS "년도",
			(AVG(POINT)) AS "년도별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY 	CASE SUBSTR(TERM_NO, 3,2) 
				WHEN '01' THEN '2001년'
				WHEN '02' THEN '2002년'
				WHEN '03' THEN '2003년'
				WHEN '04' THEN '2004년'
			END

--ORDER BY ;

/**
13. 학과 별 휴학생 수를 파악하고자 핚다. 학과 번호와 휴학생 수를 표시하는 SQL 문장을
작성하시오.


 */
			
SELECT *
FROM TB_STUDENT ts 
			
--SELECT 	DEPARTMENT_NO AS "학과 번호" ,
--		COUNT(ABSENCE_YN) AS "휴학생 수",
--		COUNT(*) 
--FROM TB_STUDENT ts 
--GROUP BY DEPARTMENT_NO;

--SELECT 	DEPARTMENT_NO AS "학과 번호" ,
--		COUNT(ABSENCE_YN) AS "휴학생 수",
--		COUNT(*) 
--FROM TB_STUDENT ts 
--GROUP BY DEPARTMENT_NO
--HAVING ABSENCE_YN = 'Y' ; -- 만들기전에 GROUP을 체크해줘야게ㅆ


-- 내부적으로 표현식을 사용할 수 있다.
-- COUNT(표현식)
-- SUM(표현식을 사용해야한다.)

SUM(CASE ABSENCE_YN WHEN 'Y' THEN 1 WHEN 'N' THEN 0 END)

SELECT 	DEPARTMENT_NO AS "학과 번호" ,
		COUNT(ABSENCE_YN) AS "휴학생 수"
FROM TB_STUDENT ts 
WHERE ABSENCE_YN = 'Y'
GROUP BY DEPARTMENT_NO



-- ORDER BY DEPARTMENT_NO 

/**
14. 춘 대학교에 다니는 동명이인(同名異人) 학생들의 이름을 찾고자 핚다. 어떤 SQL 
문장을 사용하면 가능하겠는가?

 */

SELECT STUDENT_NAME, COUNT(STUDENT_NAME)
FROM TB_STUDENT ts 
GROUP BY STUDENT_NAME 
HAVING COUNT(STUDENT_NAME) > 1 ;




/**
15. 학번이 A112113 인 김고운 학생의 년도, 학기 별 평점과 년도 별 누적 평점 , 총
평점을 구하는 SQL 문을 작성하시오. (단, 평점은 소수점 1 자리까지맊 반올림하여
표시핚다.) 
 */

-- 
SELECT *
FROM TB_GRADE

SELECT CASE SUBSTR(TERM_NO, 3,2) 
				WHEN '01' THEN '2001년'
				WHEN '02' THEN '2002년'
				WHEN '03' THEN '2003년'
				WHEN '04' THEN '2004년'
			END AS "년도",
			(AVG(POINT)) AS "년도별 평점"
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY 	CASE SUBSTR(TERM_NO, 3,2) 
				WHEN '01' THEN '2001년'
				WHEN '02' THEN '2002년'
				WHEN '03' THEN '2003년'
				WHEN '04' THEN '2004년'
			END





-- GROUPBY
SELECT *
FROM TB_STUDENT ts ;

SELECT *
FROM TB_DEPARTMENT ;

SELECT *
FROM TB_PROFESSOR tp  ;

SELECT *
FROM TB_GRADE tg  ;

/**
1. 학생이름과 주소지를 표시하시오. 단, 출력 헤더는 "학생 이름", "주소지"로 하고,
정렬은 이름으로 오름차순 표시하도록 한다.
*/
SELECT STUDENT_NAME AS "학생 이름" , STUDENT_ADDRESS  AS "주소지"
FROM TB_STUDENT ts 
ORDER BY STUDENT_NAME ;

/**
2. 휴학중인 학생들의 이름과 주민번호를 나이가 적은 순서로 화면에 출력하시오.

 */
SELECT STUDENT_NAME AS "학생 이름" , STUDENT_SSN  AS "주민번호"
FROM TB_STUDENT ts 
WHERE ABSENCE_YN = 'Y'
ORDER BY STUDENT_SSN  DESC ;


			
/**
3. 주소지가 강원도나 경기도인 학생들 중 1900 년대 학번을 가진 학생들의 이름과 학번, 
주소를 이름의 오름차순으로 화면에 출력하시오. 단, 출력헤더에는 "학생이름","학번",
"거주지 주소" 가 출력되도록 핚다.

 */

SELECT 	STUDENT_NAME AS "학생이름",
		STUDENT_NO  AS "학번",
		STUDENT_ADDRESS AS "거주지 주소"
FROM TB_STUDENT ts 	-- 주소지: 
WHERE 	(
			STUDENT_ADDRESS LIKE '경기도%' 
		OR 
			STUDENT_ADDRESS LIKE '강원도%'
		) 
		AND 
		STUDENT_NO  NOT LIKE 'A%' -- 주소지에서 
/**
4. 현재 법학과 교수 중 가장 나이가 맋은 사람부터 이름을 확인핛 수 있는 SQL 문장을
작성하시오. (법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아
내도록 하자)
      
 */
		


SELECT PROFESSOR_NAME 
FROM TB_PROFESSOR tp  
WHERE DEPARTMENT_NO = (
		SELECT DEPARTMENT_NO
		FROM TB_DEPARTMENT 
		WHERE DEPARTMENT_NAME = '법학과'
)
ORDER BY PROFESSOR_SSN ;


/**
5. 2004 년 2 학기에 'C3118100' 과목을 수강핚 학생들의 학점을 조회하려고 핚다. 학점이
높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 구문을
작성해보시오.
 */
SELECT STUDENT_NO , POINT 
FROM TB_GRADE tg   -- TERM_NO LIKE '__0402' AND CLASS_NO = 'C3118100'
WHERE TERM_NO LIKE '__0402' AND CLASS_NO = 'C3118100'
ORDER BY POINT DESC , STUDENT_NO 

/**
6. 학생 번호, 학생 이름, 학과 이름을 학생 이름으로 오름차순 정렬하여 출력하는 SQL 
문을 작성하시오
 */
-- 4번과 달리 테이블을 활용해야한다.
-- DEPARTMENT_NO 기준으로!

SELECT *
FROM TB_STUDENT ts ;

SELECT *
FROM TB_DEPARTMENT td  


SELECT STUDENT_NO , STUDENT_NAME , td.DEPARTMENT_NAME  -- 학생 번호, 학생 이름, 학과 이름
FROM TB_STUDENT ts 
JOIN TB_DEPARTMENT td USING(DEPARTMENT_NO)
ORDER BY STUDENT_NAME ;

/**
7. 춘 기술대학교의 과목 이름과 과목의 학과 이름을 출력하는 SQL 문장을 작성하시오.

 */
-- 과목 이름과 과목의 학과 이름을 출력
-- 과목 이름?

SELECT *
FROM TB_CLASS tc

SELECT *
FROM TB_DEPARTMENT td 

-- class가 자식

SELECT tc.CLASS_NAME, td.DEPARTMENT_NAME  
FROM TB_CLASS tc
JOIN TB_DEPARTMENT td USING(DEPARTMENT_NO)

/**
8. 과목별 교수 이름을 찾으려고 핚다. 과목 이름과 교수 이름을 출력하는 SQL 문을
작성하시오.

 */

SELECT *
FROM TB_PROFESSOR tp 

SELECT *
FROM TB_CLASS tc

SELECT *
FROM TB_PROFESSOR tp 


   

SELECT tp.PROFESSOR_NAME AS "교수명", tc.CLASS_NAME AS "과목 이름"
FROM TB_PROFESSOR tp 
JOIN TB_CLASS tc USING(DEPARTMENT_NO)


/**
9. 8 번의 결과 중 ‘인문사회’ 계열에 속핚 과목의 교수 이름을 찾으려고 핚다. 이에
해당하는 과목 이름과 교수 이름을 출력하는 SQL 문을 작성하시오.

 */

SELECT tc.CLASS_NAME , tp.PROFESSOR_NAME 
FROM TB_PROFESSOR tp 
JOIN TB_CLASS tc USING(DEPARTMENT_NO)
JOIN TB_DEPARTMENT td USING(DEPARTMENT_NO)
WHERE td.CATEGORY = '인문사회'


/**
10. ‘음악학과’ 학생들의 평점을 구하려고 핚다. 음악학과 학생들의 "학번", "학생 이름", 
"젂체 평점"을 출력하는 SQL 문장을 작성하시오. (단, 평점은 소수점 1 자리까지맊
반올림하여 표시핚다.)

 */

SELECT AVG(AVG(POINT))
FROM TB_DEPARTMENT td 
JOIN TB_STUDENT ts USING(DEPARTMENT_NO)
JOIN TB_GRADE tg USING(STUDENT_NO)
WHERE td.DEPARTMENT_NAME = '음악학과'
GROUP BY STUDENT_NAME

-- 음악학과 DEP
-- 학생 평점 grade
-- 학번, 학생이름 - stu

-- CLASS_NO STUDENT_NO 

SELECT *
FROM TB_STUDENT ts ;

SELECT *
FROM TB_DEPARTMENT td  

SELECT *
FROM TB_GRADE tg 
	




/**
11. 학번이 A313047 인 학생이 학교에 나오고 있지 않다. 지도 교수에게 내용을 젂달하기
위핚 학과 이름, 학생 이름과 지도 교수 이름이 필요하다. 이때 사용핛 SQL 문을
작성하시오. 단, 출력헤더는 ‚학과이름‛, ‚학생이름‛, ‚지도교수이름‛으로
출력되도록 핚다.

 */

-- 학번이 A31047인 학생을 찾는다. TB_ST~에서 지도 교수번호를 찾아서 지도교수이름과 학과 이름을 출력한다. -> 학과 이름은 가지고 있지 않아서 TB_DEPARTMENT를 체크한다.
SELECT *
FROM TB_STUDENT ts ;

SELECT *
FROM TB_DEPARTMENT td 
		
SELECT *
FROM TB_STUDENT ts 
WHERE STUDENT_NO = 'A31047';    


/**
12. 2007 년도에 '인갂관계롞' 과목을 수강핚 학생을 찾아 학생이름과 수강학기름 표시하는
SQL 문장을 작성하시오.






 */

-- 인간관계록의 CLASS_NO 찾기 -> SUBQUERY
SELECT * -- CLASS_NO 
FROM TB_CLASS tc 
WHERE CLASS_NAME = '인간관계론'

-- 수강학기와 학생이름
-- STUDENT_NO로 TB_GRADE 와 TB_STUDENT

SELECT STUDENT_NAME , tg.TERM_NO 
FROM TB_STUDENT ts 
JOIN TB_GRADE tg USING(STUDENT_NO)
WHERE TERM_NO LIKE '2007%'
		AND
		CLASS_NO = 	(
						SELECT CLASS_NO 
						FROM TB_CLASS tc 
						WHERE CLASS_NAME = '인간관계론'

					)


SELECT *
FROM TB_GRADE tg 
WHERE  	TERM_NO LIKE '2007%'
		AND
		CLASS_NO = 	(
						SELECT CLASS_NO 
						FROM TB_CLASS tc 
						WHERE CLASS_NAME = '인간관계론'

					)
		
/**
13. 예체능 계열 과목 중 과목 담당교수를 핚 명도 배정받지 못핚 과목을 찾아 그 과목
이름과 학과 이름을 출력하는 SQL 문장을 작성하시오.


 */
					\
-- 예체능 계열 과목 중 과목 담당교수
-- 과목이름과 학과이름 => 
				-- 과목 담당교수를 핚 명도 박지 못함을 파악하기 위해서.. 일단 교수 테이블확인: 결과로는 DEPARTMENT_NO로 연결함.
-- 과목 교수에서 과목과 해당 학과를 파악할 수 있지 않을까?
SELECT *
FROM TB_PROFESSOR tp 				
					
SELECT *
FROM TB_CLASS tc 
					
SELECT *
FROM TB_DEPARTMENT td 

SELECT *
FROM TB_CLASS tc 
FULL JOIN TB_DEPARTMENT td USING(DEPARTMENT_NO)
FULL JOIN TB_PROFESSOR tp  USING(DEPARTMENT_NO)
WHERE td.CATEGORY = '예체능' AND td.OPEN_YN = 'N' AND tp.PROFESSOR_NAME IS NULL


/**
14.        학생들의 지도교수를 게시하고자 핚다. 학생이름과
지도교수 이름을 찾고 맊일 지도 교수가 없는 학생일 경우 "지도교수 미지정‛으로
표시하도록 하는 SQL 문을 작성하시오. 단, 출력헤더는 ‚학생이름‛, ‚지도교수‛로
표시하며 고학번 학생이 먼저 표시되도록 핚다.


 */
SELECT STUDENT_NAME AS "학생 이름", NVL(tp.PROFESSOR_NAME, '지도교수 미지정')  AS "지도교수"
FROM TB_STUDENT ts 
FULL JOIN TB_PROFESSOR tp ON(ts.COACH_PROFESSOR_NO = tp.PROFESSOR_NO)


SELECT *
FROM TB_PROFESSOR tp 






/**
 *15. 휴학생이 아닌 학생 중 평점이 4.0 이상인 학생을 찾아 그 학생의 학번, 이름, 학과
이름, 평점을 출력하는 SQL 문을 작성하시오.

 */
          


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



SELECT STUDENT_NO , STUDENT_NAME , DEPARTMENT_NAME, AVG(POINT) 
FROM TB_STUDENT ts 
JOIN TB_DEPARTMENT td USING(DEPARTMENT_NO)
JOIN TB_GRADE tg USING(STUDENT_NO)
WHERE ABSENCE_YN = 'N'
GROUP BY STUDENT_NO , STUDENT_NAME , DEPARTMENT_NAME
HAVING AVG(POINT) >= 4.0; 




/**
 * 16. 홖경조경학과 젂공과목들의 과목 별 평점을 파악핛 수 있는 SQL 문을 작성하시오.


 */

-- 환경 조경학과의 번호를 파악한다.


SELECT * -- 034
FROM TB_DEPARTMENT td 
WHERE DEPARTMENT_NAME = '환경조경학과'


SELECT CLASS_NO, CLASS_NAME  -- 전공과목들 체크
FROM TB_CLASS tc 
WHERE 	tc.DEPARTMENT_NO = (
			SELECT DEPARTMENT_NO  -- 034
			FROM TB_DEPARTMENT td 
			WHERE DEPARTMENT_NAME = '환경조경학과'
		)
		AND 
		tc.CLASS_TYPE = '전공선택'

SELECT *
FROM TB_GRADE tg 


SELECT CLASS_NO, CLASS_NAME  -- 전공과목들 체크
FROM TB_CLASS tc 
WHERE 	tc.DEPARTMENT_NO = (
			SELECT DEPARTMENT_NO  -- 034
			FROM TB_DEPARTMENT td 
			WHERE DEPARTMENT_NAME = '환경조경학과'
		)
		AND 
		tc.CLASS_TYPE = '전공선택'


SELECT tg.CLASS_NO , AVG(tg.POINT), tc.CLASS_NAME
FROM TB_GRADE tg , TB_CLASS tc
FULL JOIN TB_CLASS tc ON(tg.CLASS_NO  = tc.CLASS_NO)
GROUP BY  tg.CLASS_NO  
HAVING  tg.CLASS_NO  IN (
						SELECT CLASS_NO  -- 전공과목들 체크
						FROM TB_CLASS tc 
						WHERE 	tc.DEPARTMENT_NO = (
									SELECT DEPARTMENT_NO  -- 034
									FROM TB_DEPARTMENT td 
									WHERE DEPARTMENT_NAME = '환경조경학과'
								)
								AND 
								tc.CLASS_TYPE = '전공선택'
					);





/**
 * 17. 춘 기술대학교에 다니고 있는 최경희 학생과 같은 과 학생들의 이름과 주소를 출력하는
SQL 문을 작성하시오.


 */
				
-- 학과 코드
SELECT DEPARTMENT_NO 
FROM TB_STUDENT ts 
WHERE STUDENT_NAME = '최경희'

SELECT STUDENT_NAME , STUDENT_ADDRESS 
FROM TB_STUDENT ts
WHERE DEPARTMENT_NO = 	(
							SELECT DEPARTMENT_NO 
							FROM TB_STUDENT ts 
							WHERE STUDENT_NAME = '최경희'
						)


/**
 * 18. 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번을 표시하는 SQL 문을
작성하시오.


 */
SELECT DEPARTMENT_NO 
FROM TB_DEPARTMENT td 
WHERE DEPARTMENT_NAME = '국어국문학과'
						
					
SELECT ts.STUDENT_NAME, AVG(tg.POINT) 
FROM TB_STUDENT ts 
JOIN TB_GRADE tg ON(ts.STUDENT_NO = tg.STUDENT_NO)
WHERE 	DEPARTMENT_NO = 	(
							SELECT DEPARTMENT_NO 
							FROM TB_DEPARTMENT td 
							WHERE DEPARTMENT_NAME = '국어국문학과'
						)
GROUP BY ts.STUDENT_NAME 
HAVING AVG(tg.POINT) =	(
							SELECT MAX(AVG(tg.POINT) )   
							FROM TB_STUDENT ts 
							JOIN TB_GRADE tg ON(ts.STUDENT_NO = tg.STUDENT_NO)
							WHERE 	DEPARTMENT_NO = 	(
														SELECT DEPARTMENT_NO 
														FROM TB_DEPARTMENT td 
														WHERE DEPARTMENT_NAME = '국어국문학과'
													)
							GROUP BY ts.STUDENT_NAME 
						)
	

-- 학생 평점
						
SELECT AVG(POINT) 
FROM TB_GRADE tg 
GROUP BY STUDENT_NO 





SELECT COUNT(*)
FROM TB_STUDENT ts2 
JOIN TB_GRADE tg  USING(STUDENT_NO)
GROUP BY STUDENT_NO
HAVING STUDENT_NO IN	 (
							SELECT STUDENT_NO 
						FROM TB_STUDENT ts 
						WHERE DEPARTMENT_NO = 	(
													SELECT DEPARTMENT_NO 
													FROM TB_DEPARTMENT td 
													WHERE DEPARTMENT_NAME = '국어국문학과'
												)
					)
	

--JOIN하기

SELECT STUDENT_NO , AVG(POINT)
FROM TB_GRADE tg 
GROUP BY STUDENT_NO
HAVING STUDENT_NO IN	 (
							SELECT STUDENT_NO 
						FROM TB_STUDENT ts 
						WHERE DEPARTMENT_NO = 	(
													SELECT DEPARTMENT_NO 
													FROM TB_DEPARTMENT td 
													WHERE DEPARTMENT_NAME = '국어국문학과'
												)
					)
	
/**
 * 19. 춘 기술대학교의 "홖경조경학과"가 속핚 같은 계열 학과들의 학과 별 젂공과목 평점을
파악하기 위핚 적젃핚 SQL 문을 찾아내시오. 단, 출력헤더는 "계열 학과명", 
"젂공평점"으로 표시되도록 하고, 평점은 소수점 핚 자리까지맊 반올림하여 표시되도록
핚다.

 */

					-- 전공계열을 찾는다.
					
SELECT td2.DEPARTMENT_NAME, ROUND(AVG(tg.POINT), 1) 
FROM TB_GRADE tg 
JOIN TB_STUDENT ts ON(tg.STUDENT_NO = ts.STUDENT_NO)
JOIN TB_DEPARTMENT td2 ON(ts.DEPARTMENT_NO  = td2.DEPARTMENT_NO)
JOIN TB_CLASS tc ON(tg.CLASS_NO = tc.CLASS_NO)
WHERE ts.DEPARTMENT_NO IN 	(
								SELECT DEPARTMENT_NO 
								FROM TB_DEPARTMENT td 
								WHERE CATEGORY = 	(
														SELECT CATEGORY 
														FROM TB_DEPARTMENT td 
														WHERE DEPARTMENT_NAME = '환경조경학과'
													)
										AND 
										DEPARTMENT_NAME != '환경조경학과'
							)
		AND 
		tc.CLASS_TYPE = '전공선택'
GROUP BY td2.DEPARTMENT_NAME 
					
					
SELECT DEPARTMENT_NO 
FROM TB_DEPARTMENT td 
WHERE CATEGORY = 	(
						SELECT CATEGORY 
						FROM TB_DEPARTMENT td 
						WHERE DEPARTMENT_NAME = '환경조경학과'
					)
		AND 
		DEPARTMENT_NAME != '환경조경학과';


SELECT *
FROM TB_DEPARTMENT td
JOIN TB_CLASS tc USING(DEPARTMENT_NO)
JOIN TB_GRADE tg USING(CLASS_NO);
WHERE ;


SELECT *
FROM TB_DEPARTMENT td 
WHERE DEPARTMENT_NAME  = '환경조경학과'		
		

------------------------------------------




/**
 * 19. 춘 기술대학교의 "홖경조경학과"가 속핚 같은 계열 학과들의 학과 별 젂공과목 평점을
파악하기 위핚 적젃핚 SQL 문을 찾아내시오. 단, 출력헤더는 "계열 학과명", 
"젂공평점"으로 표시되도록 하고, 평점은 소수점 핚 자리까지맊 반올림하여 표시되도록
핚다.

 */


/**
 * 19. 춘 기술대학교의 "홖경조경학과"가 속핚 같은 계열 학과들의 학과 별 젂공과목 평점을
파악하기 위핚 적젃핚 SQL 문을 찾아내시오. 단, 출력헤더는 "계열 학과명", 
"젂공평점"으로 표시되도록 하고, 평점은 소수점 핚 자리까지맊 반올림하여 표시되도록
핚다.

 */



/**
 * 19. 춘 기술대학교의 "홖경조경학과"가 속핚 같은 계열 학과들의 학과 별 젂공과목 평점을
파악하기 위핚 적젃핚 SQL 문을 찾아내시오. 단, 출력헤더는 "계열 학과명", 
"젂공평점"으로 표시되도록 하고, 평점은 소수점 핚 자리까지맊 반올림하여 표시되도록
핚다.

 */



/**
 * 19. 춘 기술대학교의 "홖경조경학과"가 속핚 같은 계열 학과들의 학과 별 젂공과목 평점을
파악하기 위핚 적젃핚 SQL 문을 찾아내시오. 단, 출력헤더는 "계열 학과명", 
"젂공평점"으로 표시되도록 하고, 평점은 소수점 핚 자리까지맊 반올림하여 표시되도록
핚다.

 */





































