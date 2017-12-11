package br.com.fiap.netgifx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fiap.netgifx.dao.GenericDAO;
import br.com.fiap.netgifx.entity.User;
import br.com.fiap.netgifx.enums.ReturnType;

@Controller
public class UserRegisterController {

	@RequestMapping(value = {"userRegister","register"})
	public String openPag(){
		return "userRegister";
	}
	
	@RequestMapping("searchUser")
	public String search(String email, Model m, HttpServletRequest req, HttpServletResponse res){
		try {
			User user = (User) req.getSession().getAttribute("user");
			if (!user.getIsAdmin() || email.isEmpty())
				return "userRegister";
			
			req.setAttribute("user", new GenericDAO<User>(User.class).find("select u from User u where u.email = ?", email));
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return "userRegister";
	}
	
	@ResponseBody
	@RequestMapping("saveUser")
	public ReturnType save(User user){
		if (user.getEmail().isEmpty() || user.getPassword().isEmpty() || user.getName().isEmpty()) 
			return ReturnType.FILL_PROBLEM;
		
		if (user.getId() != 0) 
			return new GenericDAO<User>(User.class).update(user) ? ReturnType.SUCCESS : ReturnType.ERROR;
		else
			return new GenericDAO<User>(User.class).save(user) ? ReturnType.SUCCESS : ReturnType.ERROR;
	}
	
	@ResponseBody
	@RequestMapping("deleteUser")
	public ReturnType delete(User user){
		return new GenericDAO<User>(User.class).delete(user) ? ReturnType.SUCCESS : ReturnType.ERROR;
	}
	
}
