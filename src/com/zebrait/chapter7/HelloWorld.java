package com.zebrait.chapter7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorld {
	
	@RequestMapping(method=RequestMethod.GET, value="/get")
	public String doGet(Model model){		
		model.addAttribute("hello",	"world");
		return "zoo";		
	}
	@RequestMapping(method=RequestMethod.GET,value="/index")
	public String index(){
		return "WEB-INF/home";
	}
}
