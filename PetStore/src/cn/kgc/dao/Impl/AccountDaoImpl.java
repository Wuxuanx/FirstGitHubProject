package cn.kgc.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cn.kgc.dao.AccountDao;
import cn.kgc.entity.Account;
import cn.kgc.utils.Utils;

/**
 * 账单Dao接口实现类
 * @author Administrator
 *
 */
public class AccountDaoImpl extends Utils implements AccountDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Integer result = -1;
	
	/**
	 * 获取全部账单信息
	 */
	@Override
	public List<Account> getAllAccountList() {
		// TODO Auto-generated method stub
		List<Account> accountList = new ArrayList<Account>();
		connection = this.getConnection();
		String sql = "SELECT id, deal_type, pet_id, "
				+ "seller_id, buyer_id, price, deal_time FROM "
				+ "petshops.account;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setId(resultSet.getInt("id"));
				account.setDeal_type(resultSet.getInt("deal_type"));
				account.setPet_id(resultSet.getInt("pet_id"));
				account.setSeller_id(resultSet.getInt("seller_id"));
				account.setBuyer_id(resultSet.getInt("buyer_id"));
				account.setPrice(resultSet.getInt("price"));
				account.setDeal_time(resultSet.getTimestamp("deal_time"));
				accountList.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(resultSet, preparedStatement, connection);
		}
		return accountList;
	}

	/**
	 * 根据id获取账单信息
	 * 	@Override
	 */
	public Account getAccountById(Integer id) {
		// TODO Auto-generated method stub
		Account account = new Account();
		connection = this.getConnection();
		String sql = "SELECT id, deal_type, pet_id, "
				+ "seller_id, buyer_id, price, deal_time FROM "
				+ "petshops.account where id = ?;";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				account.setId(resultSet.getInt("id"));
				account.setDeal_type(resultSet.getInt("deal_type"));
				account.setPet_id(resultSet.getInt("pet_id"));
				account.setSeller_id(resultSet.getInt("seller_id"));
				account.setBuyer_id(resultSet.getInt("buyer_id"));
				account.setPrice(resultSet.getInt("price"));
				account.setDeal_time(resultSet.getTimestamp("deal_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(resultSet, preparedStatement, connection);
		}
		return account;
	}

	/**
	 * 添加账单
	 */
	@Override
	public Integer addAccount(Account account) {
		// TODO Auto-generated method stub
		Integer result = -1;
		String sql = "insert into account("
				+ "deal_type, pet_id, seller_id, "
				+ "buyer_id, price, deal_time) values"
				+ "(?, ?, ?, ?, ?, ?)";
		Object[] params = {1, account.getPet_id(),
				account.getSeller_id(), account.getBuyer_id(), account.getPrice(),
				account.getDeal_time()};
		result = this.execUpdate(sql, params);
		return result;
	}

	/**
	 * 删除一个账单
	 */
	@Override
	public Integer deleteAccount(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from account where id = ?";
		Object[] params = {id};
		result = this.execUpdate(sql, params);
		return result;
	}

	/**
	 * 更新一个账单信息
	 */
	@Override
	public Integer updateAccount(Account account) {
		// TODO Auto-generated method stub
		String sql = "update account set deal_type = ?, "
				+ "pet_id = ?, seller_id =? , buyer_id = ?, "
				+ "price = ?, deal_time = ? where id = ?";
		Object[] params = {account.getDeal_type(), account.getPet_id(),
				account.getSeller_id(), account.getBuyer_id(),
				account.getPrice(), account.getDeal_time(), account.getId()};
		result = this.execUpdate(sql, params);
		return result;
	}

}
