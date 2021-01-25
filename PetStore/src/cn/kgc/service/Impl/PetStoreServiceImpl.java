package cn.kgc.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
import cn.kgc.service.PetService;
import cn.kgc.service.PetStoreService;
import cn.kgc.test.TestMain;

public class PetStoreServiceImpl implements PetStoreService {
	
	Scanner scanner = new Scanner(System.in);
	PetDao petDao = new PetDaoImpl();
	PetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
	PetStoreDao petStoreDao = new PetStoreDaoImpl();
	AccountDao accountDao = new AccountDaoImpl();
//	PetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
	
	
	/**
	 * �����̵��¼
	 */
	@Override
	public PetStore login(String name, String password) {
		// TODO Auto-generated method stub
		PetStore petStore = null;
		PetStoreDao petStoreDao = new PetStoreDaoImpl();
		petStore = petStoreDao.getPetStoreByName(name);
		if(petStore != null) {//���ڴ��˺�����
			if(!petStore.getPassword().equals(password)) {
				petStore = null;
			}
		}
		
		return petStore;
	}

	
	/**
	 * �����̵깺�����
	 */
	public void petStore_buy_pet(PetStore petStore) {
		Pet pet = null;
//		PetDao petDao = new PetDaoImpl();
		List<Pet> pet_list = petDao.pets_old_store();
		PetService petService = new PetServiceImpl();
		petService.show_pet_old(pet_list);
		System.out.println("�����빺�����id:");
		int choose = scanner.nextInt();
		pet = pet_list.get(choose - 1);//��Ҫ�����ĳ������
		System.out.println("��ѡ�����������˵����:");
		System.out.println("���\t����");
		List<PetOwner> petOwnerList = petOwnerDao.petOwnerList();
		for(int i = 0; i < petOwnerList.size(); i++) {
			System.out.println((i + 1) + "\t" + petOwnerList.get(i).getName());
		}
		int choose_u = scanner.nextInt();
		PetOwner petOwner = petOwnerList.get(choose_u - 1);//�����ĳ�������
		pet.setOwner_id(petOwner.getId());
		pet.setStore_id(0);
//		pet.setType_name("0");
		Integer result1 = petDao.updatePet(pet);
		if(result1 > 0) {
			System.out.println("���³�����Ϣ�ɹ�");
		}else {
			System.out.println("���³�����Ϣʧ��");
		}
		
		petOwner.setMoney(petOwner.getMoney() + pet.getPrice());
		Integer result2 = petOwnerDao.updatePetOwner(petOwner);
		if(result2 > 0) {
			System.out.println("����������Ϣ�ɹ�");
		}else {
			System.out.println("����������Ϣʧ��");
		}
		
		petStore.setBalance(petStore.getBalance() - pet.getPrice());
		int result3 = petStoreDao.updatePetStore(petStore);
		if(result3 > 0) {
			System.out.println("�����̵���Ϣ�ɹ�");
		}else {
			System.out.println("�����̵���Ϣʧ��");
		}
		
		Account account = new Account();
//		account.setDeal_type(1);
		account.setPet_id(pet.getId());
		account.setSeller_id(petStore.getId());
		account.setBuyer_id(petOwner.getId());
		account.setPrice(pet.getPrice());
		account.setDeal_time(new Date());
		int result4 = accountDao.addAccount(account);
		if(result4 > 0) {
			System.out.println("����˵���Ϣ�ɹ�");
		}else {
			System.out.println("����˵���Ϣʧ��");
		}
	}

	/**
	 * �̵�������
	 */
	@Override
	public void petStore_seller_pet(PetStore petStore) {
		// TODO Auto-generated method stub
		List<Pet> pet_list = petDao.pets_old_is_store();
		PetService petService = new PetServiceImpl();
		petService.show_pet_old(pet_list);
		System.out.println("��������������id:");
		int choose = scanner.nextInt();
		Pet pet = pet_list.get(choose - 1);//��Ҫ�����ĳ������
		System.out.println("��ѡ�����������˵����:");
		System.out.println("���\t����");
		List<PetOwner> petOwnerList = petOwnerDao.petOwnerList();
		for(int i = 0; i < petOwnerList.size(); i++) {
			System.out.println((i + 1) + "\t" + petOwnerList.get(i).getName());
		}
		int choose_u = scanner.nextInt();
		PetOwner petOwner = petOwnerList.get(choose_u - 1);//�����ĳ�������
		pet.setOwner_id(petOwner.getId());
		pet.setStore_id(0);
//		pet.setType_name("0");
		Integer result1 = petDao.updatePet(pet);
		if(result1 > 0) {
			System.out.println("���³�����Ϣ�ɹ�");
		}else {
			System.out.println("���³�����Ϣʧ��");
		}
		
		petOwner.setMoney(petOwner.getMoney() + pet.getPrice());
		Integer result2 = petOwnerDao.updatePetOwner(petOwner);
		if(result2 > 0) {
			System.out.println("����������Ϣ�ɹ�");
		}else {
			System.out.println("����������Ϣʧ��");
		}
		
		petStore.setBalance(petStore.getBalance() - pet.getPrice());
		int result3 = petStoreDao.updatePetStore(petStore);
		if(result3 > 0) {
			System.out.println("�����̵���Ϣ�ɹ�");
		}else {
			System.out.println("�����̵���Ϣʧ��");
		}
		
		Account account = new Account();
		account.setDeal_type(1);
		account.setPet_id(pet.getId());
		account.setSeller_id(petStore.getId());
		account.setBuyer_id(petOwner.getId());
		account.setPrice(pet.getPrice());
		account.setDeal_time(new Date());
		int result4 = accountDao.addAccount(account);
		if(result4 > 0) {
			System.out.println("����˵���Ϣ�ɹ�");
		}else {
			System.out.println("����˵���Ϣʧ��");
		}
		
	}
	
}
