package cn.kgc.dao;

import java.util.List;

import cn.kgc.entity.PetOwner;
/**
 * ��������Dao�ӿ�
 * @author Administrator
 *
 */
public interface PetOwnerDao {	
	//��ѯȫ��������Ϣ
	List<PetOwner> petOwnerList();
	//����id��ѯ������Ϣ
	public PetOwner getPetOwnerById(Integer id);
	//���������Ϣ
	public Integer addPetOwner(PetOwner petOwner);
	//ɾ��������Ϣ
	public Integer deletPetOwner(Integer id);
	//�޸�������Ϣ
	public Integer updatePetOwner(PetOwner petOwner);
	//���˵�½
	public PetOwner getPetOwnerByName(String name);
	public PetOwner login(String name, String password);
}
