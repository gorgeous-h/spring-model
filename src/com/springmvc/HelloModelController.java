package com.springmvc;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.entity.User;

@Controller
public class HelloModelController {

	@RequestMapping("/helloModel")
	public String index(Model model){
		model.addAttribute("greeting", "Hello!");
		return "index";
	}
	
	@RequestMapping("/helloMap")
	public String index2(Map<String, Object> map){
		map.put("time", LocalDate.now());
		return "index2";
	}
	
	@RequestMapping("/helloModelAndView")
	public ModelAndView index3(){
		ModelAndView modelAndView = new ModelAndView("index3");
		User user = new User(1, "ÕÅÈý");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
}
