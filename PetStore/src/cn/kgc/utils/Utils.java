package cn.kgc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



import com.mysql.cj.jdbc.Driver;

/**
 * ������
 * @author Administrator
 *
 */



public class Utils {
	/**
	 * �������ݿ�ӿڹ���
	 */
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	static String driver = null;
	static String dburl = null;
	static String username = null;
	static String password = null;
	
	/**
	 * ���ݿ�������ݳ�ʼ������
	 */
	public static void init() {
		Properties preProperties = new Properties();
		InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			preProperties.load(inputStream);
			driver = preProperties.getProperty("jdbc.driver");
			
			dburl = preProperties.getProperty("jdbc.dburl");
			username = preProperties.getProperty("jdbc.user");
			password = preProperties.getProperty("jdbc.password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * ���ݿ������ʼ��
	 */
	static {
		init();
		
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	public Connection getConnection() {
		try {
			Class.forName(driver);
			
			connection = DriverManager.getConnection(dburl, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * �ر���������
	 * @param resultSet
	 * @param preparedStatement
	 * @param connection
	 */
	public void closeAll(ResultSet resultSet, PreparedStatement preparedStatement,
		Connection connection) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ���ݿ���ɾ�Ĳ����
	 * @param sql
	 * @param params
	 * @return
	 */
	public Integer execUpdate(String sql, Object[] params) {
		Integer result = -1;
		connection = this.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			if(params != null) {
				for(int i = 0; i < params.length; i++) {
					preparedStatement.setObject(i+1, params[i]);
				}
			}
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
}
