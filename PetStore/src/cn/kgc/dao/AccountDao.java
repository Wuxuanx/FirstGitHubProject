package cn.kgc.dao;

import java.util.List;

import cn.kgc.entity.Account;
/**
 * 账单Dao接口
 * @author Administrator
 *
 */
public interface AccountDao {
	
	//获取所有账单
	List<Account> getAllAccountList();
	//根据id查询账单
	public Account getAccountById(Integer id);
	//添加账单
	public Integer addAccount(Account account);
	//删除 账单
	public Integer deleteAccount(Integer id);
	//修改账单
	public Integer updateAccount(Account account);
}
