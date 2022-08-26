package com.exe.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("test.controller")
public class TestController {
/*
	@RequestMapping(value = "/test/param.action",method = RequestMethod.GET)
	public String processGetRequest() {
		
		System.out.println("Get방식 Request");
		
		return "paramResult";
	}
	
	@RequestMapping(value = "/test/param.action",method = RequestMethod.POST)
	public String processPostRequest() {
		
		System.out.println("Post방식 Request");
		
		return "paramResult";
		
	}
*/	
	/**위에 주석처리한 두 메소드를 하나로 합친 것*/
	@RequestMapping(value = "/test/param.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String processRequest(PersonDTO dto,String name,HttpServletRequest request) {
		
		System.out.println("Get/Post 방식 Request");
	
		System.out.println(name);
		System.out.println(request.getParameter("phone"));
		
		/**해시코드 출력됨 = 객체가 생성되었다는 의미*/
		System.out.println(dto);
		
		System.out.println("name: " + dto.getName());
		System.out.println("phone: " + dto.getPhone());
		System.out.println("email: " + dto.getEmail());
		
		return "paramResult";
	}
	
}
