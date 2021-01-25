package cn.kgc.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.kgc.dao.PetStoreDao;
import cn.kgc.entity.PetOwner;
import cn.kgc.entity.PetStore;
import cn.kgc.test.TestMain;
import cn.kgc.utils.Utils;
import jdk.jfr.Percentage;
/**
 * �����̵�DAOʵ����
 * @author Administrator
 *
 */
public class PetStoreDaoImpl extends Utils implements PetStoreDao {

	/**
	 * ���ݿ�����
	 */
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Integer result = -1;
	Boolean flag = false;
	
	/**
	 * ��ȡ���г����̵�
	 */
	@Override
	public List<PetStore> petStoresList() {
		// TODO Auto-generated method stub
		List<PetStore> petStoreList = new ArrayList<PetStore>();
		connection = this.getConnection();
		String sql = "select id, name, password, balance from petstore";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				PetStore petStore = new PetStore();
				petStore.setId(resultSet.getInt("id"));
				petStore.setBalance(resultSet.getInt("balance"));
				petStore.setName(resultSet.getString("name"));
				petStore.setPassword(resultSet.getString("password"));
				petStoreList.add(petStore);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(resultSet, preparedStatement, connection);
		}
		return petStoreList;
	}

	/**
	 * �����̵�ID��ȡ�̵���Ϣ
	 */
	@Override
	public PetStore getPetStoreById(Integer id) {
		// TODO Auto-generated method stub
		PetStore petStore = new PetStore();
		String sql = "select id, name, password, balance from petstore where id = ?";
		connection = this.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				petStore.setId(resultSet.getInt("id"));
				petStore.setBalance(resultSet.getInt("balance"));
				petStore.setName(resultSet.getString("name"));
				petStore.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(resultSet, preparedStatement, connection);
		}
		return petStore;
	}

	/**
	 * ��ӳ����̵�
	 */
	@Override
	public Integer addPetStore(PetStore petStore) {
		// TODO Auto-generated method stub
		String sql = "insert into petstore(name, password, balance) values(?, ?, ?)";
		Object [] params = {petStore.getName(), petStore.getPassword(), petStore.getBalance()};
		result = this.execUpdate(sql, params);
		return result;
	}

	/**
	 * ���³����̵���Ϣ
	 */
	@Override
	public Integer updatePetStore(PetStore petStore) {
		// TODO Auto-generated method stub
		String sql = "update petstore set name = ?, password = ?, balance = ? where id = ?";
		Object[] params = {petStore.getName(), petStore.getPassword(), petStore.getBalance(), petStore.getId()};
		result = this.execUpdate(sql, params);
		return result;
	}

	/**
	 * ɾ�������̵���Ϣ
	 */
	@Override
	public Integer deletePetStore(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from petstore where id = ?";
		Object[] params = {id};
		result = this.execUpdate(sql, params);
		return result;
	}
	
	/**
	 * �����̵��½
	 */
	public PetStore login(String name, String password) {
		connection = this.getConnection();
		String sql = "select * from petstore where name = ? and password = ?";
		PetStore petStore = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				petStore = new PetStore();
				petStore.setId(resultSet.getInt("id"));
				petStore.setName(resultSet.getString("name"));
				petStore.setBalance(resultSet.getInt("balance"));
				petStore.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestMain.petStore = petStore;
		return petStore;
		
	}
	
	/**
	 * ͨ�����ƻ�ȡ�����̵�
	 */
	public PetStore getPetStoreByName(String name) {
		PetStore petStore = null;
		String sql = "select * from petstore where name = ?";
		connection = this.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				petStore = new PetStore();
				petStore.setId(resultSet.getInt("id"));
				petStore.setBalance(resultSet.getInt("balancer"));
				petStore.setName(resultSet.getString("name"));
				petStore.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return petStore;
	}
}
