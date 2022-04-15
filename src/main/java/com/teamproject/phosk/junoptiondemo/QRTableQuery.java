package com.teamproject.phosk.junoptiondemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;





public class QRTableQuery {
	static {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;		
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jun","jun");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select*from phosk_QRTable");
			
			while(resultSet.next()) {
				String branch_num = resultSet.getString("branch_num");
				int QRTable_Num = resultSet.getInt("QRTable_Num");
				String QRTable_URL = resultSet.getString("QRTable_URL");
				
				System.out.println("지점번호:" + branch_num + ",테이블번호:" + QRTable_Num + ",테이블주소" + QRTable_URL);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet !=null) resultSet.close();
				if(statement !=null) statement.close();
				if(connection !=null) connection.close();
			} catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
}
