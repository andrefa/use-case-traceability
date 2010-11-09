package br.com.furb.engenhariasoftware.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import br.com.furb.engenhariasoftware.util.DateFormatUtil;

public class DataBaseManager {
	private Connection con = null;
	
	private Connection getConnection() throws Exception {
		if (this.con == null || this.con.isClosed()) {
			Class.forName("org.hsqldb.jdbcDriver");
			
			StringBuilder url = new StringBuilder();
			url.append("jdbc:hsqldb:file:").append(DataBaseConfig.URL);
			
			this.con = DriverManager.getConnection(url.toString(), DataBaseConfig.USERNAME, DataBaseConfig.PASSWORD);
			
			PreparedStatement pst = this.con.prepareStatement("SET AUTOCOMMIT FALSE");
			pst.execute();
			
			con.setAutoCommit(false);
			return this.con;
		} else {
			return this.con;
		}
	}
	
	public ResultSet executeQuery(String sql, Map<Integer, Object> parameters) throws Exception{
		PreparedStatement statement = this.getConnection().prepareStatement(sql);
		
		if(parameters != null){
			Set<Integer> keys = parameters.keySet();
			
			Iterator<Integer> iterator = keys.iterator();
			
			while(iterator.hasNext()){
				Integer key = iterator.next();
				Object value = parameters.get(key);
				if(value instanceof String){
					statement.setString(key, String.valueOf(value));
				}else if(value instanceof Integer){
					statement.setInt(key, Integer.valueOf(value.toString()));
				}else if(value instanceof Double){
					statement.setDouble(key, Double.valueOf(value.toString()));
				}else if(value instanceof Float){
					statement.setFloat(key, Float.valueOf(value.toString()));
				}else if(value instanceof Date){
					statement.setTimestamp(key, DateFormatUtil.getTimestampOfDate((Date)value));
				}else if(value instanceof Long){
					statement.setLong(key, Long.valueOf(value.toString()));
				}
			}
		}
		
		return statement.executeQuery();
	}
	
	public void execute(String sql, Map<Integer, Object> parameters) throws Exception{
		PreparedStatement statement = this.getConnection().prepareStatement(sql);
		
		if(parameters != null){
			Set<Integer> keys = parameters.keySet();
			
			Iterator<Integer> iterator = keys.iterator();
			
			while(iterator.hasNext()){
				Integer key = iterator.next();
				Object value = parameters.get(key);
				if(value instanceof String){
					statement.setString(key, String.valueOf(value));
				}else if(value instanceof Integer){
					statement.setInt(key, Integer.valueOf(value.toString()));
				}else if(value instanceof Double){
					statement.setDouble(key, Double.valueOf(value.toString()));
				}else if(value instanceof Float){
					statement.setFloat(key, Float.valueOf(value.toString()));
				}else if(value instanceof Date){
					statement.setTimestamp(key, DateFormatUtil.getTimestampOfDate((Date)value));
				}else if(value instanceof Long){
					statement.setLong(key, Long.valueOf(value.toString()));
				}
			}
		}
		
		statement.execute();
	}
	
	public void commit(){
		try {
			if(this.con != null){
				PreparedStatement pst = this.con.prepareStatement("COMMIT");
				pst.execute();
				this.con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollback(){
		try {
			if(this.con != null){
				PreparedStatement pst = this.con.prepareStatement("ROLLBACK");
				pst.execute();
				this.con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			if(this.con != null){
				PreparedStatement pst = this.con.prepareStatement("SHUTDOWN");
				pst.execute();
				this.con.close();
				this.con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
