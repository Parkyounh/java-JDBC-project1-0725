package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JbvcTest1 {
	public static void main(String[] args) throws ClassNotFoundException ,SQLException {
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3305/spring5fs";
		Connection con =  null;
		String sql = "select * from ";
		
		Scanner sc = new Scanner(System.in);
				
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("클래스가 없다.");
		
		con = DriverManager.getConnection(url,id,pw);
		System.out.println("접속 성공!");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println("name\tjob");
		System.out.println("----------------");
		
		while (rs.next()) {   // 자료가 더 없으면 false return
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			int empno = rs.getInt("empno");
			String str = rs.getString(5);
			System.out.print(empno+"\t"+ename+"\t"+job+"    \t"+str);
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
