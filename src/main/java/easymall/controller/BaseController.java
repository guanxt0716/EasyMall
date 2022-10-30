package easymall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import easymall.exception.UserLoginNoexception;
@Controller
public class BaseController {
	@ModelAttribute
	public void isLogin(HttpSession session,HttpServletRequest request) throws UserLoginNoexception {
		if (session.getAttribute("user")==null) {
			throw new UserLoginNoexception("请先登录");
		}
	}
}
