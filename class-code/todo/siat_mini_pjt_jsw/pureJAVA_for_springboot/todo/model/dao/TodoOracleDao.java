package todo.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import todo.model.domain.TodoRequestDTO;
import todo.model.domain.TodoResponseDTO;

public class TodoOracleDao {

    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    public static final String USER = "hr";
    public static final String PASSWORD = "hr";

    public TodoOracleDao(){
            try {
                Class.forName(DRIVER) ;
                System.out.println("1.Driver loading OK!!");
            } catch (ClassNotFoundException e) {
                
                e.printStackTrace();
            }
        }

    public int insertRow(TodoRequestDTO request) {
        System.out.println(">>> dao insertRow");
        int flag = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String insertSQL = "INSERT INTO JDBC_TODO_TBL(SEQ, TITLE, CONTENT, PRIORITY) " +
                "VALUES (JDBC_SEQ.NEXTVAL,?,?,?)";
        /* DBMS 구문을 그대로 가져온다. 다만 DBMS에 직접 넣었던 데이터를 ? 로 넣는다. */
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, request.getTitle());
            pstmt.setString(2, request.getContent());
            pstmt.setInt(3, request.getPriority());
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public int deleteRow(int seq) {
        System.out.println(">>> dao deleteRow");
        int flag = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String deleteSQL = "DELETE FROM JDBC_TODO_TBL WHERE SEQ = ?";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1, seq);
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public int updateRow(Map<String, Object> map) {
        System.out.println(">>> dao updateRow");
        int flag = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String updateSQL = "UPDATE JDBC_TODO_TBL " +
                "SET CONTENT = ? , STATUS = ? " +
                "WHERE SEQ = ?";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, (String) (map.get("content")));
            pstmt.setString(2, (String) (map.get("status")));
            pstmt.setInt(3, (Integer) (map.get("seq")));
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    // 전체보기
    public List<TodoResponseDTO> selectRow1() {
        System.out.println(">>> dao selectRow1");
        List<TodoResponseDTO> list = new ArrayList<>();
        Connection conn = null; /* 연다. */
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String selectSQL = "SELECT * FROM JDBC_TODO_TBL";
        // String selectSQL = "SELECT SEQ , TITLE , CONTENT , TO_CHAR(STARTDATE, 'YY/MM/DD')AS SD, STATUS , PRIORITY   FROM JDBC_TODO_TBL";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(selectSQL);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                TodoResponseDTO response = TodoResponseDTO.builder()
                        // .seq(rset.getInt("SEQ"))
                        .seq(rset.getInt(1))
                        .title(rset.getString(2))
                        .content(rset.getString(3))
                        .startDate(rset.getString(4))
                        // .startDate(rset.getString("SD"))
                        .status(rset.getString(5))
                        .endDate(rset.getString(6))
                        .priority(rset.getInt(7))
                        .build();
                list.add(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close(); /* 닫는다. */
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    // 상세보기 optional
    public Optional<TodoResponseDTO> selectRow(int seq) {
        System.out.println(">>> dao selectRow");
        Optional<TodoResponseDTO> response = Optional.empty();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String selectSQL = "SELECT * FROM JDBC_TODO_TBL " +
                "WHERE SEQ = ? ";
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(selectSQL);
            pstmt.setInt(1, seq);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                response = Optional.of(TodoResponseDTO.builder()
                        .seq(rset.getInt(1))
                        .title(rset.getString(2))
                        .content(rset.getString(3))
                        .startDate(rset.getString(4))
                        .status(rset.getString(5))
                        .endDate(rset.getString(6))
                        .priority(rset.getInt(7))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

}
