package cn.kgc.service.Impl;

import java.util.List;

import cn.kgc.entity.Pet;
import cn.kgc.service.PetService;

public class PetServiceImpl implements PetService {

	@Override
	public void ownerBuy() {
		// TODO Auto-generated method stub
		System.out.println("�����빺�����id��");
	}

	@Override
	public void ownerSeller() {
		// TODO Auto-generated method stub
		System.out.println("��������������id��");
	}

	@Override
	public void show_pet_old(List<Pet> petList) {
		// TODO Auto-generated method stub
		System.out.println("��������Ϣ���£�");
		System.out.println("id\t����\t����\tԪ����");
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
		System.out.println("��������Ϣ���£�");
		System.out.println("id\t����\t����\tԪ����");
		for(int i = 0; i < petList.size(); i++) {
			System.out.println((i+ 1) +"\t" + petList.get(i).getName() + "\t" + 
					petList.get(i).getType_name() + "\t" + petList.get(i).getPrice());
		}
	}

}
