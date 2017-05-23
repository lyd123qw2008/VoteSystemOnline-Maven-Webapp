package com.gdpu.dao;

import java.util.List;
import java.util.Map;

import com.gdpu.entity.Admin;



public interface AdminDao {
	/**
	 * ��������Admin��Ϣ
	 * 
	 * @return Admin��List���ͣ�
	 */
	public List<Admin> findAll();

	/**
	 * ���ӹ���Ա
	 * 
	 * @param admin
	 *            ����Ա��Ϣ
	 */
	public void addAdmin(Admin admin);

	/**
	 * ͨ���û�����������ҹ���Ա
	 * 
	 * @param password
	 *            ����
	 * @return Admin��Admin���ͣ�
	 */
	public Admin findAdmin(Map<String,Object> map);

	/**
	 * �޸�����
	 * 
	 * @param admin
	 *            ����Ա��Ϣ
	 * @return 
	 */
	public Integer changepwd(Admin admin);

	/**
	 * �޸ĵ�¼ʱ��
	 * 
	 * @param admin
	 *            ����Ա��Ϣ
	 */
	public void updatelogintime(Admin admin);

	/**
	 * ͨ��Id���ҹ���Ա
	 * 
	 * @param adminId
	 *            ����ԱId
	 * @return Admin��Admin���ͣ�
	 */
	public Admin findNameById(Integer adminId);

	/**
	 * ͨ������Ա�û������ҹ���Ա
	 * 
	 * @param name
	 *            ����Ա�û���
	 * @return admin(Admin����)
	 */
	public List<Admin> findAdminByName(String name);
}
