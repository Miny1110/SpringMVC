package com.exe.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	/** ModelAndView로 보내면 Post방식까지 데이터를 다 받지만 (화면에 둘다 출력됨)
	Post방식으로 보내면 ModelAndView에서는 받지 못한다 (화면에 post 방식만 출력됨) */
	@RequestMapping(value = "/test/mav.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView mavRequest(PersonDTO dto) {
		
		ModelAndView mav = new ModelAndView();
		
		/**request.setAttribute 와 같은 기능이라고 생각하면 됨*/
		mav.addObject("dto",dto);
		
		mav.setViewName("paramResult");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/test/redirect.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String mavRedirectRequest() {
		
		/**메인으로 온다*/
//		return "redirect:/";
		
		return "redirect:/hello.action";
		/**return "hello" 와 다르다. 이건 hello.jsp를 정확하게 띄운 것이고
		 * hello.action은 콘트롤러에서 주소를 찾아가서 실행한 것이다.*/
		
	}
	
	
	
}
