package easymall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("indexController")
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/regist")
	public String register() {
		return "regist";
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
}
