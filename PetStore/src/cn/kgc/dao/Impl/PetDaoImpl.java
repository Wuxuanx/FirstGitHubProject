package cn.kgc.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import cn.kgc.dao.PetDao;
import cn.kgc.entity.Pet;
import cn.kgc.entity.PetOwner;
import cn.kgc.test.TestMain;
import cn.kgc.utils.Utils;

/**
 * 宠物Dao接口实现类
 * @author Administrator
 *
 */
public class PetDaoImpl extends Utils implements PetDao {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
	/**
	 * 获取所有宠物信息
	 */
	@Override
	public List<Pet> getAllPets() {
		// TODO Auto-generated method stub
		List<Pet> petList = new ArrayList<Pet>();
		connection = this.getConnection();
		String sql = "select id, name, type_name, health, love, birthday, owner_id, store_id from pet;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Pet pet = new Pet();
				pet.setId(resultSet.getInt("id"));
				pet.setName(resultSet.getString("name"));
				pet.setType_name(resultSet.getString("type_name"));
				pet.setHealth(resultSet.getInt("health"));
				pet.setLove(resultSet.getInt("love"));
				pet.setBirthday(resultSet.getTimestamp("birthday"));
				pet.setOwner_id(resultSet.getInt("owner_id"));
				pet.setStore_id(resultSet.getInt("store_id"));
				petList.add(pet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(resultSet, preparedStatement, connection);
		}
		return petList;
	}

	/**
	 * 根据宠物id获取信息
	 */
	@Override
	public Pet getPetById(Integer id) {
		// TODO Auto-generated method stub
		connection = this.getConnection();
		String sql =  "select id, name, type_name, health, love,"
				+ " birthday, owner_id, store_id from pet where id = ?;";
		Pet pet = new Pet();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				pet.setId(resultSet.getInt("id"));
				pet.setName(resultSet.getString("name"));
				pet.setType_name(resultSet.getString("type_name"));
				pet.setHealth(resultSet.getInt("health"));
				pet.setLove(resultSet.getInt("love"));
				pet.setBirthday(resultSet.getTimestamp("birthday"));
				pet.setOwner_id(resultSet.getInt("owner_id"));
				pet.setStore_id(resultSet.getInt("store_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(resultSet, preparedStatement, connection);
		}
		return pet;
	}

	/**
	 * 添加宠物信息
	 */
	@Override
	public Integer addPet(Pet pet) {
		// TODO Auto-generated method stub
		String sql = "insert into pet(id, name, "
				+ "type_name, health, love, birthday, "
				+ "owner_id, store_id) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {pet.getId(), pet.getName(), pet.getType_name(),
				pet.getHealth(), pet.getLove(), pet.getBirthday(), 
				pet.getOwner_id(), pet.getOwner_id(), pet.getStore_id()};
		connection = this.getConnection();
		Integer result = this.execUpdate(sql, params);
		return result;
	}

	/**
	 * 更新宠物信息
	 */
	@Override
	public Integer updatePet(Pet pet) {
		// TODO Auto-generated method stub
		Integer result = -1;
		String sql = "update pet set name = ?, type_name = ?,"
				+ " health = ?, love = ?, birthday = ?, "
				+ " owner_id = ?, store_id = ? where id = ?";
		Object[] params = {pet.getName(), pet.getType_name(),
				pet.getHealth(), pet.getLove(), pet.getBirthday(), 
				pet.getOwner_id(), pet.getStore_id(), pet.getId()};
		result = this.execUpdate(sql, params);
		return result;
	}

	/**
	 * 删除宠物信息
	 */
	@Override
	public Integer deletePet(Integer id) {
		// TODO Auto-generated method stub
		Integer result = null;
		String sql = "delete from pet where id = ?";
		Object[] params = {id};
		result = this.execUpdate(sql, params);
		return result;
	}

