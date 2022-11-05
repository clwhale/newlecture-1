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

      System.out.println("-----------------------------");
      System.out.println("        삭제할 멤버");
      System.out.print("아이디: ");
      int id = sc.nextInt();
      System.out.print("\n이름: ");
      String nickName = sc.next();
      System.out.print("\n비밀 번호: ");
      String pwd = sc.next();
      System.out.println("-----------------------------");

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

      System.out.println("     멤버를 삭제했습니다");
   }

   private static void updateMember() throws ClassNotFoundException, SQLException {
      Scanner sc = new Scanner(System.in);

      String sql = "UPDATE member "
         + "SET"
         + "    id = ?,"
         + "    pwd = ?,"
         + "    nickname = ?"

         + "WHERE"
         + "        id = ?"
         + "    AND pwd = ?"
         + "    AND nickname = ?";


      System.out.println("-----------------------------");
      System.out.println("        변경할 멤버");
      System.out.print("아이디: ");
      int id = sc.nextInt();
      System.out.print("\n이름: ");
      String nickName = sc.next();
      System.out.print("\n비밀 번호: ");
      String pwd = sc.next();
      System.out.println("-----------------------------");
      System.out.println("-----------------------------");
      System.out.print("새로운 아이디: ");
      int newId = sc.nextInt();
      System.out.print("\n새로운 이름: ");
      String newNickName = sc.next();
      System.out.print("\n새로운 비밀 번호: ");
      String newPwd = sc.next();
      System.out.println("-----------------------------");
      
      String url = "jdbc:oracle:thin:@ict.newlecture.com:1521/xepdb1";

      Class.forName("oracle.jdbc.driver.OracleDriver"); // DB driver
      Connection con = DriverManager.getConnection(url, "NEWLEC", "rland"); // JDBC driver
      // Statement st = con.createStatement();
      PreparedStatement st = con.prepareStatement(sql);
      st.setInt(1, newId);
      st.setString(2, newPwd);
      st.setString(3, newNickName);
      st.setInt(4, id);
      st.setString(5, pwd);
      st.setString(6, nickName);
      // insert/update/delete 문장을 실행할 때
      st.executeUpdate();

      st.close();
      con.close();
      System.out.println("     멤버를 변경했습니다");
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

      // select member that added
      String sqlAdded = String.format("SELECT * FROM MEMBER WHERE NICKNAME='%s'", nickName);
      Statement stAdded = con.createStatement();
      ResultSet rs = stAdded.executeQuery(sqlAdded);

      rs.next();
      int idAdded = rs.getInt("ID");
      String nicknameAdded = rs.getString("NICKNAME");
      String pwdAdded = rs.getString("pwd");

      System.out.println("-----------------------------");
      System.out.println("        추가한 멤버");
      System.out.printf("id:%5d, \tpwd:%5s, \tnicName:%5s\n", idAdded, pwdAdded, nicknameAdded);
      System.out.println("-----------------------------");


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