package com.gdpu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.gdpu.dao.AdminDao;
import com.gdpu.entity.Admin;
import com.gdpu.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public List<Admin> findAll() {
		List<Admin> list = adminDao.findAll();
		return list;
	}

	public void addAdmin(Admin admin) {
		adminDao.addAdmin(admin);
	}

	public Admin findAdmin(String userName, String password) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("password", password);
		return adminDao.findAdmin(map);
	}

	public void changepwd(Admin admin) {
		adminDao.changepwd(admin);
	}

	public void updatelogintime(Admin admin) {
		adminDao.updatelogintime(admin);
	}

	public Admin findNameById(Integer adminId) {
		return adminDao.findNameById(adminId);
	}

	public List<Admin> findAdminByName(String userName) {
		return adminDao.findAdminByName(userName);
	}

}