	@Override
	public PetOwner getPetOwnerById(String name, String password) {
		// TODO Auto-generated method stub
		PetOwner petOwner = null;
		connection = this.getConnection();
		String sql = "select id,name,password,money from petowner where name=?";
		try {
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
	public List<Pet> pets_old() {
		// TODO Auto-generated method stub\
		List<Pet> pet_oldList = new ArrayList<Pet>();
		connection = this.getConnection();
		String sql = "select id, name, health , love, birthday, store_id, price from pet where type_name = 1";
//				+ " and owner_id = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, TestMain.petOwner.getId());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Pet pet = new Pet();
				pet.setId(resultSet.getInt("id"));
				pet.setBirthday(resultSet.getTimestamp("birthday"));
				pet.setHealth(resultSet.getInt("health"));
				pet.setLove(resultSet.getInt("love"));
				pet.setName(resultSet.getString("name"));
				pet.setStore_id(resultSet.getInt("store_id"));
				pet.setPrice(resultSet.getInt("price"));
				pet_oldList.add(pet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pet_oldList;
	}

	@Override
	public List<Pet> pets_new() {
		List<Pet> pet_newList = new ArrayList<Pet>();
		connection = this.getConnection();
		String sql = "select is, name, health , love, birthday, store_id, price from pet where type_name = 2";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Pet pet = new Pet();
				pet.setId(resultSet.getInt("id"));
				pet.setBirthday(resultSet.getTimestamp("birthday"));
				pet.setHealth(resultSet.getInt("health"));
				pet.setLove(resultSet.getInt("love"));
				pet.setName(resultSet.getString("name"));
				pet.setStore_id(resultSet.getInt("store_id"));
				pet.setPrice(resultSet.getInt("price"));
				pet_newList.add(pet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pet_newList;
	}

	@Override
	public Integer updatePet_seller_by_owner(Pet pet) {
		Integer result = -1;
		String sql = "update pet set name = ?, type_name = ?,"
				+ " health = ?, love = ?, birthday = ?, "
				+ " owner_id = ?, store_id = ? where id = ?";
		Object[] params = {pet.getName(), 1,
				pet.getHealth(), pet.getLove(), pet.getBirthday(), 
				0, pet.getStore_id(), pet.getId()};
		result = this.execUpdate(sql, params);
		return result;
	}

	/**
	 * 获取非本商店宠物信息
	 */
	@Override
	public List<Pet> pets_old_store() {
		// TODO Auto-generated method stub\
				List<Pet> pet_oldList = new ArrayList<Pet>();
				connection = this.getConnection();
				String sql = "select id, name, health , love, birthday, store_id,"
						+ " price from pet where type_name = 1"
						+ " and store_id != ?";
				try {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, TestMain.petStore.getId());
					resultSet = preparedStatement.executeQuery();
					while(resultSet.next()) {
						Pet pet = new Pet();
						pet.setId(resultSet.getInt("id"));
						pet.setBirthday(resultSet.getTimestamp("birthday"));
						pet.setHealth(resultSet.getInt("health"));
						pet.setLove(resultSet.getInt("love"));
						pet.setName(resultSet.getString("name"));
						pet.setStore_id(resultSet.getInt("store_id"));
						pet.setPrice(resultSet.getInt("price"));
						pet_oldList.add(pet);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return pet_oldList;
	}

	/**
	 * 获取商店宠物
	 */
	@Override
	public List<Pet> pets_old_is_store() {
		List<Pet> pet_oldList = new ArrayList<Pet>();
		connection = this.getConnection();
		String sql = "select id, name, health , love, birthday, store_id,"
				+ " price from pet where type_name = 1"
				+ " and store_id = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(TestMain.petStore.getId());
			preparedStatement.setInt(1, TestMain.petStore.getId());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Pet pet = new Pet();
				pet.setId(resultSet.getInt("id"));
				pet.setBirthday(resultSet.getTimestamp("birthday"));
				pet.setHealth(resultSet.getInt("health"));
				pet.setLove(resultSet.getInt("love"));
				pet.setName(resultSet.getString("name"));
				pet.setStore_id(resultSet.getInt("store_id"));
				pet.setPrice(resultSet.getInt("price"));
				pet_oldList.add(pet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pet_oldList;
	}

	@Override
	public Integer updatePet_seller_by_store(Pet pet) {
		Integer result = -1;
		String sql = "update pet set name = ?, type_name = ?,"
				+ " health = ?, love = ?, birthday = ?, "
				+ " owner_id = ?, store_id = ? where id = ?";
		Object[] params = {pet.getName(), 0,
				pet.getHealth(), pet.getLove(), pet.getBirthday(), 
				pet.getOwner_id(), 0, pet.getId()};
		result = this.execUpdate(sql, params);
		return result;
	}

	//////////////////////////////////////////////////////////////////////////
	@Override
	public Integer updatePet_buy_by_owner(Pet pet) {
		Integer result = -1;
		String sql = "update pet set name = ?, type_name = ?,"
				+ " health = ?, love = ?, birthday = ?, "
				+ " owner_id = ?, store_id = ? where id = ?";
		Object[] params = {pet.getName(), 1,
				pet.getHealth(), pet.getLove(), pet.getBirthday(), 
				0, pet.getStore_id(), pet.getId()};
		result = this.execUpdate(sql, params);
		return result;
	}

	@Override
	public Integer updatePet_buy_by_store(Pet pet) {
		Integer result = -1;
		String sql = "update pet set name = ?, type_name = ?,"
				+ " health = ?, love = ?, birthday = ?, "
				+ " owner_id = ?, store_id = ? where id = ?";
		Object[] params = {pet.getName(), 0,
				pet.getHealth(), pet.getLove(), pet.getBirthday(), 
				pet.getOwner_id(), 0, pet.getId()};
		result = this.execUpdate(sql, params);
		return result;
	}
	
	

}
