package com.gdpu.dao;

import java.util.List;
import java.util.Map;

import com.gdpu.entity.Admin;



public interface AdminDao {
	/**
	 * 查找所有Admin信息
	 * 
	 * @return Admin（List类型）
	 */
	public List<Admin> findAll();

	/**
	 * 增加管理员
	 * 
	 * @param admin
	 *            管理员信息
	 */
	public void addAdmin(Admin admin);

	/**
	 * 通过用户名，密码查找管理员
	 * 
	 * @param password
	 *            密码
	 * @return Admin（Admin类型）
	 */
	public Admin findAdmin(Map<String,Object> map);

	/**
	 * 修改密码
	 * 
	 * @param admin
	 *            管理员信息
	 * @return 
	 */
	public Integer changepwd(Admin admin);

	/**
	 * 修改登录时间
	 * 
	 * @param admin
	 *            管理员信息
	 */
	public void updatelogintime(Admin admin);

	/**
	 * 通过Id查找管理员
	 * 
	 * @param adminId
	 *            管理员Id
	 * @return Admin（Admin类型）
	 */
	public Admin findNameById(Integer adminId);

	/**
	 * 通过管理员用户名查找管理员
	 * 
	 * @param name
	 *            管理员用户名
	 * @return admin(Admin类型)
	 */
	public List<Admin> findAdminByName(String name);
}
