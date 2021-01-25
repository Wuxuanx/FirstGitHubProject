package cn.kgc.dao;

import java.util.List;

import cn.kgc.entity.Pet;
/**
 * ����dao�ӿ�
 * @author Administrator
 *
 */
import cn.kgc.entity.PetOwner;
public interface PetDao {
	//��ѯȫ������
	List<Pet> getAllPets();
	//����id��ѯ����
	public Pet getPetById(Integer id);
	//��ӳ�����Ϣ
	public Integer addPet(Pet pet);
	//�޸ĳ���
	public Integer updatePet(Pet pet);
	//ɾ��������Ϣ
	public Integer deletePet(Integer id);
	//�����û����Ʋ�ѯ�û���Ϣ
	public PetOwner getPetOwnerById(String name, String password);
	
	//��ȡ��������Ϣ[����]
	public List<Pet> pets_old();
	
	//��ȡ������������Ϣ[����]
	public List<Pet> pets_new();
	
	//��������������Ϣ[��������]
	public Integer updatePet_seller_by_owner(Pet pet);
	//�̵�����
	public Integer updatePet_seller_by_store(Pet pet);
	
	//��������������Ϣ[��������]
	public Integer updatePet_buy_by_owner(Pet pet);
	//�̵�����
	public Integer updatePet_buy_by_store(Pet pet);
	
	//��ȡ��������Ϣ[�Ǳ������̵�]
	public List<Pet> pets_old_store();
	
	//��ȡ���̵������Ϣ
	public List<Pet> pets_old_is_store();
	
}
