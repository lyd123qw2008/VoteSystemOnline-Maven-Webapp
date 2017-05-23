package com.gdpu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdpu.entity.Admin;
import com.gdpu.service.AdminService;
import com.gdpu.util.CryptographyUtil;
import com.gdpu.util.ResponseUtil;


/**
 * admin Controller层
 * @author lyd
 *
 */
@Controller
@RequestMapping("/admins")
public class AdminController {

	@Resource
	private AdminService adminService;
	
	/**
	 * 用户登录
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(Admin admin,HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(admin.getUserName(), CryptographyUtil.md5(admin.getPassword(), "gdpu"));
		try{
			subject.login(token); // 登录验证
			HttpSession httpSession =request.getSession();
			httpSession.setAttribute("admin", admin);
			return "/admin/main";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("admin", admin);
			request.setAttribute("errorInfo", "用户名或密码错误！");
			return "login";
		}
	}
	/**
	 * 修改管理员密码
	 * @param newPassword
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/modifyPassword")
	public String modifyPassword(String newPassword,Integer adminId,HttpServletResponse response)throws Exception{
		Admin admin=new Admin();
		admin.setAdminId(adminId);
		admin.setPassword(CryptographyUtil.md5(newPassword, "gdpu"));
		int resultTotal=adminService.changepwd(admin);
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 注销
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String  logout()throws Exception{
		SecurityUtils.getSubject().logout();
		return "redirect:/login.jsp";
	}
}
