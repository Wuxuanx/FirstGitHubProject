package cn.kgc.dao;

import java.util.List;

import cn.kgc.entity.PetOwner;
/**
 * 宠物主人Dao接口
 * @author Administrator
 *
 */
public interface PetOwnerDao {	
	//查询全部主人信息
	List<PetOwner> petOwnerList();
	//根据id查询主人信息
	public PetOwner getPetOwnerById(Integer id);
	//添加主人信息
	public Integer addPetOwner(PetOwner petOwner);
	//删除主人信息
	public Integer deletPetOwner(Integer id);
	//修改主人信息
	public Integer updatePetOwner(PetOwner petOwner);
	//主人登陆
	public PetOwner getPetOwnerByName(String name);
	public PetOwner login(String name, String password);
}
