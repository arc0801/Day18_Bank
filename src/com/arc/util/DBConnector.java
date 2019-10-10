package com.arc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnector {

	//Connection - DB 로그인
	//메서드명 getConnect
	//Exception은 throws
	public static Connection getConnect() throws Exception{
		//static 객체 생성X, 클래스명.메서드명으로 바로 불러올 수 있음
		Connection con = null;
		
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);

		return con;
	}//getConnect
}
