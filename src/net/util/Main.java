package net.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = DbUtil.getConnection();
		String sql = "select * from ecs_admin_user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getString(2));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
	}
	
	public void testInsert(){
		System.out.println("insert");
	}
}
