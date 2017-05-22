package com.gdpu.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.gdpu.entity.Admin;
import com.gdpu.service.AdminService;


/**
 * �Զ���Realm
 * @author java1234_С��
 *
 */
public class MyRealm extends AuthorizingRealm{

	@Resource
	private AdminService adminService;
	
	/**
	 * Ϊ����ǰ��¼���û������ɫ��Ȩ
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * ��֤��ǰ��¼���û�
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String)token.getPrincipal();
		List<Admin> list=adminService.findAdminByName(userName);
		Admin admin = null;
		if(list.size()>0){
			admin =list.get(0);
		}	
		if(admin!=null){
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", admin); // ��ǰ�û���Ϣ�浽session��
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(admin.getUserName(),admin.getPassword(),"xx");
			return authcInfo;
		}else{
			return null;				
		}
	}

}
