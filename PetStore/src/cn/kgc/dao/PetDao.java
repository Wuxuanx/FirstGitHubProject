package cn.kgc.dao;

import java.util.List;

import cn.kgc.entity.Pet;
/**
 * 宠物dao接口
 * @author Administrator
 *
 */
import cn.kgc.entity.PetOwner;
public interface PetDao {
	//查询全部宠物
	List<Pet> getAllPets();
	//根据id查询宠物
	public Pet getPetById(Integer id);
	//添加宠物信息
	public Integer addPet(Pet pet);
	//修改宠物
	public Integer updatePet(Pet pet);
	//删除宠物信息
	public Integer deletePet(Integer id);
	//根据用户名称查询用户信息
	public PetOwner getPetOwnerById(String name, String password);
	
	//获取库存宠物信息[主人]
	public List<Pet> pets_old();
	
	//获取新培育宠物信息[主人]
	public List<Pet> pets_new();
	
	//更新卖出宠物信息[主人卖出]
	public Integer updatePet_seller_by_owner(Pet pet);
	//商店卖出
	public Integer updatePet_seller_by_store(Pet pet);
	
	//更新卖出宠物信息[主人买入]
	public Integer updatePet_buy_by_owner(Pet pet);
	//商店买入
	public Integer updatePet_buy_by_store(Pet pet);
	
	//获取库存宠物信息[非本宠物商店]
	public List<Pet> pets_old_store();
	
	//获取本商店宠物信息
	public List<Pet> pets_old_is_store();
	
}
