package cn.kgc.dao;

import java.util.List;

import cn.kgc.entity.PetOwner;
import cn.kgc.entity.PetStore;
/**
 * �����̵�dao�ӿ�
 * @author Administrator
 *
 */
public interface PetStoreDao {
	//��ѯȫ���̵�
	List<PetStore> petStoresList();
	//����id��ѯ�̵�
	public PetStore getPetStoreById(Integer id);
	//����̵�
	public Integer addPetStore(PetStore petStore);
	//�޸��̵���Ϣ
	public Integer updatePetStore(PetStore petStore);
	//ɾ���̵���Ϣ
	public Integer deletePetStore(Integer id);
	//�̵��½
	public PetStore login(String name, String password);
	
	public PetStore getPetStoreByName(String name);
}
