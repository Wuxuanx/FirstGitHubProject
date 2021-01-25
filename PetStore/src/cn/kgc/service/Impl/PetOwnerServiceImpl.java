package cn.kgc.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

import cn.kgc.dao.AccountDao;
import cn.kgc.dao.PetDao;
import cn.kgc.dao.PetOwnerDao;
import cn.kgc.dao.PetStoreDao;
import cn.kgc.dao.Impl.AccountDaoImpl;
import cn.kgc.dao.Impl.PetDaoImpl;
import cn.kgc.dao.Impl.PetOwnerDaoImpl;
import cn.kgc.dao.Impl.PetStoreDaoImpl;
import cn.kgc.entity.Account;
import cn.kgc.entity.Pet;
import cn.kgc.entity.PetOwner;
import cn.kgc.entity.PetStore;
import cn.kgc.service.PetOwnerService;
import cn.kgc.service.PetService;
import cn.kgc.utils.Utils;
/**
 * ���˷�����ʵ����
 * @author Administrator
 *
 */
public class PetOwnerServiceImpl implements PetOwnerService {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	PetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
	AccountDao accountDao = new AccountDaoImpl();
	PetDao petDao = new PetDaoImpl();
	Scanner scanner = new Scanner(System.in);
	PetStoreDao petStoreDao = new PetStoreDaoImpl();
	
	/**
	 * ��¼
	 */
	@Override
	public PetOwner login(String name, String password) {
		// TODO Auto-generated method stub
		PetOwner petOwner = null;
		petOwner = petOwnerDao.getPetOwnerByName(name);
		if(petOwner != null) {//���owner!=null˵���û�������ȷ��
			if(!petOwner.getPassword().equals(password)) {
				petOwner = null;
			}
		}
		
		return petOwner;
	}
	
	/**
	 * ��������
	 */
	@Override
	public void petOwner_buy_pet(PetOwner petOwner) {
		// TODO Auto-generated method stub
		PetDao petDao = new PetDaoImpl();
		List<Pet> pet_list = petDao.pets_old();
		PetService petService = new PetServiceImpl();
		petService.show_pet_old(pet_list);
		System.out.println("�����빺�����id:");
		int choose = scanner.nextInt();
		Pet pet1 = pet_list.get(choose - 1);
		petOwner.setMoney(petOwner.getMoney() - pet1.getPrice());
		PetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
		Integer result1 = petOwnerDao.updatePetOwner(petOwner);
		if(result1 > 0) {
			System.out.println("����������Ϣ�ɹ�!");
		}
		int id = petOwner.getId();
		pet1.setOwner_id(id);
		Integer result2 = petDao.updatePet_seller_by_owner(pet1);
		if(result2 > 0) {
			System.out.println("���³�����Ϣ�ɹ�!");
		}
		Account account = new Account();
		
		account.setDeal_type(1);
		account.setPet_id(pet1.getId());
		account.setSeller_id(pet1.getStore_id());
		account.setBuyer_id(petOwner.getId());
		account.setDeal_time(new Date());
		account.setPrice(pet1.getPrice());
		Integer result3 = accountDao.addAccount(account);
		if(result3 > 0) {
			System.out.println("����˵��ɹ�!");
		}else {
			System.out.println("����˵�ʧ��!");
		}
		
		int petStore_id = pet1.getStore_id();
		PetStore petStore = petStoreDao.getPetStoreById(petStore_id);
		petStore.setBalance(petStore.getBalance() + pet1.getPrice());
		int result4 = petStoreDao.updatePetStore(petStore);
		if(result4 > 0) {
			System.out.println("�����̵���Ϣ�ɹ�");
		}else {
			System.out.println("�����̵���Ϣʧ��");
		}
		
		
		
	}
	
	/**
	 * ��������
	 */
	@Override
	public void petOwner_seller_pet(PetOwner petOwner) {
		// TODO Auto-generated method stub
		String sql = "select * from pet where owner_id = ?";
		Utils utils = new Utils();
		connection = utils.getConnection();
		List<Pet> petList = new ArrayList<Pet>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, petOwner.getId());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Pet pet = new Pet();
				pet.setBirthday(resultSet.getTimestamp("birthday"));
				pet.setHealth(resultSet.getInt("health"));
				pet.setId(resultSet.getInt("id"));
				pet.setName(resultSet.getString("name"));
				pet.setType_name(resultSet.getString("type_name"));
				pet.setLove(resultSet.getInt("love"));;
				pet.setPrice(resultSet.getInt("price"));
				pet.setType(resultSet.getString("type"));
				petList.add(pet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("id\t����\t����\tԪ����");
		for(int i = 0; i < petList.size(); i++ ) {
			System.out.println((i + 1) + "\t" + petList.get(i).getName() + 
			"\t" +petList.get(i).getType() + "\t" + petList.get(i).getPrice());
		}
		System.out.println("����������������id:");
		int id = scanner.nextInt();
		Pet pet = petList.get(id - 1);
		System.out.println("��ѡ�������̼�id:");
		System.out.println("�̼��б�����:");
		
		List<PetStore> petStoreList =  petStoreDao.petStoresList();
		System.out.println("�̼����\t�̼�����");
		for(int i = 0; i < petStoreList.size(); i++) {
			System.out.println((i + 1) + "\t" + petStoreList.get(i).getName());
		}
		int storeId = scanner.nextInt();
		PetStore petStore = petStoreList.get(storeId - 1);
		Account account = new Account();
		account.setBuyer_id(petStore.getId());
		account.setDeal_time(new Date());
		account.setPet_id(pet.getId());
		account.setPrice(pet.getPrice());
		account.setSeller_id(petOwner.getId());
		Integer result3 =  accountDao.addAccount(account);
		if(result3 > 0) {
			System.out.println("����˵��ɹ�");
		}else {
			System.out.println("����˵�ʧ��");
		}
		pet.setOwner_id(0);
		pet.setStore_id(petStore.getId());
		Integer result1 = petDao.updatePet(pet);
		if(result1 > 0) {
			System.out.println("���³�����Ϣ�ɹ�");
		}else {
			System.out.println("���³�����Ϣʧ��");
		}
		
		petOwner.setMoney(petOwner.getMoney() + pet.getPrice());
		Integer result2 =  petOwnerDao.updatePetOwner(petOwner);
		if(result2 > 0) {
			System.out.println("������Ϣ���³ɹ�");
		}else {
			System.out.println("������Ϣ����ʧ��");
		}
		
		int result4 = petStoreDao.updatePetStore(petStore);
		if(result4 > 0) {
			System.out.println("�̵���Ϣ���³ɹ�");
		}else {
			System.out.println("�̵���Ϣ����ʧ��");
		}	
	} 
}
