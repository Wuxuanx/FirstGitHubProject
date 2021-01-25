package cn.kgc.dao;

import java.util.List;

import cn.kgc.entity.Account;
/**
 * �˵�Dao�ӿ�
 * @author Administrator
 *
 */
public interface AccountDao {
	
	//��ȡ�����˵�
	List<Account> getAllAccountList();
	//����id��ѯ�˵�
	public Account getAccountById(Integer id);
	//����˵�
	public Integer addAccount(Account account);
	//ɾ�� �˵�
	public Integer deleteAccount(Integer id);
	//�޸��˵�
	public Integer updateAccount(Account account);
}
