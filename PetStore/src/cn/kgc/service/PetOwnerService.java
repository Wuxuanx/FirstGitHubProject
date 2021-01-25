package cn.kgc.service;

import cn.kgc.entity.Pet;
import cn.kgc.entity.PetOwner;

public interface PetOwnerService {
	PetOwner login(String name,String password);
	
	public void petOwner_buy_pet(PetOwner petOwner);
	
	public void petOwner_seller_pet(PetOwner petOwner);
}
