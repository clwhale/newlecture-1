package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {

   public static void main(String[] args) throws ClassNotFoundException, SQLException {
      
      EXIT:
      while(true) {
         switch(inputMenu()) {
         case 1:// 회원 관리
            listMember();
            break;
         case 2:// 게시글 관리
            break;
         case 3:
            System.out.println("Bye~");
            break EXIT;
         }
      }
      
   }

   private static void listMember() throws ClassNotFoundException, SQLException {      
      EXIT:
      while(true) {
         // 목록 출력
         
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

   private static void addMember() throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO member ("
        		+ "    id,"
        		+ "    pwd,"
        		+ "    nickname"
        		+ ") VALUES ("
        		+ "    :?,"
        		+ "    :?,"
        		+ "    :?"
        		+ ")";


        int id = 3030;
        String nickName = "haha";
        String pwd = "234";
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
      return 0;
   }

   private static int inputMenu() {
      return 0;
   }

}