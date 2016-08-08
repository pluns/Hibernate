package net.util;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.DbUtils;
import org.junit.Test;

public class DbUtilsTest {
	Connection conn = DbUtil.getConnection();
	
	@Test
	public void testSelect(){
		final String sql = "SELECT * FROM `ecs_admin_log`";
		try {
			if(conn == null || conn.isClosed()){
				conn = DbUtil.getPoolConnection();
			}
			LogBean log = new QueryRunner().query(conn, sql, new BeanHandler<LogBean>(LogBean.class));
			if(log != null){
				System.out.println(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}
	
	@Test
	public void testInsert() {
		final String sql = "INSERT INTO `ecs_admin_log` (`log_time`, `user_id`, `log_info`, `ip_address`) VALUES (UNIX_TIMESTAMP(),?, ?, ?)";
		try{
			if(conn == null || conn.isClosed()){
				conn = DbUtil.getPoolConnection();
			}
			int result = new QueryRunner().update(conn, sql, new Object[]{1, "insert", "127.0.0.1"});
			if(result > 0){
				System.out.println("insert success " + result);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
	}
	@Test
	public void testUpdate(){
		final String sql = "UPDATE `ecs_admin_log` SET `log_info` = ? WHERE `log_id` > 468";
		try {
			if(conn == null || conn.isClosed()){
				conn = DbUtil.getPoolConnection();
			}
			Object[] params = {"abc"};
			int result = new QueryRunner().update(conn, sql,  params);
			if(result > 0){
				System.out.println("update success " + result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}
	
	@Test
	public void testDelete(){
		final String sql = "DELETE FROM `ecs_admin_log` WHERE `log_id` = ? LIMIT 1";
		try{
			if(conn == null || conn.isClosed()){
				conn = DbUtil.getPoolConnection();
			}
			Object[] params = {478};
			int result = new QueryRunner().update(conn, sql, params);
			if(result > 0){
				System.out.println("delete success " + result);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
	}

}
