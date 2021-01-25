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
 * 菜单显示
 * @author Administrator
 *
 */
public class ManageView {
	/**
	 * 数据库接口以及常用变量
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
		System.out.println("===========欢迎使用宠物管理系统===========");
		System.out.println();
		
		System.out.println("宠物信息如下:");
		System.out.println("====================================");
		System.out.println("序号\t宠物名称");
		List<Pet> petList = petDao.getAllPets();
		for(Pet pet : petList) {
			System.out.println(pet.getId() + "\t" + pet.getName());
		}
		System.out.println("====================================");
		
		System.out.println("宠物主人信息如下:");
		System.out.println("====================================");
		System.out.println("序号\t主人姓名");
		List<PetOwner> petOwnerList = petOwnerDao.petOwnerList();
		for(PetOwner petOwner : petOwnerList) {
			System.out.println(petOwner.getId() + "\t" + petOwner.getName());
		}
		System.out.println("====================================");
		
		System.out.println("宠物商店信息如下:");
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
			 * 用户选择登陆方式
			 */
			while(true) {
				System.out.println("请选择登陆方式,输入1为宠物主人登陆,输入2为宠物商店登陆");
				int choose = scanner.nextInt();
				switch(choose) {
				case 1:
					PetOwner petOwner = null;
					while(!flag_login && !flag_login_again) {
						System.out.println("请输入您的账号:");
						String name = scanner.next();
						System.out.println("请输入您的密码:");
						String password = scanner.next();
						petOwner = petOwnerDao.login(name, password);
						if(petOwner != null){
							flag_login = true;
						}else {
							System.out.println("账号密码有误");
							System.out.println("请问是否再次尝试登陆?是请输入Y,否请输入N");
							String choose1 = scanner.next();
							if(choose1.equals("N") || choose1.equals("n")) {
								flag_login_again = true;
							}
						}
						continue;		
					}
					if(flag_login) {
						TestMain.petOwner = petOwner;
						System.out.println("登陆成功!欢迎您:" + petOwner.getName());
						System.out.println("您的基本信息如下:");
						System.out.println("名字:" + petOwner.getName());
						System.out.println("元宝数:" + petOwner.getMoney());
						System.out.println("您可以购买和卖出宠物,若想购买宠物请输入1,若需卖出宠物请输入2");
						System.out.println("1: 购买宠物\n2: 卖出宠物");
					}
					break;
			
				case 2:
					PetStore petStore = null;
					PetStoreDao petStoreDao = new PetStoreDaoImpl();
					while(!flag_login && !flag_login_again) {
						System.out.println("请输入您的账号:");
						String name = scanner.next();
						System.out.println("请输入您的密码:");
						String password = scanner.next();
						petStore = petStoreDao.login(name, password);
						if(petStore != null){
							flag_login = true;
						}else {
							System.out.println("账号密码有误");
							System.out.println("请问是否再次尝试登陆?是请输入Y,否请输入N");
							String choose1 = scanner.next();
							if(choose1.equals("N") || choose1.equals("n")) {
								flag_login_again = true;
							}
						}
						continue;		
					}
					if(flag_login) {
						TestMain.petStore = petStore;
						System.out.println("登陆成功!欢迎您:" + petStore.getName());
						System.out.println("您的基本信息如下:");
						System.out.println("名字:" + petStore.getName());
						System.out.println("元宝数:" + petStore.getBalance());
						System.out.println("您可以购买和卖出宠物,若想购买宠物请输入1,若需卖出宠物请输入2");
						System.out.println("1: 购买宠物\n2: 卖出宠物");
					}
					break;
				default :
					System.out.println("输入有误,请重新输入!");
					continue;
				}
				break;
			}
		break;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
