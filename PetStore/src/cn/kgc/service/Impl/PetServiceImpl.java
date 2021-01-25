package cn.kgc.service.Impl;

import java.util.List;

import cn.kgc.entity.Pet;
import cn.kgc.service.PetService;

public class PetServiceImpl implements PetService {

	@Override
	public void ownerBuy() {
		// TODO Auto-generated method stub
		System.out.println("请输入购买宠物id：");
	}

	@Override
	public void ownerSeller() {
		// TODO Auto-generated method stub
		System.out.println("请输入卖出宠物id：");
	}

	@Override
	public void show_pet_old(List<Pet> petList) {
		// TODO Auto-generated method stub
		System.out.println("库存宠物信息如下：");
		System.out.println("id\t名称\t类型\t元宝数");
		for(int i = 0; i < petList.size(); i++) {
			System.out.println((i+ 1) + "\t" + petList.get(i).getName() + "\t" + 
					petList.get(i).getType_name() + "\t" + petList.get(i).getPrice());
		}
//		for(Pet pet : petList) {
//			System.out.println(pet.getId()+ "\t" + pet.getName() + "\t" + 
//					pet.getType_name() + "\t" + pet.getPrice());
//		}
	}

	@Override
	public void show_pet_new(List<Pet> petList) {
		// TODO Auto-generated method stub
		System.out.println("库存宠物信息如下：");
		System.out.println("id\t名称\t类型\t元宝数");
		for(int i = 0; i < petList.size(); i++) {
			System.out.println((i+ 1) +"\t" + petList.get(i).getName() + "\t" + 
					petList.get(i).getType_name() + "\t" + petList.get(i).getPrice());
		}
	}

}
