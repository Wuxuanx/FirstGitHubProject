package cn.kgc.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.kgc.entity.PetOwner;
import cn.kgc.utils.Utils;
/**
 * 宠物主人Dao接口实现类
 * @author Administrator
 *
 */
public class PetOwnerDaoImpl extends Utils implements cn.kgc.dao.PetOwnerDao {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Integer result = -1;
	Boolean flag = false;
	
	/**
	 * 获取全部主人信息
	 */
	@Override
	public List<PetOwner> petOwnerList() {
		// TODO Auto-generated method stub
		List<PetOwner> petOwnerList = new ArrayList<PetOwner>();
		String sql = "select id, name, password, money from petowner";
		connection = this.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				PetOwner petOwner = new PetOwner();
				petOwner.setId(resultSet.getInt("id"));		
				petOwner.setMoney(resultSet.getInt("money"));
				petOwner.setName(resultSet.getString("name"));
				petOwner.setPassword(resultSet.getString("password"));
				petOwnerList.add(petOwner);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(resultSet, preparedStatement, connection);
		}
		return petOwnerList;
	}

	/**
	 * 根据主人id,获取主人信息
	 */
	@Override
	public PetOwner getPetOwnerById(Integer id) {
		// TODO Auto-generated method stub
		connection = this.getConnection();
		String sql = "select id, name, password, money from petowner where id = ?";
		PetOwner petOwner = new PetOwner();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				petOwner.setId(resultSet.getInt("id"));
				petOwner.setMoney(resultSet.getInt("money"));
				petOwner.setName(resultSet.getString("name"));
				petOwner.setPassword(resultSet.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(resultSet, preparedStatement, connection);
		}
		return petOwner;
	}

	/**
	 * 添加宠物主人信息
	 */
	@Override
	public Integer addPetOwner(PetOwner petOwner) {
		// TODO Auto-generated method stub
		String sql = "insert into petowner(name, password, money) values(?, ?, ?)";
		Object[] params = {petOwner.getName(), petOwner.getPassword(), petOwner.getMoney()};
		connection = this.getConnection();
		result = this.execUpdate(sql, params);
		return result;
	}

	/**
	 * 删除一个主人信息
	 */
	@Override
	public Integer deletPetOwner(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from petowner where id = ?";
		Object [] params = {id};
		connection = this.getConnection();
		result = this.execUpdate(sql, params);
		return result;
	}

	/**
	 * 更新主人信息
	 */
	@Override
	public Integer updatePetOwner(PetOwner petOwner) {
		// TODO Auto-generated method stub
		String sql = "update petowner set name = ?, password = ?, money = ? where id = ?";
		Object[] params = {petOwner.getName(), petOwner.getPassword(), petOwner.getMoney(), petOwner.getId()};
		result = this.execUpdate(sql, params);
		return result;
	}
	
	/**
	 * 宠物主人登陆
	 */
	@Override
	public PetOwner getPetOwnerByName(String name) {
		PetOwner petOwner = null;
		try {
			String sql = "select * from petowner where name = ?";
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				petOwner = new PetOwner();
				petOwner.setId(resultSet.getInt("id"));
				petOwner.setMoney(resultSet.getInt("money"));
				petOwner.setName(resultSet.getString("name"));
				petOwner.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(resultSet, preparedStatement, connection);
		}
		return petOwner;
	}

	@Override
	public PetOwner login(String name, String password) {
		PetOwner petOwner = null;
		try {
			String sql = "select * from petowner where name = ? and password = ?";
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				petOwner = new PetOwner();
				petOwner.setId(resultSet.getInt("id"));
				petOwner.setMoney(resultSet.getInt("money"));
				petOwner.setName(resultSet.getString("name"));
				petOwner.setPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return petOwner;
	}

}
