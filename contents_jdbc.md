
# contents-3.31 [실습 내용]()


전체 로직

1. driver loading: Class.forName()
2,3번 미리 초기화하고 try-catch문 에서 선언하기 (sql 쿼리 문자열도 선언해주기)

# 
2. connection: connectManger().get~(URL, USER, PASSWORD) -> Connection 패키지(맞는지 검토 필요)
==> DriverManager.getConnection()

3. prestatements: PreparedStatement 패키지
	-> setString, setInt등으로 바꾸고 전달하고 싶은것 넣어서 전달
==> conn.prepareStatement()로 String인데 sql 쿼리 문자열 전달


4. exacute:exacuteUpdate() 
(5. resultSet handling)
6. connect close

tcftc

-----------------------------------------------------------------------
DRIVER
URL
USER
PASSWORD


 Class.forName(DRIVER); // Driver Loading

-----------------------------------------------------------------------



