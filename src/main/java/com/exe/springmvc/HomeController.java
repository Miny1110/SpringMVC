package com.exe.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value = "/hello.action")
	public String getHello() {
		
		/** WEB-INF/view/hello.jsp 로 찾아감*/
		return "hello";
	}
}
