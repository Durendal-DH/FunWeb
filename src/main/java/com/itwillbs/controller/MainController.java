package com.itwillbs.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
//	@Inject
//	MainService mainService;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "/company/welcome";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "/main/main";
	}

}
