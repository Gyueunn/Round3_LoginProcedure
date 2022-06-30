package camp.java.project3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectMysql {
	private static Connection conn; //DB 커넥션 연결 객체
    private static final String USERNAME = "root";//DBMS접속 시 아이디
    private static final String PASSWORD = "12345678";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost/Logindb";//DBMS접속할 db명
    static int selectId = 0;
    static int loginSuccess=0;
    static String findPWSuccess = "";
    static String[] userInfo  = new String [4];
  
    
    public ConnectMysql() {
		try {
            System.out.println("생성자");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("드라이버 로딩 성공");
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패 ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
	}
    
    //회원 가입 
	public static void insert(String id, String name, String pw, String dob, String major, String email) {
		String sql = "INSERT into tb_user (userid, username, userpw, userdob, usermajor, useremail) values (?,?,?,?,?,?);";
        PreparedStatement pstmt = null;

        try { 
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, pw);
            pstmt.setString(4, dob);
            pstmt.setString(5, major);
            pstmt.setString(6, email);
            
            System.out.println(id + " " + name + " " + pw + " " + dob + " " + major + " " + email);
            int result = pstmt.executeUpdate();
            if(result==1) {
                System.out.println("Board데이터 삽입 성공!");
            }
            
        } catch (Exception e) {
            System.out.println("Board데이터 삽입 실패!");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e1) {}
        }
	}
	
	//회원가입(이메일 없음) 
	public static void insert(String id, String name, String pw, String dob, String major) {
		String sql = "INSERT INTO tb_user (userid, username, userpw, userdob, usermajor) VALUES (?,?,?,?,?);";
        PreparedStatement pstmt = null;
		
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, pw);
            pstmt.setString(4, dob);
            pstmt.setString(5, major);
            
            System.out.println(id + " " + name + " " + pw + " " + dob + " " + major);
            int result = pstmt.executeUpdate();
            if(result==1) {
                System.out.println("Board데이터 삽입 성공!");
            }
            
        } catch (Exception e) {
            System.out.println("Board데이터 삽입 실패!");
        }    finally {
            try {
                if(pstmt!=null && !pstmt.isClosed()) {
                    pstmt.close();
                }
            } catch (Exception e1) {}
        }
	}
	
	//중복 확인 
	public static void select(String id) {
		String sql = "SELECT count(*) from tb_user where userid = '"+id+"';";
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            
            stmt = conn.createStatement();
            System.out.println("연결 성공");
            
            rs = stmt.executeQuery(sql);// 5. 쿼리 수행

            if (rs.next()) { // 6. 실행결과 출력하기
            	selectId = rs.getInt(1);
            }
         } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
         } catch (SQLException e) {
            System.out.println("에러 " + e);
         } finally {
            try {
               if (conn != null && !conn.isClosed()) {
                  conn.close();
               }
               if (stmt != null && !stmt.isClosed()) {
                  stmt.close();
               }
               if (rs != null && !rs.isClosed()) {
                  rs.close();
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
	}
	
	public static String[] selectUser(String id) {
		String sql = "SELECT username, userdob, usermajor, useremail from tb_user where userid = '"+id+"';";
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            
            stmt = conn.createStatement();
            System.out.println("연결 성공");
            
            rs = stmt.executeQuery(sql);// 5. 쿼리 수행

            while(rs.next()) { // 6. 실행결과 출력하기
            	userInfo[0] = rs.getString(1);
            	userInfo[1] = rs.getString(2);
            	userInfo[2] = rs.getString(3);
            	userInfo[3] = rs.getString(4);
            }
         } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
         } catch (SQLException e) {
            System.out.println("에러 " + e);
         } finally {
            try {
               if (conn != null && !conn.isClosed()) {
                  conn.close();
               }
               if (stmt != null && !stmt.isClosed()) {
                  stmt.close();
               }
               if (rs != null && !rs.isClosed()) {
                  rs.close();
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
		return userInfo;
	}
	
	//로그인에 사용 
	public static void select(String id, String pw) {
		String sql = "SELECT count(*) from tb_user where userid = '"+id+"' and userpw = '"+pw+"';";
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            stmt = conn.createStatement();
            System.out.println("연결 성공");
            
            rs = stmt.executeQuery(sql);// 5. 쿼리 수행

            if (rs.next()) { // 6. 실행결과 출력하기
            	loginSuccess = rs.getInt(1);
            }
         } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
         } catch (SQLException e) {
            System.out.println("에러 " + e);
         } finally {
            try {
               if (conn != null && !conn.isClosed()) {
                  conn.close();
               }
               if (stmt != null && !stmt.isClosed()) {
                  stmt.close();
               }
               if (rs != null && !rs.isClosed()) {
                  rs.close();
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
	}
	//pw 찾기 
	public static void select(String id, String name, String dob) {
		String sql = "SELECT userpw from tb_user where userid = '"+id+"' and username = '"+name+"' and userdob = '"+dob+"';";
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            stmt = conn.createStatement();
            System.out.println("연결 성공");
            
            rs = stmt.executeQuery(sql);// 5. 쿼리 수행
            
            if (rs.next()) { // 6. 실행결과 출력하기
            	findPWSuccess = rs.getString(1);
            	System.out.println(findPWSuccess);
            }
         } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
         } catch (SQLException e) {
            System.out.println("에러 " + e);
         } finally {
            try {
               if (conn != null && !conn.isClosed()) {
                  conn.close();
               }
               if (stmt != null && !stmt.isClosed()) {
                  stmt.close();
               }
               if (rs != null && !rs.isClosed()) {
                  rs.close();
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
	}
	//삭제  
	public static void deleteUser(String id) {
		String sql = "DELETE from tb_user where userid = '"+id+"';";
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            stmt = conn.createStatement();
            System.out.println("연결 성공");
            stmt.executeUpdate(sql);// 5. 쿼리 수행
            
         } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
         } catch (SQLException e) {
            System.out.println("에러 " + e);
         } finally {
            try {
               if (conn != null && !conn.isClosed()) {
                  conn.close();
               }
               if (stmt != null && !stmt.isClosed()) {
                  stmt.close();
               }
               if (rs != null && !rs.isClosed()) {
                  rs.close();
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
	}
	
	//user 정보 수정 메일 포함 
	public static void updateInfo(String id, String name, String pw, String major, String Email) {
		String sql = "update tb_user Set username = '" + name + "', userpw = '" + pw + "', usermajor = '" + major +  "', useremail = '" + Email +"'  Where userid = '" + id + "';";
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            stmt = conn.createStatement();
            System.out.println("연결 성공");
            
            stmt.executeUpdate(sql);// 5. 쿼리 수행
            
            
         } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
         } catch (SQLException e) {
            System.out.println("에러 " + e);
         } finally {
            try {
               if (conn != null && !conn.isClosed()) {
                  conn.close();
               }
               if (stmt != null && !stmt.isClosed()) {
                  stmt.close();
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
	}
	
	//user 정보 수정 메일 미포함 
	public static void updateInfo(String id, String name, String pw, String major) {
		String sql = "update tb_user Set username = '" + name + "', userpw = '" + pw + "', usermajor = '" + major +  "' Where userid = '" + id + "';";

		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        	conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            stmt = conn.createStatement();
            System.out.println("연결 성공");
            
            stmt.executeUpdate(sql);// 5. 쿼리 수행

         } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
         } catch (SQLException e) {
            System.out.println("에러 " + e);
         } finally {
            try {
               if (conn != null && !conn.isClosed()) {
                  conn.close();
               }
               if (stmt != null && !stmt.isClosed()) {
                  stmt.close();
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
	}
	
	
	
	
	
	
  
}