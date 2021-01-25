package cn.kgc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import cn.kgc.entity.Pet;
import cn.kgc.entity.PetOwner;
import cn.kgc.entity.PetStore;
/**
 * �˵���ʾ
 * @author Administrator
 *
 */
public class ManageView {
	/**
	 * ���ݿ�ӿ��Լ����ñ���
	 */
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Integer result = -1;
	PetStoreDao petStoreDao = new PetStoreDaoImpl();
	PetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
	AccountDao accountDao = new AccountDaoImpl();
	PetDao petDao = new PetDaoImpl();
	Boolean flag = true;
	
	public void menu() {
		System.out.println("===========��ӭʹ�ó������ϵͳ===========");
		System.out.println();
		
		System.out.println("������Ϣ����:");
		System.out.println("====================================");
		System.out.println("���\t��������");
		List<Pet> petList = petDao.getAllPets();
		for(Pet pet : petList) {
			System.out.println(pet.getId() + "\t" + pet.getName());
		}
		System.out.println("====================================");
		
		System.out.println("����������Ϣ����:");
		System.out.println("====================================");
		System.out.println("���\t��������");
		List<PetOwner> petOwnerList = petOwnerDao.petOwnerList();
		for(PetOwner petOwner : petOwnerList) {
			System.out.println(petOwner.getId() + "\t" + petOwner.getName());
		}
		System.out.println("====================================");
		
		System.out.println("�����̵���Ϣ����:");
		System.out.println("====================================");
		List<PetStore> petStoreList = petStoreDao.petStoresList();
		for(PetStore petStore : petStoreList) {
			System.out.println(petStore.getId() + "\t" + petStore.getName());
		}
		System.out.println("====================================");
	}
	
	public void login() {
		Scanner scanner = new Scanner(System.in);
		Boolean flag_login = false;
		Boolean flag_login_again = false;
		while(flag) {
			/**
			 * �û�ѡ���½��ʽ
			 */
			while(true) {
				System.out.println("��ѡ���½��ʽ,����1Ϊ�������˵�½,����2Ϊ�����̵��½");
				int choose = scanner.nextInt();
				switch(choose) {
				case 1:
					PetOwner petOwner = null;
					while(!flag_login && !flag_login_again) {
						System.out.println("�����������˺�:");
						String name = scanner.next();
						System.out.println("��������������:");
						String password = scanner.next();
						petOwner = petOwnerDao.login(name, password);
						if(petOwner != null){
							flag_login = true;
						}else {
							System.out.println("�˺���������");
							System.out.println("�����Ƿ��ٴγ��Ե�½?��������Y,��������N");
							String choose1 = scanner.next();
							if(choose1.equals("N") || choose1.equals("n")) {
								flag_login_again = true;
							}
						}
						continue;		
					}
					if(flag_login) {
						TestMain.petOwner = petOwner;
						System.out.println("��½�ɹ�!��ӭ��:" + petOwner.getName());
						System.out.println("���Ļ�����Ϣ����:");
						System.out.println("����:" + petOwner.getName());
						System.out.println("Ԫ����:" + petOwner.getMoney());
						System.out.println("�����Թ������������,���빺�����������1,������������������2");
						System.out.println("1: �������\n2: ��������");
					}
					break;
			
				case 2:
					PetStore petStore = null;
					PetStoreDao petStoreDao = new PetStoreDaoImpl();
					while(!flag_login && !flag_login_again) {
						System.out.println("�����������˺�:");
						String name = scanner.next();
						System.out.println("��������������:");
						String password = scanner.next();
						petStore = petStoreDao.login(name, password);
						if(petStore != null){
							flag_login = true;
						}else {
							System.out.println("�˺���������");
							System.out.println("�����Ƿ��ٴγ��Ե�½?��������Y,��������N");
							String choose1 = scanner.next();
							if(choose1.equals("N") || choose1.equals("n")) {
								flag_login_again = true;
							}
						}
						continue;		
					}
					if(flag_login) {
						TestMain.petStore = petStore;
						System.out.println("��½�ɹ�!��ӭ��:" + petStore.getName());
						System.out.println("���Ļ�����Ϣ����:");
						System.out.println("����:" + petStore.getName());
						System.out.println("Ԫ����:" + petStore.getBalance());
						System.out.println("�����Թ������������,���빺�����������1,������������������2");
						System.out.println("1: �������\n2: ��������");
					}
					break;
				default :
					System.out.println("��������,����������!");
					continue;
				}
				break;
			}
		break;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
