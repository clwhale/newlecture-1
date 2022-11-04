package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:oracle:thin:@ict.newlecture.com:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE NICKNAME='김명진'";
		
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
		// 데이터 처리 코드
		
		rs.close();
		st.close();
		con.close();
	}

}
