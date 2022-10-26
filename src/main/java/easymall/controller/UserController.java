package easymall.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import easymall.service.UserService;
import easymall.po.User;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String login(User user, HttpSession session,Model model) {
		User user1 = userService.login(user.getUsername());
		if (user1==null) {
			model.addAttribute("message", "��������û���������");
			return "login";
		}else if (user1.getPassword().equals(user.getPassword())) {
			session.setAttribute("user", user1);
			return "redirect:/index.jsp";
		}
		else {
			model.addAttribute("message","��������������");
			return "login";
		}
		
	}
	@RequestMapping("/checkUser")
	public void checkUser(String username,HttpServletResponse response) throws IOException{
		if (userService.login(username)==null) {
			response.getWriter().print("��ϲ�����û�������ʹ�ã�");
		}
		else {
			response.getWriter().print("�û����ѱ�ʹ��");
		}
	}
	@RequestMapping("/regist")
	public String regist(User user,String valistr,HttpSession session, Model model) {
		if ("".equals(user.getUsername()) || user.getUsername()==null) {
			model.addAttribute("msg","�û�������Ϊ��");
			return "regist";
		}
		if ("".equals(user.getPassword()) || user.getPassword()==null) {
			model.addAttribute("msg","���벻��Ϊ��");
			return "regist";
		}
		if ("".equals(valistr) || valistr==null)  {
			model.addAttribute("msg","��֤�벻��Ϊ��");
		}
		if (!valistr.equalsIgnoreCase(session.getAttribute("code").toString())) {
			model.addAttribute("msg","��֤�벻һ��");
		}
		if (userService.login(user.getUsername())!=null) {
			model.addAttribute("msg","�����ظ�ע��");
		}
		if (userService.regist(user)>0) {
			model.addAttribute("msg","ע��ɹ�");
			return "regist";
		}else {
			model.addAttribute("msg","ע��ʧ�ܣ�");
			return "regist";
		}
	}
}
