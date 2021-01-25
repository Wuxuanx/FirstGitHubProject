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
 * 程序主题运行类
 * @author Administrator
 *
 */
public class TestMain{
	
	public static PetOwner petOwner = null;
	public static PetStore petStore = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 常用参数
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
		
		Boolean flag = true;//菜单循环判定
		Boolean flag_login = false;//登陆是否成功判定
		Boolean flag_login_again = false;//判定是否再次登陆
		Scanner scanner = new Scanner(System.in);
		
		
		
		/**
		 * 显示登陆的初始菜单
		 */
		ManageView manageView = new ManageView();
		manageView.menu();//菜单显示
		manageView.login();//用户登陆
		if(TestMain.petOwner != null) {
			int choose = scanner.nextInt();
			while(true) {
				if(choose == 1) {
					petOwnerService.petOwner_buy_pet(TestMain.petOwner);//主人买入宠物
					break;
				}else if(choose == 2) {
					petOwnerService.petOwner_seller_pet(TestMain.petOwner);//主人卖出宠物
					break;
				}else {
					System.out.println("输入信息有误");
					continue;
				}
			}
		}else {
			int choose = scanner.nextInt();
			while(true) {
				if(choose == 1) {
					petStoreService.petStore_buy_pet(TestMain.petStore);//商店买入宠物
					break;
				}else if(choose == 2) {
					petStoreService.petStore_seller_pet(TestMain.petStore);//商店卖出宠物
					break;
				}else {
					System.out.println("输入信息有误");
					continue;
				}
			}
		}
	
		
		
		
	
		
//		System.out.println("请选择您的登录身份,宠物主人请输入1, 宠物商店主人请输入2:");
//		int choose = scanner.nextInt();
//		if(choose == 1) {
		
//			System.out.println("请输入您的姓名:");
//			String name = scanner.next();
//			System.out.println("请输入您的密码:");
//			String password = scanner.next();
////			PetOwner petOwner = petOwnerServiceImpl.login(name, password);
//			PetOwner petOwner = petOwnerService.login(name, password);
//			if(petOwner != null) {
//				System.out.println("登陆成功!");
//				System.out.println("欢迎您:" + petOwner.getName());
//			}else {
//				System.out.println("登录失败!");
//			}
//		}else if(choose == 2){ 
//			
//		}
		
		
			
			
			
			
			
			
			
			
			
			
			
			
		
		
	}

}
