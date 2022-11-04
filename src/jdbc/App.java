package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {

   public static void main(String[] args) throws ClassNotFoundException, SQLException {
      



      EXIT:
      while(true) {
         System.out.println("-----------------------------");
         System.out.println("            메인 메뉴         ");
         System.out.println("-----------------------------");
         System.out.println("           1. 회원 관리        ");
         System.out.println("           2. 게시글 관리      ");
         System.out.println("           3. 종료             ");
         switch(inputMenu()) {
         case 1:// 회원 관리
            listMember();
            break;
         case 2:// 게시글 관리
            break;
         case 3:// 종료
            System.out.println("Bye~");
            break EXIT;
         }
      }
      
   }
   
   private static void listMember() throws ClassNotFoundException, SQLException {      
      EXIT:
      while(true) {
         // 목록 출력
         System.out.println("-----------------------------");
         System.out.println("            회원 관리         ");
         System.out.println("-----------------------------");
         String sql = "SELECT * FROM MEMBER WHERE ROWNUM BETWEEN 1 AND 5";
	   	String url = "jdbc:oracle:thin:@ict.newlecture.com:1521/xepdb1";
         Class.forName("oracle.jdbc.driver.OracleDriver"); // DB driver
         Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); // JDBC driver
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
  		// FETCH->.NEXT()
        while(rs.next()){
			int id = rs.getInt("ID");
			String nickname = rs.getString("NICKNAME");
			String pwd = rs.getString("pwd");
			System.out.printf("id:%5d, \tpwd:%5s, \tnicName:%5s\n", id, pwd, nickname);
		   }
         
         st.close();
         rs.close();
         con.close();

         System.out.println("1. 추가 2. 수정 3. 삭제 4. 상위 메뉴");

         // 서브 메뉴         
         switch(inputMemberMenu()) {
         case 1:
            addMember();
            break;
        case 2:
            updateMember();
            break;
        case 3:
            deleteMember();
            break;
         case 4:// 상위 메뉴
            //return;
            break EXIT;
         }
      }
   }

   private static void deleteMember() throws ClassNotFoundException, SQLException {
      Scanner sc = new Scanner(System.in);

      String sql = "DELETE FROM member "
      		+ "WHERE"
      		+ "        id = ?"
      		+ "    AND pwd = ?"
      		+ "    AND nickname = ?";


      System.out.print("아이디: ");
      int id = sc.nextInt();
      System.out.print("\n이름: ");
      String nickName = sc.next();
      System.out.print("\n비밀 번호: ");
      String pwd = sc.next();

      String url = "jdbc:oracle:thin:@ict.newlecture.com:1521/xepdb1";

      Class.forName("oracle.jdbc.driver.OracleDriver"); // DB driver
      Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); // JDBC driver
      // Statement st = con.createStatement();
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, id);
      st.setString(2, pwd);
      st.setString(3, nickName);
      // insert/update/delete 문장을 실행할 때
      st.executeUpdate();

      st.close();
      con.close();
   }

   private static void updateMember() throws ClassNotFoundException, SQLException {
      Scanner sc = new Scanner(System.in);

      String sql = "UPDATE member "
         + "SET"
         + "    a = b"
         + "WHERE"
         + "        id = ?"
         + "    AND pwd = ?"
         + "    AND nickname = ?";


      System.out.print("아이디: ");
      int id = sc.nextInt();
      System.out.print("\n이름: ");
      String nickName = sc.next();
      System.out.print("\n비밀 번호: ");
      String pwd = sc.next();

      String url = "jdbc:oracle:thin:@ict.newlecture.com:1521/xepdb1";

      Class.forName("oracle.jdbc.driver.OracleDriver"); // DB driver
      Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); // JDBC driver
      // Statement st = con.createStatement();
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, id);
      st.setString(2, pwd);
      st.setString(3, nickName);
      // insert/update/delete 문장을 실행할 때
      st.executeUpdate();

      st.close();
      con.close();
   }
   

   private static void addMember() throws SQLException, ClassNotFoundException {

      Scanner sc = new Scanner(System.in);

      String sql = "INSERT INTO member ("
         + "    id,"
         + "    pwd,"
         + "    nickName"
         + ") VALUES ("
         + "    ?,"
         + "    ?,"
         + "    ?"
         + ")";

      System.out.print("아이디: ");
      int id = sc.nextInt();
      System.out.print("\n이름: ");
      String nickName = sc.next();
      System.out.print("\n비밀 번호: ");
      String pwd = sc.next();
      String url = "jdbc:oracle:thin:@ict.newlecture.com:1521/xepdb1";
   
      Class.forName("oracle.jdbc.driver.OracleDriver"); // DB driver
      Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); // JDBC driver
      // Statement st = con.createStatement();
      PreparedStatement st = con.prepareStatement(sql);
      
      st.setInt(1, id);
      st.setString(2, pwd);
      st.setString(3, nickName);

      // insert/update/delete 문장을 실행할 때
      st.executeUpdate();

      st.close();
      con.close();
   }

   private static int inputMemberMenu() {
      Scanner sc = new Scanner(System.in);
      return sc.nextInt();
   }

   private static int inputMenu() {
      Scanner sc = new Scanner(System.in);
      return sc.nextInt();
   }

}