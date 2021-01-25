package cn.kgc.dao;

import java.util.List;

import cn.kgc.entity.PetOwner;
import cn.kgc.entity.PetStore;
/**
 * 宠物商店dao接口
 * @author Administrator
 *
 */
public interface PetStoreDao {
	//查询全部商店
	List<PetStore> petStoresList();
	//根据id查询商店
	public PetStore getPetStoreById(Integer id);
	//添加商店
	public Integer addPetStore(PetStore petStore);
	//修改商店信息
	public Integer updatePetStore(PetStore petStore);
	//删除商店信息
	public Integer deletePetStore(Integer id);
	//商店登陆
	public PetStore login(String name, String password);
	
	public PetStore getPetStoreByName(String name);
}
