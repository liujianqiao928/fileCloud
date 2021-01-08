package com.custchina.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.custchina.pojo.User;
import com.custchina.service.impl.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService us;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("usercode")String usercode,@RequestParam("password")String password, Model model, 
                                                          HttpSession session) {
		// 通过账号和密码查询用户
		User user = us.findUser(usercode, password);
		if(user != null){		
			// 将用户对象添加到Session
			session.setAttribute("USER_SESSION", user);
			// 跳转到主页面
//			return "customer";
			return "/main";
		}
		model.addAttribute("msg", "账号或密码错误，请重新输入！");
         // 返回到登录页面
		return "/index";
	}
	
	
	//注册
	@RequestMapping(value="/register.do" ,method=RequestMethod.POST)

	public String  register(Model model, @RequestParam("usercode") String usercode,@RequestParam("email") String email,
			@RequestParam("password") String password,@RequestParam("state") Integer state){
		User user = new User();
		user.setUser_code(usercode);
		user.setUser_email(email);
		user.setUser_password(password);
		user.setUser_state(state);
		if (usercode.length()>6 && password.length()>5){
			us.addUser(usercode,email,password,state);
			model.addAttribute("msg","注册成功请登录");
			return "/index";
		}
		model.addAttribute("msg","注册失败,请重新注册");
		return "/index";
     }
	//修改密码
	@RequestMapping(value="/update.do" , method=RequestMethod.POST)
	public String update(@RequestParam("usercode") String usercode,@RequestParam("password") String password){
		
		us.updateUser(usercode, password);
		return "/main";
	}

	
}
