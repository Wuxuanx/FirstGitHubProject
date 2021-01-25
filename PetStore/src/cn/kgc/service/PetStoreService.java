package cn.kgc.service;

import cn.kgc.entity.Pet;
import cn.kgc.entity.PetOwner;
import cn.kgc.entity.PetStore;

public interface PetStoreService {
	PetStore login(String name, String password);

	public void petStore_buy_pet(PetStore petStore);
	
	public void petStore_seller_pet(PetStore petStore);
}
