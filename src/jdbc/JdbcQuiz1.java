package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcQuiz1 {
	public static void main(String[] args) throws ClassNotFoundException ,SQLException {
		
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3305/spring5fs";
		Connection con =  null;
		String sql = "select * from ";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원하는 테이블 선택(emp,dept): ");
		sql = sql + sc.nextLine();
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection(url,id,pw);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println("name\tjob");
		System.out.println("----------------");
		
		while (rs.next()) {   // 자료가 더 없으면 false return
			String str1 = rs.getString(1);
			String str2 = rs.getString(2);
			String str3 = rs.getString(3);
			System.out.print(str1+"\t"+str2+"    \t"+str3);
			System.out.println();
		}
		
		rs.close();
		stmt.close();
		con.close();
		
		
//		try {
//			System.out.println("있다");
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("클래스가 없다.");
//		}
		
	}
}
