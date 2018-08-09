package com.gsb.finance.controller.finance;

import com.gsb.finance.pojo.UserBean;
import com.gsb.finance.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private PersonInfoService personInfoServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	/*@RequestMapping("/index")
	public String index(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "/index";
	}*/

	@RequestMapping("/test")
	public String test(ModelMap model,UserBean userBean) {
		personInfoServiceImpl.addTest( userBean);
		return "/index";
	}
}