package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Pet;

public interface PetService {
	//�������
	public void ownerBuy();
	
	//��������
	public void ownerSeller();
	
	//��������ʾ
	public void show_pet_old(List<Pet> petList);
	
	//������������ʾ
	public void show_pet_new(List<Pet> petList);
}
