package cn.kgc.service;

import java.util.List;

import cn.kgc.entity.Pet;

public interface PetService {
	//购买宠物
	public void ownerBuy();
	
	//卖出宠物
	public void ownerSeller();
	
	//库存宠物显示
	public void show_pet_old(List<Pet> petList);
	
	//新培育宠物显示
	public void show_pet_new(List<Pet> petList);
}
