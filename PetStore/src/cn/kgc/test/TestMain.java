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
import cn.kgc.service.PetOwnerService;
import cn.kgc.service.PetStoreService;
import cn.kgc.service.Impl.PetOwnerServiceImpl;
import cn.kgc.service.Impl.PetStoreServiceImpl;
import cn.kgc.utils.Utils;
/**
 * ��������������
 * @author Administrator
 *
 */
public class TestMain{
	
	public static PetOwner petOwner = null;
	public static PetStore petStore = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ���ò���
		 */
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Integer result = -1;
		PetStoreDao petStoreDao = new PetStoreDaoImpl();
		PetOwnerDao petOwnerDao = new PetOwnerDaoImpl();
		AccountDao accountDao = new AccountDaoImpl();
		PetDao petDao = new PetDaoImpl();
		PetOwnerService petOwnerService = new PetOwnerServiceImpl();
		PetStoreService petStoreService = new PetStoreServiceImpl();
		
		Boolean flag = true;//�˵�ѭ���ж�
		Boolean flag_login = false;//��½�Ƿ�ɹ��ж�
		Boolean flag_login_again = false;//�ж��Ƿ��ٴε�½
		Scanner scanner = new Scanner(System.in);
		
		
		
		/**
		 * ��ʾ��½�ĳ�ʼ�˵�
		 */
		ManageView manageView = new ManageView();
		manageView.menu();//�˵���ʾ
		manageView.login();//�û���½
		if(TestMain.petOwner != null) {
			int choose = scanner.nextInt();
			while(true) {
				if(choose == 1) {
					petOwnerService.petOwner_buy_pet(TestMain.petOwner);//�����������
					break;
				}else if(choose == 2) {
					petOwnerService.petOwner_seller_pet(TestMain.petOwner);//������������
					break;
				}else {
					System.out.println("������Ϣ����");
					continue;
				}
			}
		}else {
			int choose = scanner.nextInt();
			while(true) {
				if(choose == 1) {
					petStoreService.petStore_buy_pet(TestMain.petStore);//�̵��������
					break;
				}else if(choose == 2) {
					petStoreService.petStore_seller_pet(TestMain.petStore);//�̵���������
					break;
				}else {
					System.out.println("������Ϣ����");
					continue;
				}
			}
		}
	
		
		
		
	
		
//		System.out.println("��ѡ�����ĵ�¼���,��������������1, �����̵�����������2:");
//		int choose = scanner.nextInt();
//		if(choose == 1) {
		
//			System.out.println("��������������:");
//			String name = scanner.next();
//			System.out.println("��������������:");
//			String password = scanner.next();
////			PetOwner petOwner = petOwnerServiceImpl.login(name, password);
//			PetOwner petOwner = petOwnerService.login(name, password);
//			if(petOwner != null) {
//				System.out.println("��½�ɹ�!");
//				System.out.println("��ӭ��:" + petOwner.getName());
//			}else {
//				System.out.println("��¼ʧ��!");
//			}
//		}else if(choose == 2){ 
//			
//		}
		
		
			
			
			
			
			
			
			
			
			
			
			
			
		
		
	}

}
