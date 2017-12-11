package br.com.fiap.netgifx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.netgifx.dao.GenericDAO;
import br.com.fiap.netgifx.entity.User;

@Controller
public class LoginController {
	
	@RequestMapping(value={"index", "/"})
	public String index() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST )
	public String login(User user, Model m,HttpServletRequest req) {
		try {
			if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) 
				return "login";
			
			// try to find user in database
			user = new GenericDAO<User>(User.class).find("select u from User u where u.email = ? and u.password = ?", user.getEmail(), user.getPassword());
			
			// if couldnt find user
			if (user == null){
				m.addAttribute("head","Ooops!");
				m.addAttribute("title","Something went wrong ...");
				m.addAttribute("message","We couldn`t find your user in our system.Try to log in again or feel free to create a new free account with us.");
				return "error";
			}
			
			req.getSession().setAttribute("user", user);
			return "home";
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("head","Ooops!");
			m.addAttribute("title","This is so embarrassing... ");
			m.addAttribute("message","Something went wrong with our servers. Please try again in few minutes.");
			return "error";
		}
		
	}

}
