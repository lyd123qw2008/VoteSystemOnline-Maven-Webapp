package com.gdpu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gdpu.entity.Admin;
import com.gdpu.service.AdminService;
import com.gdpu.util.CryptographyUtil;


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
			System.out.println(httpSession.getAttribute("currentUser"));
			httpSession.setAttribute("admin", admin);
			System.out.println(httpSession.getAttribute("admin"));
			return "forward:/admin/main.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("admin", admin);
			request.setAttribute("errorInfo", "用户名或密码错误！");
			return "login";
		}
	}
	
	/**
	 * 查找博主信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/aboutMe")
	public ModelAndView aboutMe()throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.addObject("admin",adminService.findAll());
		mav.addObject("mainPage", "foreground/blogger/info.jsp");
		mav.addObject("pageTitle","关于博主_Java开源博客系统");
		mav.setViewName("mainTemp");
		return mav;
	}
}
