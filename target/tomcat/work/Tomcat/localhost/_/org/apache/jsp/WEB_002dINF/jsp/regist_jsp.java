/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-10-26 06:40:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class regist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>欢迎注册EasyMall</title>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/regist.css\"/>\r\n");
      out.write("\t\t<script  type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.4.2.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\t/* 点击图片换一张验证码  */\r\n");
      out.write("\t\t\t//浏览器只要发现图片的src地址变化，图片就会变化。\r\n");
      out.write("\t\t\t$(function(){\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#img\").click(function(){\r\n");
      out.write("\t\t\t\t\t$(this).attr(\"src\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/index/valiImage?time=\"+new Date().getTime());\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//给所有输入框添加失去输入焦点的事件  当失去输入焦点时检查输入是否为空或者两次密码是否一致，或者邮箱格式是否正确。\r\n");
      out.write("\t\t\t\t$(\"input[name='username']\").blur(function(){\r\n");
      out.write("\t\t\t\t\tif(!formobj.checkNull(\"username\", \"用户名不能为空！\")){\r\n");
      out.write("\t\t\t\t\t\treturn false;\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tvar url=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/checkUser\";\r\n");
      out.write("\t\t\t\t\t\tvar username=$(\"input[name='username']\").val();\r\n");
      out.write("\t\t\t\t\t\t$.post(url,{\"username\":username},\r\n");
      out.write("\t\t\t\t\t\t\tfunction(data){\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#username_msg\").html(data);\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"input[name='password']\").blur(function(){\r\n");
      out.write("\t\t\t\t\tformobj.checkNull(\"password\", \"密码不能为空！\");\t\r\n");
      out.write("\t\t\t\t\tformobj.checkPassword(\"password\",\"两次密码输入不一致\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"input[name='password2']\").blur(function(){\r\n");
      out.write("\t\t\t\t\tformobj.checkNull(\"password2\", \"确认密码不能为空！\");\t\t\r\n");
      out.write("\t\t\t\t\tformobj.checkPassword(\"password\",\"两次密码输入不一致\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"input[name='nickname']\").blur(function(){\r\n");
      out.write("\t\t\t\t\tformobj.checkNull(\"nickname\", \"昵称不能为空！\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"input[name='email']\").blur(function(){\r\n");
      out.write("\t\t\t\t\tformobj.checkNull(\"email\", \"邮箱不能为空！\");\r\n");
      out.write("\t\t\t\t\tformobj.checkEmail(\"email\", \"邮箱格式不正确！\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\"input[name='valistr']\").blur(function(){\r\n");
      out.write("\t\t\t\t\tformobj.checkNull(\"valistr\", \"验证码不能为空！\");\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/*注册表单的js校验*/\r\n");
      out.write("\t\t\tvar formobj={\r\n");
      out.write("\t\t\t\t\"checkForm\":function(){\r\n");
      out.write("\t\t\t\t\t//1.非空校验\t\t\t\t\r\n");
      out.write("\t\t\t\t\tvar res1=this.checkNull(\"username\", \"用户名不能为空！\");\r\n");
      out.write("\t\t\t\t\tvar res2=this.checkNull(\"password\", \"密码不能为空！\");\r\n");
      out.write("\t\t\t\t\tvar res3=this.checkNull(\"password2\", \"确认密码不能为空！\");\r\n");
      out.write("\t\t\t\t\tvar res4=this.checkNull(\"nickname\", \"昵称不能为空！\");\r\n");
      out.write("\t\t\t\t\tvar res5=this.checkNull(\"email\", \"邮箱不能为空！\");\r\n");
      out.write("\t\t\t\t\tvar res6=this.checkNull(\"valistr\", \"验证码不能为空！\");\r\n");
      out.write("\t\t\t\t\tvar res7=this.checkPassword(\"password\",\"两次密码输入不一致\");\r\n");
      out.write("\t\t\t\t\tvar res8=this.checkEmail(\"email\",\"邮箱格式不正确！\");\r\n");
      out.write("\t\t\t\t\treturn res1 && res2 && res3 && res4 && res5 && res6 && res7 && res8;\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"checkNull\":function(name,msg){\r\n");
      out.write("\t\t\t\t\tvar value=$(\"input[name='\"+name+\"']\").val();  \r\n");
      out.write("\t\t\t\t\tthis.setMsg(name,\"\");\r\n");
      out.write("\t\t\t\t\tif(value.trim()==\"\"){\r\n");
      out.write("\t\t\t\t\t\tthis.setMsg(name, msg);\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t/* 设置错误提示消息  */\r\n");
      out.write("\t\t\t\t\"setMsg\":function(name,msg){\r\n");
      out.write("\t\t\t\t\tvar $span=$(\"input[name='\"+name+\"']\").nextAll(\"span\");\t\r\n");
      out.write("\t\t\t\t\t$span.html(msg);\r\n");
      out.write("\t\t\t\t\t$span.css(\"color\",\"red\");\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//2.两次密码是否一致校验\r\n");
      out.write("\t\t\t\t\"checkPassword\":function(name,msg){\r\n");
      out.write("\t\t\t\t\tvar pwd=$(\"input[name='\"+name+\"2']\").val().trim();\r\n");
      out.write("\t\t\t\t\tvar pwd2=$(\"input[name='\"+name+\"']\").val().trim();\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t  \tif( pwd!=\"\" && pwd2!=\"\"){\r\n");
      out.write("\t\t\t\t  \t\t//清空之前的消息。\r\n");
      out.write("\t\t//\t\t\t\tthis.setMsg(name+\"2\",\"\");\r\n");
      out.write("\t\t\t\t  \t\tif(pwd!= pwd2){\r\n");
      out.write("\t\t\t\t\t\t\tthis.setMsg(name+\"2\", msg);\r\n");
      out.write("\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t  \t}\r\n");
      out.write("\t\t\t\t  \treturn true;\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t//3.邮箱格式校验\r\n");
      out.write("\t\t\t\t\"checkEmail\":function(name,msg){\r\n");
      out.write("\t\t\t\t\tvar email=$(\"input[name='\"+name+\"']\").val().trim();\r\n");
      out.write("\t\t\t\t\tvar regExp=/^\\w+@\\w+(\\.\\w+)+$/;\r\n");
      out.write("\t\t\t\t\tif(email!=\"\"){\r\n");
      out.write("\t\t\t\t\t\tif(!regExp.test(email)){\r\n");
      out.write("\t\t\t\t\t\t\tthis.setMsg(name, msg);\r\n");
      out.write("\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\treturn true;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t<!-- onsubmit事件在表单提交时触发，该事件会根据返回值决定是否提交表单，  \r\n");
      out.write("\t          如果onsubmit=\"return true\"会继续提交表单，如果onsubmit=\"return false\" \r\n");
      out.write("\t          表单将不会提交 \r\n");
      out.write("\t     onsubmit=\"\" 引号中报错并不是因为代码有问题，而是MyEclipse工具在检查语法认为这个代码有问题。其实没有错误     \r\n");
      out.write("\t-->\r\n");
      out.write("\t\t<form onsubmit=\"return formobj.checkForm();\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/regist\" method=\"POST\">\r\n");
      out.write("\t\t\t<h1>欢迎注册EasyMall</h1>\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" style=\"color:red;text-align:center;\"></span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ msg }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"tds\">用户名：</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ param.username }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t<span id=\"username_msg\"></span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"tds\">密码：</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"password\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ param.password }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t<span></span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"tds\">确认密码：</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"password2\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ param.password2 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t<span></span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"tds\">昵称：</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"nickname\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ param.nickname }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t<span></span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"tds\">邮箱：</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ param.email }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t<span></span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"tds\">验证码：</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input  type=\"text\" name=\"valistr\" value=\"\"/>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<img id=\"img\"  src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/index/valiImage\"/>\r\n");
      out.write("\t\t\t\t\t\t<span></span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"sub_td\" colspan=\"2\" class=\"tds\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"注册用户\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
