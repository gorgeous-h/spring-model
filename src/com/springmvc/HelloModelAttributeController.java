package com.springmvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.entity.User;

@RequestMapping("/helloModelAttribute")
@Controller
public class HelloModelAttributeController {
	
	@ModelAttribute
	public void getUserById(@RequestParam(value="id", required=false) Integer id, Model model){
		User user = new User(1, "张三");
		if(id!=null){
			user.setId(id);
		}
		user.setAge(22);
		user.setGender(0);
		System.out.println("修改之前的用户名："+user.getName());
		model.addAttribute("myUser", user);
	}
	
	@RequestMapping("/index4")
	public String index4(){
		return "index4";
	}
	
	@ResponseBody
	@RequestMapping("/getUserById")
	public User getUserById(HttpServletRequest request){
		Integer id = Integer.valueOf(request.getParameter("id"));
		User user = new User(id, "张三");
		user.setAge(22);
		user.setGender(0);
		return user;
	}
	
	@RequestMapping("/saveUser")
	public void saveUser(@ModelAttribute("myUser") User user, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
        .append("<html>\r\n")
        .append("    <head>\r\n")
        .append("        <title>ModelAttribute Demo</title>\r\n")
        .append("    </head>\r\n")
        .append("    <body>\r\n")
        .append("        修改之后的用户名： ").append(user.getName()).append("<br/>\r\n")
        .append("    </body>\r\n")
        .append("</html>\r\n");
	}
	
}
