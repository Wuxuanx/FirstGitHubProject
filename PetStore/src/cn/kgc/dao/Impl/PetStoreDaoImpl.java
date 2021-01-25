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
 * 宠物商店DAO实现类
 * @author Administrator
 *
 */
public class PetStoreDaoImpl extends Utils implements PetStoreDao {

	/**
	 * 数据库连接
	 */
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Integer result = -1;
	Boolean flag = false;
	
	/**
	 * 获取所有宠物商店
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
	 * 根据商店ID获取商店信息
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
	 * 添加宠物商店
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
	 * 更新宠物商店信息
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
	 * 删除宠物商店信息
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
	 * 宠物商店登陆
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
	 * 通过名称获取宠物商店
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
